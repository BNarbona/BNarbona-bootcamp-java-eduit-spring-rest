package ar.com.educationit.dto.client.socio;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SocioDTO {

	private Long id;
	private String apellido;
	private String nombre;
	private String codigo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
}
