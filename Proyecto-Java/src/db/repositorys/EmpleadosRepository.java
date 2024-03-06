package db.repositorys;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.conexion.ConexionDB;
import interfaces.RepositoryInterfaces;
import models.Empleado;
import models.Genero;

public class EmpleadosRepository implements RepositoryInterfaces<Empleado> {

    GenerosRepository generosRepository = new GenerosRepository();

    @Override
    public Empleado recuperarId(Long id) {
        try (Connection connection = ConexionDB.obtenerConnection()) {
            String q = "SELECT * FROM empleados WHERE id_empleado = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(q)) {
                preparedStatement.setLong(1, id);
                return dameEntidadResultSet(preparedStatement.executeQuery());
            } catch (Exception e) {
                System.out.println("Error en la consulta " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error en la conexion a la based de datos " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Empleado> recuperarTodos() {
        try (Connection connection = ConexionDB.obtenerConnection()) {
            String q = "SELECT * FROM empleados";
            Statement statement = connection.createStatement();
            return dameListaEmpleados(statement.executeQuery(q));
        } catch (Exception e) {
            System.out.println("Error en la conexion: " + e.getMessage());
        }
        return null;
    }

    private List<Empleado> dameListaEmpleados(ResultSet resultSet) {
        List<Empleado> empleados = new ArrayList<>();
        try {
            Long id = null;
            String nombre = null;
            String domicilio = null;
            String telefono = null;
            String email = null;
            Date fechaNacimiento = null;
            Long generoId = null;
            Genero genero = null;
            while (resultSet.next()) {
                id = resultSet.getLong("id_empleado");
                nombre = resultSet.getString("nombre");
                domicilio = resultSet.getString("domicilio");
                telefono = resultSet.getString("telefono");
                email = resultSet.getString("email");
                fechaNacimiento = resultSet.getDate("fecha_de_nacimiento");
                generoId = resultSet.getLong("id_genero");
                genero = generosRepository.recuperarId(generoId);
                empleados.add(new Empleado(id, nombre, domicilio, telefono, email, fechaNacimiento, genero));
            }
            return empleados;
        } catch (Exception e) {
            System.out.println("Error en el result: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void agregar(Empleado entidad) {

        try (Connection connection = ConexionDB.obtenerConnection()) {
            String q = "INSERT INTO  empleados VALUES (NUll, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(q)) {
                preparedStatement.setString(1, entidad.getNombre());
                preparedStatement.setString(2, entidad.getDomicilio());
                preparedStatement.setString(3, entidad.getTelefono());
                preparedStatement.setString(4, entidad.getEmail());
                preparedStatement.setDate(5, entidad.getFechaNacimiento());
                preparedStatement.setLong(6, entidad.getGenero().getId());
                preparedStatement.execute();
            } catch (Exception e) {
                System.out.println("Error en la consulta: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error en conectar a la base de datos: " + e.getMessage());
        }
    }

    @Override
    public void modificar(Empleado entidad) {
        try (Connection connection = ConexionDB.obtenerConnection()) {
            String q = "UPDATE empleados SET nombre = ?, domicilio= ?, telefono= ?, email= ?, fecha_de_nacimiento= ?, id_genero= ?   WHERE id_empleado = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(q)) {
                preparedStatement.setString(1, entidad.getNombre());
                preparedStatement.setString(2, entidad.getDomicilio());
                preparedStatement.setString(3, entidad.getTelefono());
                preparedStatement.setString(4, entidad.getEmail());
                preparedStatement.setDate(5, entidad.getFechaNacimiento());
                preparedStatement.setLong(6, entidad.getGenero().getId());
                preparedStatement.setLong(7, entidad.getId());
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                System.out.println("Error en la consulta: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error en la conexion a la base de datos: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Empleado entidad) {
        try (Connection connection = ConexionDB.obtenerConnection()) {
            String q = "DELETE FROM empleados WHERE id_empleado = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(q)) {
                preparedStatement.setLong(1, entidad.getId());
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                System.out.println("Error en la consulta: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }

    private Empleado dameEntidadResultSet(ResultSet resultSet) {
            Long id = null;
            String nombre = null;
            String domicilio = null;
            String telefono = null;
            String email = null;
            Date fechaNacimiento = null;
            Long generoId = null;
            Genero genero = null;
            try {
                if(resultSet.next()){
                id = resultSet.getLong("id_empleado");
                nombre = resultSet.getString("nombre");
                domicilio = resultSet.getString("domicilio");
                telefono = resultSet.getString("telefono");
                email = resultSet.getString("email");
                fechaNacimiento = resultSet.getDate("fecha_de_nacimiento");
                generoId = resultSet.getLong("id_genero");
                genero = generosRepository.recuperarId(generoId);
                return new Empleado(
                    id, 
                    nombre, 
                    domicilio, 
                    telefono, 
                    email, 
                    fechaNacimiento, 
                    genero);
            }
            } catch (Exception e) {
                System.out.println("Error en el resultSet: "+e.getMessage());
            }

            return null;
        }
}
