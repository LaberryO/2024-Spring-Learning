package com.laberry.junior.sbb.user;

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
		this.userService.create(userCreateForm.getUsername(), userCreateForm.getPassword(), userCreateForm.getEmail());
		return "redirect:/";
	}
}
