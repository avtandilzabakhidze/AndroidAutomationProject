package com.company.exceptions;

public class PlatformNotSupportedException extends RuntimeException {
    public PlatformNotSupportedException(String platform) {
        super("Platform '" + platform + "' is not supported");
    }
}