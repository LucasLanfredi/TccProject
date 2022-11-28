package com.TCCProject.TCCPROJECT;

import com.TCCProject.TCCPROJECT.DTO.SignupRequest;
import com.TCCProject.TCCPROJECT.DTO.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;

@SpringBootTest
class TccprojectApplicationTests {

	@Autowired
	UserDTO user;

	@Autowired
	SignupRequest newUser;

	@BeforeEach
	public void init() throws Exception {
		newUser.setDescricao("Qualquer");
		newUser.setEmail("lucas.lanfredi@gmail.com");
		newUser.setDataNascimento(Calendar.getInstance().getTime());
		newUser.setFirstName("Lucas");
		newUser.setLastName("Lanfredi");
		newUser.setPassword("12345");
		newUser.setRole("user");
		newUser.setId(1L);
		newUser.setUsername();
		newUser.setIdResponsavel();


		user.set
		user.setEmail();
		user.setUsername();
		user.setDescricao();
		user.setFirstName();
		user.setDataNascimento();
	}

	@Test
	void contextLoads() {
	}

	@Test
	void testeUsuario() {
		Us
	}

	@Test
	void criarAtividade() {

	}

	@Test
	void realizarAtividade(){

	}

}
