package br.com.sabcolinas.cadastro.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sabcolinas.cadastro.model.Empresa;
import br.com.sabcolinas.cadastro.model.Endereco;
import br.com.sabcolinas.cadastro.repository.EmpresaRepository;
import br.com.sabcolinas.cadastro.repository.EnderecoRepository;
import br.com.sabcolinas.cadastro.service.EmpresaService;

@Service("empresaService")
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepo;

	@Autowired
	private EnderecoRepository enderecoRepo;

	public void setEmpresaRepo(EmpresaRepository empresaRepo) {
		this.empresaRepo = empresaRepo;
	}

	public void setEnderecoRepo(EnderecoRepository enderecoRepo) {
		this.enderecoRepo = enderecoRepo;
	}

	@Override
	@Transactional
	public Empresa createEmpresa(String cnpj, String razaoSocial, String nomeFantasia, String logradouro, int numero,
			String cep) {
		Empresa empresa = empresaRepo.findByCnpj(cnpj);

		if (empresa == null) {
			Endereco endereco = enderecoRepo.buscaLogradouroNumeroCep(logradouro, numero, cep);
			empresa = new Empresa();
			empresa.setCnpj(cnpj);
			empresa.setRazaoSocial(razaoSocial);
			empresa.setNomeFantasia(nomeFantasia);

			if (endereco != null) {
				empresa.setEndereco(endereco);
				empresaRepo.save(empresa);
				return empresa;
			}
			empresaRepo.save(empresa);
			return empresa;
		}
		return null;
	}

	@Override
	@Transactional
	public void updateEmpresaCnpj(String cnpjAntigo, String cnpjNovo) {
		Empresa empresa = empresaRepo.findByCnpj(cnpjAntigo);

		if (empresa != null) {
			empresa.setCnpj(cnpjNovo);
			empresaRepo.save(empresa);
		}
	}

	@Override
	@Transactional
	public void updateEmpresaRazaoSocial(String razaoSocialAntigo, String razaoSocialNovo) {
		Empresa empresa = empresaRepo.findByRazaoSocial(razaoSocialAntigo);

		if (empresa != null) {
			empresa.setCnpj(razaoSocialNovo);
			empresaRepo.save(empresa);
		}
	}

	@Override
	@Transactional
	public void updateEmpresaNomeFantasia(String nomeFantasiaAntigo, String nomeFantasiaNovo) {
		Empresa empresa = empresaRepo.findByNomeFantasia(nomeFantasiaAntigo);

		if (empresa != null) {
			empresa.setCnpj(nomeFantasiaNovo);
			empresaRepo.save(empresa);
		}
	}

	@Override
	@Transactional
	public void deleteEmpresaCnpj(String cnpj) {
		Empresa empresa = empresaRepo.findByCnpj(cnpj);

		if (empresa != null) {
			empresaRepo.delete(empresa);
		}
	}

}
