package com.hotel.jdbc.controller;

import java.util.List;

import com.hotel.jdbc.dao.HuespedDAO;
import com.hotel.jdbc.factory.ConnectionFactory;
import com.hotel.jdbc.modelo.Huespedes;
import com.hotel.jdbc.modelo.Reservas;

public class HuespedController  {

    private HuespedDAO huespedDAO;

    public HuespedController() {
        var factory = new ConnectionFactory();
        this.huespedDAO = new HuespedDAO(factory.recuperaConexion());
    }
    
    public int modificar(Integer id, String nombre, String apellido, String fechaNacimiento, String nacionalidad, String telefono) {
        return huespedDAO.modificar(id, nombre, apellido, fechaNacimiento, nacionalidad, telefono);
    }

    public int eliminar(Integer id) {
        return huespedDAO.eliminar(id);
    }
    
    public List<Huespedes> listar() {
        return this.huespedDAO.listar();
    }
    
    public void guardar(Huespedes huesped) { 
    	huespedDAO.guardar(huesped);
    }

	public List<Huespedes> listarOnly(String txtFiltado) {
		   return this.huespedDAO.listarOnly(txtFiltado);
	}

}

