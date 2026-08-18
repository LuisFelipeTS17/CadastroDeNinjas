package dev.java10x.cadastroDeNinjas.Missoes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Localhost:8080

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria uma nova missão", description = "Essa rota cria uma nova missão no banco de dados com os dados enviados")
    @ApiResponse(responseCode = "201", description = "Missão criada com sucesso")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missoes) {
        MissoesDTO novaMissao = missoesService.criarMissao(missoes);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso: " + novaMissao.getNome() + " (ID): " + novaMissao.getId());
    }

    @GetMapping("/listar")
    @Operation(summary = "Lista todas as missões", description = "Essa rota retorna todas as missões cadastradas no banco de dados")
    @ApiResponse(responseCode = "200", description = "Missões listadas com sucesso")
    public ResponseEntity<List<MissoesDTO>> listarMissao() {
        List<MissoesDTO> todasMissoes = missoesService.listarMissoes();
        return ResponseEntity.ok(todasMissoes);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista uma missão por ID", description = "Essa rota retorna uma única missão de acordo com o ID informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
    public ResponseEntity<?> listarMissaoPorId(@PathVariable Long id) {
        MissoesDTO missaoPorId = missoesService.listarMissaoPorId(id);

        if (missaoPorId != null) {
            return ResponseEntity.ok(missaoPorId);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com id: " + id + " não existe nos nosso registros!");
        }
    }

    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera uma missão por ID", description = "Essa rota atualiza os dados de uma missão existente de acordo com o ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
    public ResponseEntity<String> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missaoAlterada) {
        MissoesDTO missaoAtualizada = missoesService.atualizarMissao(id, missaoAlterada);

        if (missaoAtualizada != null) {
            return ResponseEntity.ok("Missão atualizada com sucesso! " + missaoAtualizada.getNome());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com id " + id + " não encontrada");
        }
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta uma missão por ID", description = "Essa rota remove uma missão do banco de dados de acordo com o ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
    public ResponseEntity<String> deletarMissaoPorId(@PathVariable Long id) {
        if (missoesService.listarMissaoPorId(id) != null) {
            missoesService.deletarMissaoPorId(id);
            return ResponseEntity.ok("Missão com id " + id + " deletada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão com id " + id + " não encontrada");
        }
    }

}