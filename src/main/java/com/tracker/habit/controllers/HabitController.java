package com.tracker.habit.controllers;

import com.tracker.habit.entity.Habit;
import com.tracker.habit.services.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/habit")
public class HabitController {

    @Autowired
    private HabitService habitService;

    @PostMapping
    public ResponseEntity<?> postTodaysStatus(@RequestBody Habit habit){
        return new ResponseEntity<>(habitService.saveData(habit),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> fetchAllData(){
        return new ResponseEntity<>(habitService.getAllData(),HttpStatus.OK);
    }
}
