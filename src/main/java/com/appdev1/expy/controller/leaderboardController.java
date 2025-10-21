package com.appdev1.expy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appdev1.expy.entity.LeaderboardEntity;
import com.appdev1.expy.service.leaderboardService;

@RestController
@RequestMapping("api/leaderboard")
public class leaderboardController {
    @Autowired
    leaderboardService leaderboardService;

    public leaderboardController(leaderboardService leaderboardService) {
        this.leaderboardService = leaderboardService;
    }

    // C
    @PostMapping("/insertLeaderboard")
    public LeaderboardEntity createLeaderboard(@RequestBody LeaderboardEntity leaderboard) {
        return leaderboardService.createLeaderboard(leaderboard);
    }

    // R
    @GetMapping("/getAllLeaderboards")
    public List<LeaderboardEntity> getAllLeaderboards() {
        return leaderboardService.getAllLeaderboards();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaderboardEntity> getLeaderboardById(@PathVariable int id) {
        return leaderboardService.getLeaderboardById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // U
    @PutMapping("/updateLeaderboard")
    public LeaderboardEntity updateModule(@RequestParam int leaderboard_id, @RequestBody LeaderboardEntity updatedLeaderboard) {
        return leaderboardService.updateLeaderboard(leaderboard_id, updatedLeaderboard);
    }

    // D
    @DeleteMapping("/deleteLeaderboard/{id}")
    public String deleteLeaderboard(@PathVariable int id) {
        return leaderboardService.deleteLeaderboard(id);
    }
}
