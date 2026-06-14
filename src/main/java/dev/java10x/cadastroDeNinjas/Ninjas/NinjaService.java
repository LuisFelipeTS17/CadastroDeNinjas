package dev.java10x.cadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjasRepository ninjasRepository;

    public NinjaService(NinjasRepository ninjasRepository) {
        this.ninjasRepository = ninjasRepository;
    }

    //Listar todos os meus ninjas
    public List<NinjaModel> listarNinja () {
        return ninjasRepository.findAll();
    }

    //Listar todos os meus ninjas por ID

    public NinjaModel listarNinjasPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjasRepository.findById(id);
        return ninjaPorId.orElse(null);

    }

}
