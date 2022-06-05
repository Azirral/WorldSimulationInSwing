package com.pg.project2.model.pojo.plant;

import com.pg.project2.model.engine.World;
import com.pg.project2.model.engine.common.OrganismRepr;
import com.pg.project2.model.pojo.Organism;
import com.pg.project2.model.pojo.animal.Animal;

public class SosnowskysHogweed extends Plant {
    public SosnowskysHogweed(World world) {
        super(world);
        setStrength(10);
        setSymbol(OrganismRepr.SOSNOWSKYS_HOGWEED);
    }

    @Override
    public void action(int destinationX, int destinationY) {
        super.action(destinationX, destinationY);
        greedyFindAnimalFieldCoordinates();
    }

    @Override
    public Organism factoryMethod(World world) {
        return new SosnowskysHogweed(getWorld());
    }

    @Override
    public String toString() {
        return "Sosnowskys Hogweed";
    }

    public void greedyFindAnimalFieldCoordinates() {

        for (int i = -1; i < 2; i++)
            for (int j = -1; j < 2; j++)
                if (getWorld().validateBorder(getX() + i, getY() + j) && getWorld().getWorld().get(getX() + i).get(getY() + j) instanceof Animal) {
                    String temp1 = getWorld().getWorld().get(getX() + i).get(getY() + j).toString(), temp2 = toString();
                    System.out.println(temp2 + " from (" + getX() + "," + getY() + ")" + " killed " + temp1
                            + " at (" + (getX() + i) + "," + (getY() + j) + ")");
                    getWorld().place(getX() + i, getY() + j, null);
                }
    }
}
