package com.example;

import java.time.LocalDateTime;
import java.util.Objects;

public class Task {
    private final String description;
    private final EBoardMember assignedMember;
    private final LocalDateTime deadline;
    private boolean completed;

    public Task(String description, EBoardMember assignedMember, LocalDateTime deadline) {
        this.description = Objects.requireNonNull(description, "description");
        this.assignedMember = Objects.requireNonNull(assignedMember, "assignedMember");
        this.deadline = Objects.requireNonNull(deadline, "deadline");
    }

    public void markComplete() {
        completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }

    public EBoardMember getAssignedMember() {
        return assignedMember;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }
}
