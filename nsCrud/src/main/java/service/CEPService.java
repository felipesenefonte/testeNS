package service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
public class CEPService {

    //private static final String URL = "http://localhost:9999/rest/servicoCEP/consultar/"; //Local
    private static final String URL = "http://54.207.15.43:8080/nsRest/rest/servicoCEP/consultar/"; //Amazon

    private final Gson gson = new Gson();

    public String consultar(String cep) {
        WebTarget target = ClientBuilder.newClient().target(URL + cep);

        Response response = target.request(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE)
                .get();

        String jsonResposta = response.readEntity(String.class);
        return jsonResposta;
    }

}
