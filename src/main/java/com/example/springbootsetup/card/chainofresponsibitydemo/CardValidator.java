package com.example.springbootsetup.card.chainofresponsibitydemo;

import com.example.springbootsetup.card.Card;

public abstract class CardValidator {
    private CardValidator validator;

    public CardValidator(CardValidator validator) {

        this.validator = validator;
    }

    public  void validate(Card card){
        if(validator != null){
            validator.validate(card);
        }
        else{
            System.out.println("Invalid card type");
        }

    }
}
