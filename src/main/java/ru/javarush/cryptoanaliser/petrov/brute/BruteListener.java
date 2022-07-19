package ru.javarush.cryptoanaliser.petrov.brute;

import ru.javarush.cryptoanaliser.petrov.ceasar.CeasarFrame;
import ru.javarush.cryptoanaliser.petrov.consts.Alphabet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class BruteListener implements ActionListener {
    private int key;
    private StringBuilder stringBuilder = new StringBuilder();
    private File inputFile;
    private File outputFile;

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "OPEN" -> {
                CeasarFrame.getInstance().getCenterPanel().jTextAreaIn.selectAll();
                CeasarFrame.getInstance().getCenterPanel().jTextAreaIn.replaceSelection("");
                CeasarFrame.getInstance().getCenterPanel().jTextAreaOut.selectAll();
                CeasarFrame.getInstance().getCenterPanel().jTextAreaOut.replaceSelection("");
                key = 0;
                stringBuilder = null;
                outputFile = null;
                inputFile = null;
                String str = openFile();
                CeasarFrame.getInstance().getCenterPanel().jTextAreaIn.setText(str);
                CeasarFrame.getInstance().getCenterPanel().jTextAreaOut.setText(str);
                stringBuilder = new StringBuilder(str);
            }
            case "CLEAR" -> clearAll();
            case "SAVE" -> saveFile();
            case "NEW_OUT_DIR" -> changeOutDir();
            case "FIND" -> System.out.println(findKey(Alphabet.correctCharacters, "или", stringBuilder.toString()));
        }
    }

    private String openFile() {
        clearAll();
        StringBuilder stringBuilder = new StringBuilder();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jFileChooser.setCurrentDirectory(new File("./src/main/resources"));
        if (jFileChooser.showOpenDialog(CeasarFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser.getSelectedFile();
            inputFile = file;
            String str;
            try (BufferedReader br = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
                while ((str = br.readLine()) != null) {
                    stringBuilder.append(str);
                }
            } catch (IOException ex) {
                inputFile = null;
                ex.printStackTrace();
            }
            outputFile = inputFile;
        }
        return stringBuilder.toString();
    }

    private void saveFile() {
        String name = outputFile.getAbsolutePath();
        name = name.substring(0, name.length() - 4);
        try (FileWriter fw = new FileWriter(new File(name + "force" + key + ".txt"))) {

            fw.write(CeasarFrame.getInstance().getCenterPanel().jTextAreaOut.getText());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void clearAll() {
        BruteFrame.getInstance().getCenterPanel().jTextAreaIn.selectAll();
        BruteFrame.getInstance().getCenterPanel().jTextAreaIn.replaceSelection("");
        BruteFrame.getInstance().getCenterPanel().jTextAreaOut.selectAll();
        BruteFrame.getInstance().getCenterPanel().jTextAreaOut.replaceSelection("");
        stringBuilder = null;
        key = 0;
        outputFile = null;
        inputFile = null;

    }

    private void changeOutDir() {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jFileChooser.setCurrentDirectory(new File("./src/main/resources"));
        if (jFileChooser.showOpenDialog(CeasarFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            String lastName = inputFile.getName();
            lastName = lastName.substring(0, lastName.length() - 4);
            outputFile = new File(jFileChooser.getSelectedFile() + "/" + lastName);
            try (FileWriter fw = new FileWriter(new File(outputFile + "force" + key + ".txt"))) {
                System.out.println(outputFile + "force" + key + ".txt");
                fw.write(CeasarFrame.getInstance().getCenterPanel().jTextAreaOut.getText());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private int findKey( int[] alphabet, String charSequence, String txt){
            int i = 0;
            while (i < alphabet.length) {
                String nextCharSequence = shift(alphabet, i, charSequence).toString();
                if (txt.contains(nextCharSequence)) {
                    return i;
                }
                i++;
            }
            return Integer.MAX_VALUE;
        }
        public static StringBuilder shift ( int[] offsetCharacters, int range, String inputStr){
            Arrays.sort(offsetCharacters);
            StringBuilder stringBuilder = new StringBuilder(inputStr);
            if (offsetCharacters.length == range) {
                return stringBuilder;
            }
            if (Math.abs(range) > offsetCharacters.length) {
                range = range % offsetCharacters.length;
            }
            int indexInOffset;
            int currentChar;
            int newChar;
            for (int i = 0; i < stringBuilder.length(); ++i) {
                currentChar = stringBuilder.charAt(i);
                indexInOffset = Arrays.binarySearch(offsetCharacters, currentChar);
                if (indexInOffset < 0 || offsetCharacters.length <= indexInOffset) {
                    continue;
                }
                if (indexInOffset + range < 0) {
                    newChar = offsetCharacters.length + indexInOffset + range;
                } else if (indexInOffset + range >= offsetCharacters.length) {
                    newChar = -offsetCharacters.length + indexInOffset + range;
                } else {
                    newChar = indexInOffset + range;
                }
                stringBuilder.setCharAt(i, (char) offsetCharacters[newChar]);
            }
            return stringBuilder;
        }
    }


