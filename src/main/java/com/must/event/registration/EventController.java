package com.must.event.registration;

import com.must.event.registration.Event;
import com.must.event.registration.EventService;
import com.must.event.registration.Student;
import com.must.event.registration.StudentService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EventController {

    private final EventService eventService;
    private final StudentService studentService;

    public EventController(EventService eventService, StudentService studentService) {
        this.eventService = eventService;
        this.studentService = studentService;
    }

    // This method allows both authenticated and non-authenticated users to view the events
    @GetMapping("/events")
    public String listEvents(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "events";  // Show the list of events
    }

    @PostMapping("/register")
    public String registerForEvent(@RequestParam("eventId") Long eventId, Model model) {
        boolean success = eventService.register(eventId);

        if (success) {
            model.addAttribute("message", "Successfully registered for the event!");
        } else {
            model.addAttribute("message", "Registration failed or event is full.");
        }

        // After adding the message, redirect to the events page
        return "redirect:/events";  // Redirect to the events list page
    }


    @GetMapping("/login")
    public String login() {
        return "login";  // Return the login page
    }
}


