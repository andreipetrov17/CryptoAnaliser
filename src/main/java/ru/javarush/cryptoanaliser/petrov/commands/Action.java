package ru.javarush.cryptoanaliser.petrov.commands;

import ru.javarush.cryptoanaliser.petrov.entity.Result;

public interface Action {
    Result execute(String[] parameters);


}
