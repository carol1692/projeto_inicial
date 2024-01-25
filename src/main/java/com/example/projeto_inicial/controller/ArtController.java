package com.example.projeto_inicial.controller;

import com.example.projeto_inicial.art.Art;
import com.example.projeto_inicial.art.ArtRepository;
import com.example.projeto_inicial.art.ArtResponseDTO;
import com.example.projeto_inicial.art.ArtRequestDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("art")
public class ArtController {
    @Autowired
    private ArtRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveArt(@RequestBody ArtRequestDTO data){
        Art artData = new Art(data);
        repository.save(artData);
        return;
    }

    @GetMapping
    public List<ArtResponseDTO> getAll(){

        List<ArtResponseDTO> artList = repository.findAll().stream().map(ArtResponseDTO::new).toList();
        return artList;
    }
}
