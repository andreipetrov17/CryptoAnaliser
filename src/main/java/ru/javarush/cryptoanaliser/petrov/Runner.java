package ru.javarush.cryptoanaliser.petrov;

import ru.javarush.cryptoanaliser.petrov.app.Application;
import ru.javarush.cryptoanaliser.petrov.controller.MainController;

public class Runner {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        Application application = new Application(mainController);
    }
}
