package com.kaikeventura.spring_aop.service.impl;

import com.kaikeventura.spring_aop.exception.PaymentValueNotAllowedException;
import com.kaikeventura.spring_aop.model.Payment;
import com.kaikeventura.spring_aop.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public Payment createPayment(final Double value) {
        this.checkIfPaymentIsValid(value);

        return new Payment(UUID.randomUUID().toString(), value);
    }

    private void checkIfPaymentIsValid(final Double value) {
        if (value > 500) {
            throw new PaymentValueNotAllowedException(String.format("Value %s not allowed for payment", value));
        }
    }
}
