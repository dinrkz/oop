package org.example.json;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @GetMapping("/professors")
    public List<Professor> getAllProfessors() {

        return repository.findAll();
    }
}
