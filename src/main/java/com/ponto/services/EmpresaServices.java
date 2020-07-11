package com.ponto.services;

import com.ponto.model.Empresa;

public interface EmpresaServices {
	
	Empresa buscaPorCnpj(String cnpj);
	
	Empresa persistir(Empresa empresa);

}
