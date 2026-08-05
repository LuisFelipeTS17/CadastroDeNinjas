package dev.java10x.cadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {
    private MissoesMapper missoesMapper;
    private MissoesRepository missoesRepository;

    public MissoesService(MissoesMapper missoesMapper, MissoesRepository missoesRepository) {
        this.missoesMapper = missoesMapper;
        this.missoesRepository = missoesRepository;

    }

    public List<MissoesDTO> listarMissoes() {
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesDTO listarMissaoPorId(Long id) {
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.map(missoesMapper::map).orElse(null);
    }

    public MissoesDTO criarMissao(MissoesDTO missaoDTO) {
        MissoesModel missoes= missoesMapper.map(missaoDTO);
       missoes = missoesRepository.save(missoes);
       return missoesMapper.map(missoes);

    }

    public void deletarMissaoPorId(Long id) {
        missoesRepository.deleteById(id);
    }

    public MissoesDTO atualizarMissao(Long id, MissoesDTO missoesDTO){
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if (missaoExistente.isPresent()) {
            MissoesModel missoesAtualizado = missoesMapper.map(missoesDTO);
            missoesAtualizado.setId(id);
            MissoesModel missoesSalvo = missoesRepository.save(missoesAtualizado);
            return missoesMapper.map(missoesSalvo);
        }
        return null;
    }

}
