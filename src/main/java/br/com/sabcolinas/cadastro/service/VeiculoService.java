package br.com.sabcolinas.cadastro.service;

import br.com.sabcolinas.cadastro.model.Veiculo;

public interface VeiculoService {

	public Veiculo createVeiculo(String tipo, String marca, String modelo, String cor, String placa);

	public void updateVeiculoTipo(String tipoAntigo, String tipoNovo);

	public void updateVeiculoMarca(String marcaAntigo, String marcaNovo);

	public void updateVeiculoModelo(String modeloAntigo, String modeloNovo);

	public void updateVeiculoCor(String corAntigo, String corNovo);

	public void updateVeiculoPlaca(String placaAntigo, String placaNovo);

	public void updateVeiculoObservacao(String observacaoAntigo, String observacaoNovo);
	
	public void deleteVeiculo(String placa);

}
