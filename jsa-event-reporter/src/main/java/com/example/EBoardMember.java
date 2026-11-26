package com.example;

import java.util.Objects;

public class EBoardMember {
    private final String name;
    private final String position;
    private final String email;

    public EBoardMember(String name, String position, String email) {
        this.name = Objects.requireNonNull(name, "name");
        this.position = Objects.requireNonNull(position, "position");
        this.email = Objects.requireNonNull(email, "email");
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }
}
