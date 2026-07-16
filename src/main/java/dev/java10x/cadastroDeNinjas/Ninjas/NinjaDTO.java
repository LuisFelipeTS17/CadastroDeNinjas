package dev.java10x.cadastroDeNinjas.Ninjas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {

    private String nome;
    private String email;
    private String imgUrl;
    private int idade;
}
