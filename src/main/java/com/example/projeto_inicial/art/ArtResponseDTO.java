package com.example.projeto_inicial.art;

public record ArtResponseDTO(long id, String title, String image, Integer price ) {
    public ArtResponseDTO(Art art){
        this(art.getId(), art.getTitle(), art.getImage(), art.getPrice());
    }
}
