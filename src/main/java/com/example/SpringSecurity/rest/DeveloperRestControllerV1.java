package com.example.SpringSecurity.rest;

import com.example.SpringSecurity.model.Developer;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestControllerV1 {

    private List<Developer> DEVELOPERS = Stream.of(
            new Developer(1, "Nargiza", "Nematova"),
            new Developer(2, "Alex", "Eyre"),
            new Developer(3, "Rosy", "Collins")
    ).collect(Collectors.toList());

    @GetMapping
    public List<Developer> getAll() {
        return DEVELOPERS;
    }

    @GetMapping("/{id}")
    public Developer getAllId(@PathVariable Long id) {
        return DEVELOPERS.stream().filter(developer -> Objects.equals(developer.getId(), id))
                .findFirst()
                .orElse(null);
    }

        @PostMapping
        public Developer creat (@RequestBody Developer developer){
            this.DEVELOPERS.add(developer);
            return developer;
        }

        @DeleteMapping("/{id}")
        public void deleteById (@PathVariable Long id){
            this.DEVELOPERS.removeIf(developer -> Objects.equals(developer.getId(), id));
        }

    }

