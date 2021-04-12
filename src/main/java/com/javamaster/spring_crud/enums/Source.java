package com.javamaster.spring_crud.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Source {
    ECO("eco"),
    TECH("tech");

    private final String name;

    Source(String name) {
        this.name = name;
    }
}