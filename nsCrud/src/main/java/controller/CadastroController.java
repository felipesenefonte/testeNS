package controller;

import model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.CadastroService;

@Controller
public class CadastroController {

    @Autowired
    public CadastroService service;

    @RequestMapping("listarEnderecos")
    public @ResponseBody
    JsonJTableList listarEnderecos() {
        return service.listar();
    }

    @RequestMapping("apagarEndereco")
    public @ResponseBody
    String apagarEndereco(@RequestParam int id) {
        return service.apagar(id);
    }

    @RequestMapping(value = "incluirEndereco", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public @ResponseBody
    String incluirEndereco(@ModelAttribute Endereco endereco) {
        return service.incluir(endereco);
    }

    @RequestMapping(value = "atualizarEndereco", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public @ResponseBody
    String atualizarEndereco(@ModelAttribute Endereco endereco) {
        return service.atualizar(endereco);
    }
}