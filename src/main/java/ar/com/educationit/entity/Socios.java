package ar.com.educationit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
	
}
