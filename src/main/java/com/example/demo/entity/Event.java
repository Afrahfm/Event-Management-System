package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "events")
@NoArgsConstructor
@AllArgsConstructor
public class Event {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "event_id")
  private Long id;
  private String eventName;
  private String location;
  private String date;
  private String time;
  private int availableSeats;
  @ManyToOne
  @JoinColumn(name = "user_id")
  @JsonIgnore
  private User user;

  @ManyToOne
  @JoinColumn(name = "organizer_id")
  @JsonIgnore
  private Organizer organizer;
  
  @ManyToOne
  @JoinColumn(name = "venue_id")
  private Venue venue;

  public Event(long id, String eventName, String location, String date, String time, int availableSeats) {
    this.id = id;
    this.eventName = eventName;
    this.location = location;
    this.date = date;
    this.time = time;
    this.availableSeats = availableSeats;
  }
}