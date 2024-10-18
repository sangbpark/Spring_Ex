package com.example.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@RequestMapping("/lesson06/ex02")
@Controller
public class Lesson06Ex02Controller {
	@Autowired
	private UserBO userBO;
	
	// 회원가입 화면
	// /sign-up-view
	@GetMapping("/sign-up-view")
	public String singUpView() {
		return "lesson06/signUp";
	}
	
	@ResponseBody
	@GetMapping("/is-duplicated-name")
	public Map<String, Object> isDuplicatedName(
			@RequestParam("name") String name) {
		boolean isDuplicated = userBO.isDuplicatedName(name);
		// {"code":200, "is_duplicated_name":true of false}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplicated_name", isDuplicated);
		return result;
	};
	
}
