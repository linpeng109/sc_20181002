package com.cn.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "userBase")
@GenericGenerator(name = "system-uuid", strategy = "uuid")
@Data
public class UserBase {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "userBaseId", length = 32)
    public String userBaseId;

    @Column(name = "username", length = 40, nullable = false, unique = true)
    public String username;

    @Column(name = "password", length = 40)
    public String password;

    @Column(name = "age", nullable = false)
    @Type(type = "java.lang.Integer")
    public int age;

    @Column(name = "sex", nullable = false)
    @Type(type = "java.lang.Boolean")
    public boolean sex;

    @ManyToMany
    @JoinTable(
            name = "userBase_authorityBase",
            joinColumns = @JoinColumn(name = "userBaseId", referencedColumnName = "userBaseId"),
            inverseJoinColumns = @JoinColumn(name = "authorityBaseId", referencedColumnName = "authorityBaseId")
    )
    public List<AuthorityBase> authorityBaseList;
}
