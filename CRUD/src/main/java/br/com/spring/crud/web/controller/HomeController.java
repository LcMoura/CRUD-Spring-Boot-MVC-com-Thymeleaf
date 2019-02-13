package br.com.spring.crud.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//transformar em um bean add uma anotação controller
@Controller
public class HomeController {

	//Para abrir a página home
	//GetMpping acessa a raiz - contexto
	@GetMapping("/")
	public String home() {
		return "/home";
	}
	
}
