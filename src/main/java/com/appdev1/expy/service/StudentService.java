package com.appdev1.expy.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev1.expy.entity.StudentEntity;
import com.appdev1.expy.entity.UserEntity;
import com.appdev1.expy.repository.StudentRepository;
import com.appdev1.expy.repository.userRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private userRepository userRepository;

    @Autowired
    private userService userService;

    public StudentService(StudentRepository studentRepository,
                          userRepository userRepository,
                          userService userService) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    // C
    public StudentEntity createStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    // R
    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<StudentEntity> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    // U
    public StudentEntity updateStudent(int id, StudentEntity updatedStudent) {
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Student with ID " + id + " not found"));

        student.setUsername(updatedStudent.getUsername());
        student.setEmail(updatedStudent.getEmail());
        student.setPassword_hash(updatedStudent.getPassword_hash());
        student.setRole(updatedStudent.getRole());
        student.setStatus(updatedStudent.getStatus());
        student.setTotal_exp(updatedStudent.getTotal_exp());
        student.setLevel(updatedStudent.getLevel());
        student.setCurrent_streak(updatedStudent.getCurrent_streak());
        // student.setReports(updatedStudent.getReports());
        // student.setActivities(updatedStudent.getActivities());
        // student.setCohorts(updatedStudent.getCohorts());
        // student.setLeaderboards(updatedStudent.getLeaderboards());
        // student.setBadges(updatedStudent.getBadges());

        return studentRepository.save(student);
    }

    // D
    public String deleteStudent(int id) {
        Optional<UserEntity> userOpt = userRepository.findById(id);
        if (!userOpt.isPresent()) {
            return "Student with id " + id + " not found";
        }
        UserEntity user = userOpt.get();
        if (!(user instanceof StudentEntity)) {
            return "Student with id " + id + " not found";
        }

        return userService.deleteUser(id);
    }

    
}
