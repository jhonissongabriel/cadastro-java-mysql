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

import br.com.sabcolinas.cadastro.model.Inquilino;
import br.com.sabcolinas.cadastro.service.InquilinoService;
import br.com.sabcolinas.cadastro.view.View;

@RestController
@RequestMapping(value = "/inquilino")
@CrossOrigin
public class InquilinoController {

	@Autowired
	private InquilinoService inquilinoService;

	public void setInquilinoService(InquilinoService inquilinoService) {
		this.inquilinoService = inquilinoService;
	}

	@RequestMapping(value = "/getById", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Inquilino> pesquisarPorId(@RequestParam(value = "id", defaultValue = "1") Long id) {
		return new ResponseEntity<Inquilino>(inquilinoService.buscarId(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/getEspecial", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Inquilino>> pesquisarPorEspecial(
			@RequestParam(value = "especial") boolean especial) {
		return new ResponseEntity<Collection<Inquilino>>(inquilinoService.buscarEspecial(especial), HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Inquilino>> getAll() {
		return new ResponseEntity<Collection<Inquilino>>(inquilinoService.todos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@JsonView(View.Basico.class)
	public ResponseEntity<Inquilino> salvar(@RequestBody Inquilino inquilino,
			UriComponentsBuilder uriComponentsBuilder) {
		inquilino = inquilinoService.create(inquilino);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(uriComponentsBuilder.path("/getById/" + inquilino.getId()).build().toUri());
		return new ResponseEntity<Inquilino>(inquilino, responseHeaders, HttpStatus.CREATED);
	}

}
