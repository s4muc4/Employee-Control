package com.example.funcionario.repository;

import com.example.funcionario.entidade.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository <Funcionario, Integer> {

}