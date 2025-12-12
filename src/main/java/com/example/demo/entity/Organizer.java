package com.example.demo.entity;

import java.util.List;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "organizers")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Organizer {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL, orphanRemoval = true)
   @JsonIgnore
   private List<Event> events;

   public Organizer(Long id, String name) {
      this.id = id;
      this.name = name;
   }
}