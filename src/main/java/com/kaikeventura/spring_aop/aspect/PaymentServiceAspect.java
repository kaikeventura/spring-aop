package com.kaikeventura.spring_aop.aspect;

import com.kaikeventura.spring_aop.exception.PaymentValueNotAllowedException;
import com.kaikeventura.spring_aop.model.Payment;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PaymentServiceAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Before(value = "execution(* com.kaikeventura.spring_aop.service.PaymentService.createPayment(..)) and args(value))")
    public void beforeAdvice(final JoinPoint joinPoint, final Double value) {
        log.info(String.format("Before signature %s", joinPoint.getSignature()));
        log.info(String.format("Creating a new product with value %s", value));
    }

    @AfterReturning(pointcut = "execution(* com.kaikeventura.spring_aop.service.PaymentService.createPayment(..))", returning = "payment")
    public void afterReturning(final Payment payment) {
        log.info(payment.toString());
    }

    @After(value = "execution(* com.kaikeventura.spring_aop.service.PaymentService.createPayment(..)) and args(value))")
    public void afterAdvice(final JoinPoint joinPoint, final Double value) {
        log.info(String.format("After signature %s", joinPoint.getSignature()));
        log.info(String.format("Successfully created Product with value %s", value));
    }

    @AfterThrowing(value = "execution(* com.kaikeventura.spring_aop.service.PaymentService.createPayment(..))", throwing = "exception")
    public void afterThrowing(final PaymentValueNotAllowedException exception) {
        log.error(exception.getMessage());
    }
}
