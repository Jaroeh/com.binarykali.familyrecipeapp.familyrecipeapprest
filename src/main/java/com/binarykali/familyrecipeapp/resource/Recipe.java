package com.binarykali.familyrecipeapp.resource;


import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class Recipe {

    private int id;
    private String name;
    private List<Ingredient> ingredientList;

    private Duration totalTime;
    private Duration prepTime;
    private Duration cookTime;

    private Temperature temperature;
    private String directions;
    private String notes;

    public class Builder{

        private final Logger LOGGER = Logger.getLogger(Builder.class);

        private int id;
        private String name;
        private List<Ingredient> ingredientList;

        private Duration totalTime;
        private Duration prepTime;
        private Duration cookTime;

        private Temperature temperature;
        private String instructions;
        private String notes;

        public Builder(int id, String name) {
            try {
                Preconditions.checkArgument(Strings.isNullOrEmpty(name));
            } catch (NullPointerException npe) {
                LOGGER.error("The provided name string was null. Setting the name to an empty string.", npe);
            }

            this.id = id;
            this.name = name;
        }

        public Builder withIngredientsList(List<Ingredient> ingredientsList) {
            try {
                Preconditions.checkNotNull(ingredientsList);
                Preconditions.checkArgument(ingredientsList.size() <= 0);

                this.ingredientList = ingredientsList;
            } catch (IllegalArgumentException iae) {
                LOGGER.warn("Recipe Builder: Provided ingredientsList object was empty.", iae);
                this.ingredientList = new ArrayList<>();
            } catch (NullPointerException npe) {
                LOGGER.error("Recipe Builder: Provided ingredientsList object was null. Initializing with an empty array.", npe);
                this.ingredientList = new ArrayList<>();
            }

            return this;
        }

        public Builder withTotalTime(Duration totalTime) {
            try {
                Preconditions.checkNotNull(totalTime);

                this.totalTime = totalTime;
            } catch (NullPointerException npe) {
                LOGGER.error("Recipe Builder: Provided totalTime object was null. Setting value to ZERO.", npe);
                this.totalTime = Duration.ZERO;
            }

            return this;
        }

        public Builder withPrepTime(Duration prepTime) {
            try {
                Preconditions.checkNotNull(prepTime);
                this.prepTime = prepTime;
            } catch (NullPointerException npe) {
                LOGGER.error("Recipe Builder: Provided prepTime object was null. Setting value to ZERO.", npe);
                this.prepTime = Duration.ZERO;
            }

            return this;
        }

        public Builder withCookTime(Duration cookTime) {
            try {
                Preconditions.checkNotNull(cookTime);
                this.cookTime = cookTime;
            } catch (NullPointerException npe) {
                LOGGER.error("Recipe Builder: Provided cookTime object was null. Setting value to ZERO.", npe);
                this.cookTime = Duration.ZERO;
            }

            return this;
        }

        public Builder withTemperature(Temperature temperature) {
            try {
                Preconditions.checkNotNull(temperature);
                this.temperature = new Temperature();
            } catch (NullPointerException npe) {
                LOGGER.error("Recipe Builder: The provided temperature object was null. Setting value to absolute zero.", npe);
                this.temperature = new Temperature();
            }

            return this;
        }

        public Builder withInstructions(String instructions) {
            try {
                Preconditions.checkArgument(!Strings.isNullOrEmpty(instructions));
                this.instructions = instructions;
            } catch (IllegalArgumentException iae) {
                LOGGER.error("Recipe Builder: The instructions string was null or empty. Defaulting to an empty string.", iae);
                this.instructions = StringUtils.EMPTY;
            }

            return this;
        }

        public Builder withNotes(String notes) {
            try {
                Preconditions.checkArgument(!Strings.isNullOrEmpty(notes));
                this.notes = notes;
            } catch (IllegalArgumentException iae) {
                LOGGER.error("Recipe Builder: The notes string was null or empty. Defaulting to an empty string.", iae);
                this.notes = StringUtils.EMPTY;
            }

            return this;
        }

        public Recipe build() {
            return new Recipe(this.id, this.name, this.ingredientList, this.totalTime, this.prepTime, this.cookTime, this.temperature, this.instructions, this.notes);
        }
    }

    private Recipe(int id, String name, List<Ingredient> ingredientList, Duration totalTime, Duration prepTime, Duration cookTime, Temperature temperature, String directions, String notes) {
        this.id = id;
        this.name = name;
        this.ingredientList = ingredientList;
        this.totalTime = totalTime;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.temperature = temperature;
        this.directions = directions;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public Duration getTotalTime() {
        return totalTime;
    }

    public Duration getPrepTime() {
        return prepTime;
    }

    public Duration getCookTime() {
        return cookTime;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public String getDirections() {
        return directions;
    }

    public String getNotes() {
        return notes;
    }
}
