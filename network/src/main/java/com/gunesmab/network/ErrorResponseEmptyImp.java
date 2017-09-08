package com.gunesmab.network;


public class ErrorResponseEmptyImp implements ErrorResponse {

    static ErrorResponse create() {
        return new ErrorResponseEmptyImp();
    }

    private ErrorResponseEmptyImp() {
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCodeEmptyImp.create();
    }

    @Override
    public String getErrorMessage() {
        return "";
    }
}
