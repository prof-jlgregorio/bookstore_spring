package br.com.jlgregorio.bookstore.model;

public enum RoleModel {

    ADMIN("admin"), USER("user");

    private String name;

    RoleModel(String name){
        this.name = name;
    }

}
