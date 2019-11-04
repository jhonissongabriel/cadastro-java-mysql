package br.com.sabcolinas.cadastro.service.implement;

import java.sql.Blob;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sabcolinas.cadastro.model.Animal;
import br.com.sabcolinas.cadastro.model.Conjuge;
import br.com.sabcolinas.cadastro.model.Contato;
import br.com.sabcolinas.cadastro.model.Dependente;
import br.com.sabcolinas.cadastro.model.Endereco;
import br.com.sabcolinas.cadastro.model.Pessoa;
import br.com.sabcolinas.cadastro.model.Proprietario;
import br.com.sabcolinas.cadastro.model.Recado;
import br.com.sabcolinas.cadastro.model.Trabalho;
import br.com.sabcolinas.cadastro.model.Veiculo;
import br.com.sabcolinas.cadastro.repository.AnimalRepository;
import br.com.sabcolinas.cadastro.repository.ConjugeRepository;
import br.com.sabcolinas.cadastro.repository.ContatoRepository;
import br.com.sabcolinas.cadastro.repository.DependenteRepository;
import br.com.sabcolinas.cadastro.repository.EnderecoRepository;
import br.com.sabcolinas.cadastro.repository.FuncionarioRepository;
import br.com.sabcolinas.cadastro.repository.PessoaRepository;
import br.com.sabcolinas.cadastro.repository.ProprietarioRepository;
import br.com.sabcolinas.cadastro.repository.RecadoRepository;
import br.com.sabcolinas.cadastro.repository.TrabalhoRepository;
import br.com.sabcolinas.cadastro.repository.VeiculoRepository;
import br.com.sabcolinas.cadastro.service.ProprietarioService;

@Service("proprietarioService")
public class ProprietarioServiceImpl implements ProprietarioService {

	@Autowired
	private ProprietarioRepository proprietarioRepo;

	@Autowired
	private PessoaRepository pessoaRepo;

	@Autowired
	private TrabalhoRepository trabalhoRepo;

	@Autowired
	private ConjugeRepository conjugeRepo;

	@Autowired
	private DependenteRepository dependenteRepo;

	@Autowired
	private FuncionarioRepository funcionarioRepo;

	@Autowired
	private EnderecoRepository enderecoRepo;

	@Autowired
	private ContatoRepository contatoRepo;

	@Autowired
	private RecadoRepository recadoRepo;

	@Autowired
	private VeiculoRepository veiculoRepo;

	@Autowired
	private AnimalRepository animalRepo;

	public void setProprietarioRepo(ProprietarioRepository proprietarioRepo) {
		this.proprietarioRepo = proprietarioRepo;
	}

	public void setPessoaRepo(PessoaRepository pessoaRepo) {
		this.pessoaRepo = pessoaRepo;
	}

	public void setTrabalhoRepo(TrabalhoRepository trabalhoRepo) {
		this.trabalhoRepo = trabalhoRepo;
	}

	public void setConjugeRepo(ConjugeRepository conjugeRepo) {
		this.conjugeRepo = conjugeRepo;
	}

	public void setDependenteRepo(DependenteRepository dependenteRepo) {
		this.dependenteRepo = dependenteRepo;
	}

	public void setFuncionarioRepo(FuncionarioRepository funcionarioRepo) {
		this.funcionarioRepo = funcionarioRepo;
	}

	public void setEnderecoRepo(EnderecoRepository enderecoRepo) {
		this.enderecoRepo = enderecoRepo;
	}

	public void setContatoRepo(ContatoRepository contatoRepo) {
		this.contatoRepo = contatoRepo;
	}

	public void setRecadoRepo(RecadoRepository recadoRepo) {
		this.recadoRepo = recadoRepo;
	}

	public void setVeiculoRepo(VeiculoRepository veiculoRepo) {
		this.veiculoRepo = veiculoRepo;
	}

	public void setAnimalRepo(AnimalRepository animalRepo) {
		this.animalRepo = animalRepo;
	}

	@Override
	@Transactional
	public Proprietario createProprietario(String cpf, String empresa, String profissao, String cpfConjuge,
			String rgDependente, String codigo, String telefone1, String telefone2, String email, String nomeRecado,
			String parentescoRecado, String telefoneRecado, String placa, String tipo, String raca, String nomeAnimal,
			String registroAnimal, Blob foto, String informacoes) {

		Pessoa pessoa = pessoaRepo.findByCpf(cpf);

		if (pessoa != null) {
			Proprietario proprietario = new Proprietario();
			proprietario.setPessoa(pessoa);
			Trabalho trabalho = trabalhoRepo.buscaEmpresaProfissao(empresa, profissao);
			
			Pessoa conj = pessoaRepo.findByCpf(cpfConjuge);
			Optional<Conjuge> conjuge = conjugeRepo.findById(conj.getId());

			Pessoa depe = pessoaRepo.buscaRg(rgDependente);
			Optional<Dependente> dependente = dependenteRepo.findById(depe.getId());
			
			Endereco endereco = enderecoRepo.findByCodigo(codigo);
			Contato contato = contatoRepo.buscaTelefone1Telefone2Email(telefone1, telefone2, email);
			Recado recado = recadoRepo.buscaRecado(nomeRecado, parentescoRecado, telefoneRecado);
			Veiculo veiculo = veiculoRepo.findByPlaca(placa);
			Animal animal = animalRepo.buscaAnimal(tipo, raca, nomeAnimal, registroAnimal);

			if (profissao != null) {
				proprietario.setTrabalho(trabalho);
			}
			if (conjuge != null) {
				proprietario.setConjuge(conjuge);
			}
			if(dependente != null) {
				proprietario.setDependente(dependente);
			}
		}

		return null;
	}

	@Override
	@Transactional
	public void updateProprietarioFoto(Blob fotoAntigo, Blob fotoNovo) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void updateProprietarioInformacoes(String informacoesAntigo, String informacoesNovo) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void deleteProprietario(Long id) {
		// TODO Auto-generated method stub

	}

}
