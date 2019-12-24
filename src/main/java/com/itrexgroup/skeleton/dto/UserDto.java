package com.itrexgroup.skeleton.dto;

import com.itrexgroup.skeleton.to.Role;
import com.itrexgroup.skeleton.to.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDto {

    private long id = -1;

    @NotNull
    private String login;

    @NotNull
    private String password;

    @NotNull
    private String email;

    @NotNull
    private String firstName;

    private String lastName;

    @NotNull
    private String role = Role.USER.getValue();

    @NotNull
    private String status = Status.INACTIVE.getValue();

    private Date createdAt;

}
