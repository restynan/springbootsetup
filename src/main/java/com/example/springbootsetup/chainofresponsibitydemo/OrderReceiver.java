package com.example.springbootsetup.chainofresponsibitydemo;

import lombok.Builder;
import org.springframework.stereotype.Component;

@Builder
@Component
public class OrderReceiver {
    private OrderHandler orderHandler;

    public void setOrderHandler(OrderHandler orderHandler) {
        this.orderHandler = orderHandler;
    }

    public void handleOrder(String orderContent){
        orderHandler.handleOrder(orderContent);
    }

}
