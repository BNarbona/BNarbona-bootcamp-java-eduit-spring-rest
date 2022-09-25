package ar.com.educationit.dto.orden;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import ar.com.educationit.entity.Cupon;
import ar.com.educationit.entity.EstadoOrden;
import ar.com.educationit.entity.Orden;
import ar.com.educationit.entity.Socios;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class OrdenRequestDTO {

	@NotNull
	@Min(value = 1)
	private Long estadoOrdenId;
	
	@NotNull
	private Long socioId;
	
	@NotNull
	@Min(value = 0)
	private Double montoTotal;
	
	private Long cuponId;


	
}
