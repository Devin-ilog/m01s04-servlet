package tech.devinhouse.m01s06spring.controllers;

import org.springframework.web.bind.annotation.*;
import tech.devinhouse.m01s06spring.models.Pessoa;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "pessoa")
public class PessoaController {

    private static List<Pessoa> pessoas = new ArrayList<>();

    @GetMapping
    public List<Pessoa> get() {
        return pessoas;
    }

    @GetMapping(path = "{id}")
    public Pessoa getId(@PathVariable Integer id) {
        for (Pessoa p : pessoas) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @PostMapping
    public Pessoa post(@RequestBody Pessoa pessoa) {
        pessoas.add(pessoa);
        return pessoa;
    }

    @PutMapping(path = "{id}")
    public Pessoa put(@PathVariable Integer id, @RequestBody Pessoa pessoa) {

        Pessoa pessoaEditada = null;
        for (Pessoa p : pessoas) {
            if (p.getId() == id) {
                pessoaEditada = p;
                break;
            }
        }

        if (pessoaEditada != null) {
            pessoaEditada.setNome(pessoa.getNome());
            pessoaEditada.setIdade(pessoa.getIdade());
        }

        return pessoaEditada;
    }

    @DeleteMapping
    public void delete(Integer id) {

        Pessoa pessoaRemover = null;
        for (Pessoa p : pessoas) {
            if (p.getId() == id) {
                pessoaRemover = p;
                break;
            }
        }

        if (pessoaRemover != null) {
            pessoas.remove(pessoaRemover);
        }

    }

}
