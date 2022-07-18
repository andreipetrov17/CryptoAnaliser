package ru.javarush.cryptoanaliser.petrov;


import ru.javarush.cryptoanaliser.petrov.ceasars.CeasarsFrame;

public class Runner {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(
                () -> CeasarsFrame.getInstance());
    }
}

