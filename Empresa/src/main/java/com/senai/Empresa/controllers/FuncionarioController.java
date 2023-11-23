package com.senai.Empresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.Empresa.entities.Funcionario;
import com.senai.Empresa.services.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	private final FuncionarioService funcionarioService;
	
	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}
	
	@PostMapping
	public Funcionario createFuncionario (@RequestBody Funcionario funcionario) {
		return funcionarioService.saveFuncionario(funcionario);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> getFuncionario (@PathVariable Long funcodigo) {
		Funcionario funcionario = funcionarioService.getFuncionarioById(funcodigo);
		if (funcionario !=null) {
			return ResponseEntity.ok(funcionario);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping ("/home")
	public String paginaInicial () {
		return 	"index";
	}
	
	public List<Funcionario> getAllFuncionarios(){
		return funcionarioService.getAllFuncionarios();
	}
	
	@DeleteMapping("/{id}")
	public void deleteFuncionario (@PathVariable Long funnome) {
		funcionarioService.deleteFuncionario(funnome);
	}
	//Utilizando o ResponseEntity e RequestEntity
		@GetMapping
		public ResponseEntity<List<Funcionario>> getAllFuncionarios(RequestEntity<Void> requestEntity) {
			String method = requestEntity.getMethod().name();
			String contentType = requestEntity.getHeaders().getContentType().toString();
			List<Funcionario> funcionarios = funcionarioService.getAllFuncionarios();
			return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
					.body(funcionarios);
		}
		
		@PutMapping("/{id}")
		public Funcionario updateFuncionario(@PathVariable Long funcodigo, @RequestBody Funcionario funcionario) {
		    return funcionarioService.updateFuncionario(funcodigo, funcionario);
		}
}
