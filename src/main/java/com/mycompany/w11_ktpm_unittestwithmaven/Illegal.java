package com.mycompany.w11_ktpm_unittestwithmaven;

public class Illegal extends Exception {
    String reason;

    public Illegal(String reason) {
        this.reason = reason;
    }
}