package ru.javarush.cryptoanaliser.petrov;


import ru.javarush.cryptoanaliser.petrov.brute.BruteFrame;
import ru.javarush.cryptoanaliser.petrov.ceasar.CeasarFrame;

public class Runner {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(
                () -> BruteFrame.getInstance());
    }
}

