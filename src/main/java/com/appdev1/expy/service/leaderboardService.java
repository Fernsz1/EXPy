package com.appdev1.expy.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev1.expy.entity.leaderboardEntity;
import com.appdev1.expy.repository.leaderboardRepository;

@Service
public class leaderboardService {
    @Autowired
    leaderboardRepository leaderboardRep;

    public leaderboardService() {
        super();
    }

    //C
    public leaderboardEntity createLesson(leaderboardEntity leaderboard) {
        return leaderboardRep.save(leaderboard);
    }

    //R
    public List<leaderboardEntity> getAllLeaderboards() {
        return leaderboardRep.findAll();
    }

    //U
    @SuppressWarnings("finally")
    public leaderboardEntity updateLeaderboard(int leaderboard_id, leaderboardEntity leaderboard) {
        leaderboardEntity newLeaderboard = new leaderboardEntity();
        try {
            newLeaderboard = leaderboardRep.findById(leaderboard_id).get();
            newLeaderboard.setName(leaderboard.getName());
            newLeaderboard.setPeriodType(leaderboard.getPeriodType());
            newLeaderboard.setStartDate(leaderboard.getStartDate());

            leaderboardRep.save(newLeaderboard);
            return newLeaderboard;

        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Leaderboard with ID " + leaderboard_id + " not found.");

        } finally {
            return leaderboardRep.save(newLeaderboard);
        }
    }

    //D
    public String deleteLeaderboard(int leaderboard_id) {
        String msg = "";

        if(leaderboardRep.findById(leaderboard_id) != null){
            leaderboardRep.deleteById(leaderboard_id);
            msg = "Leaderboard with ID " + leaderboard_id + " has been deleted.";
        } else {
            msg = "Leaderboard with ID " + leaderboard_id + " does not exist.";
        }
        return msg;
    }
}
