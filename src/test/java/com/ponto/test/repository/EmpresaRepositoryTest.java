package com.ponto.test.repository;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.ponto.model.Empresa;
import com.ponto.repository.EmpresaRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class EmpresaRepositoryTest {

	@Autowired
	private EmpresaRepository repository;

	private static final String CNPJ = "123456789";

	@Before
	public void setUp() throws Exception {
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("Irineu");
		empresa.setCnpj(CNPJ);
		this.repository.save(empresa);
	}

	@After
	public final void tearDown() {
		this.repository.deleteAll();
	}

	@Test
	public void testBuscarPorCnpj() {
		Empresa empresa = this.repository.findByCnpj(CNPJ);
		assertEquals(CNPJ, empresa.getCnpj());
	}
}