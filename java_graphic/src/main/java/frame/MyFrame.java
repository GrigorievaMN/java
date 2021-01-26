package frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    private final JTextField textField;
    private char operation;
    private double total;
    private boolean isFirstDigit;


    public MyFrame() {
        setTitle("Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 170, 260);
        //setVisible(true);


        total = 0;

        JPanel jPanel = new JPanel();


        textField = new JTextField(12);
        textField.setEditable(false);

        jPanel.add(textField);

        JButton[] jbs = new JButton[9];
        for (int i = 0; i < jbs.length; i++) {
            jbs[i] = new JButton(String.valueOf(i + 1));
            jbs[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    action(e);
                }
            });
            jPanel.add(jbs[i]);
        }

        JButton buttonZero = new JButton("0");
        JButton buttonPlus = new JButton("+");
        JButton buttonMinus = new JButton("-");
        JButton buttonMultiply = new JButton("*");
        JButton buttonDivide = new JButton("/");
        JButton buttonSquare = new JButton("sqr");
        JButton buttonEquals = new JButton("=");
        JButton buttonPoint = new JButton(".");

        buttonPoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });

        buttonZero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });

        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });

        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });

        buttonMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });

        buttonDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });

        buttonSquare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculating(e);
                square();
            }
        });

        buttonEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculating(e);
            }
        });


        jPanel.add(buttonPoint);
        jPanel.add(buttonZero);
        jPanel.add(buttonPlus);
        jPanel.add(buttonMinus);
        jPanel.add(buttonMultiply);
        jPanel.add(buttonDivide);
        jPanel.add(buttonSquare);
        jPanel.add(buttonEquals);


        add(jPanel);
        setVisible(true);
    }

    /**
     * 1) Берём текст из текстового поля
     * 2) Идём по каждому символу пока не встретим + или -
     * 3) Затем переводим наше число из String в Double
     * 4) Записываем текущий символ(+ или -)
     * 5) Если у нас уже записано одно число, проводим операцию и переходим на шаг 2, иначе переходим на шаг 2
     *
     * @param e
     */
    private void square() {
       double currentValue = Double.parseDouble(textField.getText());
       textField.setText(String.valueOf(currentValue * currentValue));
    }
    private void calculating(ActionEvent e) {
        String text = textField.getText();
        String digit = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '-' || c == '+' || c == '*' || c == '/') {
                double currentValue = Double.parseDouble(digit);
                total += currentValue;

                digit = "";
                operation = c;
                continue;
            }

            digit += c;
        }
        double currentValue = Double.parseDouble(digit);

        if (operation == '/' && currentValue == 0) {
            textField.setText("");
            total = 0;
        } else {
            switch (operation) {
                case '-':
                    total -= currentValue;
                    break;
                case '+':
                    total += currentValue;
                    break;
                case '*':
                    total *= currentValue;
                    break;
                case '/':
                    total /= currentValue;
                    break;
                default:
                    total = currentValue;

            }

            textField.setText(String.valueOf(total));
            total = 0;
        }

    }

    public void action(ActionEvent event) {
        if (event.getActionCommand() == "+" || event.getActionCommand() == "-" || event.getActionCommand() == "." || event.getActionCommand() == "*" || event.getActionCommand() == "/") {
            String text = textField.getText();
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (c == '.' && event.getActionCommand() == "." && (i == text.length() - 1)) {
                    return;
                }
                if ((c == '-' || c == '+' || c == '*' || c == '/') && (i == text.length() - 1)) {
                    return;
                }
                if ((c == '-' || c == '+' || c == '*' || c == '/') && i < text.length() - 1 && event.getActionCommand() != ".") {
                    calculating(event);
                }
            }
            if (text.length() == 0) return;
        }
        if (textField.getText().length() == 0 && operation == '/') {
            operation = '\0';
            return;
        }

        textField.setText(textField.getText() + event.getActionCommand());

    }
}
