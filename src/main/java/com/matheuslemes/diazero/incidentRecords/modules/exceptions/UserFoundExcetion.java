package com.matheuslemes.diazero.incidentRecords.modules.exceptions;

public class UserFoundExcetion extends RuntimeException {
    public UserFoundExcetion() {
        super("usuario ja existe");
    }
}
