package com.dabbotorg.lavatie.commons.rest;

public interface Converter<A, B> {

    B convertTo(A source, B destination);

    A convertFrom(B source, A destination);

    default B convertTo(A source) {
        return convertTo(source, null);
    }

    default A convertFrom(B source) {
        return convertFrom(source, null);
    }

}