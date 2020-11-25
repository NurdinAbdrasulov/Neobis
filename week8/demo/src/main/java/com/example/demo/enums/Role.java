package com.example.demo.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;

import static java.util.Set.of;

public enum Role {
    ADMIN(of(Permission.READ,Permission.ADD, Permission.UPDATE, Permission.DELETE, Permission.EMPLOYEE, Permission.CLIENT, Permission.CarBrand)),
    CLIENT(of(Permission.READ, Permission.CarBrand));

    final Set<Permission> permissions;

    Role(Set<Permission> permissions){
        this.permissions = permissions;
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
