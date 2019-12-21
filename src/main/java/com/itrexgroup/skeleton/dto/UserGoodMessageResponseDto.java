package com.itrexgroup.skeleton.dto;

import com.itrexgroup.skeleton.to.Role;
import com.itrexgroup.skeleton.to.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserGoodMessageResponseDto {

    private long id;

    private String login;

    private String email;

    private String firstName;

    private String lastName;

    private String role = Role.USER.getValue();

    private String status = Status.INACTIVE.getValue();
}
