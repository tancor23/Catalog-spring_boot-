package com.itrexgroup.skeleton.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Builder
@Table(name = "users", schema = "spring_rest_skeleton")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id = -1;

    @Basic
    @Column(name = "login", length = 50, nullable = false, unique = true)
    private String login;

    @Basic
    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Basic
    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Basic
    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    @Basic
    @Column(name = "last_name", length = 100)
    private String lastName;

    @Basic
    @Column(name = "role", length = 100, nullable = false, columnDefinition = "DEFAULT 'user'")
    private String role;

    @Basic
    @Column(name = "status", length = 100, nullable = false, columnDefinition = "DEFAULT 'inactive'")
    private String status;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;
}

