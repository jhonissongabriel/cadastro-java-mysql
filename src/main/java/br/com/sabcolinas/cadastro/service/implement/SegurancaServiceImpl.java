package br.com.sabcolinas.cadastro.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.sabcolinas.cadastro.model.Usuario;
import br.com.sabcolinas.cadastro.repository.UsuarioRepository;

@Service("segurancaService")
public class SegurancaServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepo;

	public void setUsuarioRepo(UsuarioRepository usuarioRepo) {
		this.usuarioRepo = usuarioRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepo.findByNome(username);
		if(usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		return usuario;
	}

}
