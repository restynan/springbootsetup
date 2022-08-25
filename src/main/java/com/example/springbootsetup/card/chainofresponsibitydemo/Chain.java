package com.example.springbootsetup.card.chainofresponsibitydemo;

import com.example.springbootsetup.card.Card;

public class Chain {
    CardValidator   validatorChain;

    public Chain() {
       buildChain();
    }

    private void buildChain() {
        validatorChain = new VisaCardValidator(new MasterCardValidator(new AmexCardValidator(null)));
    }

    public void validate(Card card){
        validatorChain.validate(card);


    }
}
