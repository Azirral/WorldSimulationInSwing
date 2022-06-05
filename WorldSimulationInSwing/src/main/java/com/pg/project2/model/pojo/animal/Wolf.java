package com.pg.project2.model.pojo.animal;

import com.pg.project2.model.engine.World;
import com.pg.project2.model.engine.common.OrganismRepr;
import com.pg.project2.model.pojo.Organism;

public class Wolf extends Animal {
    public Wolf(World world) {
        super(world);
        setInitiative(5);
        setStrength(9);
        setSymbol(OrganismRepr.WOLF);
    }

    @Override
    public Organism factoryMethod(World world) {
        return new Wolf(getWorld());
    }

    @Override
    public String toString() {
        return "Wolf";
    }
}
