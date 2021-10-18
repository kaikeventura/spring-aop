package com.kaikeventura.spring_aop.model;

public class Payment {

    private String uuid;
    private Double value;

    public Payment() {
    }

    public Payment(String uuid, Double value) {
        this.uuid = uuid;
        this.value = value;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Double getValue() {
        return value;
    }
    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "uuid='" + uuid + '\'' +
                ", value=" + value +
                '}';
    }
}
