package com.tracker.habit.services;

import com.tracker.habit.Dtos.HabitResponseDTO;
import com.tracker.habit.entity.Habit;
import com.tracker.habit.repository.HabitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Service
public class HabitService {

    @Autowired
    private HabitRepository habitRepository;

    public HabitResponseDTO saveData(Habit habit){
        String s = "";
        log.info("Received habit "+habit);
        boolean duplicateDate = checkDuplicateDate(habit);
        if(duplicateDate){
            return new HabitResponseDTO(false,"Your done for today! come back tomorrow");
        }

        //Business logic to implement the google pay number or the good one mohammed status
        if(habit.isStatus()){
             s = generateAGoodOneMessage();
             habit.setMessage(s);
        }else{
             s = generateRandomPaymentNumber();
             habit.setMessage(s);
        }

        Habit save = habitRepository.save(habit);
        log.error(s);
        HabitResponseDTO build = HabitResponseDTO.builder().status(save.isStatus()).message(s).build();
        return build;
    }

    private String generateRandomPaymentNumber(){
        long min = 6788888888L;
        long max = 9999999999L;
        long l = ThreadLocalRandom.current().nextLong(min, max + 1);
        return "Google Pay Number: "+String.valueOf(l);
    }

    private String generateAGoodOneMessage(){
        return "Good one Mohammed!";
    }

    private boolean checkDuplicateDate(Habit habit){
        Optional<Habit> byLocalDate = habitRepository.findByLocalDate(habit.getLocalDate());
        if(byLocalDate.isPresent()){
            return true;
        }
        return false;
    }

    //get all the data for stats
    public List<Habit> getAllData(){
        return habitRepository.findAll();
    }
}
