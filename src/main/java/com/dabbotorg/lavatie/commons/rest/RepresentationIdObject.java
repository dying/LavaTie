package com.dabbotorg.lavatie.commons.rest;

public class RepresentationIdObject implements RepresentationId {
    private Long id = null;
    private String name = null;

    public RepresentationIdObject() {}

    public RepresentationIdObject(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() { return id; }

    public String getName() { return name; }
}
