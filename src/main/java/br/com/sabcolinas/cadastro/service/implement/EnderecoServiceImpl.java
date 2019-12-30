package br.com.sabcolinas.cadastro.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sabcolinas.cadastro.model.Endereco;
import br.com.sabcolinas.cadastro.repository.EnderecoRepository;
import br.com.sabcolinas.cadastro.service.EnderecoService;

@Service("enderecoService")
@Transactional
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepo;

	public void setEnderecoRepo(EnderecoRepository enderecoRepo) {
		this.enderecoRepo = enderecoRepo;
	}

	@Override
	public Endereco create(Endereco endereco) {
		return enderecoRepo.save(endereco);
	}

	@Override
	public void delete(Long id) {
		enderecoRepo.deleteById(id);
	}

	@Override
	public void updateRua(String ruaAntigo, String ruaNovo) {
		Endereco endereco = enderecoRepo.findByRua(ruaAntigo);
		if (endereco != null) {
			endereco.setRua(ruaNovo);
			enderecoRepo.save(endereco);
		}
	}

	@Override
	public void updateNumero(int numeroAntigo, int numeroNovo) {
		Endereco endereco = enderecoRepo.findByNumero(numeroAntigo);
		if (endereco != null) {
			endereco.setNumero(numeroNovo);
			enderecoRepo.save(endereco);
		}
	}

	@Override
	public void updateCodigo(String codigoAntigo, String codigoNovo) {
		Endereco endereco = enderecoRepo.findByCodigo(codigoAntigo);
		if (endereco != null) {
			endereco.setCodigo(codigoNovo);
			enderecoRepo.save(endereco);
		}
	}

	@Override
	public void updateCep(String cepAntigo, String cepNovo) {
		Endereco endereco = enderecoRepo.findByCep(cepAntigo);
		if (endereco != null) {
			endereco.setCep(cepNovo);
			enderecoRepo.save(endereco);
		}
	}

	@Override
	public List<Endereco> todos() {
		List<Endereco> retorno = new ArrayList<Endereco>();
		for (Endereco endereco : enderecoRepo.findAll()) {
			retorno.add(endereco);
		}
		return retorno;
	}

	@Override
	public Endereco buscarId(Long id) {
		Optional<Endereco> endereco = enderecoRepo.findById(id);
		if (endereco.isPresent()) {
			return endereco.get();
		}
		return null;
	}

	@Override
	public List<Endereco> buscarRua(String rua) {
		List<Endereco> retorno = new ArrayList<Endereco>();
		for (Endereco endereco : enderecoRepo.findByRuaContains(rua)) {
			retorno.add(endereco);
		}
		return retorno;
	}

	@Override
	public List<Endereco> buscarNumero(int numero) {
		List<Endereco> retorno = new ArrayList<Endereco>();
		for (Endereco endereco : enderecoRepo.findByNumeroContains(numero)) {
			retorno.add(endereco);
		}
		return retorno;
	}

	@Override
	public List<Endereco> buscarCodigo(String codigo) {
		List<Endereco> retorno = new ArrayList<Endereco>();
		for (Endereco endereco : enderecoRepo.findByCodigoContains(codigo)) {
			retorno.add(endereco);
		}
		return retorno;
	}

	@Override
	public List<Endereco> buscarCep(String cep) {
		List<Endereco> retorno = new ArrayList<Endereco>();
		for (Endereco endereco : enderecoRepo.findByCepContains(cep)) {
			retorno.add(endereco);
		}
		return retorno;
	}

}
