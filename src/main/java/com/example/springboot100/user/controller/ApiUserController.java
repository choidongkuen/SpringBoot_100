package com.example.springboot100.user.controller;

import com.example.springboot100.exception.ResponseError;
import com.example.springboot100.user.domain.dto.UserCreateDto;
import com.example.springboot100.user.domain.dto.UserUpdateDto;
import com.example.springboot100.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ApiUserController {

    private final UserService userService;

    @PostMapping("/api/user")
    public ResponseEntity<Object> addUser(
            @RequestBody @Valid UserCreateDto.UserCreateRequest request,
            Errors errors)
    {
        ResponseEntity<Object> responseErrors = getObjectResponseEntity(errors);
        if (responseErrors != null) return responseErrors;

        return new ResponseEntity<>(
                userService.addUser(request),HttpStatus.OK
        );
    }

    @PutMapping("/api/user/{id}")
    public ResponseEntity<Object> updateUser(
            @PathVariable("id") Long id,
            @RequestBody @Valid UserUpdateDto.UserUpdateRequest request,
            Errors errors
    ) {

        ResponseEntity<Object> responseErrors = getObjectResponseEntity(errors);
        if (responseErrors != null) return responseErrors;

        return new ResponseEntity<>(
                userService.updateUser(id, request),HttpStatus.OK
        );
    }


    private static ResponseEntity<Object> getObjectResponseEntity(Errors errors) {

        if(errors.hasErrors()) {

            List<ResponseError> responseErrors = new ArrayList<>();

            errors.getAllErrors().forEach(e -> {

                responseErrors.add(ResponseError.of((FieldError) e));

            });

            return new ResponseEntity<>(
                    responseErrors, HttpStatus.BAD_REQUEST
            );

        }
        return null;
    }
}
