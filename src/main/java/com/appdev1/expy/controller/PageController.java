package com.appdev1.expy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "index"; // index.html
    }

    @GetMapping("/students")
    public String students(Model model) {
        model.addAttribute("activePage", "students");
        return "students"; // students.html
    }

    
        @GetMapping("/login")
     public String login() {
         return "login";
     }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/home")
    public String dashboard(Model model) {
        model.addAttribute("activePage", "home");
        return "home";
    }

    @GetMapping("/lessons")
    public String lessons(Model model) {
        model.addAttribute("activePage", "lessons");
        return "lessons";
    }

    @GetMapping("/challenges")
    public String challenges(Model model) {
        model.addAttribute("activePage", "challenges");
        return "challenges";
    }

    @GetMapping("/playground")
    public String playground(Model model) {
        model.addAttribute("activePage", "playground");
        return "playground";
    }

    @GetMapping("/lesson/{id}")
    public String lessonOpened(@PathVariable Long id, Model model) {
        model.addAttribute("activePage", "lessons");
        model.addAttribute("lessonId", id);
        model.addAttribute("lessonTitle", "Python Foundations");
        model.addAttribute("lessonLevel", "Beginner");
        model.addAttribute("lessonSubheader", "Introduction to Python");
        model.addAttribute("lessonDescription", "Learn the fundamentals of Python programming, from syntax to your first program.");

        List<Map<String, Object>> subLessons = new ArrayList<>();
        subLessons.add(createSubLesson(1L, 1, "Introduction to Python", "Get started with Python basics and syntax.", 50, "available", false));
        subLessons.add(createSubLesson(2L, 2, "Variables and Data Types", "Learn about variables, strings, numbers, and data types.", 75, "locked", true));
        subLessons.add(createSubLesson(3L, 3, "Control Flow", "Master if/else statements and loops.", 100, "locked", true));
        subLessons.add(createSubLesson(4L, 4, "Functions", "Learn to create and use functions.", 125, "locked", true));
        subLessons.add(createSubLesson(5L, 5, "Data Structures", "Explore lists, dictionaries, and more.", 150, "locked", true));

        model.addAttribute("subLessons", subLessons);

        return "lesson_opened";
    }

    @GetMapping("/lesson/{lessonId}/sublesson/{subLessonId}")
    public String subLesson(@PathVariable Long lessonId,
                            @PathVariable Long subLessonId,
                            Model model) {
        model.addAttribute("lessonId", lessonId);
        model.addAttribute("subLessonId", subLessonId);
        model.addAttribute("lessonTitle", "Python Foundations");
        model.addAttribute("subLessonTitle", "Lesson " + subLessonId + ": Introduction to Python");
        model.addAttribute("subLessonDescription", "Understand the basics of Python syntax, keywords, and how to run your first script.");
        model.addAttribute("progressPercent", 20);
        model.addAttribute("currentTopic", 1);

        List<Map<String, Object>> topics = new ArrayList<>();
        topics.add(createTopic(1, "Python REPL & Script Mode", "Experiment quickly in the REPL before converting snippets into scripts."));
        topics.add(createTopic(2, "Printing & Comments", "Communicate with print() and document thoughts with comments."));
        topics.add(createTopic(3, "Basic Input", "Accept user input, process it, and respond back."));
        model.addAttribute("subLessonTopics", topics);
        model.addAttribute("totalTopics", topics.size());

        List<Map<String, String>> steps = new ArrayList<>();
        steps.add(createStep("Hello World & Print",
                "Every Python journey starts with print(). Use it to display text or the value of a variable.",
                "print(\"Hello, World!\")\ngreeting = \"Hello, EXPy!\"\nprint(greeting)"));
        steps.add(createStep("Variables & Data Types",
                "Store information by assigning names. Python infers the data type automatically.",
                "username = \"Nova\"\nage = 16\npi = 3.1416\nis_wizard = True"));
        steps.add(createStep("User Input",
                "Use input() to interact with the player. Convert the result when you need numeric values.",
                "spell = input(\"Name your spell: \")\npower = int(input(\"Power level (0-10): \"))\nprint(f\"{spell} has power {power}!\")"));
        model.addAttribute("lessonSteps", steps);

        model.addAttribute("questionPrompt", "Complete the code so it prints: Hello, EXPy!");
        model.addAttribute("questionSnippet", "name = \"EXPy\"\n# fill the missing line below\nprint(____)");
        model.addAttribute("questionPlaceholder", "Type your answer here... Example: print('Hello, ' + name + '!')");

        return "sublesson";
    }

    private Map<String, Object> createSubLesson(Long id,
                                                int number,
                                                String title,
                                                String description,
                                                int exp,
                                                String status,
                                                boolean isLocked) {
        Map<String, Object> subLesson = new HashMap<>();
        subLesson.put("id", id);
        subLesson.put("number", number);
        subLesson.put("title", title);
        subLesson.put("description", description);
        subLesson.put("expPoints", exp);
        subLesson.put("status", status);
        subLesson.put("isLocked", isLocked);
        return subLesson;
    }

    private Map<String, Object> createTopic(int index, String title, String description) {
        Map<String, Object> topic = new HashMap<>();
        topic.put("index", index);
        topic.put("title", title);
        topic.put("description", description);
        return topic;
    }

    private Map<String, String> createStep(String title, String description, String code) {
        Map<String, String> step = new HashMap<>();
        step.put("title", title);
        step.put("description", description);
        step.put("code", code);
        return step;
    }
}
