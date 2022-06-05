package com.pg.project2.view.component;

import com.pg.project2.model.engine.common.OrganismRepr;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JComboBoxAnimalRenderer extends DefaultListCellRenderer {
    private Map<OrganismRepr, ImageIcon> iconMap = new HashMap<>();

    public JComboBoxAnimalRenderer() {
        iconMap.put(OrganismRepr.ANTELOPE, getImageIcon("antelope.png"));
        iconMap.put(OrganismRepr.BELLADONNA, getImageIcon("belladonna.png"));
        iconMap.put(OrganismRepr.SOSNOWSKYS_HOGWEED, getImageIcon("borscht.png"));
        iconMap.put(OrganismRepr.SOW_THISTLE, getImageIcon("flower.png"));
        iconMap.put(OrganismRepr.GRASS, getImageIcon("grass.png"));
        iconMap.put(OrganismRepr.GUARANA, getImageIcon("guarana.png"));
        iconMap.put(OrganismRepr.HUMAN, getImageIcon("man.png"));
        iconMap.put(OrganismRepr.SHEEP, getImageIcon("sheep.png"));
        iconMap.put(OrganismRepr.TURTLE, getImageIcon("turtle.png"));
        iconMap.put(OrganismRepr.FOX, getImageIcon("fox.png"));
        iconMap.put(OrganismRepr.WOLF, getImageIcon("wolf.png"));
        iconMap.put(OrganismRepr.EMPTY, null);
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        OrganismRepr organismRepr = (OrganismRepr) value;
        this.setIcon(iconMap.get(organismRepr));
        this.setText("");
        return this;
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    private ImageIcon getImageIcon(String name) {
        return new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(name)))
                .getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
    }
}
