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

import br.com.sabcolinas.cadastro.model.Locacao;
import br.com.sabcolinas.cadastro.service.LocacaoService;
import br.com.sabcolinas.cadastro.view.View;

@RestController
@RequestMapping(value = "/locacao")
@CrossOrigin
public class LocacaoController {

	@Autowired
	private LocacaoService locacaoService;

	public void setLocacaoService(LocacaoService locacaoService) {
		this.locacaoService = locacaoService;
	}

	@RequestMapping(value = "/getById", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Locacao> pesquisarPorId(@RequestParam(value = "id", defaultValue = "1") Long id) {
		return new ResponseEntity<Locacao>(locacaoService.buscarId(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/getNome", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Locacao>> pesquisarPorNome(@RequestParam(value = "nome") String nome) {
		return new ResponseEntity<Collection<Locacao>>(locacaoService.buscarNome(nome), HttpStatus.OK);
	}

	@RequestMapping(value = "/getTelefone", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Locacao>> pesquisarPorTelefone(@RequestParam(value = "telefone") String telefone) {
		return new ResponseEntity<Collection<Locacao>>(locacaoService.buscarTelefone(telefone), HttpStatus.OK);
	}

	@RequestMapping(value = "/getDataInicio", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Locacao>> pesquisarPorDataInicio(
			@RequestParam(value = "dataInicio") String dataInicio) {
		return new ResponseEntity<Collection<Locacao>>(locacaoService.buscarDataInicio(dataInicio), HttpStatus.OK);
	}

	@RequestMapping(value = "/getDataTermino", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Locacao>> pesquisarPorDataTermino(
			@RequestParam(value = "dataTermino") String dataTermino) {
		return new ResponseEntity<Collection<Locacao>>(locacaoService.buscarDataTermino(dataTermino), HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Locacao>> getAll() {
		return new ResponseEntity<Collection<Locacao>>(locacaoService.todos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@JsonView(View.Basico.class)
	public ResponseEntity<Locacao> salvar(@RequestBody Locacao locacao, UriComponentsBuilder uriComponentsBuilder) {
		locacao = locacaoService.create(locacao);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(uriComponentsBuilder.path("/getById/" + locacao.getId()).build().toUri());
		return new ResponseEntity<Locacao>(locacao, responseHeaders, HttpStatus.CREATED);
	}

}
