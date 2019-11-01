package com.progesco.progescoadmin.model;

/**
 * @author emile.camara
 * @date 01/11/2019
 */
public class RoleModel {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
