package com.example.geektrust.model;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Station {
    String name;
    int amount;
    int discountAmount;
    Map<PersonType, Integer> personTypeIntegerMap;

    public Station(String name) {
        this.name = name;
        this.amount = 0;
        this.personTypeIntegerMap = new TreeMap<>();
        this.discountAmount = 0;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public Map<PersonType, Integer> getPersonTypeIntegerMap() {
        return personTypeIntegerMap;
    }

    public String getName() {
        return name;
    }
}
