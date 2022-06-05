package com.pg.project2.model.pojo.animal;

import com.pg.project2.model.engine.World;
import com.pg.project2.model.engine.common.OrganismRepr;
import com.pg.project2.model.pojo.Organism;

public class Sheep extends Animal {
    public Sheep(World world) {
        super(world);
        setInitiative(4);
        setStrength(4);
        setSymbol(OrganismRepr.SHEEP);
    }

    @Override
    public Organism factoryMethod(World world) {
        return new Sheep(getWorld());
    }

    @Override
    public String toString() {
        return "Sheep";
    }
}
