package com.example.springbootsetup.card;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Card {
    private String number;
    private String type;
    private int expiryMonth;
    private int expiryYear;
}
