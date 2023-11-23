package com.senai.Empresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.Empresa.entities.Departamento;
import com.senai.Empresa.repositories.DepartamentoRepository;


@Service
public class DepartamentoService {
	private final DepartamentoRepository departamentoRepository;

	@Autowired
	public DepartamentoService(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}

	public Departamento saveDepartamento(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}

	public Departamento getDepartamentoById(Long depcodigo) {
		return departamentoRepository.findById(depcodigo).orElse(null);
	}

	public List<Departamento> getAllDepartamentos() {
		return departamentoRepository.findAll();
	}

	public void deleteDepartamento(Long depcodigo) {
		departamentoRepository.deleteById(depcodigo);
	}
	// fazendo o update do Departamento com o optional
		public Departamento updateDepartamento(Long depcodigo, Departamento novoDepartamento) {
	        Optional<Departamento> DepartamentoOptional = departamentoRepository.findById(depcodigo);
	        if (DepartamentoOptional.isPresent()) {
	        	Departamento departamentoExistente = DepartamentoOptional.get();
	        	departamentoExistente.setDepnome(novoDepartamento.getDepnome());          
	            return departamentoRepository.save(departamentoExistente); 
	        } else {
	            return null; 
	            
	        }
	    }
}


