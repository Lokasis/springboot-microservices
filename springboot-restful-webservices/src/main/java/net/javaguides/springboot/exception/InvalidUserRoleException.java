package net.javaguides.springboot.exception;

public class InvalidUserRoleException extends RuntimeException {

  public InvalidUserRoleException(String message) {
    super(message);
  }
}
