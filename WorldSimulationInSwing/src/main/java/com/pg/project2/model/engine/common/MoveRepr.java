package com.pg.project2.model.engine.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum MoveRepr {
    LEFT("←", 3), DOWN("↓", 2), RIGHT("→", 1), UP("↑", 0), UNKNOWN("", -1);

    private String strRepr;
    private int intRepr;

    public MoveRepr[] getValues() {
        return values();
    }

    public static MoveRepr findByStrRepr(String strRepr) {
        return Arrays.stream(values()).filter(e -> e.getStrRepr().equals(strRepr)).findFirst().orElse(UNKNOWN);
    }
}
