package com.ponto.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ponto.model.Funcionario;
import com.ponto.repository.FuncionarioRepository;
import com.ponto.services.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{

	private static final Logger log = LoggerFactory.getLogger(FuncionarioServiceImpl.class);
	
	@Autowired
	private FuncionarioRepository repository;
	
	@Override
	public Optional<Funcionario> buscarPorCpf(String cpf) {
		log.info("Buscando Funcionario pelo CPF {}",cpf);
		return Optional.ofNullable(repository.findByCpf(cpf));
	}

	@Override
	public Optional<Funcionario> buscarPorEmail(String email) {
		log.info("Buscando Funcionario pelo Email {}",email);
		return Optional.ofNullable(repository.findByEmail(email));
	}

	@Override
	public Optional<Funcionario> buscarPorId(Long id) {
		log.info("Buscando Funcionario pelo ID {}",id);
		return repository.findById(id);
	}

	@Override
	public Funcionario persitir(Funcionario funcionario) {
		log.info("Persistindo o usuário {}",funcionario);
		return repository.save(funcionario);
	}

	
}
