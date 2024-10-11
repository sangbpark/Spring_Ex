package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.domain.Student;

@RequestMapping("/lesson04/ex02")
@Controller
public class Lesson04Ex02Controller {
	
	@Autowired
	private StudentBO studentBO;
	
	// 학생 추가 화면
	// http://localhost/lesson04/ex02/add-student-view
	@GetMapping("/add-student-view")
	public String addStudentView() {
		return "lesson04/addStudent"; 
	}
	
	// 학생 DB 추가 => 방금 가입한 학생 화면 이건 객체로 받아와야 가능하다
	@PostMapping("/add-student")
	public String addStudent(
			Model model,
			@ModelAttribute Student student ) { // form 태그의 name과 field가 일치하면 세팅됨
		// DB Insert
		studentBO.addStudent(student); // mybatis는 insert 후 select을 한번 해본다
		// DB select
		Student latestStudent = studentBO.getStudentById(student.getId());
		// Model에 최근 학생을 담는다.
		model.addAttribute("student", latestStudent);
		
		return "lesson04/afterAddStudent";
	}
}
