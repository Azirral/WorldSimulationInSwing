package com.pg.project2.view.component;

import com.pg.project2.model.engine.common.OrganismRepr;
import com.pg.project2.model.pojo.Organism;
import com.pg.project2.model.pojo.animal.Human;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class JComboBoxAnimal<T> extends JComboBox<T> {
    private Integer xCord;
    private Integer yCord;
    private Organism organism;

    public JComboBoxAnimal(Integer xCord, Integer yCord, Organism organism) {
        super();
        this.xCord = xCord;
        this.yCord = yCord;
        this.organism = organism;

        DefaultComboBoxModel<T> model = new DefaultComboBoxModel();
        List<T> list = new ArrayList<>();
        Arrays.stream(OrganismRepr.valuesForChoose()).forEach(e -> list.add((T) e));
        model.addAll(list);
        setModel(model);
        setRenderer(new JComboBoxAnimalRenderer());
    }

    public void setOrganism(Organism organism) {
        this.organism = organism;
        setSelectedItem(!Objects.isNull(organism) ? organism.getSymbol() : OrganismRepr.EMPTY);
        setEnabled(Objects.isNull(organism));
    }
}
