package org.lowes.promotion.promotionstatetransition.exception;

public class InvalidStateTransitionException extends RuntimeException {

  private String msg;

  public InvalidStateTransitionException(String message) {
    super(message);
    this.msg = message;
  }
}
