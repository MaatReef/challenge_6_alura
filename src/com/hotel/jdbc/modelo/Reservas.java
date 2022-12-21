package com.hotel.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

import com.hotel.jdbc.modelo.Reservas;

public class Reservas {
	

	private Integer id;

    private String fechaEntrada;

    private String fechaSalida;

    private Integer valor;
    
    private String formaPago;


	public Reservas(Integer id, String fechaEntrada, String fechaSalida, Integer valor, String formaPago) {
		this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida ;
        this.valor = valor;
        this.formaPago = formaPago;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
    


}
