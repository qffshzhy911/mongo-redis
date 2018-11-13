package com.example.demo.Redis;

import java.util.Optional;

public class Enterprise {

    private User user;
    private Optional<User> optionalUser;

    public Enterprise(User user, Optional<User> optionalUser) {
        this.user = user;
        this.optionalUser = optionalUser;
    }

    public Enterprise() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Optional<User> getOptionalUser() {
        return optionalUser;
    }

    public void setOptionalUser(Optional<User> optionalUser) {
        this.optionalUser = optionalUser;
    }
}
