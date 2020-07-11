package com.ponto.test.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.ponto.enums.PerfilEnum;
import com.ponto.model.Empresa;
import com.ponto.model.Funcionario;
import com.ponto.repository.EmpresaRepository;
import com.ponto.repository.FuncionarioRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class FuncionarioRepositoryTest {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	private static final String CPF = "123456789";
	private static final String EMAIL = "email@email.com";
	
	@Before
	public void setUp() throws Exception{
		Empresa empresa = this.empresaRepository.save(obterEmpresa());
		this.funcionarioRepository.save(obterFuncionario(empresa));
	}
	
	@After
	public void tearDown() {
		this.empresaRepository.deleteAll();
	}
	
	@Test
	public void testBuscaFuncionarioPorCpf() {
		Funcionario funcionario = this.funcionarioRepository.findByCpf(CPF);
		assertEquals(CPF,funcionario.getCpf());
	}
	
	@Test
	public void testBuscaFuncionarioPorEmail() {
		Funcionario funcionario = this.funcionarioRepository.findByEmail(EMAIL);
		assertEquals(EMAIL,funcionario.getEmail());
	}
	
	@Test
	public void testBuscaFuncionarioPorCpfOuEmail() {
		Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(CPF, EMAIL);
		assertNotNull(funcionario);
	}
	
	@Test
	public void testBuscaFuncionarioPorCpfOuEmailECpfInvalido() {
		Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail("1234567", EMAIL);
		assertNotNull(funcionario);
	}
	
	@Test
	public void testBuscaFuncionarioPorCpfOuEmailEEmailInvalido() {
		Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(CPF, "123123123");
		assertNotNull(funcionario);
	}
	
	
	public Funcionario obterFuncionario(Empresa empresa) {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Leonardo");
		funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
		funcionario.setSenha("123456");
		funcionario.setCpf(CPF);
		funcionario.setEmail(EMAIL);
		funcionario.setEmpresa(empresa);
		return funcionario;
	}
	
	public Empresa obterEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setCnpj("1234556794");
		empresa.setRazaoSocial("ADIVINHA QUEM É");
		return empresa;
}
}
