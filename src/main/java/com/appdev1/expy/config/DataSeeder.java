package com.appdev1.expy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.appdev1.expy.entity.BadgeEntity;
import com.appdev1.expy.repository.BadgeRepository;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private BadgeRepository badgeRepository;

    @Override
    public void run(String... args) throws Exception {
        try {
            if (badgeRepository.count() == 0) {
                // Create sample badges
                BadgeEntity b1 = new BadgeEntity();
                b1.setName("First Steps");
                b1.setDescription("Complete your first lesson.");
                b1.setImageUrl("/images/steps.png");
                b1.setCriteria("Finish lesson 1");
                badgeRepository.save(b1);

                BadgeEntity b2 = new BadgeEntity();
                b2.setName("Week Warrior");
                b2.setDescription("Maintain a 7-day learning streak.");
                b2.setImageUrl("/images/week.png");
                b2.setCriteria("7 consecutive days of activity");
                badgeRepository.save(b2);

                BadgeEntity b3 = new BadgeEntity();
                b3.setName("Code Master");
                b3.setDescription("Solve 10 coding challenges.");
                b3.setImageUrl("/images/Code.png");
                b3.setCriteria("Solve 10 challenges");
                badgeRepository.save(b3);

                BadgeEntity b4 = new BadgeEntity();
                b4.setName("Champion");
                b4.setDescription("Top performer on the leaderboard this week.");
                b4.setImageUrl("/images/champion.png");
                b4.setCriteria("Top 3 this week");
                badgeRepository.save(b4);

                BadgeEntity b5 = new BadgeEntity();
                b5.setName("Python Pro");
                b5.setDescription("Complete the Python fundamentals path.");
                b5.setImageUrl("/images/python.png");
                b5.setCriteria("Finish all beginner lessons");
                badgeRepository.save(b5);

                BadgeEntity b6 = new BadgeEntity();
                b6.setName("Speed Runner");
                b6.setDescription("Solve a challenge in under 2 minutes.");
                b6.setImageUrl("/images/speed.png");
                b6.setCriteria("Complete challenge under 2 minutes");
                badgeRepository.save(b6);
            }
        } catch (Exception e) {
            // Do not prevent app startup if seeding fails
            System.err.println("Badge seeding failed: " + e.getMessage());
        }
    }
}
