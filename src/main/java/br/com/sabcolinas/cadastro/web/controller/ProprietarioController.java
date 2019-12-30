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

import br.com.sabcolinas.cadastro.model.Proprietario;
import br.com.sabcolinas.cadastro.service.ProprietarioService;
import br.com.sabcolinas.cadastro.view.View;

@RestController
@RequestMapping(value = "/proprietario")
@CrossOrigin
public class ProprietarioController {

	@Autowired
	private ProprietarioService proprietarioService;

	public void setProprietarioService(ProprietarioService proprietarioService) {
		this.proprietarioService = proprietarioService;
	}

	@RequestMapping(value = "/getById", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Proprietario> pesquisarPorId(@RequestParam(value = "id", defaultValue = "1") Long id) {
		return new ResponseEntity<Proprietario>(proprietarioService.buscarId(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/getEspecial", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Proprietario>> pesquisarPorEspecial(
			@RequestParam(value = "especial") boolean especial) {
		return new ResponseEntity<Collection<Proprietario>>(proprietarioService.buscarEspecial(especial),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Proprietario>> getAll() {
		return new ResponseEntity<Collection<Proprietario>>(proprietarioService.todos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@JsonView(View.Basico.class)
	public ResponseEntity<Proprietario> salvar(@RequestBody Proprietario proprietario,
			UriComponentsBuilder uriComponentsBuilder) {
		proprietario = proprietarioService.create(proprietario);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(uriComponentsBuilder.path("/getById/" + proprietario.getId()).build().toUri());
		return new ResponseEntity<Proprietario>(proprietario, responseHeaders, HttpStatus.CREATED);
	}

}
