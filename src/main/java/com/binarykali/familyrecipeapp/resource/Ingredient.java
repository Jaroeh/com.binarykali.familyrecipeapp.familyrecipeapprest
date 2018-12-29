package com.binarykali.familyrecipeapp.resource;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

public class Ingredient {

    private String name;
    private Measurement measurement;

    public Ingredient(String name, Measurement measurement) {
        Preconditions.checkArgument(StringUtils.isNotBlank(name), "The provided ingredient name cannot be null or blank.");
        Preconditions.checkNotNull(measurement, "The provided ingredient measurement unit cannot be null.");

        this.name = name;
        this.measurement = measurement;
    }

    public String getName() {
        return name;
    }

    public Measurement getMeasurement() {
        return measurement;
    }
}
