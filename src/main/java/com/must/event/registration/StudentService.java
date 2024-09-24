package com.must.event.registration;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student findByUsername(String username) {
        return studentRepository.findByUsername(username);
    }

    public void registerStudent(Student student) {
        studentRepository.save(student);
    }
}
