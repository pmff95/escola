package com.example.demo.controller.doc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.demo.util.ApiReturn;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Operation(
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Lista recuperada com sucesso",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ApiReturn.class),
                                examples = {
                                        @ExampleObject(
                                                name = "Exemplo de retorno",
                                                summary = "Exemplo de resposta",
                                                value = "{\"success\": true, \"errorType\": null, \"errorCode\": 0, \"error\": null, \"internalException\": null, \"return\": \"Objeto de Retorno\"}"
                                        )
                                }
                        )
                ),
                @ApiResponse(
                        responseCode = "204",
                        description = "Consulta realizada com sucesso, mas sem resultados",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ApiReturn.class),
                                examples = {
                                        @ExampleObject(
                                                name = "Exemplo de retorno",
                                                summary = "Exemplo de resposta",
                                                value = "{\"success\": true, \"errorType\": \"NO_CONTENT\", \"errorCode\": 204, \"error\": \"Não há dados para este filtro\", \"internalException\": \"Não há dados para este filtro\", \"return\": null}\n"
                                        )
                                }
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Requisição inválida",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ApiReturn.class),
                                examples = {
                                        @ExampleObject(
                                                name = "Exemplo de retorno",
                                                summary = "Exemplo de resposta",
                                                value = "{\"success\": false, \"errorType\": \"VALIDATION\", \"errorCode\": 400, \"error\": \"Mensagem de Erro\", \"internalException\": \"Mensagem de Erro\", \"return\": null}\n"
                                        )
                                }
                        )
                ),
                @ApiResponse(
                        responseCode = "401",
                        description = "Sem permissão",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ApiReturn.class),
                                examples = {
                                        @ExampleObject(
                                                name = "Exemplo de retorno",
                                                summary = "Exemplo de resposta",
                                                value = "{\"success\": false, \"errorType\": \"UNAUTHORIZED\", \"errorCode\": 401, \"error\": \"Mensagem de Erro\", \"internalException\": \"Mensagem de Erro\", \"return\": null}"
                                        )
                                }
                        )
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Objeto não encontrado",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ApiReturn.class),
                                examples = {
                                        @ExampleObject(
                                                name = "Exemplo de retorno",
                                                summary = "Exemplo de resposta",
                                                value = "{\"success\": false, \"errorType\": \"NOT_FOUND\", \"errorCode\": 404, \"error\": \"Mensagem de Erro\", \"internalException\": \"Mensagem de Erro\", \"return\": null}"
                                        )
                                }
                        )
                ),
                @ApiResponse(
                        responseCode = "409",
                        description = "Conflito de informação",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ApiReturn.class),
                                examples = {
                                        @ExampleObject(
                                                name = "Exemplo de retorno",
                                                summary = "Exemplo de resposta",
                                                value = "{\"success\": false, \"errorType\": \"CONFLICT\", \"errorCode\": 409, \"error\": \"Mensagem de Erro\", \"internalException\": \"Mensagem de Erro\", \"return\": null}"
                                        )
                                }
                        )
                ),
                @ApiResponse(
                        responseCode = "500",
                        description = "Erro interno do servidor",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ApiReturn.class),
                                examples = {
                                        @ExampleObject(
                                                name = "Exemplo de retorno",
                                                summary = "Exemplo de resposta",
                                                value = "{\"success\": false, \"errorType\": \"EXCEPTION\", \"errorCode\": 500, \"error\": \"Mensagem de Erro\", \"internalException\": \"Mensagem de Erro\", \"return\": null}"
                                        )
                                }
                        )
                ),
        }
)
public @interface EurekaApiOperation {
    String summary() default "";
    String description() default "";
}
