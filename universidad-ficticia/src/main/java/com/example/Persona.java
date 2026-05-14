package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode


public class Persona {
	
	private String nombre;
		
	private String primerApellido;
	
	private String segundoApellido;
	
	private LocalDate fechaDeNacimiento;
}