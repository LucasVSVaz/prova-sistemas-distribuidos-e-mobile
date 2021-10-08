package org.una.prova.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.una.prova.models.Curso;
import org.una.prova.repository.CursoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curso")
@AllArgsConstructor
public class CursoController {
    private CursoRepository repository;

    @GetMapping()
    public List<Curso> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Curso> getById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping()
    public Curso create(@RequestBody Curso curso) {
        return repository.save(curso);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping(value = "/{id}")
    public void update (@PathVariable Long id, @RequestBody Curso curso){
        curso.setId(id);
        repository.save(curso);
    }
}
