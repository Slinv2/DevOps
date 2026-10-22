package com.example.demo;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void helloWithoutNameReturnsDefaultGreeting() throws Exception {
		mockMvc.perform(get("/api/hello"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.message", is("Hello, World!")));
	}

	@Test
	void helloWithNameReturnsPersonalizedGreeting() throws Exception {
		mockMvc.perform(get("/api/hello").param("name", "Nils"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.message", is("Hello, Nils!")));
	}

	@Test
	void statusReturnsUp() throws Exception {
		mockMvc.perform(get("/api/status"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status", is("UP")));
	}

	@Test
	void greetWithoutNameReturnsDefaultGreeting() throws Exception {
		mockMvc.perform(get("/api/greet"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.greeting", is("Hello World, World!")));
	}

	@Test
	void greetWithNameReturnsPersonalizedGreeting() throws Exception {
		mockMvc.perform(get("/api/greet").param("name", "Nils"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.greeting", is("Hello World, Nils!")));
	}

	@Test
	void greetingBuildsExpectedMessage() {
		HelloController controller = new HelloController();
		org.junit.jupiter.api.Assertions.assertEquals("Hello World, Test!", controller.greeting("Test"));
	}

}
