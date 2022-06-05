package com.pg.project2.model.pojo.plant;

import com.pg.project2.model.engine.World;
import com.pg.project2.model.engine.common.OrganismRepr;
import com.pg.project2.model.pojo.Organism;

public class Guarana extends Plant {
    public Guarana(World world) {
        super(world);
        setSymbol(OrganismRepr.GUARANA);
    }

    @Override
    public Organism factoryMethod(World world) {
        return new Guarana(getWorld());
    }

    @Override
    public String toString() {
        return "Guarana";
    }
}
