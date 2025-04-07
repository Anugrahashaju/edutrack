package com.example.enrollement_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
    @NotNull
    Long studentId;
    @NotNull
    Long courseId;
}
