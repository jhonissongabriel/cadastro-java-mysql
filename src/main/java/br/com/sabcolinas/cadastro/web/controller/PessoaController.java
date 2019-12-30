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

import br.com.sabcolinas.cadastro.model.Pessoa;
import br.com.sabcolinas.cadastro.service.PessoaService;
import br.com.sabcolinas.cadastro.view.View;

@RestController
@RequestMapping(value = "/pessoa")
@CrossOrigin
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	public void setPessoaService(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	@RequestMapping(value = "/getById", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Pessoa> pesquisarPorId(@RequestParam(value = "id", defaultValue = "1") Long id) {
		return new ResponseEntity<Pessoa>(pessoaService.buscarId(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/getNome", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Pessoa>> pesquisarPorNome(@RequestParam(value = "nome") String nome) {
		return new ResponseEntity<Collection<Pessoa>>(pessoaService.buscarNome(nome), HttpStatus.OK);
	}

	@RequestMapping(value = "/getCpf", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Pessoa>> pesquisarPorCpf(@RequestParam(value = "cpf") String cpf) {
		return new ResponseEntity<Collection<Pessoa>>(pessoaService.buscarCpf(cpf), HttpStatus.OK);
	}

	@RequestMapping(value = "/getRg", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Pessoa>> pesquisarPorRg(@RequestParam(value = "rg") String rg) {
		return new ResponseEntity<Collection<Pessoa>>(pessoaService.buscarRg(rg), HttpStatus.OK);
	}

	@RequestMapping(value = "/getDataNasc", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Pessoa>> pesquisarPorDataNasc(@RequestParam(value = "dataNasc") String dataNasc) {
		return new ResponseEntity<Collection<Pessoa>>(pessoaService.buscarDataNasc(dataNasc), HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Pessoa>> getAll() {
		return new ResponseEntity<Collection<Pessoa>>(pessoaService.todos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@JsonView(View.Basico.class)
	public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa pessoa, UriComponentsBuilder uriComponentsBuilder) {
		pessoa = pessoaService.create(pessoa);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(uriComponentsBuilder.path("/getById/" + pessoa.getId()).build().toUri());
		return new ResponseEntity<Pessoa>(pessoa, responseHeaders, HttpStatus.CREATED);
	}

}
