package com.example;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class EventReporter {
    private static final DateTimeFormatter DATE_TIME_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private final List<Event> events = new ArrayList<>();
    private final List<EBoardMember> members = new ArrayList<>();

    public EventReporter() {
    }

    public void addEvent(Event event) {
        events.add(Objects.requireNonNull(event, "event"));
    }

    public void removeEvent(Event event) {
        events.remove(Objects.requireNonNull(event, "event"));
    }

    public void addMember(EBoardMember member) {
        EBoardMember nonNullMember = Objects.requireNonNull(member, "member");
        if (!members.contains(nonNullMember)) {
            members.add(nonNullMember);
        }
    }

    public List<Event> getEvents() {
        return Collections.unmodifiableList(new ArrayList<>(events));
    }

    public List<EBoardMember> getMembers() {
        return Collections.unmodifiableList(new ArrayList<>(members));
    }

    public String generateSummary(Event event) {
        Event nonNullEvent = Objects.requireNonNull(event, "event");
        StringBuilder summary = new StringBuilder();
        summary.append("Event: ").append(nonNullEvent.getName()).append('\n')
                .append("Date and time: ")
                .append(nonNullEvent.getDateTime().format(DATE_TIME_FORMAT)).append('\n')
                .append("Location: ").append(nonNullEvent.getLocation()).append('\n')
                .append("Attending members:\n");

        List<EBoardMember> attendees = nonNullEvent.getAttendingMembers();
        if (attendees.isEmpty()) {
            summary.append("  None\n");
        } else {
            for (EBoardMember member : attendees) {
                summary.append("  - ").append(member.getName())
                        .append(" (").append(member.getPosition())
                        .append(", ").append(member.getEmail()).append(")\n");
            }
        }

        summary.append("Tasks:\n");
        List<Task> tasks = nonNullEvent.getTasks();
        if (tasks.isEmpty()) {
            summary.append("  None\n");
        } else {
            for (Task task : tasks) {
                summary.append("  - ").append(task.getDescription())
                        .append(" | Assigned to: ").append(task.getAssignedMember().getName())
                        .append(" | Deadline: ").append(task.getDeadline().format(DATE_TIME_FORMAT))
                        .append(" | Status: ").append(task.isCompleted() ? "Complete" : "Incomplete")
                        .append('\n');
            }
        }

        return summary.toString();
    }
}
