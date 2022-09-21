package ar.com.educationit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/* MAPEO DE ENTIDADES 
 * */
/*
 * JPA: Java persistence api - dice como se gestiona la entidad
 * Hibernate: implementacion de JPA
 * @Entity - es una entidad: representa una tabla
 * @Table: indicar el nombre de la tabla
 * */

@Entity
@Table( name = "socios")
public class Socios {
	//identificamos la PK
	
	@Id
	//la clave en la DB es autoincrement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 50, name = "apellido") //NOT NULL
	@NotEmpty
	private String apellido;
	
	@Column(nullable = false, length = 60) 
	@NotEmpty
	private String nombre;
	
	@Column(nullable = false, length = 6, unique = true)
	@NotEmpty
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
