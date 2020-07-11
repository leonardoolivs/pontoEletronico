package com.ponto.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ponto.model.Empresa;
import com.ponto.repository.EmpresaRepository;
import com.ponto.services.EmpresaServices;

@Service
public class EmpresaServicesImpl implements EmpresaServices{
	
	private static final Logger log = LoggerFactory.getLogger(EmpresaServicesImpl.class);
	
	@Autowired
	private EmpresaRepository repository;

	@Override
	public Empresa buscaPorCnpj(String cnpj) {
		log.info("Buscando a empresa para o CNPJ {}",cnpj);
		return this.repository.findByCnpj(cnpj);
	}

	@Override
	public Empresa persistir(Empresa empresa) {
		log.info("Adicionando a empresa: {}",empresa);
		return repository.save(empresa);
	}
	


}
