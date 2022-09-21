package ar.com.educationit.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.educationit.entity.Orden;
import ar.com.educationit.repositories.OrdenRepository;
import ar.com.educationit.service.OrdenService;

@Service
public class OrdenServiceImpl implements OrdenService {

	@Autowired
	private OrdenRepository repository;
	
	@Override
	public List<Orden> findAll() {
		
		return repository.findAll();
	}

}
