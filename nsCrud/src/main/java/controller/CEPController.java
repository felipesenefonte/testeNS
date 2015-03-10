package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.CEPService;

@Controller
public class CEPController {

    @Autowired
    public CEPService service;

    @RequestMapping("consultarCEP")
    public @ResponseBody
    String consultarCep(@RequestParam String cep) {

        return service.consultar(cep);
    }
}
