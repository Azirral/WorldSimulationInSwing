package com.pg.project2.model.pojo.plant;

import com.pg.project2.model.engine.World;
import com.pg.project2.model.engine.common.OrganismRepr;
import com.pg.project2.model.pojo.Organism;

public class Belladonna extends Plant {
    public Belladonna(World world) {
        super(world);
        setStrength(99);
        setSymbol(OrganismRepr.BELLADONNA);
    }

    @Override
    public Organism factoryMethod(World world) {
        return new Belladonna(getWorld());
    }

    @Override
    public String toString() {
        return "Belladonna";
    }
}
