package ru.javarush.cryptoanaliser.petrov.function;

import ru.javarush.cryptoanaliser.petrov.brute.BruteFrame;
import ru.javarush.cryptoanaliser.petrov.ceasar.CeasarFrame;

import javax.swing.*;

public class ModeChooser {
    public ModeChooser(){
        String[] str = new String[]{"Шифрование Цезаря", "Подбор ключа", "ReadMe"};
        String mode = (String) JOptionPane.showInputDialog(null,
                "","Выбор режима", JOptionPane.PLAIN_MESSAGE,
                new ImageIcon(),  str, str[2]);
        if(mode==null){
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Режим выбран" , "", JOptionPane.PLAIN_MESSAGE);
        switch (mode){
            case "Шифрование Цезаря" -> CeasarFrame.getInstance();
            case "Подбор ключа" -> BruteFrame.getInstance();
            case "ReadMe" -> new InfoFrame();
        }
    }
}
