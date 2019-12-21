package com.itrexgroup.skeleton.service.imp;

import com.itrexgroup.skeleton.dao.UserDao;
import com.itrexgroup.skeleton.entity.UserEntity;
import com.itrexgroup.skeleton.exception.*;
import com.itrexgroup.skeleton.service.UserService;
import com.itrexgroup.skeleton.to.Role;
import com.itrexgroup.skeleton.to.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static com.itrexgroup.skeleton.to.Status.STOPPED;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserEntity create(UserEntity userEntity) {
        List<UserEntity> usersEntityByLogin = userDao.findByLogin(userEntity.getLogin());
        for (UserEntity userEntityByLogin : usersEntityByLogin) {
            if (userEntityByLogin != null && !userEntityByLogin.getStatus().equals(STOPPED.getValue())) {
                throw new UserNotUniqueLoginException(userEntityByLogin.getLogin());
            }
        }
        try {
            userEntity.setPassword(new String(getPasswordSha256(userEntity.getPassword())));
        } catch (Exception e) {
            throw new IAmTeapotException(userEntity.getLogin());
        }
        userEntity.setStatus(Status.INACTIVE.getValue());
        userEntity.setRole(Role.USER.getValue());
        return userDao.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUserEntity() {
        return userDao.findAll();
    }

    @Override
    public UserEntity readById(Long id) {
        return getUserEntityById(id);
    }

    @Override
    public void delete(UserEntity userEntity) {
        UserEntity newUserEntity = getUserEntityById(userEntity.getId());
        if (newUserEntity.getStatus().equals(STOPPED.getValue())) {
            throw new UserIsAlreadyDeletedException(newUserEntity.getId(), newUserEntity.getLogin());
        }
        userEntity.setStatus(STOPPED.getValue());
        userDao.save(userEntity);
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        getUserEntityById(userEntity.getId());
        List<UserEntity> usersEntityByLogin = userDao.findByLogin(userEntity.getLogin());
        for (UserEntity userEntityByLogin : usersEntityByLogin) {
            if (userEntityByLogin != null && !userEntityByLogin.getStatus().equals(STOPPED.getValue())) {
                throw new UserNotUniqueLoginException(userEntityByLogin.getLogin());

            }
        }
        if (!isValidStatus(userEntity.getStatus())) {
            throw new UserNotValidStatusError(userEntity.getId(), userEntity.getLogin(), userEntity.getStatus());
        }

        if (!isValidRole(userEntity.getRole())) {
            throw new UserNotValidRoleError(userEntity.getId(), userEntity.getLogin(), userEntity.getRole());
        }
        try {
            userEntity.setPassword(new String(getPasswordSha256(userEntity.getPassword())));
        } catch (Exception e) {
            throw new IAmTeapotException(userEntity.getLogin());
        }
        userDao.save(userEntity);
        return userEntity;
    }

    private UserEntity getUserEntityById(Long id) {
        return userDao.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    private boolean isValidStatus(String newStatus) {
        if (!newStatus.isEmpty()) {
            for (Status status : Status.values()) {
                if (status.getValue().equals(newStatus)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValidRole(String newRole) {
        if (!newRole.isEmpty()) {
            for (Role role : Role.values()) {
                if (role.getValue().equals(newRole)) {
                    return true;
                }
            }
        }
        return false;
    }

    private byte[] getPasswordSha256(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(password.getBytes(StandardCharsets.UTF_8));
    }
}
