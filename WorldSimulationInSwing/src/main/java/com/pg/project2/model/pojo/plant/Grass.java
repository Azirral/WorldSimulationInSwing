package com.pg.project2.model.pojo.plant;

import com.pg.project2.model.engine.World;
import com.pg.project2.model.engine.common.OrganismRepr;
import com.pg.project2.model.pojo.Organism;

public class Grass extends Plant {
    public Grass(World world) {
        super(world);
        setSymbol(OrganismRepr.GRASS);
    }

    @Override
    public Organism factoryMethod(World world) {
        return new Grass(getWorld());
    }

    @Override
    public String toString() {
        return "Grass";
    }
}
