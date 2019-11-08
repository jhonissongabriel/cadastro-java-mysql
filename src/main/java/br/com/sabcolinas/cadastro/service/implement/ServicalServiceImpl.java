package br.com.sabcolinas.cadastro.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sabcolinas.cadastro.model.Servical;
import br.com.sabcolinas.cadastro.repository.ServicalRepository;
import br.com.sabcolinas.cadastro.service.ServicalService;

@Service("servicalService")
public class ServicalServiceImpl implements ServicalService{

	
	@Autowired
	private ServicalRepository servicalRepo;

	public void setServicalRepo(ServicalRepository servicalRepo) {
		this.servicalRepo = servicalRepo;
	}

	@Override
	public Servical createServical() {
		Servical servical = new Servical();
		return servical;
	}

	@Override
	public void deleteServical(Long id) {
		servicalRepo.deleteById(id);
	}
	
	
}
