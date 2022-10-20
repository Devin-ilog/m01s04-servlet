package tech.devinhouse.m01s06spring.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Pessoa {

    private static Integer SEQUENCIA = 0;

    private Integer id;
    private String nome;
    private Integer idade;

    public Pessoa() {
        this.id = gerarId();
    }

    private Integer gerarId() {
        return ++SEQUENCIA;
    }

}
