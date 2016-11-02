package com.rudolf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rudi on 11/1/2016.
 */
public class creditCard_Validator extends JFrame {
    private JPanel rootPanel;
    private JButton validateButton;
    private JButton quitButton;
    private JTextField creditCardNumberTextField;
    private JLabel validMessageLabel;


    protected creditCard_Validator() {
        setTitle("Credit Card Validator");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(new Dimension(300, 270));

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String creditCardNumber = creditCardNumberTextField.getText();
                boolean valid = isVisaCreditCardNumberValid(creditCardNumber);
                if (valid) {
                    validMessageLabel.setText("Credit card number is valid");
                } else {
                    validMessageLabel.setText("Credit card number is NOT valid");
                }


                quitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }


                });
            }

            private boolean isVisaCreditCardNumberValid(String ccNumber) {
                if (!ccNumber.startsWith("4") || (ccNumber.length() != 16)) {
                    System.out.println("Doesn't start with 4 or length wrong");
                    return false;
                }

                int sum = 0;

                for (int i = 0; i < 16; i++) {
                    int thisDigit = Integer.parseInt((ccNumber.substring(i, i + 1)));
                    if (i % 2 == 1) {
                        sum = sum + thisDigit;
                    } else {
                        int doubled = thisDigit * 2;
                        if (doubled > 9) {
                            int toAdd = 1 + (doubled % 10);
                            sum = sum + toAdd;
                        } else {
                            sum = sum + (thisDigit * 2);
                        }
                    }
                }

                if (sum % 10 == 0) {
                    return true;
                }

                return false;
            }
        });
    }
}


