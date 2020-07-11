package com.ponto.services;

import java.util.Optional;

import com.ponto.model.Funcionario;

public interface FuncionarioService {
	
	Optional<Funcionario> buscarPorCpf(String cpf);
	
	Optional<Funcionario> buscarPorEmail(String cpf);
	
	Optional<Funcionario> buscarPorId(Long id);
	
	Funcionario persitir(Funcionario funcionario);

}
