package com.pg.project2.view;

import com.pg.project2.model.engine.common.OrganismRepr;
import com.pg.project2.model.pojo.Organism;
import com.pg.project2.view.component.JComboBoxAnimal;
import lombok.Getter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class MainForm {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel gamePanel;
    private JButton btnNextRound;
    private JComboBox<OrganismRepr> comboBoxAnimal00;
    private JComboBox<OrganismRepr> comboBoxAnimal01;
    private JComboBox<OrganismRepr> comboBoxAnimal02;
    private JComboBox<OrganismRepr> comboBoxAnimal03;
    private JComboBox<OrganismRepr> comboBoxAnimal10;
    private JComboBox<OrganismRepr> comboBoxAnimal11;
    private JComboBox<OrganismRepr> comboBoxAnimal12;
    private JComboBox<OrganismRepr> comboBoxAnimal13;
    private JComboBox<OrganismRepr> comboBoxAnimal04;
    private JComboBox<OrganismRepr> comboBoxAnimal05;
    private JComboBox<OrganismRepr> comboBoxAnimal06;
    private JComboBox<OrganismRepr> comboBoxAnimal14;
    private JComboBox<OrganismRepr> comboBoxAnimal15;
    private JComboBox<OrganismRepr> comboBoxAnimal16;
    private JComboBox<OrganismRepr> comboBoxAnimal07;
    private JComboBox<OrganismRepr> comboBoxAnimal17;
    private JComboBox<OrganismRepr> comboBoxAnimal08;
    private JComboBox<OrganismRepr> comboBoxAnimal18;
    private JComboBox<OrganismRepr> comboBoxAnimal09;
    private JComboBox<OrganismRepr> comboBoxAnimal19;
    private JComboBox<OrganismRepr> comboBoxAnimal20;
    private JComboBox<OrganismRepr> comboBoxAnimal30;
    private JComboBox<OrganismRepr> comboBoxAnimal40;
    private JComboBox<OrganismRepr> comboBoxAnimal50;
    private JComboBox<OrganismRepr> comboBoxAnimal60;
    private JComboBox<OrganismRepr> comboBoxAnimal70;
    private JComboBox<OrganismRepr> comboBoxAnimal80;
    private JComboBox<OrganismRepr> comboBoxAnimal91;
    private JComboBox<OrganismRepr> comboBoxAnimal21;
    private JComboBox<OrganismRepr> comboBoxAnimal22;
    private JComboBox<OrganismRepr> comboBoxAnimal23;
    private JComboBox<OrganismRepr> comboBoxAnimal24;
    private JComboBox<OrganismRepr> comboBoxAnimal25;
    private JComboBox<OrganismRepr> comboBoxAnimal26;
    private JComboBox<OrganismRepr> comboBoxAnimal27;
    private JComboBox<OrganismRepr> comboBoxAnimal28;
    private JComboBox<OrganismRepr> comboBoxAnimal29;
    private JComboBox<OrganismRepr> comboBoxAnimal31;
    private JComboBox<OrganismRepr> comboBoxAnimal32;
    private JComboBox<OrganismRepr> comboBoxAnimal33;
    private JComboBox<OrganismRepr> comboBoxAnimal34;
    private JComboBox<OrganismRepr> comboBoxAnimal35;
    private JComboBox<OrganismRepr> comboBoxAnimal36;
    private JComboBox<OrganismRepr> comboBoxAnimal37;
    private JComboBox<OrganismRepr> comboBoxAnimal38;
    private JComboBox<OrganismRepr> comboBoxAnimal39;
    private JComboBox<OrganismRepr> comboBoxAnimal49;
    private JComboBox<OrganismRepr> comboBoxAnimal59;
    private JComboBox<OrganismRepr> comboBoxAnimal48;
    private JComboBox<OrganismRepr> comboBoxAnimal58;
    private JComboBox<OrganismRepr> comboBoxAnimal69;
    private JComboBox<OrganismRepr> comboBoxAnimal68;
    private JComboBox<OrganismRepr> comboBoxAnimal79;
    private JComboBox<OrganismRepr> comboBoxAnimal89;
    private JComboBox<OrganismRepr> comboBoxAnimal99;
    private JComboBox<OrganismRepr> comboBoxAnimal90;
    private JComboBox<OrganismRepr> comboBoxAnimal41;
    private JComboBox<OrganismRepr> comboBoxAnimal42;
    private JComboBox<OrganismRepr> comboBoxAnimal43;
    private JComboBox<OrganismRepr> comboBoxAnimal44;
    private JComboBox<OrganismRepr> comboBoxAnimal45;
    private JComboBox<OrganismRepr> comboBoxAnimal46;
    private JComboBox<OrganismRepr> comboBoxAnimal47;
    private JComboBox<OrganismRepr> comboBoxAnimal57;
    private JComboBox<OrganismRepr> comboBoxAnimal67;
    private JComboBox<OrganismRepr> comboBoxAnimal78;
    private JComboBox<OrganismRepr> comboBoxAnimal77;
    private JComboBox<OrganismRepr> comboBoxAnimal87;
    private JComboBox<OrganismRepr> comboBoxAnimal88;
    private JComboBox<OrganismRepr> comboBoxAnimal98;
    private JComboBox<OrganismRepr> comboBoxAnimal97;
    private JComboBox<OrganismRepr> comboBoxAnimal76;
    private JComboBox<OrganismRepr> comboBoxAnimal65;
    private JComboBox<OrganismRepr> comboBoxAnimal66;
    private JComboBox<OrganismRepr> comboBoxAnimal56;
    private JComboBox<OrganismRepr> comboBoxAnimal55;
    private JComboBox<OrganismRepr> comboBoxAnimal54;
    private JComboBox<OrganismRepr> comboBoxAnimal53;
    private JComboBox<OrganismRepr> comboBoxAnimal52;
    private JComboBox<OrganismRepr> comboBoxAnimal51;
    private JComboBox<OrganismRepr> comboBoxAnimal61;
    private JComboBox<OrganismRepr> comboBoxAnimal62;
    private JComboBox<OrganismRepr> comboBoxAnimal63;
    private JComboBox<OrganismRepr> comboBoxAnimal64;
    private JComboBox<OrganismRepr> comboBoxAnimal74;
    private JComboBox<OrganismRepr> comboBoxAnimal75;
    private JComboBox<OrganismRepr> comboBoxAnimal86;
    private JComboBox<OrganismRepr> comboBoxAnimal96;
    private JComboBox<OrganismRepr> comboBoxAnimal85;
    private JComboBox<OrganismRepr> comboBoxAnimal95;
    private JComboBox<OrganismRepr> comboBoxAnimal84;
    private JComboBox<OrganismRepr> comboBoxAnimal94;
    private JComboBox<OrganismRepr> comboBoxAnimal73;
    private JComboBox<OrganismRepr> comboBoxAnimal83;
    private JComboBox<OrganismRepr> comboBoxAnimal93;
    private JComboBox<OrganismRepr> comboBoxAnimal72;
    private JComboBox<OrganismRepr> comboBoxAnimal82;
    private JComboBox<OrganismRepr> comboBoxAnimal92;
    private JComboBox<OrganismRepr> comboBoxAnimal71;
    private JComboBox<OrganismRepr> comboBoxAnimal81;
    private JPanel boardPanel;
    private JButton btnUp;
    private JButton btnLeft;
    private JButton btnRight;
    private JButton btnDown;
    private JButton btnSpecialAbility;
    private JButton btnSaveToFile;
    private JButton btnLoadFromFile;
    private List<JComboBox<OrganismRepr>> jComboBoxAnimalList;

    public MainForm() {
        frame = new JFrame("Virtual World Simulator");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }

    public void createUIComponents() {
        jComboBoxAnimalList = new ArrayList<>();
        comboBoxAnimal00 = new JComboBoxAnimal<>(0, 0, null);
        comboBoxAnimal01 = new JComboBoxAnimal<>(0, 1, null);
        comboBoxAnimal02 = new JComboBoxAnimal<>(0, 2, null);
        comboBoxAnimal03 = new JComboBoxAnimal<>(0, 3, null);
        comboBoxAnimal04 = new JComboBoxAnimal<>(0, 4, null);
        comboBoxAnimal05 = new JComboBoxAnimal<>(0, 5, null);
        comboBoxAnimal06 = new JComboBoxAnimal<>(0, 6, null);
        comboBoxAnimal07 = new JComboBoxAnimal<>(0, 7, null);
        comboBoxAnimal08 = new JComboBoxAnimal<>(0, 8, null);
        comboBoxAnimal09 = new JComboBoxAnimal<>(0, 9, null);

        comboBoxAnimal10 = new JComboBoxAnimal<>(1, 0, null);
        comboBoxAnimal11 = new JComboBoxAnimal<>(1, 1, null);
        comboBoxAnimal12 = new JComboBoxAnimal<>(1, 2, null);
        comboBoxAnimal13 = new JComboBoxAnimal<>(1, 3, null);
        comboBoxAnimal14 = new JComboBoxAnimal<>(1, 4, null);
        comboBoxAnimal15 = new JComboBoxAnimal<>(1, 5, null);
        comboBoxAnimal16 = new JComboBoxAnimal<>(1, 6, null);
        comboBoxAnimal17 = new JComboBoxAnimal<>(1, 7, null);
        comboBoxAnimal18 = new JComboBoxAnimal<>(1, 8, null);
        comboBoxAnimal19 = new JComboBoxAnimal<>(1, 9, null);

        comboBoxAnimal20 = new JComboBoxAnimal<>(2, 0, null);
        comboBoxAnimal21 = new JComboBoxAnimal<>(2, 1, null);
        comboBoxAnimal22 = new JComboBoxAnimal<>(2, 2, null);
        comboBoxAnimal23 = new JComboBoxAnimal<>(2, 3, null);
        comboBoxAnimal24 = new JComboBoxAnimal<>(2, 4, null);
        comboBoxAnimal25 = new JComboBoxAnimal<>(2, 5, null);
        comboBoxAnimal26 = new JComboBoxAnimal<>(2, 6, null);
        comboBoxAnimal27 = new JComboBoxAnimal<>(2, 7, null);
        comboBoxAnimal28 = new JComboBoxAnimal<>(2, 8, null);
        comboBoxAnimal29 = new JComboBoxAnimal<>(2, 9, null);

        comboBoxAnimal30 = new JComboBoxAnimal<>(3, 0, null);
        comboBoxAnimal31 = new JComboBoxAnimal<>(3, 1, null);
        comboBoxAnimal32 = new JComboBoxAnimal<>(3, 2, null);
        comboBoxAnimal33 = new JComboBoxAnimal<>(3, 3, null);
        comboBoxAnimal34 = new JComboBoxAnimal<>(3, 4, null);
        comboBoxAnimal35 = new JComboBoxAnimal<>(3, 5, null);
        comboBoxAnimal36 = new JComboBoxAnimal<>(3, 6, null);
        comboBoxAnimal37 = new JComboBoxAnimal<>(3, 7, null);
        comboBoxAnimal38 = new JComboBoxAnimal<>(3, 8, null);
        comboBoxAnimal39 = new JComboBoxAnimal<>(3, 9, null);

        comboBoxAnimal40 = new JComboBoxAnimal<>(4, 0, null);
        comboBoxAnimal41 = new JComboBoxAnimal<>(4, 1, null);
        comboBoxAnimal42 = new JComboBoxAnimal<>(4, 2, null);
        comboBoxAnimal43 = new JComboBoxAnimal<>(4, 3, null);
        comboBoxAnimal44 = new JComboBoxAnimal<>(4, 4, null);
        comboBoxAnimal45 = new JComboBoxAnimal<>(4, 5, null);
        comboBoxAnimal46 = new JComboBoxAnimal<>(4, 6, null);
        comboBoxAnimal47 = new JComboBoxAnimal<>(4, 7, null);
        comboBoxAnimal48 = new JComboBoxAnimal<>(4, 8, null);
        comboBoxAnimal49 = new JComboBoxAnimal<>(4, 9, null);

        comboBoxAnimal50 = new JComboBoxAnimal<>(5, 0, null);
        comboBoxAnimal51 = new JComboBoxAnimal<>(5, 1, null);
        comboBoxAnimal52 = new JComboBoxAnimal<>(5, 2, null);
        comboBoxAnimal53 = new JComboBoxAnimal<>(5, 3, null);
        comboBoxAnimal54 = new JComboBoxAnimal<>(5, 4, null);
        comboBoxAnimal55 = new JComboBoxAnimal<>(5, 5, null);
        comboBoxAnimal56 = new JComboBoxAnimal<>(5, 6, null);
        comboBoxAnimal57 = new JComboBoxAnimal<>(5, 7, null);
        comboBoxAnimal58 = new JComboBoxAnimal<>(5, 8, null);
        comboBoxAnimal59 = new JComboBoxAnimal<>(5, 9, null);

        comboBoxAnimal60 = new JComboBoxAnimal<>(6, 0, null);
        comboBoxAnimal61 = new JComboBoxAnimal<>(6, 1, null);
        comboBoxAnimal62 = new JComboBoxAnimal<>(6, 2, null);
        comboBoxAnimal63 = new JComboBoxAnimal<>(6, 3, null);
        comboBoxAnimal64 = new JComboBoxAnimal<>(6, 4, null);
        comboBoxAnimal65 = new JComboBoxAnimal<>(6, 5, null);
        comboBoxAnimal66 = new JComboBoxAnimal<>(6, 6, null);
        comboBoxAnimal67 = new JComboBoxAnimal<>(6, 7, null);
        comboBoxAnimal68 = new JComboBoxAnimal<>(6, 8, null);
        comboBoxAnimal69 = new JComboBoxAnimal<>(6, 9, null);

        comboBoxAnimal70 = new JComboBoxAnimal<>(7, 0, null);
        comboBoxAnimal71 = new JComboBoxAnimal<>(7, 1, null);
        comboBoxAnimal72 = new JComboBoxAnimal<>(7, 2, null);
        comboBoxAnimal73 = new JComboBoxAnimal<>(7, 3, null);
        comboBoxAnimal74 = new JComboBoxAnimal<>(7, 4, null);
        comboBoxAnimal75 = new JComboBoxAnimal<>(7, 5, null);
        comboBoxAnimal76 = new JComboBoxAnimal<>(7, 6, null);
        comboBoxAnimal77 = new JComboBoxAnimal<>(7, 7, null);
        comboBoxAnimal78 = new JComboBoxAnimal<>(7, 8, null);
        comboBoxAnimal79 = new JComboBoxAnimal<>(7, 9, null);

        comboBoxAnimal80 = new JComboBoxAnimal<>(8, 0, null);
        comboBoxAnimal81 = new JComboBoxAnimal<>(8, 1, null);
        comboBoxAnimal82 = new JComboBoxAnimal<>(8, 2, null);
        comboBoxAnimal83 = new JComboBoxAnimal<>(8, 3, null);
        comboBoxAnimal84 = new JComboBoxAnimal<>(8, 4, null);
        comboBoxAnimal85 = new JComboBoxAnimal<>(8, 5, null);
        comboBoxAnimal86 = new JComboBoxAnimal<>(8, 6, null);
        comboBoxAnimal87 = new JComboBoxAnimal<>(8, 7, null);
        comboBoxAnimal88 = new JComboBoxAnimal<>(8, 8, null);
        comboBoxAnimal89 = new JComboBoxAnimal<>(8, 9, null);

        comboBoxAnimal90 = new JComboBoxAnimal<>(9, 0, null);
        comboBoxAnimal91 = new JComboBoxAnimal<>(9, 1, null);
        comboBoxAnimal92 = new JComboBoxAnimal<>(9, 2, null);
        comboBoxAnimal93 = new JComboBoxAnimal<>(9, 3, null);
        comboBoxAnimal94 = new JComboBoxAnimal<>(9, 4, null);
        comboBoxAnimal95 = new JComboBoxAnimal<>(9, 5, null);
        comboBoxAnimal96 = new JComboBoxAnimal<>(9, 6, null);
        comboBoxAnimal97 = new JComboBoxAnimal<>(9, 7, null);
        comboBoxAnimal98 = new JComboBoxAnimal<>(9, 8, null);
        comboBoxAnimal99 = new JComboBoxAnimal<>(9, 9, null);

        jComboBoxAnimalList.add(comboBoxAnimal00);
        jComboBoxAnimalList.add(comboBoxAnimal01);
        jComboBoxAnimalList.add(comboBoxAnimal02);
        jComboBoxAnimalList.add(comboBoxAnimal03);
        jComboBoxAnimalList.add(comboBoxAnimal04);
        jComboBoxAnimalList.add(comboBoxAnimal05);
        jComboBoxAnimalList.add(comboBoxAnimal06);
        jComboBoxAnimalList.add(comboBoxAnimal07);
        jComboBoxAnimalList.add(comboBoxAnimal08);
        jComboBoxAnimalList.add(comboBoxAnimal09);

        jComboBoxAnimalList.add(comboBoxAnimal10);
        jComboBoxAnimalList.add(comboBoxAnimal11);
        jComboBoxAnimalList.add(comboBoxAnimal12);
        jComboBoxAnimalList.add(comboBoxAnimal13);
        jComboBoxAnimalList.add(comboBoxAnimal14);
        jComboBoxAnimalList.add(comboBoxAnimal15);
        jComboBoxAnimalList.add(comboBoxAnimal16);
        jComboBoxAnimalList.add(comboBoxAnimal17);
        jComboBoxAnimalList.add(comboBoxAnimal18);
        jComboBoxAnimalList.add(comboBoxAnimal19);

        jComboBoxAnimalList.add(comboBoxAnimal20);
        jComboBoxAnimalList.add(comboBoxAnimal21);
        jComboBoxAnimalList.add(comboBoxAnimal22);
        jComboBoxAnimalList.add(comboBoxAnimal23);
        jComboBoxAnimalList.add(comboBoxAnimal24);
        jComboBoxAnimalList.add(comboBoxAnimal25);
        jComboBoxAnimalList.add(comboBoxAnimal26);
        jComboBoxAnimalList.add(comboBoxAnimal27);
        jComboBoxAnimalList.add(comboBoxAnimal28);
        jComboBoxAnimalList.add(comboBoxAnimal29);

        jComboBoxAnimalList.add(comboBoxAnimal30);
        jComboBoxAnimalList.add(comboBoxAnimal31);
        jComboBoxAnimalList.add(comboBoxAnimal32);
        jComboBoxAnimalList.add(comboBoxAnimal33);
        jComboBoxAnimalList.add(comboBoxAnimal34);
        jComboBoxAnimalList.add(comboBoxAnimal35);
        jComboBoxAnimalList.add(comboBoxAnimal36);
        jComboBoxAnimalList.add(comboBoxAnimal37);
        jComboBoxAnimalList.add(comboBoxAnimal38);
        jComboBoxAnimalList.add(comboBoxAnimal39);

        jComboBoxAnimalList.add(comboBoxAnimal40);
        jComboBoxAnimalList.add(comboBoxAnimal41);
        jComboBoxAnimalList.add(comboBoxAnimal42);
        jComboBoxAnimalList.add(comboBoxAnimal43);
        jComboBoxAnimalList.add(comboBoxAnimal44);
        jComboBoxAnimalList.add(comboBoxAnimal45);
        jComboBoxAnimalList.add(comboBoxAnimal46);
        jComboBoxAnimalList.add(comboBoxAnimal47);
        jComboBoxAnimalList.add(comboBoxAnimal48);
        jComboBoxAnimalList.add(comboBoxAnimal49);

        jComboBoxAnimalList.add(comboBoxAnimal50);
        jComboBoxAnimalList.add(comboBoxAnimal51);
        jComboBoxAnimalList.add(comboBoxAnimal52);
        jComboBoxAnimalList.add(comboBoxAnimal53);
        jComboBoxAnimalList.add(comboBoxAnimal54);
        jComboBoxAnimalList.add(comboBoxAnimal55);
        jComboBoxAnimalList.add(comboBoxAnimal56);
        jComboBoxAnimalList.add(comboBoxAnimal57);
        jComboBoxAnimalList.add(comboBoxAnimal58);
        jComboBoxAnimalList.add(comboBoxAnimal59);

        jComboBoxAnimalList.add(comboBoxAnimal60);
        jComboBoxAnimalList.add(comboBoxAnimal61);
        jComboBoxAnimalList.add(comboBoxAnimal62);
        jComboBoxAnimalList.add(comboBoxAnimal63);
        jComboBoxAnimalList.add(comboBoxAnimal64);
        jComboBoxAnimalList.add(comboBoxAnimal65);
        jComboBoxAnimalList.add(comboBoxAnimal66);
        jComboBoxAnimalList.add(comboBoxAnimal67);
        jComboBoxAnimalList.add(comboBoxAnimal68);
        jComboBoxAnimalList.add(comboBoxAnimal69);

        jComboBoxAnimalList.add(comboBoxAnimal70);
        jComboBoxAnimalList.add(comboBoxAnimal71);
        jComboBoxAnimalList.add(comboBoxAnimal72);
        jComboBoxAnimalList.add(comboBoxAnimal73);
        jComboBoxAnimalList.add(comboBoxAnimal74);
        jComboBoxAnimalList.add(comboBoxAnimal75);
        jComboBoxAnimalList.add(comboBoxAnimal76);
        jComboBoxAnimalList.add(comboBoxAnimal77);
        jComboBoxAnimalList.add(comboBoxAnimal78);
        jComboBoxAnimalList.add(comboBoxAnimal79);

        jComboBoxAnimalList.add(comboBoxAnimal80);
        jComboBoxAnimalList.add(comboBoxAnimal81);
        jComboBoxAnimalList.add(comboBoxAnimal82);
        jComboBoxAnimalList.add(comboBoxAnimal83);
        jComboBoxAnimalList.add(comboBoxAnimal84);
        jComboBoxAnimalList.add(comboBoxAnimal85);
        jComboBoxAnimalList.add(comboBoxAnimal86);
        jComboBoxAnimalList.add(comboBoxAnimal87);
        jComboBoxAnimalList.add(comboBoxAnimal88);
        jComboBoxAnimalList.add(comboBoxAnimal89);

        jComboBoxAnimalList.add(comboBoxAnimal90);
        jComboBoxAnimalList.add(comboBoxAnimal91);
        jComboBoxAnimalList.add(comboBoxAnimal92);
        jComboBoxAnimalList.add(comboBoxAnimal93);
        jComboBoxAnimalList.add(comboBoxAnimal94);
        jComboBoxAnimalList.add(comboBoxAnimal95);
        jComboBoxAnimalList.add(comboBoxAnimal96);
        jComboBoxAnimalList.add(comboBoxAnimal97);
        jComboBoxAnimalList.add(comboBoxAnimal98);
        jComboBoxAnimalList.add(comboBoxAnimal99);

    }

    public void setOrganism(int x, int y, Organism organism) {
        jComboBoxAnimalList = jComboBoxAnimalList.stream().peek(e -> {
            if (((JComboBoxAnimal<?>) e).getXCord() == x && ((JComboBoxAnimal<?>) e).getYCord() == y)
                ((JComboBoxAnimal<?>) e).setOrganism(organism);
        }).collect(Collectors.toList());
    }
}
