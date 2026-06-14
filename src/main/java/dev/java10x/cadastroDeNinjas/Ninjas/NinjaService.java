package dev.java10x.cadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;


import java.util.List;

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

}
