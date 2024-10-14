package com.example.lesson05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller
public class Lesson05Controller {

	@GetMapping("/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		List<String> fruits = new ArrayList<>();
		fruits.add("사과");
		fruits.add("파인애플");
		fruits.add("바나나");
		fruits.add("포도");
		fruits.add("망고");
		model.addAttribute("fruits", fruits);
		List<Map<String, Object>> users = new ArrayList<>();
		Map<String, Object> user1 = new HashMap<>();
		user1.put("name", "박상배");
		user1.put("age", 30);
		user1.put("hobby", "도색");
		users.add(user1);
		
		Map<String, Object> user2 = new HashMap<>();
		user2.put("name", "김씨");
		user2.put("age", 32);
		user2.put("hobby", "독서");
		users.add(user2);
		
		model.addAttribute("users", users);

		return "lesson05/ex02";
	}
}
