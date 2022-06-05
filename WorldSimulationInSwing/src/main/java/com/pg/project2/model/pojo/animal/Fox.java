package com.pg.project2.model.pojo.animal;

import com.pg.project2.model.engine.World;
import com.pg.project2.model.engine.common.OrganismRepr;
import com.pg.project2.model.engine.common.Pair;
import com.pg.project2.model.pojo.Organism;

import java.util.Objects;

public class Fox extends Animal {
    public Fox(World world) {
        super(world);
        setInitiative(7);
        setStrength(3);
        setSymbol(OrganismRepr.FOX);
    }

    @Override
    public void action(int destinationX, int destinationY) {
        // - fox never moves to a stronger opponent cell
        if (!Objects.isNull(getWorld().getWorld().get(destinationX).get(destinationY))
                && getStrength() < getWorld().getWorld().get(destinationX).get(destinationY).getStrength()) {
            Pair<Integer, Integer> emptyCoordinates = greedyFindEmptyFieldCoordinates();
            if (!Objects.isNull(emptyCoordinates))
                super.action(emptyCoordinates.getLeft(), emptyCoordinates.getRight());
        } else
            super.action(destinationX, destinationY);
    }

    @Override
    public Organism factoryMethod(World world) {
        return new Fox(getWorld());
    }

    @Override
    public String toString() {
        return "Fox";
    }
}
