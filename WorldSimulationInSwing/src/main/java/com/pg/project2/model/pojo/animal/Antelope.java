package com.pg.project2.model.pojo.animal;

import com.pg.project2.model.engine.World;
import com.pg.project2.model.engine.common.OrganismRepr;
import com.pg.project2.model.pojo.Organism;

public class Antelope extends Animal {
    public Antelope(World world) {
        super(world);
        setInitiative(4);
        setStrength(4);
        setSymbol(OrganismRepr.ANTELOPE);
    }

    @Override
    public Integer getLength() {
        return 2;
    }

    @Override
    public Organism factoryMethod(World world) {
        return new Antelope(getWorld());
    }

    @Override
    public String toString() {
        return "Antelope";
    }
}
