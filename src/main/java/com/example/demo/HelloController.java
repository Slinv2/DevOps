package com.example.demo;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/api/hello")
	public Map<String, String> hello(@RequestParam(defaultValue = "World") String name) {
		return Map.of("message", "Hello, " + name + "!");
	}

	@GetMapping("/api/status")
	public Map<String, String> status() {
		return Map.of("status", "UP");
	}

}
