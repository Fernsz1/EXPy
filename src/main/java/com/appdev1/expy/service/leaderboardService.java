package com.appdev1.expy.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev1.expy.entity.LeaderboardEntity;
import com.appdev1.expy.repository.leaderboardRepository;

@Service
public class leaderboardService {
    @Autowired
    leaderboardRepository leaderboardRep;

    public leaderboardService() {
        super();
    }

    //C
    public LeaderboardEntity createLeaderboard(LeaderboardEntity leaderboard) {
        return leaderboardRep.save(leaderboard);
    }

    //R
    public List<LeaderboardEntity> getAllLeaderboards() {
        return leaderboardRep.findAll();
    }

    public Optional<LeaderboardEntity> getLeaderboardById(int id) {
        return leaderboardRep.findById(id);
    }

    //U
    public LeaderboardEntity updateLeaderboard(int leaderboard_id, LeaderboardEntity leaderboard) {
        LeaderboardEntity newLeaderboard;
        try {
            newLeaderboard = leaderboardRep.findById(leaderboard_id).get();
            newLeaderboard.setName(leaderboard.getName());
            newLeaderboard.setPeriodType(leaderboard.getPeriodType());
            newLeaderboard.setStartDate(leaderboard.getStartDate());

            leaderboardRep.save(newLeaderboard);
            return leaderboardRep.save(newLeaderboard);

        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Leaderboard with ID " + leaderboard_id + " not found.");
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
