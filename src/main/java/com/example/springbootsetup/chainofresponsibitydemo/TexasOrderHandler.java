package com.example.springbootsetup.chainofresponsibitydemo;

import lombok.Builder;
import org.springframework.stereotype.Service;

@Builder
@Service("TexasOrderHandler")
public class TexasOrderHandler implements OrderHandler{

    private OrderHandler nextHandler;

    @Override
    public void handleOrder(String orderContent) {
        if (orderContent.startsWith("Texas")){
            System.out.println("Handle order for Texas");
        }
        else{
            // throw an exception
            System.out.println("Product not supported");
        }
    }
}
