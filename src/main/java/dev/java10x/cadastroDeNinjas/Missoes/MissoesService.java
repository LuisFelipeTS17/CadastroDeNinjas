package dev.java10x.cadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //Listar todas as missoes
    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    //Listar tadas missoes por ID
    public MissoesModel listarMissaoPorId(Long id) {
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.orElse(null);
    }

    //Criar uma nova missao
    public MissoesModel criarMissao(MissoesModel missao) {
        return missoesRepository.save(missao);
    }

    //Deletar missao - tem que ser void
    public void deletarMissaoPorId(Long id) {
        missoesRepository.deleteById(id);
    }

}
