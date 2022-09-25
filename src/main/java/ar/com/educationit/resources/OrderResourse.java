package ar.com.educationit.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import ar.com.educationit.dto.client.socio.SocioDTO;
import ar.com.educationit.dto.orden.OrdenRequestDTO;
import ar.com.educationit.entity.Cupon;
import ar.com.educationit.entity.EstadoOrden;
import ar.com.educationit.entity.Orden;
import ar.com.educationit.entity.Socios;
import ar.com.educationit.service.OrdenService;

@RestController
public class OrderResourse {
	
	@Autowired
	private OrdenService ordenService; 
	
	@Autowired
	private RestTemplate restTemplateClient;
	
	@Value("${spring.external.service-socios-url}")
	private String sociosPathUrlBase;
	
	//GET all
	@GetMapping(value="/orden", produces="application/json")
	public ResponseEntity<List<Orden>> findAll(){
		List<Orden> ordenes = this.ordenService.findAll();
		return ResponseEntity.ok(ordenes);
	}
	
	@PostMapping(value="/orden")
	public ResponseEntity<?> post(
			@ Valid @RequestBody OrdenRequestDTO ordenRequestDTO
			) throws URISyntaxException{
		
		//http://localhost:8081/socio/ordenRequestDTO.getSocioId() => socio
	//	RestTemplate restTemplateClient = new RestTemplate(); 
		SocioDTO socioDTO =restTemplateClient.
			getForObject("http://localhost:8081/socio/"+ordenRequestDTO.getSocioId(), SocioDTO.class);
		
		if(socioDTO == null) {
			return ResponseEntity.badRequest().build();
		}
		
		//Orden orden = new Orden(null, null, null, null, null, null);
		
		Orden newOrden = Orden.builder()
		.cupon(ordenRequestDTO.getCuponId() != null ? Cupon.builder().id(ordenRequestDTO.getCuponId()).build(): null)
		.estado(EstadoOrden.builder().id(ordenRequestDTO.getEstadoOrdenId()).build())
		.fechaCreacion(new Date())
		.montoTotal(ordenRequestDTO.getMontoTotal())
		.socio(Socios.builder().id(ordenRequestDTO.getSocioId()).build())
		.build();
		
		this.ordenService.crear(newOrden);
		//	/orden/1
		return ResponseEntity.created(new URI("/orden/"+newOrden.getId())).build();
	}

}
