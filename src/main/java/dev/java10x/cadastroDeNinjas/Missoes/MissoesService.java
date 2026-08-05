package dev.java10x.cadastroDeNinjas.Missoes;

import dev.java10x.cadastroDeNinjas.Ninjas.NinjaMapper;
import dev.java10x.cadastroDeNinjas.Ninjas.NinjaModel;
import dev.java10x.cadastroDeNinjas.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {
    private MissoesMapper missoesMapper;
    private MissoesRepository missoesRepository;

    public MissoesService(MissoesMapper missoesMapper, MissoesRepository missoesRepository) {
        this.missoesMapper = missoesMapper;
        this.missoesRepository = missoesRepository;

    }

    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    public MissoesModel listarMissaoPorId(Long id) {
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.orElse(null);
    }

    public MissoesDTO criarMissao(MissoesDTO missaoDTO) {
        MissoesModel missoes= missoesMapper.map(missaoDTO);
       missoes = missoesRepository.save(missoes);
       return missoesMapper.map(missoes);

    }

    public void deletarMissaoPorId(Long id) {
        missoesRepository.deleteById(id);
    }

    public MissoesModel atualizarMissao(Long id, MissoesModel missoesAtualizado){
        if ((missoesRepository.existsById(id) )){
            missoesAtualizado.setId(id);
            return missoesRepository.save(missoesAtualizado);
        }

        return null;
    }

}
