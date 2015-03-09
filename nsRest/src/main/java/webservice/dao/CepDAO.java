package webservice.dao;

import org.springframework.stereotype.Repository;
import webservice.CEP;
import webservice.util.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CepDAO {

    private Connection dbConnection;
    private PreparedStatement pStmt;

    public CepDAO() {
        dbConnection = JdbcUtils.getConnection();
    }

    public CEP selectById(String id) {
        CEP cep = null;
        String query = "SELECT * FROM nsdb.cep WHERE id=?";

        try {
            pStmt = dbConnection.prepareStatement(query);
            pStmt.setString(1, id);

            ResultSet rs = pStmt.executeQuery();
            if (rs.next()) {
                cep = new CEP();
                cep.setId(rs.getString("id"));
                cep.setRua(rs.getString("rua"));
                cep.setCidade(rs.getString("cidade"));
                cep.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return cep;
    }

    public List<CEP> selectByList(String ini, String fim) {
        List<CEP> ceps = new ArrayList<CEP>();
        String query = "SELECT * FROM nsdb.cep WHERE id between ? and ?";

        try {
            pStmt = dbConnection.prepareStatement(query);
            pStmt.setString(1, ini);
            pStmt.setString(2, fim);

            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                CEP cep = new CEP();
                cep.setId(rs.getString("id"));
                cep.setRua(rs.getString("rua"));
                cep.setCidade(rs.getString("cidade"));
                cep.setEstado(rs.getString("estado"));
                ceps.add(cep);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return ceps;
    }
}

