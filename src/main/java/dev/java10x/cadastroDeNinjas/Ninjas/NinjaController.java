package dev.java10x.cadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é a minha primeira mensagem nessa roda! Boas-Vindas!";
    }

    //Adicionar ninja(CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }
    //Mostrar todos os ninjas(READ)
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "Mostrar ninjas";
    }

    //Mostrar ninja por ID(READ)
    @GetMapping("/todosID")
    public String mostrarTodosOsNinjasPorId(){
        return "Mostrar ninja por Id";
    }

    // Alterar dados do Ninja(UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterar ninja por Id";
    }

    //Deletar Ninja(DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "Alterar ninja por Id";
    }
}
