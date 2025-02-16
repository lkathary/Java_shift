package org.lkathary.shift.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeFile {
    INTEGER_FILE("integer.txt"),
    FLOAT_FILE("float.txt"),
    STRING_FILE("string.txt");

    private final String title;
}
