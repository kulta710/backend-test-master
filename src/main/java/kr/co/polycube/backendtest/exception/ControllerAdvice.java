package kr.co.polycube.backendtest.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {

    // 404에 대하여
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> notFoundException(Exception e) {

        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        Map<String, String> map = new HashMap<String, String>();
        map.put("reason", "resource not found");

        return new ResponseEntity<Map<String, String>>(map, responseHeaders, httpStatus);
    }

    // 400에 대하여
    @ExceptionHandler({
            HttpMessageNotReadableException.class,
            MissingServletRequestPartException.class,
            MethodArgumentNotValidException.class,
            MissingServletRequestParameterException.class,
            TypeMismatchException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> badRequestException(Exception e) {

        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        Map<String, String> map = new HashMap<String, String>();
        map.put("reason", "bad request");

        return new ResponseEntity<Map<String, String>>(map, responseHeaders, httpStatus);
    }
}
