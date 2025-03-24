package net.javaguides.springboot.exception;

public class UserSoftDeletedException extends RuntimeException{
    public UserSoftDeletedException(String message) {
        super(message);
    }
}
