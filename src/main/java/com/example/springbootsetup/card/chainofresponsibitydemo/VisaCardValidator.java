package com.example.springbootsetup.card.chainofresponsibitydemo;

import com.example.springbootsetup.card.Card;

public class VisaCardValidator extends CardValidator{

    public VisaCardValidator(CardValidator validator) {
        super(validator);
    }
    @Override
    public  void validate(Card card){
        if(card.getType().equals("VISA")){
            System.out.println("Validating VISA card");
        }
        else{
            super.validate(card);
        }
    }
}
