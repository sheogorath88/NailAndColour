package com.nailandcolour.exceptions;

public class ClientNotExistentException extends IllegalArgumentException{
  public ClientNotExistentException(String message) {
    super(message);
  }
}
