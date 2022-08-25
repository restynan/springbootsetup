package com.example.springbootsetup.card.chainofresponsibitydemo;

import com.example.springbootsetup.card.Card;

public class AmexCardValidator extends CardValidator{

    public AmexCardValidator(CardValidator validator) {
        super(validator);
    }

    @Override
    public  void validate(Card card){
        if(card.getType().equals("AMEX")){
            System.out.println("Validating AMEX card");
        }
        else{
            super.validate(card);
        }
    }
}
