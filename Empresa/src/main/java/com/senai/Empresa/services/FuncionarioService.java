package com.senai.Empresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.Empresa.entities.Funcionario;
import com.senai.Empresa.repositories.FuncionarioRepository;


@Service
public class FuncionarioService {
	private final FuncionarioRepository funcionarioRepository;

	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public Funcionario saveFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public Funcionario getFuncionarioById(Long funcodigo) {
		return funcionarioRepository.findById(funcodigo).orElse(null);
	}

	public List<Funcionario> getAllFuncionarios() {
		return funcionarioRepository.findAll();
	}

	public void deleteFuncionario(Long funcodigo) {
		funcionarioRepository.deleteById(funcodigo);
	}
	// fazendo o update do Departamento com o optional
		public Funcionario updateFuncionario(Long funcodigo, Funcionario novoFuncionario) {
	        Optional<Funcionario> FuncionarioOptional = funcionarioRepository.findById(funcodigo);
	        if (FuncionarioOptional.isPresent()) {
	        	Funcionario funcionarioExistente = FuncionarioOptional.get();
	        	funcionarioExistente.setFunnome(novoFuncionario.getFunnome()); 
	        	funcionarioExistente.setFunnascimento(novoFuncionario.getFunnascimento());          
	        	funcionarioExistente.setFunsalario(novoFuncionario.getFunsalario());                    
	            return funcionarioRepository.save(funcionarioExistente); 
	        } else {
	            return null; 
	            
	        }
	    }
}



