package com.example.demo.controller;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
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
import com.example.demo.entity.Organizer;
import com.example.demo.service.OrganizerService;

@RestController
@RequestMapping("/api/organizers")
public class OrganizerController {
   private final OrganizerService organizerService;

   public OrganizerController(OrganizerService organizerService) {
      this.organizerService = organizerService;
   }

   @GetMapping
   public List<Organizer> getAllOrganizers() {
      return organizerService.getAllOrganizers();
   }

   @GetMapping("/{id}")
   @ResponseStatus(HttpStatus.OK)
   public Organizer getOrganizerById(@PathVariable Long id) {
      return organizerService.getOrganizerById(id);
   }

   @GetMapping("/paginate")
   public Page<Organizer> getPaginatedOrganizers(@RequestParam(defaultValue = "0") int page,
         @RequestParam(defaultValue = "10") int size) {
      return organizerService.getPaginatedOrganizers(PageRequest.of(page, size));
   }

   @PostMapping
   public Organizer createOrganizer(@RequestBody Organizer organizer) {
      return organizerService.createOrganizer(organizer);
   }

   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.OK)
   public void deleteOrganizer(@PathVariable Long id) {
      organizerService.deleteOrganizer(id);
   }
}