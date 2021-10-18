package com.kaikeventura.spring_aop.controller;

import com.kaikeventura.spring_aop.model.Payment;
import com.kaikeventura.spring_aop.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(final PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<Payment> create(@RequestParam("value") final Double value) {
        var payment = paymentService.createPayment(value);

        return ResponseEntity.ok(payment);
    }

}
