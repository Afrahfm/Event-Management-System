package com.example.demo.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Event;
import com.example.demo.service.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController {
  private EventService eventService;

  public EventController(EventService eventService) {
    this.eventService = eventService;
  }

  @PostMapping
  public ResponseEntity<Event> createEvent(@RequestBody Event event) {
    return ResponseEntity.ok(eventService.createEvent(event));
  }

  @GetMapping
  public ResponseEntity<Page<Event>> getAllEvents(@RequestParam(defaultValue = "10") int page,
      @RequestParam(defaultValue = "10") int size) {
    Page<Event> events = eventService.getAllEvents(PageRequest.of(page, size));
    return ResponseEntity.ok(events);
  }

  @GetMapping("/{id}")
  public Event getEventById(@PathVariable Long id) {
    return eventService.getEventById(id);
  }

  @PutMapping("/{id}")
  public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
    return eventService.updateEvent(id, event);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteEvent(@PathVariable Long id) {
    eventService.deleteEvent(id);
  }
}