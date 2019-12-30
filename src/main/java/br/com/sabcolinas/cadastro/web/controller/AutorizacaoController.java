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

import br.com.sabcolinas.cadastro.model.Autorizacao;
import br.com.sabcolinas.cadastro.service.AutorizacaoService;
import br.com.sabcolinas.cadastro.view.View;

@RestController
@RequestMapping(value = "/autorizacao")
@CrossOrigin
public class AutorizacaoController {

	@Autowired
	private AutorizacaoService autorizacaoService;

	public void setAutorizacaoService(AutorizacaoService autorizacaoService) {
		this.autorizacaoService = autorizacaoService;
	}

	@RequestMapping(value = "/getAutorizacao", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Autorizacao>> pesquisar(@RequestParam(value = "nome") String nome) {
		return new ResponseEntity<Collection<Autorizacao>>(autorizacaoService.buscar(nome), HttpStatus.OK);
	}

	@RequestMapping(value = "/getById", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Autorizacao> pesquisarPorId(@RequestParam(value = "id", defaultValue = "1") Long id) {
		return new ResponseEntity<Autorizacao>(autorizacaoService.buscarPorId(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Autorizacao>> getAll() {
		return new ResponseEntity<Collection<Autorizacao>>(autorizacaoService.todos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@JsonView(View.Basico.class)
	public ResponseEntity<Autorizacao> salvar(@RequestBody Autorizacao autorizacao,
			UriComponentsBuilder uriComponentsBuilder) {
		autorizacao = autorizacaoService.salvar(autorizacao);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(uriComponentsBuilder.path("/getById/" + autorizacao.getId()).build().toUri());
		return new ResponseEntity<Autorizacao>(autorizacao, responseHeaders, HttpStatus.CREATED);
	}


}
