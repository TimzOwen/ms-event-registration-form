package com.must.event.registration;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public void registerForEvent(Student student, Event event) {
        student.getEvents().add(event);
        event.getStudents().add(student);
        eventRepository.save(event);
    }

    public boolean register(Long eventId) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);
        if (eventOptional.isPresent()) {
            Event event = eventOptional.get();
                eventRepository.save(event); // Persist updated event to the database
                return true;
            }
        return false;  // Either event not found or no available slots
    }

    public Event getEventById(Long eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }
}
