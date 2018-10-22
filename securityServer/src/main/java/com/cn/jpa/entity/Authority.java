package com.cn.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@Entity
@GenericGenerator(name = "system-uuid", strategy = "uuid")
@Table(name = "authority")
public class Authority implements GrantedAuthority {
    @GeneratedValue(generator = "system-uuid")
    @Id
    @Column(name = "authorityId", length = 32)
    public String authorityId;

    @Column(name = "authority", unique = true, nullable = false, length = 32)
    public String authority;

    @Column(name = "authorityDescription", length = 100)
    public String authorityDescription;

}
