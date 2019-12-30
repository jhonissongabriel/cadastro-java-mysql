package br.com.sabcolinas.cadastro.service;

import java.util.List;

import br.com.sabcolinas.cadastro.model.Veiculo;

public interface VeiculoService {

	public Veiculo create(Veiculo veiculo);

	public void delete(Long id);

	public void updateMarca(String marcaAntigo, String marcaNovo);

	public void updatePlaca(String placaAntigo, String placaNovo);

	public void updateCor(String corAntigo, String corNovo);

	public List<Veiculo> todos();

	public Veiculo buscarId(Long id);

	public List<Veiculo> buscarMarca(String marca);

	public List<Veiculo> buscarPlaca(String placa);

	public List<Veiculo> buscarCor(String cor);

}
