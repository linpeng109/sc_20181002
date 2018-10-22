package com.cn.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
@GenericGenerator(name = "system-uuid", strategy = "uuid")
@Table(name = "UserBase")
public class User implements UserDetails {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "userId", length = 32)
    public String userId;

    @Column(name = "username", unique = true, nullable = false)
    public String username;

    @Column(name = "password", length = 32)
    public String password;

    @Column(name = "accountNonExpired")
    @Type(type = "java.lang.Boolean")
    public boolean accountNonExpired;

    @Column(name = "accountNonLocked")
    @Type(type = "java.lang.Boolean")
    public boolean accountNonLocked;

    @Column(name = "credentialsNonExpired")
    @Type(type = "java.lang.Boolean")
    public boolean credentialsNonExpired;

    @Column(name = "enabled")
    @Type(type = "java.lang.Boolean")
    public boolean enabled;

    @Column(name = "createDate")
    @Type(type = "java.util.Date")
    public Date createDate;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(name = "user_authority", joinColumns = {@JoinColumn(name = "userId", referencedColumnName = "userId")}, inverseJoinColumns = {@JoinColumn(name = "authorityId", referencedColumnName = "authorityId")})
    public Collection<Authority> authorities;
}
