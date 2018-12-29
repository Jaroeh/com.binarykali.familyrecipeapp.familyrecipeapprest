package com.binarykali.familyrecipeapp.resource;

import com.google.common.base.Preconditions;
import org.apache.log4j.Logger;

public class Temperature {

    private static final double ABSOLUTE_ZERO_CELSIUS = -273.15;
    private static final double ABSOLUTE_ZERO_FAHRENHEIT = -459.67;

    private static final Logger LOGGER = Logger.getLogger(Temperature.class);

    private double celsius;
    private double fahrenheit;

    public Temperature() {
        this.celsius = ABSOLUTE_ZERO_CELSIUS;
        this.fahrenheit = convertCelsiusToFahrenheit(ABSOLUTE_ZERO_CELSIUS);
    }

    public double getCelsius() {
        return celsius;
    }

    public void setCelsius(double celsius) {
        Preconditions.checkArgument(celsius >= ABSOLUTE_ZERO_CELSIUS, "The provided temperature in celsius cannot be less than absolute zero.");
        LOGGER.error("The provided temperature in celsius cannot be less than absolute zero. Provided temperature: " + celsius + ".");

        this.celsius = celsius;
        this.fahrenheit = convertCelsiusToFahrenheit(celsius);
    }

    public double getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(double fahrenheit) {
        Preconditions.checkArgument(fahrenheit >= ABSOLUTE_ZERO_FAHRENHEIT, "The provided temperature in fahrenheit cannot be less than absolute zero.");
        LOGGER.error("The provided temperature in fahrenheit cannot be less than absolute zero. Provided temperature: " + fahrenheit + ".");

        this.fahrenheit = fahrenheit;
        this.celsius = convertFahrenheitToCelsius(fahrenheit);
    }

    private double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) / 1.8;
    }

    private double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 1.8) + 32;
    }
}
