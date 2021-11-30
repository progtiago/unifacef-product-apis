package edu.unifacef.productapi.exceptions;

public class NotFoundException extends RuntimeException {

  private static final long serialVersionUID = -7623049475304109271L;

  public NotFoundException(final String message) {
    super(message);
  }

}
