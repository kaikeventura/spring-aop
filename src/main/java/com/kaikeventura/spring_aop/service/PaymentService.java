package com.kaikeventura.spring_aop.service;

import com.kaikeventura.spring_aop.model.Payment;

public interface PaymentService {
    Payment createPayment(Double value);
}
