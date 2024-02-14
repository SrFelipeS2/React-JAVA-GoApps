package com.avalencia.java.jdbc.repositorio;

import com.avalencia.java.jdbc.modelo.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositorioImpl implements Repositorio<Categoria>{

    private Connection conn;

    public CategoriaRepositorioImpl() {
    }

    public CategoriaRepositorioImpl(Connection conn) {
        this.conn = conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Categoria> listar() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM categorias")){
            while (rs.next()) {
                categorias.add(getCategoria(rs));
            }
        }
        return categorias;
    }



    @Override
    public Categoria porId(Long id) throws SQLException {
        Categoria categoria = null;
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM categorias c WHERE c.id = ?")){
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    categoria = getCategoria(rs);
                }
            }
        }

        return categoria;
    }

    @Override
    public Categoria guardar(Categoria categoria) throws SQLException {
        String sql = null;
        if(categoria.getId() != null && categoria.getId() > 0){
            sql = "UPDATE categorias SET nombre = ? WHERE id = ?";
        }else{
            sql = "INSERT INTO categorias(nombre) values(?)";
        }
        try(PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, categoria.getNombre());
            if(categoria.getId() != null && categoria.getId() > 0){
                stmt.setLong(2,categoria.getId());
            }
            stmt.executeUpdate();

            if (categoria.getId() == null){
                try (ResultSet rs = stmt.getGeneratedKeys()){
                    if(rs.next()){
                        categoria.setId(rs.getLong(1));
                    }
                }
            }
        }
        return categoria;
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM categorias WHERE id =?")){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }

    }

    private static Categoria getCategoria(ResultSet rs) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setId(rs.getLong("id"));
        categoria.setNombre(rs.getString("nombre"));
        return categoria;
    }
}