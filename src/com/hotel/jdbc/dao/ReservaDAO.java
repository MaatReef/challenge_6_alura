package com.hotel.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hotel.jdbc.modelo.Huespedes;
import com.hotel.jdbc.modelo.Reservas;

public class ReservaDAO {

	 private Connection con;

	    public ReservaDAO(Connection con) {
	        this.con = con;
	    }
	    
	    public void guardar(Reservas reserva) {
	        try {
	            PreparedStatement statement;
	                statement = con.prepareStatement(
	                        "INSERT INTO RESERVAS "
	                        + "(fechaEntrada, fechaSalida, valor, formaPago)"
	                        + " VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
	    
	            try (statement) {
	                statement.setString(1, reserva.getFechaEntrada());
	                statement.setString(2, reserva.getFechaSalida());
	                statement.setInt(3, reserva.getValor());
	                statement.setString(4, reserva.getFormaPago());
	    
	                statement.execute();
	                final ResultSet resultSet = statement.getGeneratedKeys();
	    
	                try (resultSet) {
	                    while (resultSet.next()) {
	                    	reserva.setId(resultSet.getInt(1));
	                       
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
	    
	    public List<Reservas> listar() {
	        List<Reservas> resultado = new ArrayList<>();

	        try {
	            String sql = "SELECT * FROM RESERVAS";
	            
	            final PreparedStatement statement = con
	                    .prepareStatement(sql);

	            try (statement) {
	                final ResultSet resultSet = statement.executeQuery();

	                try (resultSet) {
	                    while (resultSet.next()) {
	                	    resultado.add(new Reservas(
	                	    		resultSet.getInt("id"),
	                	    		resultSet.getString("fechaEntrada"),
	                	            resultSet.getString("fechaSalida"),
	                	            resultSet.getInt("valor"),
	                	            resultSet.getString("formaPago")));
	                	}
	                }
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return resultado;
	    }
	    
	    public int modificar(Integer id, String fechaEntrada ,String fechaSalida,Integer valor,String formaPago, Integer id2) {
	        try {
	            final PreparedStatement statement = con.prepareStatement(
	                    "UPDATE RESERVAS SET "
                		+ " ID = ?,"
	                    + " FECHAENTRADA = ?,"
	                    + " FECHASALIDA = ?,"
	                    + " VALOR = ?,"
	                    + " FORMAPAGO = ?"
	                    + " WHERE ID = ?");

	            try (statement) {
	            	statement.setInt(1, id);
	            	statement.setString(2, fechaEntrada);
	                statement.setString(3, fechaSalida);
	                statement.setInt(4, valor);
	                statement.setString(5, formaPago);
	                statement.setInt(6, id2);
	                statement.execute();

	                int updateCount = statement.getUpdateCount();
	                return updateCount;
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
	    
	    public int eliminar(Integer id) {
	        try {
	            final PreparedStatement statement = con.prepareStatement("DELETE FROM RESERVAS WHERE ID = ?");

	            try (statement) {
	                statement.setInt(1, id);
	                statement.execute();

	                int updateCount = statement.getUpdateCount();
	                
	                return updateCount;
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
	    
	    public List<Reservas> listarOnly(String txtFiltado) {
	        List<Reservas> resultado = new ArrayList<>();

	        try {
	           String sql = "SELECT * FROM RESERVAS WHERE id='"+ txtFiltado +"' or valor='"+txtFiltado+"' or formaPago='"+txtFiltado+"' ";
	           final PreparedStatement statement = con
	                    .prepareStatement(sql);

	            try (statement) {
	                final ResultSet resultSet = statement.executeQuery();

	                try (resultSet) {
	                    while (resultSet.next()) {
	                	    resultado.add(new Reservas(
	                	    		resultSet.getInt("id"),
	                	    		resultSet.getString("fechaEntrada"),
	                	            resultSet.getString("fechaSalida"),
	                	            resultSet.getInt("valor"),
	                	            resultSet.getString("formaPago")));
	                	}
	                }
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return resultado;
	    }
	    
	   

}