package com.tracker.habit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "temp_users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Users {
    @Id
    private String id;
    private String name;
    private String email;
}
