package com.tracker.habit.Dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class HabitResponseDTO {
    private boolean status;
    private String message;

}
