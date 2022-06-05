package com.pg.project2.controller;

import com.pg.project2.model.engine.World;
import com.pg.project2.model.engine.common.MoveRepr;
import com.pg.project2.model.engine.common.OrganismRepr;
import com.pg.project2.model.engine.common.Utils;
import com.pg.project2.model.pojo.Organism;
import com.pg.project2.view.MainForm;
import com.pg.project2.view.component.JComboBoxAnimal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class MainController {
    // front dependency
    private MainForm mainForm;
    // back dependency
    private World world;
    private int humanDirection = -1;

    public MainController() {
        mainForm = new MainForm();
        world = new World();
    }

    public void control() {
        init();
        addActionListenersForComboBoxes();
        mainForm.getBtnLeft().addActionListener(e -> onClickBtnHumanMove(e));
        mainForm.getBtnDown().addActionListener(e -> onClickBtnHumanMove(e));
        mainForm.getBtnRight().addActionListener(e -> onClickBtnHumanMove(e));
        mainForm.getBtnUp().addActionListener(e -> onClickBtnHumanMove(e));
        mainForm.getBtnSpecialAbility().addActionListener(e -> onClickBtnSpecialAbility());
        mainForm.getBtnSaveToFile().addActionListener(e -> onClickBtnSaveToFile());
        mainForm.getBtnLoadFromFile().addActionListener(e -> onClickBtnLoadFromFile());
        mainForm.getBtnNextRound().addActionListener(e -> onClickBtnNextRound());
    }

    private void addActionListenersForComboBoxes() {
        mainForm.getJComboBoxAnimalList().forEach(c -> c.addActionListener(this::onChangeComboBox));
    }

    private void init() {
        mainForm.getFrame().setVisible(true);
        performWorldInit();
    }

    private void reloadComboBoxes() {
        for (int x = 0; x < 10; x++)
            for (int y = 0; y < 10; y++)
                mainForm.setOrganism(x, y, world.getWorld().get(x).get(y));
    }

    private void performWorldInit() {
        world.initializePopulation();
        reloadComboBoxes();
    }

    private void performPlace(int x, int y, OrganismRepr selectedOrganismRepr, JComboBoxAnimal jComboBoxAnimal) {
        Organism organism = selectedOrganismRepr.getOrg();
        if (!Objects.isNull(organism)) {
            organism.setWorld(world).setX(x).setY(y).setSymbol(selectedOrganismRepr);
            organism.setAge(0);
        }
        jComboBoxAnimal.setOrganism(organism);
        world.place(x, y, organism);
    }

    private void onChangeComboBox(ActionEvent e) {
        JComboBoxAnimal<?> jComboBoxAnimal = ((JComboBoxAnimal<?>) e.getSource());
        OrganismRepr selectedOrganismRepr = ((OrganismRepr) Objects.requireNonNull(jComboBoxAnimal.getSelectedItem()));
        if (Objects.isNull(world.getWorld().get(jComboBoxAnimal.getXCord()).get(jComboBoxAnimal.getYCord())))
            performPlace(jComboBoxAnimal.getXCord(), jComboBoxAnimal.getYCord(), selectedOrganismRepr, jComboBoxAnimal);
    }

    private void onClickBtnHumanMove(ActionEvent e) {
        humanDirection = MoveRepr.findByStrRepr(((JButton) e.getSource()).getText()).getIntRepr();
    }

    private void onClickBtnSpecialAbility() {
        world.setRoundTurn(1);
        mainForm.getBtnSpecialAbility().setEnabled(false);
    }

    private void onClickBtnSaveToFile() {
        try {
            world.saveWorld(getFile(true));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void onClickBtnLoadFromFile() {
        try {
            world.readWorld(getFile(false));
            reloadComboBoxes();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void onClickBtnNextRound() {
        world.makeTurn(humanDirection);
        reloadComboBoxes();
        mainForm.getBtnSpecialAbility().setEnabled(world.getRoundTurn() == 0);
    }

    private File getFile(boolean saveMode) {
        return Utils.displayFileChooserAndGetFile(saveMode, mainForm.getMainPanel());
    }
}
