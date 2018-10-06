package com.cn.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "authorityBase")
@GenericGenerator(name = "system-uuid", strategy = "uuid")
@Data
public class AuthorityBase {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "authorityBaseId", length = 32)
    public String authorityBaseId;

    @Column(nullable = false, unique = true, length = 40)
    public String authorityBaseName;

    @Column(length = 60)
    public String authorityBaseDescription;

    @Type(type = "java.lang.Boolean")
    public boolean isEnable = true;

//    @ManyToMany(mappedBy = "authorityBaseList")
//    public List<UserBase> userBaseList;
}
