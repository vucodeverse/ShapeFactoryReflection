package org.designpatterm.utils;

public class AppException extends Exception {
    /**
     * Creates a new instance of <code>NewException</code> without detail
     * message.
     */
    public AppException(){
    }

    /**
     * Constructs an instance of <code>NewException</code> with the specified
     * detail message.
     *
     * @param message the detail message.
     */
    public AppException(String message) {
        super(message);
    }
}
