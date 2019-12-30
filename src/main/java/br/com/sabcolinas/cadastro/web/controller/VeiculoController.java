package br.com.sabcolinas.cadastro.web.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.sabcolinas.cadastro.model.Veiculo;
import br.com.sabcolinas.cadastro.service.VeiculoService;
import br.com.sabcolinas.cadastro.view.View;

@RestController
@RequestMapping(value = "/veiculo")
@CrossOrigin
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;

	public void setVeiculoService(VeiculoService veiculoService) {
		this.veiculoService = veiculoService;
	}

	@RequestMapping(value = "/getById", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Veiculo> pesquisarPorId(@RequestParam(value = "id", defaultValue = "1") Long id) {
		return new ResponseEntity<Veiculo>(veiculoService.buscarId(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/getMarca", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Veiculo>> pesquisarPorMarca(@RequestParam(value = "marca") String marca) {
		return new ResponseEntity<Collection<Veiculo>>(veiculoService.buscarMarca(marca), HttpStatus.OK);
	}

	@RequestMapping(value = "/getPlaca", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Veiculo>> pesquisarPorPlaca(@RequestParam(value = "placa") String placa) {
		return new ResponseEntity<Collection<Veiculo>>(veiculoService.buscarPlaca(placa), HttpStatus.OK);
	}

	@RequestMapping(value = "/getCor", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Veiculo>> pesquisarPorCor(@RequestParam(value = "cor") String cor) {
		return new ResponseEntity<Collection<Veiculo>>(veiculoService.buscarCor(cor), HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Veiculo>> getAll() {
		return new ResponseEntity<Collection<Veiculo>>(veiculoService.todos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@JsonView(View.Basico.class)
	public ResponseEntity<Veiculo> salvar(@RequestBody Veiculo veiculo, UriComponentsBuilder uriComponentsBuilder) {
		veiculo = veiculoService.create(veiculo);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(uriComponentsBuilder.path("/getById/" + veiculo.getId()).build().toUri());
		return new ResponseEntity<Veiculo>(veiculo, responseHeaders, HttpStatus.CREATED);
	}

}
