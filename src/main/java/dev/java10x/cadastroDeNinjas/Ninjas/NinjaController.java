package dev.java10x.cadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaRepository ninjaRepository;
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService, NinjaRepository ninjaRepository) {
        this.ninjaService = ninjaService;
        this.ninjaRepository = ninjaRepository;
    }

    @GetMapping("/boasvindas")
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota é uma mensagem de boas vindas para quem acessa ela")
    @ApiResponse(responseCode = "200", description = "Mensagem de boas vindas retornada com sucesso")
    public String boasVindas() {
        return "Essa é a minha primeira mensagem nessa roda! Boas-Vindas!";
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Essa rota cria um novo ninja no banco de dados com os dados enviados")
    @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    @GetMapping("/listar")
    @Operation(summary = "Lista todos os ninjas", description = "Essa rota retorna todos os ninjas cadastrados no banco de dados")
    @ApiResponse(responseCode = "200", description = "Ninjas listados com sucesso")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> todosNinjas= ninjaService.listarNinja();
        return ResponseEntity.ok(todosNinjas);

    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista um ninja por ID", description = "Essa rota retorna um único ninja de acordo com o ID informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id){
        NinjaDTO todosNinjaId =  ninjaService.listarNinjasPorId(id);

        if (todosNinjaId != null){
            return ResponseEntity.ok(todosNinjaId);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com id: " + id + " não existe nos nosso registros!");
        }
    }

    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera um ninja por ID", description = "Essa rota atualiza os dados de um ninja existente de acordo com o ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<String> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninjaAtualizadoId = ninjaService.atualizarNinja(id, ninjaAtualizado);

        if (ninjaAtualizadoId != null ) {
            return ResponseEntity.ok("Ninja atualizado com sucesso!" + ninjaAtualizado.getNome());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com id " + id + " não encontrado");
        }
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta um ninja por ID", description = "Essa rota remove um ninja do banco de dados de acordo com o ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){

        if (ninjaService.listarNinjasPorId(id) != null ){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com " + id + " deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com id " + id + "Não encontrado");
        }
    }

}
