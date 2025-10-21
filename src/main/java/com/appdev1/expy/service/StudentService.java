package com.appdev1.expy.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev1.expy.entity.StudentEntity;
import com.appdev1.expy.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
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
        Optional<StudentEntity> studentOpt = studentRepository.findById(id);
        if (studentOpt.isPresent()) {
            studentRepository.deleteById(id);
            return "Student with id " + id + " deleted successfully";
        } else {
            return "Student with id " + id + " not found";
        }
    }

    
}
