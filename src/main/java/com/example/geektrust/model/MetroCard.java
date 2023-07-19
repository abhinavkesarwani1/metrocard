package com.example.geektrust.model;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MetroCard implements Comparable<MetroCard>{
    private int balance;
    private String id;

    public Map<PersonType, Integer> getPersonTypeIntegerMap() {
        return personTypeIntegerMap;
    }

    public void setPersonTypeIntegerMap(String personType, int count) {
        personTypeIntegerMap.put(PersonType.valueOf(personType), count);
    }

    private Map<PersonType, Integer> personTypeIntegerMap;

    public MetroCard(String id, int balance) {
        this.id = id;
        this.balance = balance;
        this.personTypeIntegerMap = new TreeMap<>();
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    @Override
    public int compareTo(MetroCard o) {
        if (this.id == o.id)
            return 1;
        return -1;
    }

}
