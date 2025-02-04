package com.laberry.junior.sbb.user;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
	private final UserService userService;

	@GetMapping("/sign-up")
	public String signup(UserCreateForm userCreateForm) {
		return "signup_form";
	}

	@PostMapping("/sign-up")
	public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "signup_form";
		}
		if (!userCreateForm.getPassword().equals(userCreateForm.getCheckPassword())) {
			bindingResult.rejectValue("checkPassword", "IncorrectPW", "비밀번호가 일치하지 않습니다.");
			return "signup_form";
		}
		
		try {
			this.userService.create(userCreateForm.getUsername(), userCreateForm.getPassword(), userCreateForm.getEmail());
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			bindingResult.reject("DupeUser", "이미 등록된 사용자 입니다.");
			return "signup_form";
		} catch (Exception e) {
			e.printStackTrace();
			bindingResult.reject("SignupFaild", e.getMessage());
			return "signup_form";
		}
		return "redirect:/";
	}
	
	@GetMapping("/sign-in")
	public String signin() {
		return "signin_form";
	}
}
