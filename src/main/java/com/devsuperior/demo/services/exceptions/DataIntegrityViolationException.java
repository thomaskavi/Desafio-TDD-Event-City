package com.devsuperior.demo.services.exceptions;

public class DataIntegrityViolationException extends RuntimeException {

  DataIntegrityViolationException(String msg) {
    super(msg);
  }
}