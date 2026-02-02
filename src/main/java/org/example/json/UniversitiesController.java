package org.example.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UniversitiesController {

    @Autowired
    private UniversitiesRepository repository;

    @GetMapping("/universities")
    public List<Universities> getAll() {

        return repository.findAll();
    }
}
