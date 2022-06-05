package com.pg.project2.model.pojo.animal;

import com.pg.project2.model.engine.World;
import com.pg.project2.model.engine.common.OrganismRepr;
import com.pg.project2.model.pojo.Organism;

import java.util.Random;

public class Turtle extends Animal {
    public Turtle(World world) {
        super(world);
        setInitiative(1);
        setStrength(2);
        setSymbol(OrganismRepr.TURTLE);
    }

    @Override
    public Integer getLength() {
        int[] chances = {1, 0, 0, 0};
        int randomNumber = new Random().nextInt(4);
        if (chances[randomNumber] == 0)
            System.out.println("Turtle stayed at position (" + getX() + "," + getY() + ")");
        return chances[randomNumber];
    }

    @Override
    public Organism factoryMethod(World world) {
        return new Turtle(getWorld());
    }

    @Override
    public String toString() {
        return "Turtle";
    }
}
