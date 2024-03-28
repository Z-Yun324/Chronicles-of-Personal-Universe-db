package com.example.demo.pojo;

import lombok.Getter;

@Getter
public enum PictureID {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private final int value;

    PictureID(int value) {
        this.value = value;
    }

}

