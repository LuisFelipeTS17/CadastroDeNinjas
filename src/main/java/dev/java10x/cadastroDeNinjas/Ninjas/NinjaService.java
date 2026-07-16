package dev.java10x.cadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar todos os meus ninjas
    public List<NinjaModel> listarNinja () {
        return ninjaRepository.findAll();
    }

    //Listar todos os meus ninjas por ID
    public NinjaModel listarNinjasPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    //Criar um novo ninja
    public NinjaModel criarNinja(NinjaDTO dto) {
        NinjaModel ninja = new NinjaModel();
        ninja.setNome(dto.getNome());
        ninja.setEmail(dto.getEmail());
        ninja.setImgUrl(dto.getImgUrl());
        ninja.setIdade(dto.getIdade());
        return ninjaRepository.save(ninja);
    }

    //Deletar o ninja - tem q ser um metodo void
    public void deletarNinjaPorId(Long id){
       ninjaRepository.deleteById(id);
    }

    //Atualizar ninja
    public NinjaModel atualizarNinja(Long id, NinjaDTO dto) {
        if (ninjaRepository.existsById(id)) {
            NinjaModel ninja = new NinjaModel();
            ninja.setId(id);
            ninja.setNome(dto.getNome());
            ninja.setEmail(dto.getEmail());
            ninja.setImgUrl(dto.getImgUrl());
            ninja.setIdade(dto.getIdade());
            return ninjaRepository.save(ninja);
        }
        return null;
    }
}
