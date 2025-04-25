package com.matheuslemes.diazero.incidentRecords.modules.exceptions;

public class ErrorAPI extends RuntimeException {
    public ErrorAPI() {
        super("error, check the operation of the API features");
    }
}
