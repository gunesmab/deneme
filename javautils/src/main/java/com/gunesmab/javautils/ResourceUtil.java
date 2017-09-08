package com.gunesmab.javautils;


public class ResourceUtil {

    public static final int INVALID_RESOURCE_ID = 0;

    private static final ResourceUtil INSTANCE = new ResourceUtil();

    private ResourceUtil() {
    }

    public static ResourceUtil getInstance() {
        return INSTANCE;
    }

    public void checkValid(final int id) {
        if (id == INVALID_RESOURCE_ID) {
            throw new IllegalStateException("given id : " + id + " is invalid");
        }
    }
}
