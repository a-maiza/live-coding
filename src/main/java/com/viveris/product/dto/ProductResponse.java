package com.viveris.product.dto;

// DTO de réponse : ce que l'API expose au client
// Ne contient que ce que le client a le droit de voir
// Aucune annotation JPA — complètement découplé de la base de données
public record ProductResponse(Long id, String name, double price) {
}
