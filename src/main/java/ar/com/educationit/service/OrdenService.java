package ar.com.educationit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.com.educationit.entity.Orden;
import java.util.Optional;


@Service
public interface OrdenService {

	public List<Orden> findAll();

	public Orden crear(Orden newOrden);

	public Optional<Orden> getById(Long id);
	
	public void update(Orden ordenFromDb);
}
