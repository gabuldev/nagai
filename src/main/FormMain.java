package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormMain {
    private JPanel panel1;
    private JTextField returntext;
    private JComboBox comboBox1;
    private JButton okButton;
    private JComboBox comboBox2;
    private JTextField inputtext;
    private JButton OKButton;


    public FormMain() {
        StringAlgorithms string = new StringAlgorithms("Title","Author","1","Description");
        NumericAlgorithms numeric = new NumericAlgorithms("Title","Author","1","Description");

        DefaultComboBoxModel model = new DefaultComboBoxModel();
//CRIANDO A COMBOBOX
        model.addElement("Numeric");
        model.addElement("String");
        comboBox2.setModel(model);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultComboBoxModel model2 = new DefaultComboBoxModel();
                if(comboBox2.getSelectedIndex() == 1){

                    model2.addElement("Caesar Chiper");
                    model2.addElement("Count Ocurrences");
                    model2.addElement("Clean InputText");
                    model2.addElement("Schedule Expression");
                }
                else if(comboBox2.getSelectedIndex() == 0){
                    model2.addElement("Shortener Encode");
                    model2.addElement("Shortener Decode");
                    model2.addElement("Generate Number Sequence");
                }
                comboBox1.setModel(model2);
            }
        });
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox2.getSelectedIndex() == 1) {
                    string.setInputeText(inputtext.getText());

                    if (comboBox1.getSelectedIndex() == 0) {
                        returntext.setText(string.cesarCypher());
                    }
                    if (comboBox1.getSelectedIndex() == 1) {
                        returntext.setText(string.countOcurrences());
                    }
                    if (comboBox1.getSelectedIndex() == 2) {
                        returntext.setText(string.cleanInputText());
                    }
                    if (comboBox1.getSelectedIndex() == 3) {
                        returntext.setText(string.scheduleExpression());
                    }
                }

                if (comboBox2.getSelectedIndex() == 0) {

                    if (comboBox1.getSelectedIndex() == 0) {
                        returntext.setText(numeric.shortenerEncode(Integer.parseInt(inputtext.getText())));
                    }
                    if (comboBox1.getSelectedIndex() == 1) {
                        returntext.setText(String.valueOf(numeric.shortenerDecode(inputtext.getText())));
                    }
                    if (comboBox1.getSelectedIndex() == 2) {
                        returntext.setText(String.valueOf(numeric.generateNumberSequence(inputtext.getText())));
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new FormMain().panel1);
        frame.pack();
        frame.setVisible(true);
    }

}
