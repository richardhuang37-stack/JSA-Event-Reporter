package com.example;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        EventReporter reporter = new EventReporter();

        EBoardMember president = new EBoardMember(
                "Alex Johnson", "President", "alex.johnson@example.com");
        EBoardMember secretary = new EBoardMember(
                "Morgan Lee", "Secretary", "morgan.lee@example.com");
        reporter.addMember(president);
        reporter.addMember(secretary);

        LocalDateTime eventDateTime = LocalDateTime.now().plusDays(14).withSecond(0).withNano(0);
        Event event = new Event("JSA Welcome Social", eventDateTime, "Student Union");
        reporter.addEvent(event);

        Task reserveVenue = new Task(
                "Reserve the event venue", president, eventDateTime.minusDays(7));
        Task prepareAgenda = new Task(
                "Prepare the event agenda", secretary, eventDateTime.minusDays(3));
        event.addTask(reserveVenue);
        event.addTask(prepareAgenda);

        reserveVenue.markComplete();
        event.confirmAttendance(president);
        event.confirmAttendance(secretary);

        System.out.println(reporter.generateSummary(event));
    }
}
