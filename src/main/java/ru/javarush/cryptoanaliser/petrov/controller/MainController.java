package ru.javarush.cryptoanaliser.petrov.controller;

import ru.javarush.cryptoanaliser.petrov.commands.Action;
import ru.javarush.cryptoanaliser.petrov.entity.Result;

public class MainController {
    public Result execute(String command, String[] parameters){
        Action action = Actions.find(command);
        Result result = action.execute(parameters);
        return result;
    }
}
