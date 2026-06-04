package dev.java10x.cadastroDeNinjas.Missoes;


import org.springframework.web.bind.annotation.*;

//Localhost:8080

@RestController
@RequestMapping("missoes")
public class MissoesController {

    //Get -> Mandar uma requisição para mostrar as missões
    @GetMapping("/listar")
    public String listarMissao() {
        return "Missoes listadas com sucesso";
    }

    //Post -> Mandar uma requisição para criar as missoes
    @PostMapping("/criar")
    public String criarMissao() {
        return "Missao criada com sucesso";
    }

    //Put -> Mandar uma requisição para alterar as missões
    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missao alterada com sucesso";
    }

    //Delete -> Mandar uma requisição para deletar as missões
    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "Missao deletada com sucesso";
    }

}
