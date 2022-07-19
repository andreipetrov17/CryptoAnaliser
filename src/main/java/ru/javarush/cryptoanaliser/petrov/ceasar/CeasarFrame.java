package ru.javarush.cryptoanaliser.petrov.ceasar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CeasarFrame extends JFrame {
    private CenterPanel centerPanel ;
    private JPanel northPanel;
    private JPanel eastPanel;
    private JPanel southPanel;
    private WestPanel westPanel;
    public static ActionListener actionListener = new CeasarListener();
    private static CeasarFrame instance;
    private CeasarFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(600, 300));
        setResizable(true);
        setLayout(new BorderLayout());
        centerPanel = new CenterPanel();
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        westPanel = new WestPanel();
        getContentPane().add(westPanel, BorderLayout.WEST);
        setVisible(true);
    }
    public static CeasarFrame getInstance() {
        if(instance == null) instance = new CeasarFrame();
        return instance;
    }

    public CenterPanel getCenterPanel(){
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

    public WestPanel getWestPanel() {
        return westPanel;
    }

    public ActionListener getActionListener() {
        return actionListener;
    }
}
