package com.comunidade.identity.api;

import org.springframework.web.bind.annotation.RestControllerAdvice;

// TODO Fase 1: handler global de exceções.
// Tratar pelo menos:
//   - MethodArgumentNotValidException -> 400 com lista de erros campo a campo
//   - DataIntegrityViolationException (email/cpf duplicado) -> 409 Conflict
//   - EntityNotFoundException -> 404 Not Found
//   - Exception (catch-all) -> 500 com mensagem genérica
//
// Considere usar o padrão RFC 7807 (ProblemDetail) — Spring 6+ tem suporte built-in
// via ProblemDetail.forStatusAndDetail(...). Aprenda esse padrão, é o estado da arte.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // TODO: @ExceptionHandler(...) métodos
}
