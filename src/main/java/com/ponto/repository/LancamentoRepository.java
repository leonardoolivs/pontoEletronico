package com.ponto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ponto.model.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento,Long>{
	
	@Transactional(readOnly=true)
	Lancamento findByDescricao(String descricao);

}
