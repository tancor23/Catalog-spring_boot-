package com.itrexgroup.vydrasergei.catalog.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SimpleUserDto {

    private long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    public SimpleUserDto(@NotNull String firstName, @NotNull String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
