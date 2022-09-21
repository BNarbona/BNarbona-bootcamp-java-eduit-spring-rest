package ar.com.educationit.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.educationit.entity.Orden;
import ar.com.educationit.service.OrdenService;

@RestController
public class OrderResourse {
	
	@Autowired
	private OrdenService ordenService; 
	
	//GET all
	@GetMapping(value="/orden", produces="application/json")
	public ResponseEntity<List<Orden>> findAll(){
		List<Orden> ordenes = this.ordenService.findAll();
		return ResponseEntity.ok(ordenes);
	}
	
}
