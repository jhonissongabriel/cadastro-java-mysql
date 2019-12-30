package br.com.sabcolinas.cadastro.web.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.sabcolinas.cadastro.model.Usuario;
import br.com.sabcolinas.cadastro.service.UsuarioService;
import br.com.sabcolinas.cadastro.view.View;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@RequestMapping(value = "/getUsuario", method = RequestMethod.GET)
	@JsonView(View.Avancado.class)
	public ResponseEntity<Collection<Usuario>> pesquisar(@RequestParam(value = "usuario") String usuario) {
		return new ResponseEntity<Collection<Usuario>>(usuarioService.buscarUsuario(usuario), HttpStatus.OK);
	}

	@RequestMapping(value = "/getById", method = RequestMethod.GET)
	@JsonView(View.Avancado.class)
	public ResponseEntity<Usuario> get(@RequestParam(value = "id", defaultValue = "1") Long id) {
		Usuario usuario = usuarioService.buscar(id);
		if (usuario == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@JsonView(View.Basico.class)
	public ResponseEntity<Collection<Usuario>> getAll() {
		return new ResponseEntity<Collection<Usuario>>(usuarioService.todos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@JsonView(View.Avancado.class)
	public ResponseEntity<Usuario> save(@RequestBody Usuario usuario, UriComponentsBuilder uriComponentsBuilder) {
		usuario = usuarioService.salvar(usuario);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(uriComponentsBuilder.path("/getById?id=" + usuario.getId()).build().toUri());
		return new ResponseEntity<Usuario>(usuario, responseHeaders, HttpStatus.CREATED);
	}

}
