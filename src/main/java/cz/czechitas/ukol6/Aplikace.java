package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
public class Aplikace extends JFrame {

    private JLabel husyLabel;
    private JLabel kraliciLabel;
    private JLabel hlavyLabel;
    private JLabel nohyLabel;

    private JTextField husyField;
    private JTextField kraliciField;
    private JTextField hlavyField;
    private JTextField nohyField;
    private JSpinner kraliciSpinner;

    private JSpinner husySpinner;

    private JButton vypocitatButton;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("FarmářkaMonika 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(300, 250));

        SpinnerNumberModel husyModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
        husySpinner = new JSpinner(husyModel);
        //husyField.setHorizontalAlignment(JTextField.TRAILING);
        husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        husyLabel.setLabelFor(husySpinner);
        add(husyLabel);
        add(husySpinner, "span");
        husySpinner.setPreferredSize(new Dimension(175, 25));
        husySpinner.setMinimumSize(new Dimension(175, 25));
        husySpinner.setMaximumSize(new Dimension(175, 25));

                SpinnerNumberModel kraliciModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
        kraliciSpinner = new JSpinner(kraliciModel);

        //kraliciField.setHorizontalAlignment(JTextField.TRAILING);
        kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciLabel.setLabelFor(kraliciSpinner);
        add(kraliciLabel);
        add(kraliciSpinner, "span");
        kraliciSpinner.setPreferredSize(new Dimension(175, 25));
        kraliciSpinner.setMinimumSize(new Dimension(175, 25));
        kraliciSpinner.setMaximumSize(new Dimension(175, 25));
        add(createButtonBar(), "span");

        pack();

        getRootPane().setDefaultButton(vypocitatButton);

        vypocitatButton.addActionListener(this::handleVypocitat);

        hlavyField = new JTextField();
        hlavyField.setHorizontalAlignment(JTextField.TRAILING);
        hlavyField.setEditable(false);
        hlavyLabel = new JLabel("Počet hlav");
        hlavyLabel.setLabelFor(hlavyField);
        add(hlavyLabel);
        add(hlavyField, "span");
        hlavyField.setPreferredSize(new Dimension(175, 25));
        hlavyField.setMinimumSize(new Dimension(175, 25));
        hlavyField.setMaximumSize(new Dimension(175, 25));

        nohyField = new JTextField();
        nohyField.setHorizontalAlignment(JTextField.TRAILING);
        nohyField.setEditable(false);
        nohyLabel = new JLabel("Počet nohou");
        nohyLabel.setLabelFor(nohyField);
        add(nohyLabel);
        add(nohyField, "span");
        nohyField.setPreferredSize(new Dimension(175, 25));
        nohyField.setMinimumSize(new Dimension(175, 25));
        nohyField.setMaximumSize(new Dimension(175, 25));

    }

    private JPanel createButtonBar() {
        vypocitatButton = new JButton("Vypočítat");
        vypocitatButton.setMnemonic('V');


        JPanel buttonBar = new JPanel(new MigLayout(null, "[right, grow]"));

        buttonBar.add(vypocitatButton);
        return buttonBar;
    }

    private void handleVypocitat(ActionEvent actionEvent) {

        int pocetKraliku = (int) kraliciSpinner.getValue();
        int pocetHus = (int) husySpinner.getValue();

        int pocetNoh = pocetKraliku * 4 + pocetHus * 2;
        nohyField.setText(String.valueOf(pocetNoh));

        int pocetHlav = pocetKraliku + pocetHus;
        hlavyField.setText(String.valueOf(pocetHlav));
    }
}