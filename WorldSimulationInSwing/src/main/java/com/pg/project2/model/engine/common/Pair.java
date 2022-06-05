package com.pg.project2.model.engine.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Pair<L, R> {
    private L left;
    private R right;

    public void set(L left, R right) {
        this.left = left;
        this.right = right;
    }
}
