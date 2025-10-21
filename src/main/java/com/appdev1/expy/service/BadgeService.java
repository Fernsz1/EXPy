package com.appdev1.expy.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev1.expy.entity.BadgeEntity;
import com.appdev1.expy.repository.BadgeRepository;

@Service
public class BadgeService {

    @Autowired
    private final BadgeRepository badgeRepository;

    public BadgeService(BadgeRepository badgeRepository) {
        this.badgeRepository = badgeRepository;
    }

    // CREATE
    public BadgeEntity createBadge(BadgeEntity badge) {
        return badgeRepository.save(badge);
    }

    // READ 
    public List<BadgeEntity> getAllBadges() {
        return badgeRepository.findAll();
    }

    public Optional<BadgeEntity> getBadgeById(int id) {
        return badgeRepository.findById(id);
    }

    // UPDATE
    public BadgeEntity updateBadge(int id, BadgeEntity updatedBadge) {
        BadgeEntity badge = badgeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Badge with ID " + id + " not found"));

        badge.setName(updatedBadge.getName());
        badge.setDescription(updatedBadge.getDescription());
        badge.setImageUrl(updatedBadge.getImageUrl());
        badge.setCriteria(updatedBadge.getCriteria());
        // badge.setStudent(updatedBadge.getStudent());

        return badgeRepository.save(badge);
    }

    // DELETE
    public String deleteBadge(int id) {
        String msg = "";
        if(badgeRepository.findById(id) != null){
            badgeRepository.deleteById(id);
            msg = "Badge with ID " + id + " has been deleted.";
        } else {
            msg = "Badge with ID " + id + " does not exist.";
        }
        return msg;
    }
}