package com.binarykali.familyrecipeapp.resource;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;


public class User {

    private static final Logger LOGGER = Logger.getLogger(User.class);

    private int id;
    private String name;

    private User() {}

    public User(int id, String name) {
        this.id = id;
        setName(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        try{
            Preconditions.checkArgument(StringUtils.isNotBlank(name));
            this.name = name;
        } catch (IllegalArgumentException iae) {
            LOGGER.error("User Object: The provided name string was blank or null. Defaulting to an empty string.", iae);
            this.name = StringUtils.EMPTY;
        }
    }
}
