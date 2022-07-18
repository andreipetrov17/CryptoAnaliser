package ru.javarush.cryptoanaliser.petrov.ceasars;

import javax.swing.*;
import java.awt.*;


public class CeasarsFrame extends JFrame {
    private JPanel centerPanel;
    private JPanel northPanel;
    private JPanel eastPanel;
    private JPanel southPanel;
    private JPanel westPanel;
    private static CeasarsFrame instance;
    private CeasarsFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(600, 300));
        setResizable(true);
        setLayout(new BorderLayout());
        setVisible(true);
    }
    public static CeasarsFrame getInstance() {
        if(instance == null) instance = new CeasarsFrame();
        return instance;
    }
    public JPanel getCenterPanel() {
        return centerPanel;
    }

    public JPanel getNorthPanel() {
        return northPanel;
    }

    public JPanel getEastPanel() {
        return eastPanel;
    }

    public JPanel getSouthPanel() {
        return southPanel;
    }

    public JPanel getWestPanel() {
        return westPanel;
    }
}
