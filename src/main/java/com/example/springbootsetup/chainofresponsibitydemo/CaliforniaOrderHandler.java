package com.example.springbootsetup.chainofresponsibitydemo;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Builder
@Service("CaliforniaOrderHandler")
public class CaliforniaOrderHandler implements OrderHandler{

    private OrderHandler nextHandler;


    @Override
    public void handleOrder(String orderContent) {
        if (orderContent.startsWith("California")){
            System.out.println("Handle order for california");
        }
        else{
            nextHandler.handleOrder(orderContent);
        }

    }
}
