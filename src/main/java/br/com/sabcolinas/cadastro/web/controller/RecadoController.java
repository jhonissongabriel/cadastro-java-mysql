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

import br.com.sabcolinas.cadastro.model.Recado;
import br.com.sabcolinas.cadastro.service.RecadoService;
import br.com.sabcolinas.cadastro.view.View;

@RestController
@RequestMapping(value = "/recado")
@CrossOrigin
public class RecadoController {

	@Autowired
	private RecadoService recadoService;

	public void setRecadoService(RecadoService recadoService) {
		this.recadoService = recadoService;
	}

	@RequestMapping(value = "/getById", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Recado> pesquisarPorId(@RequestParam(value = "id", defaultValue = "1") Long id) {
		return new ResponseEntity<Recado>(recadoService.buscarId(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/getTelefone", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Recado>> pesquisarPorTelefone(@RequestParam(value = "telefone") String telefone) {
		return new ResponseEntity<Collection<Recado>>(recadoService.buscarTelefone(telefone), HttpStatus.OK);
	}

	@RequestMapping(value = "/getNome", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Recado>> pesquisarPorNome(@RequestParam(value = "nome") String nome) {
		return new ResponseEntity<Collection<Recado>>(recadoService.buscarNome(nome), HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Recado>> getAll() {
		return new ResponseEntity<Collection<Recado>>(recadoService.todos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@JsonView(View.Basico.class)
	public ResponseEntity<Recado> salvar(@RequestBody Recado recado, UriComponentsBuilder uriComponentsBuilder) {
		recado = recadoService.create(recado);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(uriComponentsBuilder.path("/getById/" + recado.getId()).build().toUri());
		return new ResponseEntity<Recado>(recado, responseHeaders, HttpStatus.CREATED);
	}

}
