package com.pg.project2.model.pojo.plant;

import com.pg.project2.model.engine.World;
import com.pg.project2.model.engine.common.Pair;
import com.pg.project2.model.pojo.Organism;

import java.util.Objects;
import java.util.Random;

public abstract class Plant extends Organism {
    public Plant(World world) {
        super(world);
    }

    @Override
    public void action(int destinationX, int destinationY) {
        Pair<Integer, Integer> emptyCoordinates = greedyFindEmptyFieldCoordinates();
        int number = new Random().nextInt(101);
        // - sawing of plants
        if (!Objects.isNull(emptyCoordinates) && number <= 10
                && Objects.isNull(getWorld().getWorld().get(emptyCoordinates.getLeft()).get(emptyCoordinates.getRight()))) {
            Organism newBorn = factoryMethod(getWorld());
            newBorn.place(emptyCoordinates.getLeft(), emptyCoordinates.getRight());
            String temp = newBorn.toString();
            System.out.println(temp + " from (" + getX() + "," + getY() + ")" + " saw to (" + emptyCoordinates.getLeft()
                    + "," + emptyCoordinates.getRight() + ")");
        }
    }

    @Override
    public Integer getLength() {
        return 0;
    }
}
