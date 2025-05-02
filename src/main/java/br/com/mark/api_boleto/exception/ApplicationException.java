package br.com.mark.api_boleto.exception;

public class ApplicationException extends RuntimeException {
  public ApplicationException(String message) {
    super(message);
  }
}
