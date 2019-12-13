package com.itrexgroup.skeleton.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BookDto {

    private long id;

    @NotNull
    private String name;

    @NotNull
    private String author;

    private int page;

    private List<SimpleUserDto> simpleUserDtoList;

    public BookDto(@NotNull String name, @NotNull String author) {
        this.name = name;
        this.author = author;
    }

    public BookDto(@NotNull String name, @NotNull String author, int page) {
        this.name = name;
        this.author = author;
        this.page = page;
    }

}
