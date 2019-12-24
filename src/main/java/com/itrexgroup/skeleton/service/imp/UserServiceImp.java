package com.itrexgroup.skeleton.service.imp;

import com.itrexgroup.skeleton.config.bean.PasswordSha256Bean;
import com.itrexgroup.skeleton.dao.UserDao;
import com.itrexgroup.skeleton.entity.UserEntity;
import com.itrexgroup.skeleton.exception.UserEmailConfirmWasChangedException;
import com.itrexgroup.skeleton.exception.UserEmailWasChangedException;
import com.itrexgroup.skeleton.exception.UserFirstNameIsEmptyException;
import com.itrexgroup.skeleton.exception.UserIsAlreadyDeletedException;
import com.itrexgroup.skeleton.exception.UserLoginIsEmptyException;
import com.itrexgroup.skeleton.exception.UserLoginWasChangedException;
import com.itrexgroup.skeleton.exception.UserNotFoundException;
import com.itrexgroup.skeleton.exception.UserNotUniqueLoginException;
import com.itrexgroup.skeleton.exception.UserRoleWasChangedException;
import com.itrexgroup.skeleton.exception.UserStatusWasChangedException;
import com.itrexgroup.skeleton.exception.UserWasNotChangedException;
import com.itrexgroup.skeleton.service.UserService;
import com.itrexgroup.skeleton.to.Role;
import com.itrexgroup.skeleton.to.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.itrexgroup.skeleton.to.Status.STOPPED;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;
    private final PasswordSha256Bean passwordSha256Bean;

    @Autowired
    public UserServiceImp(UserDao userDao, PasswordSha256Bean passwordSha256Bean) {
        this.userDao = userDao;
        this.passwordSha256Bean = passwordSha256Bean;
    }

    @Override
    public UserEntity create(UserEntity userEntity) {
        List<UserEntity> usersEntityByLogin = userDao.findByLogin(userEntity.getLogin());
        for (UserEntity userEntityByLogin : usersEntityByLogin) {
            if (userEntityByLogin != null && !userEntityByLogin.getStatus().equals(STOPPED.getValue())) {
                throw new UserNotUniqueLoginException(userEntityByLogin.getLogin());
            }
        }
        userEntity.setPassword(passwordSha256Bean.getEncryptedPassword(userEntity.getPassword()));
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
    public void delete(Long userId) {
        UserEntity userEntity = getUserEntityById(userId);
        if (userEntity.getStatus().equals(STOPPED.getValue())) {
            throw new UserIsAlreadyDeletedException(userEntity.getId(), userEntity.getLogin());
        }
        userEntity.setStatus(STOPPED.getValue());
        userDao.save(userEntity);
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        if (userEntity.getLogin().isEmpty()) {
            throw new UserLoginIsEmptyException(userEntity.getId());
        }
        UserEntity userEntityFromDb = getUserEntityById(userEntity.getId());
        if (!userEntity.getLogin().equals(userEntityFromDb.getLogin())) {
            throw new UserLoginWasChangedException(userEntityFromDb.getId(), userEntityFromDb.getLogin());
        }
        if (userEntity.getEmail().equals(userEntityFromDb.getEmail())) {
            throw new UserEmailWasChangedException(userEntityFromDb.getId());
        }
        if (Boolean.compare(userEntity.isConfirmedEmail(), userEntityFromDb.isConfirmedEmail()) == 0) {
            throw new UserEmailConfirmWasChangedException(userEntityFromDb.getId());
        }
        if (userEntity.getFirstName().isEmpty()) {
            throw new UserFirstNameIsEmptyException(userEntityFromDb.getId());
        }
        if (userEntity.getRole().equals(userEntityFromDb.getRole())) {
            throw new UserRoleWasChangedException(userEntityFromDb.getId());
        }
        if (userEntity.getStatus().equals(userEntityFromDb.getStatus())) {
            throw new UserStatusWasChangedException(userEntityFromDb.getId());
        }
/*        List<UserEntity> usersEntityByLogin = userDao.findByLogin(userEntity.getLogin());
        for (UserEntity userEntityByLogin : usersEntityByLogin) {
            if (userEntityByLogin != null && !userEntityByLogin.getStatus().equals(STOPPED.getValue())) {
                throw new UserNotUniqueLoginException(userEntityByLogin.getLogin());
            }
        }
        if (!isValidStatus(userEntity.getStatus())) {
            throw new UserNotValidStatusException(userEntity.getId(), userEntity.getLogin(), userEntity.getStatus());
        }
        if (!isValidRole(userEntity.getRole())) {
            throw new UserNotValidRoleException(userEntity.getId(), userEntity.getLogin(), userEntity.getRole());
        }
        try {
            userEntity.setPassword(new String(getPasswordSha256(userEntity.getPassword())));
        } catch (NoSuchAlgorithmException e) {
            throw new UserNotValidPasswordException(userEntity.getLogin());
        }*/
        if (userEntity.equals(userEntityFromDb)) {
            throw new UserWasNotChangedException(userEntityFromDb.getId(), userEntityFromDb.getLogin());
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


}
