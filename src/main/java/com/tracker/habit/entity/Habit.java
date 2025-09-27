package com.tracker.habit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Document(collection = "habit")
public class Habit {
    @JsonIgnore
    private String id;
    private LocalDate localDate;
    private boolean status;
    private String message;
}
