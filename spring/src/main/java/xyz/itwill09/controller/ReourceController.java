package xyz.itwill09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReourceController {
	@RequestMapping("/resource")
	public String resource() {
		return "resource_display";
	}
}
