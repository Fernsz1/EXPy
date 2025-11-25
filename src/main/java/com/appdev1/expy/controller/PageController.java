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

    // Challenge Routes
    @GetMapping("/challenge/completecode/{id}")
    public String completeCodeChallenge(@PathVariable Long id, Model model) {
        model.addAttribute("activePage", "challenges");
        model.addAttribute("challengeId", id);
        
        // Set challenge-specific data based on ID
        if (id == 1) {
            model.addAttribute("challengeTitle", "Fill the Gaps");
            model.addAttribute("challengeDescription", "Finish incomplete Python functions and test your understanding of core concepts.");
            model.addAttribute("expReward", 50);
            model.addAttribute("codeTemplate", "def calculate_sum(a, b):\n    # Complete the function below\n    result = ____\n    return result\n\n# Test your solution\nprint(calculate_sum(5, 3))  # Should output: 8");
        } else if (id == 2) {
            model.addAttribute("challengeTitle", "Logic Puzzles");
            model.addAttribute("challengeDescription", "Complete control flow and data manipulation code snippets step by step.");
            model.addAttribute("expReward", 75);
            model.addAttribute("codeTemplate", "def find_max(numbers):\n    # Complete the function to find the maximum number\n    max_num = ____\n    for num in numbers:\n        if num > max_num:\n            max_num = ____\n    return max_num\n\nprint(find_max([3, 7, 2, 9, 1]))  # Should output: 9");
        }
        
        return "completecode";
    }

    @GetMapping("/challenge/quiz/{id}")
    public String quizChallenge(@PathVariable Long id, Model model) {
        model.addAttribute("activePage", "challenges");
        model.addAttribute("challengeId", id);
        
        // Set challenge-specific data based on ID
        if (id == 1) {
            model.addAttribute("challengeTitle", "Python Fundamentals Quiz");
            model.addAttribute("challengeDescription", "Test your knowledge with multiple-choice questions on Python basics and syntax.");
            model.addAttribute("expReward", 100);
            model.addAttribute("totalQuestions", 5);
            
            // Create sample questions
            List<Map<String, Object>> questions = new ArrayList<>();
            questions.add(createQuizQuestion(1, "What is the output of print(2 + 3 * 4)?", 
                List.of("14", "20", "24", "Error"), 1));
            questions.add(createQuizQuestion(2, "Which of the following is a valid variable name?", 
                List.of("2variable", "variable-name", "variable_name", "variable name"), 2));
            questions.add(createQuizQuestion(3, "What does len() function return?", 
                List.of("The last element", "The length of a sequence", "The sum of elements", "The average"), 1));
            questions.add(createQuizQuestion(4, "Which keyword is used to define a function?", 
                List.of("def", "function", "define", "func"), 0));
            questions.add(createQuizQuestion(5, "What is the result of 'Hello' + 'World'?", 
                List.of("HelloWorld", "Hello World", "Error", "Hello+World"), 0));
            
            model.addAttribute("questions", questions);
        } else if (id == 2) {
            model.addAttribute("challengeTitle", "Advanced Concepts");
            model.addAttribute("challengeDescription", "Challenge yourself with questions on OOP, decorators, and Python internals.");
            model.addAttribute("expReward", 150);
            model.addAttribute("totalQuestions", 5);
            
            // Create sample questions for advanced quiz
            List<Map<String, Object>> questions = new ArrayList<>();
            questions.add(createQuizQuestion(1, "What is a decorator in Python?", 
                List.of("A function that modifies another function", "A data structure", "A loop construct", "A variable type"), 0));
            questions.add(createQuizQuestion(2, "What does __init__ represent in a class?", 
                List.of("Destructor", "Constructor", "Iterator", "Generator"), 1));
            questions.add(createQuizQuestion(3, "What is the purpose of 'self' in Python classes?", 
                List.of("Reference to the class", "Reference to the instance", "A keyword", "A variable"), 1));
            questions.add(createQuizQuestion(4, "What does @staticmethod do?", 
                List.of("Makes a method static", "Creates a decorator", "Defines a class", "Imports a module"), 0));
            questions.add(createQuizQuestion(5, "What is a generator in Python?", 
                List.of("A function that returns an iterator", "A data type", "A loop", "A class"), 0));
            
            model.addAttribute("questions", questions);
        }
        
        return "quiz";
    }

    @GetMapping("/challenge/debugging/{id}")
    public String debuggingChallenge(@PathVariable Long id, Model model) {
        model.addAttribute("activePage", "challenges");
        model.addAttribute("challengeId", id);
        
        // Set challenge-specific data based on ID
        if (id == 1) {
            model.addAttribute("challengeTitle", "Find the Bug");
            model.addAttribute("challengeDescription", "Identify and fix errors in broken Python code. Sharpen your debugging skills.");
            model.addAttribute("expReward", 125);
            model.addAttribute("brokenCode", "def calculate_average(numbers):\n    total = 0\n    for num in numbers:\n        total += num\n    average = total / len(numbers)  # Error: division by zero possible\n    return average\n\n# Test case\nresult = calculate_average([])  # This will cause an error\nprint(result)");
            model.addAttribute("expectedOutput", "# When calculate_average([1, 2, 3, 4, 5]) is called:\n# Expected output: 3.0\n\n# When calculate_average([]) is called:\n# Expected output: 0 or appropriate error handling");
            List<String> hints = new ArrayList<>();
            hints.add("Check for division by zero");
            hints.add("Consider what happens when the list is empty");
            model.addAttribute("errorHints", hints);
        } else if (id == 2) {
            model.addAttribute("challengeTitle", "Syntax Errors Hunt");
            model.addAttribute("challengeDescription", "Locate syntax errors, logic mistakes, and exception triggers in code snippets.");
            model.addAttribute("expReward", 100);
            model.addAttribute("brokenCode", "def factorial(n):\n    if n == 0 or n == 1:\n        return 1\n    else:\n        return n * factorial(n - 1)  # Missing base case handling\n\n# Test case\nresult = factorial(-1)  # This will cause infinite recursion\nprint(result)");
            model.addAttribute("expectedOutput", "# When factorial(5) is called:\n# Expected output: 120\n\n# When factorial(-1) is called:\n# Should handle negative numbers appropriately");
            List<String> hints = new ArrayList<>();
            hints.add("Check for negative number handling");
            hints.add("Look for infinite recursion possibilities");
            model.addAttribute("errorHints", hints);
        }
        
        return "debugging";
    }

    @GetMapping("/challenge/codesprint/{id}")
    public String codeSprintChallenge(@PathVariable Long id, Model model) {
        model.addAttribute("activePage", "challenges");
        model.addAttribute("challengeId", id);
        
        // Set challenge-specific data based on ID
        if (id == 1) {
            model.addAttribute("challengeTitle", "Speed Coding Challenge");
            model.addAttribute("challengeDescription", "Race against the clock! Solve problems under time pressure and improve your speed.");
            model.addAttribute("expReward", 200);
            model.addAttribute("timeLimit", 300); // 5 minutes
            model.addAttribute("problemDescription", "Write a Python function that takes a list of integers and returns the sum of all even numbers in the list. Complete this within the time limit!");
            
            List<Map<String, String>> examples = new ArrayList<>();
            Map<String, String> ex1 = new HashMap<>();
            ex1.put("input", "[1, 2, 3, 4, 5, 6]");
            ex1.put("output", "12");
            examples.add(ex1);
            Map<String, String> ex2 = new HashMap<>();
            ex2.put("input", "[10, 15, 20, 25]");
            ex2.put("output", "30");
            examples.add(ex2);
            model.addAttribute("examples", examples);
        } else if (id == 2) {
            model.addAttribute("challengeTitle", "5-Minute Challenge");
            model.addAttribute("challengeDescription", "Complete coding tasks within 5 minutes. Perfect your quick problem-solving skills.");
            model.addAttribute("expReward", 250);
            model.addAttribute("timeLimit", 300); // 5 minutes
            model.addAttribute("problemDescription", "Write a Python function that checks if a string is a palindrome (reads the same forwards and backwards). Ignore case and spaces.");
            
            List<Map<String, String>> examples = new ArrayList<>();
            Map<String, String> ex1 = new HashMap<>();
            ex1.put("input", "\"racecar\"");
            ex1.put("output", "True");
            examples.add(ex1);
            Map<String, String> ex2 = new HashMap<>();
            ex2.put("input", "\"A man a plan a canal Panama\"");
            ex2.put("output", "True");
            examples.add(ex2);
            model.addAttribute("examples", examples);
        }
        
        return "codesprint";
    }

    private Map<String, Object> createQuizQuestion(int number, String text, List<String> options, int correctIndex) {
        Map<String, Object> question = new HashMap<>();
        question.put("number", number);
        question.put("text", text);
        question.put("points", 10);
        
        List<Map<String, Object>> optionList = new ArrayList<>();
        for (int i = 0; i < options.size(); i++) {
            Map<String, Object> option = new HashMap<>();
            option.put("text", options.get(i));
            option.put("correct", i == correctIndex);
            optionList.add(option);
        }
        question.put("options", optionList);
        
        return question;
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
