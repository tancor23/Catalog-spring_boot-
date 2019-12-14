package com.itrexgroup.skeleton.dto;

import lombok.*;

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

    private String role;

    private String status;

    private Date createdAt;

}
