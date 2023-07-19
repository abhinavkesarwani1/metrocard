package com.example.geektrust.model;

public enum PersonType {
    ADULT(200), KID(50), SENIOR_CITIZEN(100);

    private final int personTypeAmount ;
    PersonType(int personTypeAmount) {
        this.personTypeAmount = personTypeAmount;
    }

    public int getPersonTypeAmount() {
        return personTypeAmount;
    }
}
