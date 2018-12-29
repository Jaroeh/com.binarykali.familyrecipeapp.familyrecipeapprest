package com.binarykali.familyrecipeapp.resource;

public class Measurement {
    private Unit unit;
    private float amount;

    private Measurement() {}

    public Measurement(Unit unit, byte amount) {
        this.unit = unit;
        this.amount = amount;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
