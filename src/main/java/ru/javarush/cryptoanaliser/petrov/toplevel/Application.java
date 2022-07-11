package ru.javarush.cryptoanaliser.petrov.toplevel;

import ru.javarush.cryptoanaliser.petrov.controller.MainController;

public class Application {
    private final MainController mainController;

    public Application(MainController mainController) {
        this.mainController = mainController;
    }

    public MainController getMainController() {
        return mainController;
    }
}
