package br.com.spring.crud.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.spring.crud.domain.Departamento;
import br.com.spring.crud.service.DepartamentoService;

@Controller
//Criar o link das páginas
//Define a url que quando for requisitada chamara o metodo
@RequestMapping("/departamentos")
public class DepartamentoController {

	@Autowired
	// Para acessar os métodos do service
	private DepartamentoService service;
	
	//Link: http://localhost:8080/departamentos/cadastrar
	@GetMapping("/cadastrar")
	public String cadastrar(Departamento departamento, ModelMap model) {
		model.addAttribute("sucess", "Departamento cadastrado com sucesso.");
		return "/departamento/cadastro"; // Na pasta Template - pasta departamento e arquivo cadastro.html
	}
	
	//Link: localhost:8080/departamentos/listar
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("departamentos", service.buscarTodos()); // departamentos = nome da variável esperado na página
		return "/departamento/lista"; // Na pasta Template - pasta departamento e arquivo lista.html
	}
	
	@PostMapping("/salvar")
	public String salvar(Departamento departamento, ModelMap model) {
		service.salvar(departamento);
		model.addAttribute("sucess", "Departamento salvo com sucesso.");
		return ("redirect:/departamentos/cadastrar"); // Redirecionar para a tela de cadastro
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("departamento", service.buscarPorId(id));
		return "/departamento/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Departamento departamento, ModelMap model) {
		service.editar(departamento);
		model.addAttribute("success", "Departamento excluído com sucesso.");
		return "redirect:/departamentos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("success", "Departamento excluído com sucesso.");		
		return listar(model);
	}
}
