package com.gunesmab.network;


import com.gunesmab.javautils.Observable;

public interface CallResponse<Body> extends Observable {

    Body getResponse();

    ErrorResponse getErrorResponse();

    void cancel();
}
