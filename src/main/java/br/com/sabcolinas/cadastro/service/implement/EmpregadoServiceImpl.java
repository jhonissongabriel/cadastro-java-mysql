package br.com.sabcolinas.cadastro.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sabcolinas.cadastro.model.Empregado;
import br.com.sabcolinas.cadastro.repository.EmpregadoRepository;
import br.com.sabcolinas.cadastro.service.EmpregadoService;

@Service("empregadoService")
public class EmpregadoServiceImpl implements EmpregadoService {

	@Autowired
	private EmpregadoRepository empregadoRepo;

	public void setServicalRepo(EmpregadoRepository empregadoRepo) {
		this.empregadoRepo = empregadoRepo;
	}

	@Override
	public Empregado create(Empregado empregado) {
		return empregadoRepo.save(empregado);
	}

	@Override
	public void delete(Long id) {
		empregadoRepo.deleteById(id);
	}

	@Override
	public void updateDiaTrabalho(String diaTrabalhoAntigo, String diaTrabalhoNovo) {
		Empregado empregado = empregadoRepo.findByDiaTrabalho(diaTrabalhoAntigo);
		if (empregado != null) {
			empregado.setDiaTrabalho(diaTrabalhoNovo);
			empregadoRepo.save(empregado);
		}
	}

	@Override
	public void updateHorarioTrabalho(String horarioTrabalhoAntigo, String horarioTrabalhoNovo) {
		Empregado empregado = empregadoRepo.findByHorarioTrabalho(horarioTrabalhoAntigo);
		if (empregado != null) {
			empregado.setHorarioTrabalho(horarioTrabalhoNovo);
			empregadoRepo.save(empregado);
		}
	}

	@Override
	public List<Empregado> todos() {
		List<Empregado> retorno = new ArrayList<Empregado>();
		for (Empregado empregado : empregadoRepo.findAll()) {
			retorno.add(empregado);
		}
		return retorno;
	}

	@Override
	public Empregado buscarId(Long id) {
		Optional<Empregado> empregado = empregadoRepo.findById(id);
		if (empregado.isPresent()) {
			return empregado.get();
		}
		return null;
	}

	@Override
	public List<Empregado> buscarDiaTrabalho(String diaTrabalho) {
		List<Empregado> retorno = new ArrayList<Empregado>();
		for (Empregado empregado : empregadoRepo.findByDiaTrabalhoContains(diaTrabalho)) {
			retorno.add(empregado);
		}
		return retorno;
	}

	@Override
	public List<Empregado> buscarHorarioTrabalho(String horarioTrabalho) {
		List<Empregado> retorno = new ArrayList<Empregado>();
		for (Empregado empregado : empregadoRepo.findByHorarioTrabalhoContains(horarioTrabalho)) {
			retorno.add(empregado);
		}
		return retorno;
	}

}
