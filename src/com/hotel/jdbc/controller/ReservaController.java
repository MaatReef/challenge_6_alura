package com.hotel.jdbc.controller;

import java.util.List;

import com.hotel.jdbc.dao.ReservaDAO;
import com.hotel.jdbc.factory.ConnectionFactory;
import com.hotel.jdbc.modelo.Reservas;

public class ReservaController {

    private ReservaDAO reservaDAO;

    public ReservaController() {
        var factory = new ConnectionFactory();
        this.reservaDAO = new ReservaDAO(factory.recuperaConexion());
    }

    public int eliminar(Integer id) {
        return reservaDAO.eliminar(id);
    }
    
    public int modificar(Integer id, String fechaEntrada ,String fechaSalida,Integer valor,String formaPago, Integer id2) {
        return reservaDAO.modificar(id, fechaEntrada ,fechaSalida,valor,formaPago, id2);
    }
    
    public List<Reservas> listar() {
        return this.reservaDAO.listar();
    }
	
    public void guardar(Reservas reserva) {
    	reservaDAO.guardar(reserva);
    }

	public List<Reservas> listarOnly(String txtFiltado) {
		   return this.reservaDAO.listarOnly(txtFiltado);
	}
}
