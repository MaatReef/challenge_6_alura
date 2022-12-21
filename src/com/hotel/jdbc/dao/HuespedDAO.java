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

public class HuespedDAO {

    private Connection con;

    public HuespedDAO(Connection con) {
        this.con = con;
    }

    public void guardar(Huespedes huesped) {
        try {
            PreparedStatement statement;
                statement = con.prepareStatement(
                        "INSERT INTO HUESPEDES "
                        + "(nombre, apellido, fechaNacimiento, nacionalidad, telefono)"
                        + " VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            try (statement) {
                statement.setString(1, huesped.getNombre());
                statement.setString(2, huesped.getApellido());
                statement.setString(3, huesped.getFechaNacimiento());
                statement.setString(4, huesped.getNacionalidad());
                statement.setString(5, huesped.getTelefono());
                //statement.setInt(6, huesped.getIdReserva());
                statement.execute();
    
                final ResultSet resultSet = statement.getGeneratedKeys();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        huesped.setId(resultSet.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Huespedes> listar() {
        List<Huespedes> resultado = new ArrayList<>();

        try {
            String sql = "SELECT * FROM HUESPEDES";
            
            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                	    resultado.add(new Huespedes(
                	    		resultSet.getInt("id"),
                	            resultSet.getString("nombre"),
                	            resultSet.getString("apellido"),
                	            resultSet.getString("fechaNacimiento"),
                	            resultSet.getString("nacionalidad"),
                	            resultSet.getString("telefono"),
                	            resultSet.getInt("idReserva")));
                	}
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }
    
    public int modificar(Integer id, String nombre, String apellido, String fechaNacimiento, String nacionalidad, String telefono) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "UPDATE HUESPEDES SET "
                    + " ID = ?,"
                    + " NOMBRE = ?,"
                    + " APELLIDO = ?,"
                    + " FECHANACIMIENTO = ?,"
                    + " NACIONALIDAD = ?,"
                    + " TELEFONO = ?"
                    + " WHERE ID = ?");

            
            try (statement) {
            	statement.setInt(1, id);
                statement.setString(2, nombre);
                statement.setString(3, apellido);
                statement.setString(4, fechaNacimiento);
                statement.setString(5, nacionalidad);
                statement.setString(6, telefono);
                statement.setInt(7, id);
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
            final PreparedStatement statement = con.prepareStatement("DELETE FROM HUESPEDES WHERE ID = ?");

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

    public List<Huespedes> listarOnly(String txtFiltado) {
        List<Huespedes> resultado = new ArrayList<>();
        
        try {
           String sql = "SELECT * FROM HUESPEDES WHERE id='"+ txtFiltado +"' or nombre='"+txtFiltado+"' or apellido='"+txtFiltado+"' or nacionalidad='"+txtFiltado+"' or telefono='"+txtFiltado+"'" ;

           final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                	    resultado.add(new Huespedes(
                	    		resultSet.getInt("id"),
                	    		resultSet.getString("nombre"),
                	            resultSet.getString("apellido"),
                	            resultSet.getString("fechaNacimiento"),
                	            resultSet.getString("nacionalidad"),
                	            resultSet.getString("telefono"), 
                	            null));
                	}
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }
}