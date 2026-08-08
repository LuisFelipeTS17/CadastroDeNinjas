package dev.java10x.cadastroDeNinjas.Missoes;

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
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missoes) {
        MissoesDTO novaMissao = missoesService.criarMissao(missoes);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso: " + novaMissao.getNome() + " (ID): " + novaMissao.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissao() {
        List<MissoesDTO> todasMissoes = missoesService.listarMissoes();
        return ResponseEntity.ok(todasMissoes);
    }

    @GetMapping("/listar/{id}")
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