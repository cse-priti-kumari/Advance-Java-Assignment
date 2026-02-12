package com.calculator.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import com.calculator.demo.Student;
import com.calculator.demo.StudentService;

public class StudentServiceTest {

    private StudentService service;
    private Student student;

    @BeforeEach
    void setup() {
        service = new StudentService();
        student = new Student(
                1, "Ritika", 20,
                80, 90, 95);
    }

    @Test
    void testTotal() {
        assertEquals(265,
            service.calculateTotal(student));
    }

    @Test
    void testAverage() {
        assertEquals(88.33,
            service.calculateAverage(student),
            0.01);   // delta
    }

    @Test
    void testPassed() {
        assertTrue(
            service.isPassed(student));
    }
}
