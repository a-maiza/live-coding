package com.viveris.product.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

// Réponse structurée retournée par le GlobalExceptionHandler
// Remplace les simples String par un objet JSON cohérent
public record ErrorResponse(
        int status,
        String error,
        String message,
        LocalDateTime timestamp
) {
    // TODO: ajouter un constructeur statique de confort "factory method"
    //   ex: public static ErrorResponse of(HttpStatus status, String message)
    //       qui renseigne automatiquement le timestamp avec LocalDateTime.now()
    public static ErrorResponse of(HttpStatus status, String message) {
        return new ErrorResponse(
                status.value(),
                status.getReasonPhrase(),  // ex: "Not Found", "Bad Request"
                message,
                LocalDateTime.now()
        );
    }
}
