package com.itrexgroup.skeleton.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SimpleBookDto {

    private long id;

    @NotNull
    private String name;

    @NotNull
    private String author;

    public SimpleBookDto(@NotNull String name, @NotNull String author) {
        this.name = name;
        this.author = author;
    }
}
