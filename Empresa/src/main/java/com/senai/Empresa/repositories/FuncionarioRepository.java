package com.senai.Empresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.Empresa.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
