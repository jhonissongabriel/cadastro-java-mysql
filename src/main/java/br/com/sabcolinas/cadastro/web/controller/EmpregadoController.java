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

import br.com.sabcolinas.cadastro.model.Empregado;
import br.com.sabcolinas.cadastro.service.EmpregadoService;
import br.com.sabcolinas.cadastro.view.View;

@RestController
@RequestMapping(value = "/empregado")
@CrossOrigin
public class EmpregadoController {

	@Autowired
	private EmpregadoService empregadoService;

	public void setEmpregadoService(EmpregadoService empregadoService) {
		this.empregadoService = empregadoService;
	}

	@RequestMapping(value = "/getById", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Empregado> pesquisarPorId(@RequestParam(value = "id", defaultValue = "1") Long id) {
		return new ResponseEntity<Empregado>(empregadoService.buscarId(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/getDiaTrabalho", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Empregado>> pesquisarPorDiaTrabalho(
			@RequestParam(value = "diaTrabalho") String diaTrabalho) {
		return new ResponseEntity<Collection<Empregado>>(empregadoService.buscarDiaTrabalho(diaTrabalho),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/getHorarioTrabalho", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Empregado>> pesquisarPorHorarioTrabalho(
			@RequestParam(value = "horarioTrabalho") String horarioTrabalho) {
		return new ResponseEntity<Collection<Empregado>>(empregadoService.buscarHorarioTrabalho(horarioTrabalho),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Empregado>> getAll() {
		return new ResponseEntity<Collection<Empregado>>(empregadoService.todos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@JsonView(View.Basico.class)
	public ResponseEntity<Empregado> salvar(@RequestBody Empregado empregado,
			UriComponentsBuilder uriComponentsBuilder) {
		empregado = empregadoService.create(empregado);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(uriComponentsBuilder.path("/getById/" + empregado.getId()).build().toUri());
		return new ResponseEntity<Empregado>(empregado, responseHeaders, HttpStatus.CREATED);
	}

}
