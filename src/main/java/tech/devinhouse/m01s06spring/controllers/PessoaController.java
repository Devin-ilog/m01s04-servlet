package tech.devinhouse.m01s06spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.m01s06spring.models.Pessoa;
import tech.devinhouse.m01s06spring.services.PessoaService;

import java.util.List;

@RestController
@RequestMapping(value = "pessoa")
public class PessoaController {

    private PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public List<Pessoa> get() {
        return pessoaService.findAll();
    }

    @GetMapping(path = "{id}")
    public Pessoa getId(@PathVariable Integer id) {
        return pessoaService.findById(id);
    }

    @PostMapping
    public Pessoa post(@RequestBody Pessoa pessoa) {
        return pessoaService.save(pessoa);
    }

    @PutMapping(path = "{id}")
    public Pessoa put(@PathVariable Integer id, @RequestBody Pessoa pessoa) {
        pessoa.setId(id);
        return pessoaService.save(pessoa);
    }

    @DeleteMapping
    public void delete(Integer id) {
        pessoaService.delete(id);
    }

}
