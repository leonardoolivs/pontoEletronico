package com.ponto.test.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.ponto.enums.TipoEnum;
import com.ponto.model.Lancamento;
import com.ponto.repository.LancamentoRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class LancamentoRepositoryTest {
	
		@Autowired
		private LancamentoRepository repository;
		
		private static final String DESCRICAO = "Irineu";
		
		@Before
		public void setUp() throws Exception {
			Lancamento lancamento = new Lancamento();
			lancamento.setDescricao(DESCRICAO);
			lancamento.setLocalizacao("Praça da Sé");
			lancamento.setTipo(TipoEnum.INICIO_ALMOCO);
			this.repository.save(lancamento);
		}
			
		@After
		public void tearDown() {
			this.repository.deleteAll();
		}
		
		@Test
		public void testBuscarPorDescricao() {
			this.repository.findByDescricao(DESCRICAO);
		}
}
