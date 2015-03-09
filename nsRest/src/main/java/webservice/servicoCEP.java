package webservice;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import webservice.dao.CepDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/servicoCEP")
public class servicoCEP {

    @GET
    @Path("consultar/{cep}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String consultar(@PathParam("cep") String id) {

        Gson gson = new Gson();
        JsonResponse retorno;

        //Remover o '-'
        id = id.replaceAll("-","");

        //valida formato do cep
        if (!id.matches("^[0-9]{5}[0-9]{3}$")) {
            return gson.toJson(new JsonResponse("CEP Inválido!"));
        } else {

            //Procura primeiro o cep digitado
            CEP cep = buscaCEP(id);

            if (cep != null) {
                retorno = new JsonResponse("OK");
                retorno.setResult(cep);
                return gson.toJson(retorno);
            } else {
                //se nao encontrar com o cep especifico, procura com as demais combinacoes
                //TODO: Melhorar utilizando algum mecanismo de cache
                for (int i = 1; i<=7; i++) {
                    cep = buscaCEP(StringUtils.rightPad(id.substring(0, id.length() - i), 8, '0'));
                    if (null != cep) {
                        retorno = new JsonResponse("OK");
                        retorno.setResult(cep);
                        return gson.toJson(retorno);
                    }
                }
                return gson.toJson(new JsonResponse("CEP não encontrado!"));
            }
        }
    }

    //Realiza a busca do endereço no BD
    private CEP buscaCEP(String id) {
        CepDAO cepDAO = new CepDAO();
        System.out.println("Busca cep: " + id);
        return cepDAO.selectById(id);
    }


}
