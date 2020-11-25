package com.example.demo.enums;

public enum Permission {
    READ("чтение"),
    ADD("добавление"),
    UPDATE("обновление"),
    DELETE("удаление"),
    EMPLOYEE("employeesMapping"),
    CLIENT("clientMapping"),
    CarBrand("carBrandMapping");

    private final String permission;

    Permission(String permission){
        this.permission = permission;
    }

    public String getPermission(){
        return permission;
    }

}
