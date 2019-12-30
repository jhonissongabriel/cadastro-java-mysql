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

import br.com.sabcolinas.cadastro.model.Morador;
import br.com.sabcolinas.cadastro.service.MoradorService;
import br.com.sabcolinas.cadastro.view.View;

@RestController
@RequestMapping(value = "/morador")
@CrossOrigin
public class MoradorController {

	@Autowired
	private MoradorService moradorService;

	public void setMoradorService(MoradorService moradorService) {
		this.moradorService = moradorService;
	}

	@RequestMapping(value = "/getById", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Morador> pesquisarPorId(@RequestParam(value = "id", defaultValue = "1") Long id) {
		return new ResponseEntity<Morador>(moradorService.buscarId(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/getParentesco", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Morador>> pesquisarPorParentesco(
			@RequestParam(value = "parentesco") String parentesco) {
		return new ResponseEntity<Collection<Morador>>(moradorService.buscarParentesco(parentesco), HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Morador>> getAll() {
		return new ResponseEntity<Collection<Morador>>(moradorService.todos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@JsonView(View.Basico.class)
	public ResponseEntity<Morador> salvar(@RequestBody Morador morador, UriComponentsBuilder uriComponentsBuilder) {
		morador = moradorService.create(morador);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(uriComponentsBuilder.path("/getById/" + morador.getId()).build().toUri());
		return new ResponseEntity<Morador>(morador, responseHeaders, HttpStatus.CREATED);
	}
}
