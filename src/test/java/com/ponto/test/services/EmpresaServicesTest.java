package com.ponto.test.services;

import static org.junit.Assert.assertNotNull;

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

import com.ponto.model.Empresa;
import com.ponto.repository.EmpresaRepository;
import com.ponto.services.EmpresaServices;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class EmpresaServicesTest {
	
	private static final String CNPJ = "123456789";
	
	@MockBean
	private EmpresaRepository repository;
	
	@Autowired
	private EmpresaServices service;
	
	@Before
	public void setUp() throws Exception {
		BDDMockito.given(this.repository.findByCnpj(Mockito.anyString())).willReturn(new Empresa());
		BDDMockito.given(this.repository.save(Mockito.any(Empresa.class))).willReturn(new Empresa());
	}
	
	@Test
	public void testBuscaPorCnpj() {
		Empresa empresa = this.service.buscaPorCnpj(CNPJ);
		assertNotNull(empresa);
	}
	
	@Test
	public void testPersistir() {
		Empresa empresa = this.service.persistir(new Empresa());
		assertNotNull(empresa);
	}
	
}
