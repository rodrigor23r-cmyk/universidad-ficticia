package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Data
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Profesor extends Persona {
	
	private int totalEstudiantes;
	
	private Dpto dpto;
	
	private LocalDate fechaIncioFacultad;
	
	private BigDecimal salario;

}	
