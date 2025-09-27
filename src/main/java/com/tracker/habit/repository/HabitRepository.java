package com.tracker.habit.repository;

import com.tracker.habit.entity.Habit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface HabitRepository extends MongoRepository<Habit,String> {
    Optional<Habit> findByLocalDate(LocalDate localDate);
}
