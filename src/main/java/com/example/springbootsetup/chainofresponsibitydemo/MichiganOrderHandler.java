package com.example.springbootsetup.chainofresponsibitydemo;

import lombok.Builder;
import org.springframework.stereotype.Service;


@Builder
@Service("MichiganOrderHandler")
public class MichiganOrderHandler implements  OrderHandler {
    private OrderHandler nextHandler;

    @Override
    public void handleOrder(String orderContent) {
        if (orderContent.startsWith("Michigan")){
            System.out.println("Handle order for Michigan");
        }
        else{
            nextHandler.handleOrder(orderContent);
        }

    }
}
