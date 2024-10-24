package com.example.lesson04.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private StudentRepository studentRepository;
	
	// JPA
	public StudentEntity addStudent(String name, String phoneNumber
			, String email, String dreamJob) {
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.build();
		return studentRepository.save(student);
	};
	
	// mybatis
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	};
	
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	};
	
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		// pk가 있을시 save() - update
		StudentEntity student = studentRepository.findById(id).orElse(null);
		
		if (student != null) {
			student = student.toBuilder().dreamJob(dreamJob).build();
			return studentRepository.save(student);
		}
		return null;
	}
	
	public void deleteStudentById(int id) {
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		if (student != null) {
//			studentRepository.delete(student);
//		}
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);
		
		studentOptional.ifPresent(s -> studentRepository.delete(s));
	}
}
