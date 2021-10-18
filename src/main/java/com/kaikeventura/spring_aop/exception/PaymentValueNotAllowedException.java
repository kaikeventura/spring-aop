package com.kaikeventura.spring_aop.exception;

public class PaymentValueNotAllowedException extends RuntimeException {

    public PaymentValueNotAllowedException(String message) {
        super(message);
    }
}
