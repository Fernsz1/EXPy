package com.appdev1.expy.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblReport")
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "reportId" 
)
public class ReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reportId;

    private String type;
    private LocalDateTime generatedDate;
    private String data;

    @ManyToOne(optional = false)
    @JoinColumn(name = "instructor_id", referencedColumnName = "user_id")
    //@JsonBackReference(value = "instructor-reports")  - no back reference here since we need
    //to see which instructor generated the report when fetching reports -z
    @JsonIdentityReference(alwaysAsId = true)
    private InstructorEntity instructor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", referencedColumnName = "user_id")
    //@JsonBackReference(value = "student-reports") - no back reference here since we need to see 
    // who the report is for when fetching reports -z
    @JsonIdentityReference(alwaysAsId = true)
    private StudentEntity student;

    public ReportEntity() {}

    public int getReportId() {
        return reportId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(LocalDateTime generatedDate) {
        this.generatedDate = generatedDate;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public InstructorEntity getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorEntity instructor) {
        this.instructor = instructor;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }


}
