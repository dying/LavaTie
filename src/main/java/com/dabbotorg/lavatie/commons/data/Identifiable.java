package com.dabbotorg.lavatie.commons.data;

public interface Identifiable {

    long getId();
    void setId(long id);

    static long getIdentifier(Identifiable object) {
        return object.getId();
    }

    default boolean instanceOf(Class targetClass) { return targetClass.isInstance(this); }
}
