package br.com.sabcolinas.cadastro.service;

import br.com.sabcolinas.cadastro.model.Empresa;

public interface EmpresaService {

	public Empresa createEmpresa(String cnpj, String razaoSocial, String nomeFantasia, String logradouro, int numero, String cep);

	public void updateEmpresaCnpj(String cnpjAntigo, String cnpjNovo);

	public void updateEmpresaRazaoSocial(String razaoSocialAntigo, String razaoSocialNovo);

	public void updateEmpresaNomeFantasia(String nomeFantasiaAntigo, String nomeFantasiaNovo);

	public void deleteEmpresaCnpj(String cnpj);

}
