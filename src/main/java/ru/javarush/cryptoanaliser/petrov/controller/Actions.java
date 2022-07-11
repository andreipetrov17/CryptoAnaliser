package ru.javarush.cryptoanaliser.petrov.controller;

import ru.javarush.cryptoanaliser.petrov.commands.Action;
import ru.javarush.cryptoanaliser.petrov.commands.Decoder;
import ru.javarush.cryptoanaliser.petrov.commands.Encoder;

import java.util.Locale;

public enum Actions {
    ENCODE(new Encoder()),
    DECODE(new Decoder());
    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String command) {
        return Actions.valueOf(command.toUpperCase()).action;
    }
}