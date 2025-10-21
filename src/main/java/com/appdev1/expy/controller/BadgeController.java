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

import com.appdev1.expy.entity.BadgeEntity;
import com.appdev1.expy.service.BadgeService;

@RestController
@RequestMapping("/api/badges")
public class BadgeController {

    @Autowired
    private BadgeService badgeService;

    public BadgeController(BadgeService badgeService) {
        this.badgeService = badgeService;
    }

    @PostMapping("/insertBadge")
    public BadgeEntity createBadge(@RequestBody BadgeEntity badge) {
        return badgeService.createBadge(badge);
    }

    @GetMapping("/getAllBadges")
    public List<BadgeEntity> getAllBadges() {
        return badgeService.getAllBadges();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BadgeEntity> getBadgeById(@PathVariable int id) {
        return badgeService.getBadgeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/updateBadge")
    public BadgeEntity updateBadge(@RequestParam int badgeId, @RequestBody BadgeEntity updatedBadgeDetails) {
        return badgeService.updateBadge(badgeId, updatedBadgeDetails);
    }

    @DeleteMapping("/deleteBadge/{id}")
    public String deleteBadge(@PathVariable int id) {
        return badgeService.deleteBadge(id);
    }
}
