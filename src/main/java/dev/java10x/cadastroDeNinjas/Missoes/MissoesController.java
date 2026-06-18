package dev.java10x.cadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

//Localhost:8080

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController( MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //Get -> Mandar uma requisição para mostrar as missões
    @GetMapping("/listar")
    public List<MissoesModel> listarMissao() {
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesModel listarMissaoPorId(@PathVariable Long id){
        return missoesService.listarMissaoPorId(id);
    }

    //Post -> Mandar uma requisição para criar as missoes
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missoes) { return missoesService.criarMissao(missoes);
    }

    //Put -> Mandar uma requisição para alterar as missões
    @PutMapping("/alterarID")
    public String alterarMissao() {
        return "Missao alterada com sucesso";
    }

    //Delete -> Mandar uma requisição para deletar as missões
    @DeleteMapping("/deletar/{id}")
    public void  deletarMissaoPorId(@PathVariable Long id) {
        missoesService.deletarMissaoPorId(id);
    }

}
