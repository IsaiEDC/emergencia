package db.repositorys;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import db.conexion.ConexionDB;
import interfaces.RepositoryInterfaces;
import models.Genero;

public class GenerosRepository implements RepositoryInterfaces<Genero> {

    @Override
    public Genero recuperarId(Long id) {
            //obtengo conexion
        try (Connection connection = ConexionDB.obtenerConnection()) {
            String q = "SELECT * FROM  generos WHERE id_genero = ?";
            //entro a la consulta
            try (
                PreparedStatement preparedStatement = connection.prepareStatement(q)) {
                preparedStatement.setLong(1, id);
                return dameEntidadResultSet(preparedStatement.executeQuery());

            } catch (Exception e) {
                System.out.println("Error en  la consulta");
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos");
        }
        return null;
    }

    @Override
    public List<Genero> recuperarTodos() {
        try (Connection connection = ConexionDB.obtenerConnection()){
            String q = "SELECT * FROM generos";
            Statement statement = connection.createStatement();
            return dameListaGeneros(statement.executeQuery(q));
        } catch (Exception e) {
            System.out.println("Error en la conexion "+e.getMessage());
        }
        return null;
    }

    private List<Genero> dameListaGeneros(ResultSet resultSet) {
    List <Genero> generos = new ArrayList<Genero>();
    Long id = null;
    String nombre = null;
    try {
        while (resultSet.next()) {
            id = resultSet.getLong("id_genero");
            nombre = resultSet.getString("nombre");
            generos.add(new Genero(id, nombre));
        }
        return generos;
    } catch (Exception e) {
        System.out.println("Error en el result "+e.getMessage());
    }
        return null;
    }

    @Override
    public void agregar(Genero entidad) {
        try (Connection connection = ConexionDB.obtenerConnection()) {
            String q = "INSERT INTO generos VALUES (null, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(q)) {
                preparedStatement.setString(1, entidad.getNombre());
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                System.out.println("Error en la consulta "+e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al recuperar la conexion "+e.getMessage());
        }
    }

    @Override
    public void modificar(Genero entidad) {
    try (Connection connection = ConexionDB.obtenerConnection()) {
        String q = "UPDATE generos SET nombre = ? WHERE id_genero = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(q)){
            preparedStatement.setString(1, entidad.getNombre());
            preparedStatement.setLong(2, entidad.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en la consulta "+e.getMessage());
        }
    } catch (Exception e) {
        System.out.println("Error al recuperar la conexion "+e.getMessage());
    }
}

    @Override
    public void eliminar(Genero entidad) {
            try (Connection connection = ConexionDB.obtenerConnection()) {
                String q = "DELETE FROM generos WHERE id_genero = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(q)) {
                    preparedStatement.setLong(1, entidad.getId());
                    preparedStatement.executeUpdate();
                } catch (Exception e) {
                    System.out.println("Error en la consulta "+e.getMessage());
                }
            } catch (Exception e) {
                System.out.println("Error al conectar a la basa de datos "+e.getMessage());
            }
    }

    private Genero dameEntidadResultSet(ResultSet resultSet){
        Long id = null;
        String nombre = null;
        try {
            while (resultSet.next()) {
                id = resultSet.getLong("id_genero");
                nombre = resultSet.getString("nombre");
            }
            return new Genero(id, nombre);
        } catch (Exception e) {
            System.out.println("Error al recuperar resulSet "+e.getMessage());
        }
        return null;
    }
}