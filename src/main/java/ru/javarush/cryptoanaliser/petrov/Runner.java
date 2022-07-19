package ru.javarush.cryptoanaliser.petrov;


import ru.javarush.cryptoanaliser.petrov.brute.BruteFrame;
import ru.javarush.cryptoanaliser.petrov.ceasar.CeasarFrame;
import ru.javarush.cryptoanaliser.petrov.function.ModeChooser;

import javax.swing.*;

public class Runner {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(
                () -> new ModeChooser()
        );}
}

