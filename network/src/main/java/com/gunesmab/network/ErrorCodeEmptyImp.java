package com.gunesmab.network;


class ErrorCodeEmptyImp implements ErrorCode {

    static ErrorCode create() {
        return new ErrorCodeEmptyImp();
    }

    private ErrorCodeEmptyImp() {
    }

    @Override
    public String asString() {
        return "";
    }
}
