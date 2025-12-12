package com.example.demo.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Venue;
import com.example.demo.service.VenueService;

@RestController
@RequestMapping("/api/venues")
public class VenueController {
   private final VenueService venueService;

   public VenueController(VenueService venueService) {
      this.venueService = venueService;
   }

   @PostMapping
   public ResponseEntity<Venue> createVenue(@RequestBody Venue venue) {
      Venue createdVenue = venueService.createVenue(venue);
      return new ResponseEntity<>(createdVenue, HttpStatus.OK);
   }

   @GetMapping
   public ResponseEntity<List<Venue>> getAllVenues() {
      List<Venue> venues = venueService.getAllVenues();
      return new ResponseEntity<>(venues, HttpStatus.OK);
   }

   @GetMapping("/{id}")
   public Venue getVenueById(@PathVariable Long id) {
      return venueService.getVenueById(id);
   }

   @PutMapping("/{id}")
   public ResponseEntity<Venue> updateVenue(@PathVariable Long id, @RequestBody Venue updatedVenue) {
      Venue venue = venueService.updateVenue(id, updatedVenue);
      return new ResponseEntity<>(venue, HttpStatus.OK);
   }

   @DeleteMapping("/{id}")   
    @ResponseStatus(HttpStatus.NO_CONTENT)    
    public void deleteVenue(@PathVariable Long id)    {        
      venueService.deleteVenue(id);
   }
}