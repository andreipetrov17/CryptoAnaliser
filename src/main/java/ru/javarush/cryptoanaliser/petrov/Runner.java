package ru.javarush.cryptoanaliser.petrov;


import ru.javarush.cryptoanaliser.petrov.ceasar.CeasarFrame;

public class Runner {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(
                () -> CeasarFrame.getInstance());
    }
}

