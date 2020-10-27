package br.com.ramires.learn.basics.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

/**
 * Basic DTO ErrorResponse
 * @author feliperamires
 * @date 26,Out 2020
 *
 */
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class ErrorResponseDTO {

    private Integer statusCode;
    private String message;
    private String body;

}