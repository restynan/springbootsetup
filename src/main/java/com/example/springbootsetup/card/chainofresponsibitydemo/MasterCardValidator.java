package com.example.springbootsetup.card.chainofresponsibitydemo;

import com.example.springbootsetup.card.Card;

public class MasterCardValidator extends CardValidator{

    public MasterCardValidator(CardValidator validator) {
        super(validator);
    }

    @Override
    public  void validate(Card card){
        if(card.getType().equals("MASTER")){
            System.out.println("Validating MASTER card");
        }
        else{
            super.validate(card);
        }
    }
}
