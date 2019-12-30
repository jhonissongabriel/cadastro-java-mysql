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

import br.com.sabcolinas.cadastro.model.Contato;
import br.com.sabcolinas.cadastro.service.ContatoService;
import br.com.sabcolinas.cadastro.view.View;

@RestController
@RequestMapping(value = "/contato")
@CrossOrigin
public class ContatoController {

	@Autowired
	private ContatoService contatoService;

	public void setContatoService(ContatoService contatoService) {
		this.contatoService = contatoService;
	}

	@RequestMapping(value = "/getById", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Contato> pesquisarPorId(@RequestParam(value = "id", defaultValue = "1") Long id) {
		return new ResponseEntity<Contato>(contatoService.buscarId(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/getTelefone", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Contato>> pesquisarPorTelefone(@RequestParam(value = "telefone") String telefone) {
		return new ResponseEntity<Collection<Contato>>(contatoService.buscarTelefone(telefone), HttpStatus.OK);
	}

	@RequestMapping(value = "/getEmail", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Contato>> pesquisarPorEmail(@RequestParam(value = "email") String email) {
		return new ResponseEntity<Collection<Contato>>(contatoService.buscarEmail(email), HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Contato>> getAll() {
		return new ResponseEntity<Collection<Contato>>(contatoService.todos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@JsonView(View.Basico.class)
	public ResponseEntity<Contato> salvar(@RequestBody Contato contato, UriComponentsBuilder uriComponentsBuilder) {
		contato = contatoService.create(contato);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(uriComponentsBuilder.path("/getById/" + contato.getId()).build().toUri());
		return new ResponseEntity<Contato>(contato, responseHeaders, HttpStatus.CREATED);
	}

}
