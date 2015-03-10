package service;

import model.JsonJTableList;
import model.Endereco;
import model.dao.CadastroDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroService {

    @Autowired
    private CadastroDAO dao;

    /**
     * Retorna todos os endereços
     * @return
     */
    public JsonJTableList listar() {
        JsonJTableList res = new JsonJTableList();

        try {
            List<Endereco> listaEnderecos = dao.select();
            res.setResult("OK");
            res.setRecords(listaEnderecos);
            res.setTotalRecordCount(listaEnderecos.size());
        } catch (Exception e) {
            res.setResult("ERROR");
            res.setMessage(e.getMessage());
        }
        return res;
    }

    /**
     * Remove o endereço
     * @param id
     * @return
     */
    public String apagar(int id) {

        String jsonResposta;
        try {
            dao.delete(id);
            jsonResposta = "{\"Result\":\"OK\"}";

        } catch (Exception e) {
            jsonResposta = "{\"Result\":\"ERROR\"}";
        }

        return jsonResposta;
    }

    /**
     * Realizar a inclusão de um novo endereço
     * @param endereco
     * @return
     */
    public String incluir(Endereco endereco) {
        String jsonResposta;
        try {
            dao.insert(endereco);
            jsonResposta = "{\"Result\":\"OK\"}";

        } catch (Exception e) {
            jsonResposta = "{\"Result\":\"ERROR\"}";
        }

        return jsonResposta;
    }

    /**
     * Atualiza um endereço Existente
     * @param endereco
     * @return
     */
    public String atualizar(Endereco endereco) {
        String jsonResposta;
        try {
            dao.update(endereco);
            jsonResposta = "{\"Result\":\"OK\"}";

        } catch (Exception e) {
            jsonResposta = "{\"Result\":\"ERROR\"}";
        }

        return jsonResposta;
    }

}
