package br.com.sabcolinas.cadastro.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sabcolinas.cadastro.model.Endereco;
import br.com.sabcolinas.cadastro.repository.EnderecoRepository;
import br.com.sabcolinas.cadastro.service.EnderecoService;

@Service("enderecoService")
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepo;

	public void setEnderecoRepo(EnderecoRepository enderecoRepo) {
		this.enderecoRepo = enderecoRepo;
	}

	@Override
	@Transactional
	public Endereco createEndereco(String logradouro, int numero, String codigo, String complemento, String bairro,
			String cep, String cidade, String estado) {
		Endereco endereco = enderecoRepo.buscaLogradouroNumeroCep(logradouro, numero, cep);

		if (endereco == null) {
			endereco = new Endereco();
			endereco.setLogradouro(logradouro);
			endereco.setNumero(numero);
			endereco.setCodigo(codigo);
			endereco.setComplemento(complemento);
			endereco.setBairro(bairro);
			endereco.setCidade(cidade);
			endereco.setEstado(estado);
			enderecoRepo.save(endereco);
			return endereco;
		}
		return null;
	}

	@Override
	@Transactional
	public void updateEnderecoLogradouro(String logradouroAntigo, String logradouroNovo) {
		Endereco endereco = enderecoRepo.findByLogradouro(logradouroAntigo);

		if (endereco != null) {
			endereco.setLogradouro(logradouroNovo);
			enderecoRepo.save(endereco);
		}
	}

	@Override
	@Transactional
	public void updateEnderecoNumero(int numeroAntigo, int numeroNovo) {
		Endereco endereco = enderecoRepo.findByNumero(numeroAntigo);

		if (endereco != null) {
			endereco.setNumero(numeroNovo);
			enderecoRepo.save(endereco);
		}
	}

	@Override
	@Transactional
	public void updateEnderecoCodigo(String codigoAntigo, String codigoNovo) {
		Endereco endereco = enderecoRepo.findByCodigo(codigoAntigo);

		if (endereco != null) {
			endereco.setCodigo(codigoNovo);
			enderecoRepo.save(endereco);
		}
	}

	@Override
	@Transactional
	public void updateEnderecoComplemento(String complementoAntigo, String complementoNovo) {
		Endereco endereco = enderecoRepo.findByComplemento(complementoAntigo);

		if (endereco != null) {
			endereco.setComplemento(complementoNovo);
			enderecoRepo.save(endereco);
		}
	}

	@Override
	@Transactional
	public void updateEnderecoBairro(String bairroAntigo, String bairroNovo) {
		Endereco endereco = enderecoRepo.findByBairro(bairroAntigo);

		if (endereco != null) {
			endereco.setBairro(bairroNovo);
			enderecoRepo.save(endereco);
		}
	}

	@Override
	@Transactional
	public void updateEnderecoCep(String cepAntigo, String cepNovo) {
		Endereco endereco = enderecoRepo.findByCep(cepAntigo);

		if (endereco != null) {
			endereco.setCep(cepNovo);
			enderecoRepo.save(endereco);
		}
	}

	@Override
	@Transactional
	public void updateEnderecoCidade(String cidadeAntigo, String cidadeNovo) {
		Endereco endereco = enderecoRepo.findByCidade(cidadeAntigo);

		if (endereco != null) {
			endereco.setCidade(cidadeNovo);
			enderecoRepo.save(endereco);
		}
	}

	@Override
	@Transactional
	public void updateEnderecoEstado(String estadoAntigo, String estadoNovo) {
		Endereco endereco = enderecoRepo.findByEstado(estadoAntigo);

		if (endereco != null) {
			endereco.setEstado(estadoNovo);
			enderecoRepo.save(endereco);
		}
	}

	@Override
	@Transactional
	public void deleteEnderecoCodigo(String codigo) {
		Endereco endereco = enderecoRepo.findByCodigo(codigo);

		if (endereco != null) {
			enderecoRepo.delete(endereco);
		}
	}

	@Override
	@Transactional
	public void deleteEnderecoLogradouroNumeroCep(String logradouro, int numero, String cep) {
		Endereco endereco = enderecoRepo.buscaLogradouroNumeroCep(logradouro, numero, cep);

		if (endereco != null) {
			enderecoRepo.delete(endereco);
		}
	}
	
	@Override
	@Transactional
	public void deleteEndereco(Long id) {
		enderecoRepo.deleteById(id);
		
	}

}
