package com.viveris.product.exception;

import com.viveris.product.dto.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 404 — Ressource introuvable
     * Levée par le service quand un produit n'existe pas
     */
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ProductNotFoundException ex) {
        // TODO: utiliser ErrorResponse.of(HttpStatus.NOT_FOUND, ex.getMessage())
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse.of(HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    /**
     * 400 — Erreurs de validation (@Valid sur @RequestBody)
     * Ex : name vide, price négatif
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
        // TODO: extraire tous les messages d'erreur (pas juste le premier)
        //       les joindre avec ", " et retourner un 400
        //       Astuce : ex.getBindingResult().getFieldErrors().stream()
        //                 .map(e -> e.getField() + " : " + e.getDefaultMessage())
        //                 .collect(Collectors.joining(", "))
        String message = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(e -> e.getField() + " : " + e.getDefaultMessage())
                .findFirst()
                .orElse("requete invalide");

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.of(HttpStatus.BAD_REQUEST, message));
    }

    /**
     * 400 — JSON malformé ou corps manquant
     * Ex : accolades manquantes, virgule en trop, body absent
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleNotReadable(HttpMessageNotReadableException ex) {
        // TODO: retourner 400 avec message "Corps de la requête manquant ou invalide"
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.of(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    /**
     * 400 — Mauvais type dans l'URL
     * Ex : GET /api/products/abc → "abc" ne peut pas être converti en Long
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        // TODO: construire un message du type :
        //       "Paramètre '" + ex.getName() + "' invalide : valeur '" + ex.getValue() + "'"
        //       et retourner un 400
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.of(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    /**
     * 405 — Méthode HTTP non supportée
     * Ex : DELETE /api/products alors que seul GET est défini
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorResponse> handleMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        // TODO: retourner 405 avec message "Méthode HTTP non supportée : " + ex.getMethod()
        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(ErrorResponse.of(HttpStatus.METHOD_NOT_ALLOWED, ex.getMessage()));
    }

    /**
     * 409 — Conflit en base de données
     * Ex : création d'un produit avec un nom déjà existant (contrainte unique)
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrity(DataIntegrityViolationException ex) {
        // TODO: retourner 409 avec message "Conflit : une ressource avec ces données existe déjà"
        //       Ne pas exposer le message technique de Hibernate (ex.getMessage() contient des détails SQL)
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ErrorResponse.of(HttpStatus.CONFLICT, ex.getMessage()));
    }

    /**
     * 500 — Toute exception non gérée
     * Filet de sécurité — ne jamais exposer le message technique au client
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex) {
        // TODO: logger l'exception (ex.getMessage()) pour le debug interne
        //       retourner 500 avec message générique "Une erreur interne est survenue"
        //       NE PAS retourner ex.getMessage() au client !
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR, "Une erreur interne est survenue"));
    }
}
