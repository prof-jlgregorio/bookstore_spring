package br.com.jlgregorio.bookstore.model;

public enum RoleModel {

    ADMIN("ADMIN"), USER("ADMIN");

    private String name;

    RoleModel(String name){
        this.name = name;
    }

}
