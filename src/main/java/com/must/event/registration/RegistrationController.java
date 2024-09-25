package com.must.event.registration;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RegistrationController {

    @GetMapping
    public String showRegistrationForm() {
        return "registration"; // This is the name of the Thymeleaf template (registration.html)
    }

    @PostMapping("/register")
    public String registerParticipant(String name, String institution, String course, String year, Model model) {
        // Normally you'd process the registration here (e.g., save to DB), but we'll just simulate success
        model.addAttribute("name", name);
        model.addAttribute("institution", institution);
        model.addAttribute("course", course);
        model.addAttribute("year", year);
        return "registration"; // Redirect back to the form (modal will appear via JS)
    }
}
