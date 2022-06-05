package com.pg.project2.model.pojo.animal;

import com.pg.project2.model.engine.World;
import com.pg.project2.model.engine.common.Pair;
import com.pg.project2.model.pojo.Organism;
import com.pg.project2.model.pojo.plant.Belladonna;
import com.pg.project2.model.pojo.plant.Guarana;
import com.pg.project2.model.pojo.plant.Plant;
import com.pg.project2.model.pojo.plant.SosnowskysHogweed;

import java.util.Objects;

public abstract class Animal extends Organism {
    public Animal(World world) {
        super(world);
    }

    @Override
    public void action(int destinationX, int destinationY) {
        String temp = this.toString();
        System.out.println(temp + " moved from (" + getX() + "," + getY() + ") to (" + destinationX + ","
                + destinationY + ")");
        getWorld().place(destinationX, destinationY, this);
        getWorld().place(getX(), getY(), null);
        setX(destinationX);
        setY(destinationY);
    }

    public void collision(int destinationX, int destinationY) {
        if (isPlant(getWorld().getWorld().get(destinationX).get(destinationY))) // if neighbour is plant
            performActionForPlant(this, getX(), getY(), destinationX, destinationY);
        else // if neighbour is animal
            if (isSameSpecies(getWorld().getWorld().get(destinationX).get(destinationY))) {// if of the same type (then breed)
                System.out.println(this.toString() + " from (" + getX() + "," + getY() + ") attempted to breed "
                        + getWorld().getWorld().get(destinationX).get(destinationY).toString() + " at (" + destinationX
                + "," + destinationY + ")");
                performActionForBreed(this, destinationX, destinationY);
            }
            else // not of the same type
                performFight(getX(), getY(), destinationX, destinationY);
    }

    private void performActionForPlant(Organism organism, int x, int y, int destinationX, int destinationY) {
        /*
            Instead of calling the plant's collision method, the action is handled in the
            performActionForPlant because the collision action is strictly related to the movement,
            when the destination field is already taken.
        */
        // death condition
        String temp1 = toString(), temp2 = getWorld().getWorld().get(destinationX).get(destinationY).toString(),
                text = temp1 + " from (" + x + "," + y + ")" + " ate " + temp2 + " at (" + destinationX + "," + destinationY + ")";
        if (isPoisonousPlant(getWorld().getWorld().get(destinationX).get(destinationY))) {
            System.out.println(temp1 + " from (" + x + "," + y + ")" + " ate a poisonous plant " + temp2
                    + " at (" + destinationX + "," + destinationY + ")");
            getWorld().place(getX(), getY(), null);
            getWorld().place(destinationX, destinationY, null);
        }
        // increase strength condition
        else if (isStrengtheningPlant(getWorld().getWorld().get(destinationX).get(destinationY))) {
            System.out.println(text);
            action(destinationX, destinationY);
            increaseStrength();
        }
        // do nothing means perform move (eating grass and sow thistles)
        else {
            System.out.println(text);
            action(destinationX, destinationY);
        }
    }

    private void performActionForBreed(Organism organism, int x, int y) {
        // - breeding of animals
        Pair<Integer, Integer> emptyCoordinates = greedyFindEmptyFieldCoordinates();
        if (!Objects.isNull(emptyCoordinates)
                && Objects.isNull(getWorld().getWorld().get(emptyCoordinates.getLeft()).get(emptyCoordinates.getRight()))) {
            System.out.println(this + " multiplied to (" + emptyCoordinates.getLeft() + "," + emptyCoordinates.getRight() + ")");
            organism.factoryMethod(getWorld()).action(emptyCoordinates.getLeft(), emptyCoordinates.getRight());
        }
    }

    private void performFight(int x, int y, int destinationX, int destinationY) {
        String temp1 = toString(), temp2 = getWorld().getWorld().get(destinationX).get(destinationY).toString(),
                text = temp1 + " from (" + x + "," + y + ")" + " %s " + temp2
                        + " at (" + destinationX + "," + destinationY + ")";
        if (getStrength() >= getWorld().getWorld().get(destinationX).get(destinationY).getStrength()) {
            action(destinationX, destinationY);
            System.out.println(String.format(text, "killed"));
        } else if (getWorld().getWorld().get(destinationX).get(destinationY) instanceof Turtle && getStrength() >= 5) {
            action(destinationX, destinationY);
            System.out.println(String.format(text, "fend of the attacker"));
        } else {
            System.out.println(String.format(text, "was killed by"));
            getWorld().getWorld().get(getX()).set(getY(), null); // dunno
        }
    }

    private Boolean isPlant(Organism organism) {
        return organism instanceof Plant;
    }

    private Boolean isPoisonousPlant(Organism organism) {
        return organism instanceof Belladonna || organism instanceof SosnowskysHogweed;
    }

    private Boolean isStrengtheningPlant(Organism organism) {
        return organism instanceof Guarana;
    }

    protected Boolean isSameSpecies(Organism organism) {
        return this.getClass().equals(organism.getClass());
    }

    private void increaseStrength() {
        setStrength(getStrength() + 3);
    }

    @Override
    public String toString() {
        return "Animal";
    }
}
