package com.weatherService.weather.service.email;

public enum Emails {
    Yaroslav("sakhno.yaroslav.13.95@gmail.com");

    private final String email;

    Emails(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
