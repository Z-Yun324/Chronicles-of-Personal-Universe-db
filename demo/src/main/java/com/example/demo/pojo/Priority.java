package com.example.demo.pojo;

import lombok.Getter;

@Getter
public enum Priority {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4);

    private final int value;

    Priority(int value) {
        this.value = value;
    }
}
