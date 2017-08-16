package com.janbask.training3;

public class Helper {
    static void LogException(Exception exception){
        System.out.printf("\nThere was an error, refer to the details below:\nError: %s\nMessage: %s",
                exception.getClass().getName(),
                exception.getMessage());
    }
}
