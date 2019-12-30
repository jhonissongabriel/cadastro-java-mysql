package br.com.sabcolinas.cadastro.service;

import java.util.List;

import br.com.sabcolinas.cadastro.model.Usuario;

public interface UsuarioService {
	
	public Usuario incluirUsuario(String nome, String senha, String nomeAutorizacao);
	
	public List<Usuario> buscarUsuario(String usuario);
	
	public Usuario buscar(Long id);
	
	public List<Usuario> todos();
	
	public Usuario salvar(Usuario usuario);

}
