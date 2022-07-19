package ru.javarush.cryptoanaliser.petrov.function;

import javax.swing.*;
import java.awt.*;

public class InfoFrame extends JFrame {
    public InfoFrame(){
        super("информация");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTextArea jta = new JTextArea();
        jta.setEditable(false);
        jta.setLineWrap(true);
        jta.setText("Доброго времени суток, в слеке написанно сдавать только полностью готовый, " +
                "но в моем случае это значит никогда не доделанный, с другой стороны, было распоряжение сделать,\n" +
                " решил отправить с ошибками и ужасным кодом. Жена пилит, дети грызут, буржуины эксплуатируют. \n" +
                "Войдите в положение. Если код ревью только для меня надо, то смысла в этом нет, когда сформулируются" +
                " вопросы об архитектуре на факультативе попробую задать. Потихоньку начинаю текущий править. Спасибо.");
        add(jta);
        setSize(new Dimension(800, 500));
        setVisible(true);
    }
}
