package br.com.sabcolinas.cadastro.service.implement;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sabcolinas.cadastro.model.Autorizacao;
import br.com.sabcolinas.cadastro.model.Usuario;
import br.com.sabcolinas.cadastro.repository.AutorizacaoRepository;
import br.com.sabcolinas.cadastro.repository.UsuarioRepository;
import br.com.sabcolinas.cadastro.service.UsuarioService;

@Service("usuarioService")
@Transactional
@PreAuthorize("isAuthenticated()")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Autowired
	private AutorizacaoRepository autorizacaoRepo;

	public void setUsuarioRepo(UsuarioRepository usuarioRepo) {
		this.usuarioRepo = usuarioRepo;
	}

	public void setAutorizacaoRepo(AutorizacaoRepository autorizacaoRepo) {
		this.autorizacaoRepo = autorizacaoRepo;
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Usuario incluirUsuario(String nome, String senha, String nomeAutorizacao) {
		Autorizacao autorizacao = autorizacaoRepo.findByNome(nomeAutorizacao);
		// Se nao existe
		if (autorizacao == null) {
			// Cria nova
			autorizacao = new Autorizacao();
			autorizacao.setNome(nomeAutorizacao);
			autorizacaoRepo.save(autorizacao);
		}
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setSenha(md5(senha));
		usuario.setAutorizacoes(new ArrayList<Autorizacao>());
		usuario.getAutorizacoes().add(autorizacao);
		usuarioRepo.save(usuario);
		return usuario;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Usuario> buscarUsuario(String usuario) {
		return usuarioRepo.findByNomeContainsIgnoreCase(usuario);
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public Usuario buscar(Long id) {
		Optional<Usuario> usuario = usuarioRepo.findById(id);
		if (usuario.isPresent()) {
			return usuario.get();
		}
		return null;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Usuario> todos() {
		List<Usuario> retorno = new ArrayList<Usuario>();
		for (Usuario usuario : usuarioRepo.findAll()) {
			retorno.add(usuario);
		}
		return retorno;
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Usuario salvar(Usuario usuario) {
		if (!usuario.getAutorizacoes().isEmpty()) {
			for (Autorizacao aut : usuario.getAutorizacoes()) {
				// Se nao existe, cria
				if (aut.getId() == null && autorizacaoRepo.findByNome(aut.getNome()) == null) {
					autorizacaoRepo.save(aut);
				}
			}
		}
		usuario.setSenha(md5(usuario.getSenha()));
		return usuarioRepo.save(usuario);
	}

	private String md5(String senha) {
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			byte messageDigest[] = algorithm.digest("senha".getBytes("UTF-8"));

			StringBuilder hexString = new StringBuilder();
			hexString.append("{MD5}");
			for (byte b : messageDigest) {
				hexString.append(String.format("%02X", 0xFF & b));
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException exception) {
			exception.printStackTrace();
			// Unexpected - do nothing
		} catch (UnsupportedEncodingException exception) {
			exception.printStackTrace();
			// Unexpected - do nothing
		}
		return senha;
	}

}
