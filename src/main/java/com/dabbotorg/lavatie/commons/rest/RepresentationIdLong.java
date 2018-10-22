package com.dabbotorg.lavatie.commons.rest;

public class RepresentationIdLong implements RepresentationId {
    private Long id = null;
    public RepresentationIdLong(Long id) { this.id = id; }
    public Long getId() { return id; }
}
