package com.pg.project2.model.engine.common;

import com.pg.project2.model.pojo.Organism;
import com.pg.project2.model.pojo.animal.*;
import com.pg.project2.model.pojo.plant.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum OrganismRepr {
    GRASS("|", new Grass(null)), GUARANA("g", new Guarana(null)),
    BELLADONNA("b", new Belladonna(null)), TURTLE("t", new Turtle(null)),
    FOX("f", new Fox(null)), SHEEP("s", new Sheep(null)),
    WOLF("w", new Wolf(null)), SOW_THISTLE("m", new SowThistle(null)),
    SOSNOWSKYS_HOGWEED("H", new SosnowskysHogweed(null)), HUMAN("C", new Human(null)),
    ANTELOPE("a", new Antelope(null)), EMPTY(" ", null);

    private String repr;
    private Organism org;

    public OrganismRepr[] getValues() {
        return values();
    }

    public static OrganismRepr findByCode(String code) {
        return Arrays.stream(values()).filter(e -> e.getRepr().equals(code)).findFirst().orElse(EMPTY);
    }

    public static OrganismRepr[] valuesForChoose() {
        return new OrganismRepr[]{GRASS, GUARANA, BELLADONNA, TURTLE, FOX, SHEEP, WOLF, SOW_THISTLE, SOSNOWSKYS_HOGWEED,
                HUMAN, ANTELOPE, EMPTY
        };
    }
}
