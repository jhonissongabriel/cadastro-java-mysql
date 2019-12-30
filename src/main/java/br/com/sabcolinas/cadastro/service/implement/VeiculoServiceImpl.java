package br.com.sabcolinas.cadastro.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sabcolinas.cadastro.model.Veiculo;
import br.com.sabcolinas.cadastro.repository.VeiculoRepository;
import br.com.sabcolinas.cadastro.service.VeiculoService;

@Service("veiculoService")
@Transactional
public class VeiculoServiceImpl implements VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepo;

	public void setVeiculoRepo(VeiculoRepository veiculoRepo) {
		this.veiculoRepo = veiculoRepo;
	}

	@Override
	public Veiculo create(Veiculo veiculo) {
		return veiculoRepo.save(veiculo);
	}

	@Override
	public void delete(Long id) {
		veiculoRepo.deleteById(id);
	}

	@Override
	public void updateMarca(String marcaAntigo, String marcaNovo) {
		Veiculo veiculo = veiculoRepo.findByMarca(marcaAntigo);
		if (veiculo != null) {
			veiculo.setMarca(marcaNovo);
			veiculoRepo.save(veiculo);
		}
	}

	@Override
	public void updatePlaca(String placaAntigo, String placaNovo) {
		Veiculo veiculo = veiculoRepo.findByPlaca(placaAntigo);
		if (veiculo != null) {
			veiculo.setPlaca(placaNovo);
			veiculoRepo.save(veiculo);
		}
	}

	@Override
	public void updateCor(String corAntigo, String corNovo) {
		Veiculo veiculo = veiculoRepo.findByCor(corAntigo);
		if (veiculo != null) {
			veiculo.setCor(corNovo);
			veiculoRepo.save(veiculo);
		}
	}

	@Override
	public List<Veiculo> todos() {
		List<Veiculo> retorno = new ArrayList<Veiculo>();
		for (Veiculo veiculo : veiculoRepo.findAll()) {
			retorno.add(veiculo);
		}
		return retorno;
	}

	@Override
	public Veiculo buscarId(Long id) {
		Optional<Veiculo> veiculo = veiculoRepo.findById(id);
		if (veiculo.isPresent()) {
			return veiculo.get();
		}
		return null;
	}

	@Override
	public List<Veiculo> buscarMarca(String marca) {
		List<Veiculo> retorno = new ArrayList<Veiculo>();
		for (Veiculo veiculo : veiculoRepo.findByMarcaContains(marca)) {
			retorno.add(veiculo);
		}
		return retorno;
	}

	@Override
	public List<Veiculo> buscarPlaca(String placa) {
		List<Veiculo> retorno = new ArrayList<Veiculo>();
		for (Veiculo veiculo : veiculoRepo.findByPlacaContains(placa)) {
			retorno.add(veiculo);
		}
		return retorno;
	}

	@Override
	public List<Veiculo> buscarCor(String cor) {
		List<Veiculo> retorno = new ArrayList<Veiculo>();
		for (Veiculo veiculo : veiculoRepo.findByCorContains(cor)) {
			retorno.add(veiculo);
		}
		return retorno;
	}

}
