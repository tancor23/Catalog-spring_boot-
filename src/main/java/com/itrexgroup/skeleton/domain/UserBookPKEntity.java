package com.itrexgroup.skeleton.domain;

import lombok.*;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Embeddable
public class UserBookPKEntity implements Serializable {

    @Basic
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Basic
    @Column(name = "book_id", nullable = false)
    private Long bookId;

}
