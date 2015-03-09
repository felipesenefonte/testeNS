package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.util.JdbcUtils;
import model.Endereco;
import org.springframework.stereotype.Repository;

@Repository
public class CadastroDAO {

    private Connection dbConnection;
    private PreparedStatement pStmt;

    public CadastroDAO() {
        dbConnection = JdbcUtils.getConnection();
    }

    public List<Endereco> select() {
        List<Endereco> enderecos = new ArrayList<Endereco>();

        String query = "SELECT * FROM nsdb.endereco ORDER BY id";
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Endereco endereco = new Endereco();

                endereco.setId(rs.getInt("id"));
                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getInt("numero"));
                endereco.setCep(rs.getString("cep"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setComplemento(rs.getString("complemento"));

                enderecos.add(endereco);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return enderecos;
    }

    public void insert(Endereco endereco) {
        String insertQuery = "INSERT INTO nsdb.endereco (rua, numero, cep, cidade, estado, bairro, complemento) \n" +
                "VALUES (?,?,?,?,?,?,?)";
        try {
            pStmt = dbConnection.prepareStatement(insertQuery);
            pStmt.setString(1, endereco.getRua());
            pStmt.setInt(2, endereco.getNumero());
            pStmt.setString(3, endereco.getCep());
            pStmt.setString(4, endereco.getCidade());
            pStmt.setString(5, endereco.getEstado());
            pStmt.setString(6, endereco.getBairro());
            pStmt.setString(7, endereco.getComplemento());

            pStmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void update(Endereco endereco)  {
        String updateQuery = "UPDATE nsdb.endereco SET rua = ?, numero = ?, cep = ?, cidade = ?, estado = ?, bairro = ?," +
                " complemento = ? WHERE id = ?";
        try {
            pStmt = dbConnection.prepareStatement(updateQuery);
            pStmt.setString(1, endereco.getRua());
            pStmt.setInt(2, endereco.getNumero());
            pStmt.setString(3, endereco.getCep());
            pStmt.setString(4, endereco.getCidade());
            pStmt.setString(5, endereco.getEstado());
            pStmt.setString(6, endereco.getBairro());
            pStmt.setString(7, endereco.getComplemento());
            pStmt.setInt(8, endereco.getId());
            pStmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void delete(int id) {
        String deleteQuery = "DELETE FROM nsdb.endereco WHERE id = ?";
        try {
            pStmt = dbConnection.prepareStatement(deleteQuery);
            pStmt.setInt(1, id);
            pStmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}

