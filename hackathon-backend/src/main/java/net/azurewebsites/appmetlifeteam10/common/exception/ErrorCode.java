package net.azurewebsites.appmetlifeteam10.common.exception;

import org.springframework.http.HttpStatus;

public record ErrorCode(HttpStatus status, String message) {
}
