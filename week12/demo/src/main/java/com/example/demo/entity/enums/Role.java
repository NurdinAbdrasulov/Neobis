package com.example.demo.entity.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public enum Role {

    ADMIN(Permission.READ,Permission.ADD, Permission.UPDATE, Permission.DELETE, Permission.EMPLOYEE, Permission.CLIENT, Permission.CarBrand),
    CLIENT(Permission.READ, Permission.CarBrand);

    final Set<Permission> permissions;

    Role(Permission... permissions){
        Set<Permission> set = new HashSet<Permission>();
        Collections.addAll(set, permissions);
        this.permissions = set;
    }

    public Set<Permission> getPermissions(){
        return  permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities(){
//        return getAuthorities().stream()
//                .map(permission -> new SimpleGrantedAuthority(permission.getAuthority()))
//                .collect(Collectors.toSet());

        Set<SimpleGrantedAuthority> set = new HashSet<>();
        for(Permission permission: permissions)
            set.add(new SimpleGrantedAuthority(permission.getPermission()));
        return set;
    }

}
