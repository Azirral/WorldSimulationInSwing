package com.pg.project2.model.pojo;

import com.pg.project2.model.engine.World;
import com.pg.project2.model.engine.common.OrganismRepr;
import com.pg.project2.model.engine.common.Pair;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Organism {
    private World world;
    private Integer x = 0;
    private Integer y = 0;
    private Integer numberOfTries = 0;
    private Integer strength = 0;
    private Integer initiative = 0;
    private Integer age = 0;
    private Integer length = 1;
    private OrganismRepr symbol = OrganismRepr.EMPTY;
    private Boolean toBeMove = true;

    public Organism(World world) {
        this.world = world;
    }

    public Organism(OrganismRepr symbol) {
        this.symbol = symbol;
    }

    public abstract void action(int destinationX, int destinationY);

    public abstract Organism factoryMethod(World world);

    public void place(int x, int y) {
        getWorld().place(x, y, this);
        this.x = x;
        this.y = y;
    }

    public Pair<Integer, Integer> greedyFindEmptyFieldCoordinates() {
        for (int i = -1; i < 2; i++)
            for (int j = -1; j < 2; j++)
                if ((i != 0 || j != 0) && getWorld().validateCollision(getX() + i, getY() + j))
                    return new Pair<>(getX() + i, getY() + j);
        return null;
    }

    public Organism setWorld(World world) {
        this.world = world;
        return this;
    }

    public Organism setX(Integer x) {
        this.x = x;
        return this;
    }

    public Organism setY(Integer y) {
        this.y = y;
        return this;
    }

    public Organism setSymbol(OrganismRepr symbol) {
        this.symbol = symbol;
        return this;
    }

    public Integer getInitiative() {
        return this.initiative;
    }
}
