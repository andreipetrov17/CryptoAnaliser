package ru.javarush.cryptoanaliser.petrov.bruteforce;
import javax.swing.*;
import java.awt.*;

    public class BruteFrame extends JFrame {
        private JPanel centerPanel;
        private JPanel northPanel;
        private JPanel eastPanel;
        private JPanel southPanel;
        private JPanel westPanel;
        private static BruteFrame instance;
        private BruteFrame() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setMinimumSize(new Dimension(600, 300));
            setResizable(true);
            setLayout(new BorderLayout());
            setVisible(true);
        }
        public static BruteFrame getInstance() {
            if(instance == null) instance = new BruteFrame();
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


