package com.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Event {
    private final String name;
    private final LocalDateTime dateTime;
    private final String location;
    private final List<Task> tasks = new ArrayList<>();
    private final List<EBoardMember> attendingMembers = new ArrayList<>();

    public Event(String name, LocalDateTime dateTime, String location) {
        this.name = Objects.requireNonNull(name, "name");
        this.dateTime = Objects.requireNonNull(dateTime, "dateTime");
        this.location = Objects.requireNonNull(location, "location");
    }

    public void addTask(Task task) {
        tasks.add(Objects.requireNonNull(task, "task"));
    }

    public void removeTask(Task task) {
        tasks.remove(Objects.requireNonNull(task, "task"));
    }

    public void confirmAttendance(EBoardMember member) {
        EBoardMember nonNullMember = Objects.requireNonNull(member, "member");
        if (!attendingMembers.contains(nonNullMember)) {
            attendingMembers.add(nonNullMember);
        }
    }

    public void removeAttendance(EBoardMember member) {
        attendingMembers.remove(Objects.requireNonNull(member, "member"));
    }

    public List<Task> getTasks() {
        return Collections.unmodifiableList(new ArrayList<>(tasks));
    }

    public List<EBoardMember> getAttendingMembers() {
        return Collections.unmodifiableList(new ArrayList<>(attendingMembers));
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getLocation() {
        return location;
    }
}
