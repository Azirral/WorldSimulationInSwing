package com.pg.project2.model.pojo.animal;

import com.pg.project2.model.engine.World;
import com.pg.project2.model.engine.common.OrganismRepr;
import com.pg.project2.model.pojo.Organism;

import java.util.Random;

public class Human extends Animal {
    public Human(World world) {
        super(world);
        setInitiative(4);
        setStrength(5);
        setSymbol(OrganismRepr.HUMAN);
    }

    @Override
    public Integer getLength() {
        // - human special ability - antelope's speed
        if (getWorld().getRoundTurn() < 4 && getWorld().getRoundTurn() != 0) {
            getWorld().setRoundTurn(getWorld().getRoundTurn() + 1);
            return 2;
        } else if (getWorld().getRoundTurn() >= 4 && getWorld().getRoundTurn() <= 5) {
            int[] chances = {1, 1, 2, 2};
            getWorld().setRoundTurn(getWorld().getRoundTurn() + 1);
            return chances[new Random().nextInt(4)];
        }
        if(getWorld().getRoundTurn() != 0)
            getWorld().setRoundTurn(getWorld().getRoundTurn() + 1);
        if (getWorld().getRoundTurn() == 11)
            getWorld().setRoundTurn(0);
        return 1;
    }

    @Override
    public Organism factoryMethod(World world) {
        return new Human(getWorld());
    }

    @Override
    public String toString() {
        return "Human";
    }
}
