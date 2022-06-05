package com.pg.project2.model.engine;

import com.pg.project2.model.engine.common.Constants;
import com.pg.project2.model.engine.common.OrganismRepr;
import com.pg.project2.model.engine.common.Pair;
import com.pg.project2.model.pojo.Organism;
import com.pg.project2.model.pojo.animal.*;
import com.pg.project2.model.pojo.plant.*;
import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

@Getter
@Setter
public class World {
    private List<List<Organism>> world;
    private Integer sizeX;
    private Integer sizeY;
    private Boolean turtleMove = Boolean.TRUE;
    private int roundTurn = 0;

    public World() {
        sizeX = Constants.WORLD_X;
        sizeY = Constants.WORLD_Y;
        initWorld();
    }

    private void initWorld() {
        world = new ArrayList<>(sizeX);
        for (int i = 0; i < sizeX; i++) {
            world.add(new ArrayList<>(sizeY));
            for (int j = 0; j < sizeY; j++)
                world.get(i).add(null);
        }
    }

    public void makeTurn(int humanDirection) {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            System.err.println(e.getMessage());
        }
        Set<Integer> initiativesSet = new HashSet<>();
        Set<Integer> ageSet = new HashSet<>();
        // - initializing a set of initiatives from the board
        for (int i = 0; i < sizeX; i++)
            for (int j = 0; j < sizeY; j++)
                if (!Objects.isNull(world.get(i).get(j)))
                    initiativesSet.add(world.get(i).get(j).getInitiative());

        // - sorting set of initiatives
        List<Integer> initiatives = new ArrayList<>(initiativesSet);
        Collections.sort(initiatives, Collections.reverseOrder());

        for (int i = 0; i < initiatives.size(); i++) {
            // - initiating a set of ages within a given age
            for (int k = 0; k < sizeX; k++)
                for (int l = 0; l < sizeY; l++)
                    if (!Objects.isNull(world.get(k).get(l)) && world.get(k).get(l).getInitiative().equals(initiatives.get(i)))
                        ageSet.add(world.get(k).get(l).getAge());
            List<Integer> ages = new ArrayList<>(ageSet);
            Collections.sort(ages, Collections.reverseOrder());

            // - moving all the organisms within a given initiative and age
            for (int h = 0; h < ages.size(); h++) {
                for (int a = 0; a < sizeX; a++)
                    for (int b = 0; b < sizeY; b++)
                        if (!Objects.isNull(world.get(a).get(b)) && world.get(a).get(b).getInitiative().equals(initiatives.get(i))
                                && world.get(a).get(b).getAge().equals(ages.get(h)) && world.get(a).get(b).getToBeMove())
                            move(a, b, world.get(a).get(b), humanDirection);
            }
        }
        // - updating the state of the game
        for (int k = 0; k < sizeX; k++) {
            for (int l = 0; l < sizeY; l++)
                if (!Objects.isNull(world.get(k).get(l))) {
                    world.get(k).get(l).setAge(world.get(k).get(l).getAge() + 1);
                    world.get(k).get(l).setToBeMove(true);
                }
        }
    }

    public void drawWorld() {                     //method drawWorld from previous project now not needed, all in swing
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (!Objects.isNull(world.get(i).get(j)))
                    System.out.print(world.get(i).get(j).getSymbol().getRepr());
                else
                    System.out.print("-");
            }
            System.out.println();
        }
    }

    public Pair<Integer, Integer> calculateCoordinates(Organism organism, int destinationX, int destinationY, int humanDirection) {
        int length = organism.getLength(), direction = !validateHuman(organism) ? new Random().nextInt(4) : humanDirection;
        if (length != 0) {
            return switch (direction) {
                case 0 -> new Pair<>(destinationX -= length, destinationY);// 0 means up
                case 1 -> new Pair<>(destinationX, destinationY += length); // 1 means right
                case 2 -> new Pair<>(destinationX += length, destinationY);// 2 means down
                case 3 -> new Pair<>(destinationX, destinationY -= length);// 3 means left
                default -> new Pair<>(-1, -1);
            };
        } else {
            turtleMove = false;
        }
        return new Pair<>(-1, -1);
    }

    public Boolean move(int x, int y, Organism organism, int humanDirection) {
        organism.setToBeMove(true);
        turtleMove = true;
        int destinationX = x, destinationY = y;
        Pair<Integer, Integer> coordinates = calculateCoordinates(organism, destinationX, destinationY, humanDirection);
        destinationX = coordinates.getLeft();
        destinationY = coordinates.getRight();
        Boolean vBorder = validateBorder(destinationX, destinationY),
                vCollision = validateCollision(destinationX, destinationY),
                vPlant = validatePlant(organism);
        if (vPlant)
            organism.action(-1, -1); // plant is not moving
        else if (!vBorder && organism.getNumberOfTries() < 20 && !validateHuman(organism) && !(organism instanceof Turtle)) {
            organism.setNumberOfTries(organism.getNumberOfTries() + 1);
            move(x, y, world.get(x).get(y), -1);
        } else if (organism.getNumberOfTries() >= 20) {
            organism.setNumberOfTries(0);
            return vBorder;
        } else if (vBorder && vCollision)  // if no border or collision issues
            organism.action(destinationX, destinationY);
        else if (vBorder)
            if (turtleMove)
                ((Animal) organism).collision(destinationX, destinationY);
        organism.setNumberOfTries(0);
        turtleMove = true;
        organism.setToBeMove(false);
        return vBorder;
    }

    public void place(int x, int y, Organism organism) {
        world.get(x).set(y, organism);
    }

    public void initializePopulation() {
        initializeOrganism(OrganismRepr.HUMAN);
        IntStream.range(0, (int) Math.floor(sizeX * sizeY * Constants.POPULATION))
                .forEach(number -> initializeOrganism(randomizeOrganisms()));
    }

    public Pair<Integer, Integer> getRandomCoordinates() {
        Pair<Integer, Integer> result = new Pair<>(null, null);
        do {
            result.set(new Random().nextInt(sizeX), new Random().nextInt(sizeY));
        } while (!Objects.isNull(world.get(result.getLeft()).get(result.getRight())));
        return result;
    }

    public void initializeOrganism(OrganismRepr symbol) {
        Pair<Integer, Integer> randomCoordinates = getRandomCoordinates();
        chooseOrganism(symbol).place(randomCoordinates.getLeft(), randomCoordinates.getRight());
    }

    public Organism chooseOrganism(OrganismRepr symbol) {
        return switch (symbol) {
            case HUMAN -> new Human(this);
            case WOLF -> new Wolf(this);
            case SHEEP -> new Sheep(this);
            case ANTELOPE -> new Antelope(this);
            case FOX -> new Fox(this);
            case TURTLE -> new Turtle(this);
            case BELLADONNA -> new Belladonna(this);
            case SOSNOWSKYS_HOGWEED -> new SosnowskysHogweed(this);
            case SOW_THISTLE -> new SowThistle(this);
            case GUARANA -> new Guarana(this);
            case GRASS -> new Grass(this);
            default -> null;
        };
    }

    public OrganismRepr randomizeOrganisms() {
        OrganismRepr res;
        do {
            res = OrganismRepr.values()[new Random().nextInt(OrganismRepr.values().length)];
        } while (res == OrganismRepr.HUMAN || res == OrganismRepr.EMPTY);
        return res;
    }

    public void saveWorld(File file) throws IOException {
        FileOutputStream fout = new FileOutputStream(file);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fout));
        for (int i = 0; i < sizeX; i++)
            for (int j = 0; j < sizeY; j++)
                if (!Objects.isNull(world.get(i).get(j))) {
                    bw.write(world.get(i).get(j).getSymbol().getRepr() + " "
                            + world.get(i).get(j).getX() + " "
                            + world.get(i).get(j).getY() + " "
                            + world.get(i).get(j).getStrength() + " "
                            + world.get(i).get(j).getAge() + " ");
                    bw.newLine();
                }
        bw.close();
    }

    public World readWorld(File file) throws IOException {
        initWorld();
        FileInputStream fin = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fin));
        String line = br.readLine();
        while (!Objects.isNull(line)) {
            String[] elements = line.split(" ");
            Organism org = this.chooseOrganism(OrganismRepr.findByCode(elements[0]));
            org.setStrength(Integer.valueOf(elements[3]));
            org.setAge(Integer.valueOf(elements[4]));
            this.place(Integer.parseInt(elements[1]), Integer.parseInt(elements[2]), org);
            line = br.readLine();
        }
        br.close();
        return this;
    }

    public Boolean validateBorder(int x, int y) {
        return ((x >= 0 && x < sizeX) && (y >= 0 && y < sizeY));
    }

    public Boolean validateCollision(int x, int y) {
        return validateBorder(x, y) && world.get(x).get(y) == null;
    }

    private Boolean validatePlant(Organism organism) {
        return organism instanceof Plant;
    }

    private Boolean validateHuman(Organism organism) {
        return organism instanceof Human;
    }

}
