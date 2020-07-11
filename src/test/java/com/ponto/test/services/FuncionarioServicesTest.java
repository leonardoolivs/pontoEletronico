package com.ponto.test.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.ponto.model.Funcionario;
import com.ponto.repository.FuncionarioRepository;
import com.ponto.services.FuncionarioService;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class FuncionarioServicesTest {

	@MockBean
	private FuncionarioRepository repository;
	
	@Autowired
	private FuncionarioService service;
	
	private static final String CPF = "123456789";
	private static final String EMAIL = "leo@leo.com.br";
	
	@Before
	public void setUp() throws Exception{
		BDDMockito.given(repository.findByCpf(Mockito.anyString())).willReturn(new Funcionario());
		BDDMockito.given(repository.findByEmail(Mockito.anyString())).willReturn(new Funcionario());
		BDDMockito.given(repository.save(Mockito.any(Funcionario.class))).willReturn(new Funcionario());
	}
	
	@Test
	public void testPersistir() {
		Funcionario funcionario = service.persitir(new Funcionario());
		assertNotNull(funcionario);
	}
	
	@Test
	public void testBuscaPorCpf() {
		Optional<Funcionario> funcionario = service.buscarPorCpf(CPF);
		assertTrue(funcionario.isPresent());
	}
	
	@Test
	public void testBuscaPorEmail() {
		Optional<Funcionario> funcionario = service.buscarPorEmail(EMAIL);
		assertTrue(funcionario.isPresent());
	}

}
