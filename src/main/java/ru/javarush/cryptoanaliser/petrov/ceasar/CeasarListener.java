package ru.javarush.cryptoanaliser.petrov.ceasar;

import ru.javarush.cryptoanaliser.petrov.consts.Alphabet;
import ru.javarush.cryptoanaliser.petrov.function.CeasarsFunction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CeasarListener implements ActionListener {
    private int key;
    private StringBuilder stringBuilder = new StringBuilder();
    @Override
    public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "SHIFT_PLUS" -> shift(1);
                case "SHIFT_MINES" -> shift(-1);
                case "FORCE_SHIFT" -> {
                    int i = 0;
                    try {
                        i = Integer.parseInt(CeasarFrame.getInstance().getWestPanel().jTextField.getText());
                    }
                    catch (NumberFormatException ex){
                        CeasarFrame.getInstance().getWestPanel().jTextField.setText("");
                    }
                    shift(i);
                }
            }
        }
        private void shift(int i){
            stringBuilder = CeasarsFunction.shift(Alphabet.correctCharacters, i , stringBuilder.toString());
            key += i;
            CeasarFrame.getInstance().getWestPanel().jLabel.setText("Ключ: " +  key);
            System.out.println(key);
            CeasarFrame.getInstance().getContentPane().revalidate();
        }


}
