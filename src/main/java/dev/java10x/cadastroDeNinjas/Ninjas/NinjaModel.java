package dev.java10x.cadastroDeNinjas.Ninjas;

import dev.java10x.cadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//Entity -> Ele transforma uma classe em uma entidade do DB
// JPA = JAVA PERSISTENCE API
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column
    private String imgUrl;

    @Column(name = "idade")
    private int idade;

    //@ManyToOne = Um ninja tem uma unica missao.
    @ManyToOne
    @JoinColumn(name ="missoes_id") // Foreing Key ou chave estrangeira

    private MissoesModel missoes;



}
