package com.pg.project2.model.pojo.plant;

import com.pg.project2.model.engine.World;
import com.pg.project2.model.engine.common.OrganismRepr;
import com.pg.project2.model.engine.common.Pair;
import com.pg.project2.model.pojo.Organism;

import java.util.Objects;
import java.util.Random;

public class SowThistle extends Plant {
    public SowThistle(World world) {
        super(world);
        setSymbol(OrganismRepr.SOW_THISTLE);
    }

    @Override
    public void action(int destinationX, int destinationY) {
        // - sawing of sow thistle
        for (int i = 0; i < 3; i++) {
            Pair<Integer, Integer> emptyCoordinates = greedyFindEmptyFieldCoordinates();
            int number = new Random().nextInt(101);
            if (!Objects.isNull(emptyCoordinates) && number <= 10) {
                Organism newBorn = factoryMethod(getWorld());
                newBorn.place(emptyCoordinates.getLeft(), emptyCoordinates.getRight());
                String temp = newBorn.toString();
                System.out.println(temp + " from (" + getX() + "," + getY() + ")" + " saw to (" + emptyCoordinates.getLeft()
                        + "," + emptyCoordinates.getRight() + ")");
            }
        }
    }

    @Override
    public Organism factoryMethod(World world) {
        return new SowThistle(getWorld());
    }

    @Override
    public String toString() {
        return "Sow Thistle";
    }
}
