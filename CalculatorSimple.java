import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorSimple implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JButton Scientific;
    static String[] button = { "7", "8", "9", "4", "5", "6", "1", "2", "3", "0" };
    JPanel panel;
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    CalculatorSimple(){

        panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY.darker());
        panel.setBounds(0,0,375,150);
        panel.isOpaque();
        
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setBackground(Color.BLACK);
        frame.setResizable(false);
        frame.setBounds(400,50,375,560);
        frame.add(panel);

        textfield = new JTextField();
        textfield.setBounds(20, 25, 330, 50);
        textfield.setFont(new Font("Lusida Sans Unicode", Font.PLAIN,30));
        textfield.setEditable(false);
        textfield.setBackground(Color.LIGHT_GRAY);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("CE");
        clrButton = new JButton("C");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        Scientific = new JButton("SCI");
        Scientific.setFont(new Font("Lusida Sans Unicode", Font.BOLD,20));
        Scientific.setFocusable(false);
        Scientific.setBackground(Color.orange);
        Scientific.setForeground(Color.BLACK);
        Scientific.addActionListener(this);

        frame.add(Scientific);

        for(int i =0;i<9;i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(new Font("Lusida Sans Unicode",Font.PLAIN,20));
            functionButtons[i].setFocusable(false);
            frame.add(functionButtons[i]);
            functionButtons[i].setBackground(Color.orange);
            functionButtons[i].setForeground(Color.BLACK);
        }

        int x = 0;
        int y = 225;
        for(int i =0;i<10;i++) {
            numberButtons[i] = new JButton(button[i]);
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(new Font("Lusida Sans Unicode",Font.CENTER_BASELINE,20));
            frame.add(numberButtons[i]);
            numberButtons[i].setBackground(Color.DARK_GRAY);
            numberButtons[i].setForeground(Color.WHITE);
            numberButtons[i].setFocusable(false);

            if(x<=269) {
                numberButtons[i].setBounds(x, y, 90, 75);
                x = x + 90;
            }else{
                x = 0;
                y = y + 75;
                numberButtons[i].setBounds(x, y, 90, 75);
                x = x + 90;
            }if(i ==9) {
                numberButtons[9].setBounds(90, 450, 90, 75);
            }
        }

        Scientific.setBounds(0,450,90,75);
        negButton.setBounds(0,150,90,75);
        delButton.setBounds(90,150,90,75);
        delButton.setBackground(Color.WHITE.darker());
        clrButton.setBounds(180,150,90,75);
        clrButton.setBackground(Color.WHITE.darker());

        divButton.setBounds(270,150,90,75);
        addButton.setBounds(270,225,90,75);
        subButton.setBounds(270,300,90,75);
        mulButton.setBounds(270,375,90,75);

        decButton.setBounds(180,450,90,75);
        equButton.setBounds(270,450,90,75);
        equButton.setBackground(Color.WHITE.darker());

        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        CalculatorSimple calc = new CalculatorSimple();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Scientific) {

            frame.dispose();
            new CalculatorScientific();

        } else {

            for (int i = 0; i < 10; i++) {
                if (e.getSource() == numberButtons[i]) {
                    textfield.setText(textfield.getText().concat(button[i]));
                }
            }
            if (e.getSource() == decButton) {
                textfield.setText(textfield.getText().concat("."));
            }
            if (e.getSource() == addButton) {
                num1 = Double.parseDouble(textfield.getText());
                operator = '+';
                textfield.setText("");
            }
            if (e.getSource() == subButton) {
                num1 = Double.parseDouble(textfield.getText());
                operator = '-';
                textfield.setText("");
            }
            if (e.getSource() == mulButton) {
                num1 = Double.parseDouble(textfield.getText());
                operator = '*';
                textfield.setText("");
            }
            if (e.getSource() == divButton) {
                num1 = Double.parseDouble(textfield.getText());
                operator = '/';
                textfield.setText("");
            }
            if (e.getSource() == equButton) {
                num2 = Double.parseDouble(textfield.getText());

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                }
                textfield.setText(String.valueOf(result));
                num1 = result;
            }
            if (e.getSource() == clrButton) {
                textfield.setText("");
            }
            if (e.getSource() == delButton) {
                String string = textfield.getText();
                textfield.setText("");
                for (int i = 0; i < string.length() - 1; i++) {
                    textfield.setText(textfield.getText() + string.charAt(i));
                }
            }
            if (e.getSource() == negButton) {
                double temp = Double.parseDouble(textfield.getText());
                temp *= -1;
                textfield.setText(String.valueOf(temp));
            }
        }
    }
}

class CalculatorScientific extends JFrame implements ActionListener {
    JButton[] numberButtons = new JButton[10];
    static String[] button = { "7", "8", "9", "4", "5", "6", "1", "2", "3", "0" };
    JButton sinButton, cosButton, tanButton, secButton, cotButton, cosecButton;
    JButton equButton, X_2Button, e_xButton, CEButton, LogButton, X_XButton, DotButton;
    JPanel panel;
    static JButton Simple = new JButton("SIM");
    JTextField textField = new JTextField();
    static double num1;
    static double num2;
    static int num3;
    static int choice;
    static int length;

    public CalculatorScientific() {

        panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY.darker());
        panel.setBounds(0, 0, 375, 195);
        panel.isOpaque();

        this.setTitle("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(375, 590);
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setResizable(false);
        this.setVisible(true);
        this.setBounds(400, 50, 375, 590);
        this.add(panel);

        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        cotButton = new JButton("cot");
        secButton = new JButton("sec");
        cosecButton = new JButton("cosec");

        sinButton.setBounds(0, 195, 90, 60);
        this.add(sinButton);
        sinButton.setFocusable(false);
        sinButton.setBackground(Color.ORANGE);
        sinButton.setForeground(Color.BLACK);
        sinButton.setFont(new Font("FIRA CODE", Font.PLAIN, 25));
        sinButton.addActionListener(this);

        cosButton.setBounds(90, 195, 90, 60);
        this.add(cosButton);
        cosButton.setFocusable(false);
        cosButton.setBackground(Color.orange);
        cosButton.setForeground(Color.BLACK);
        cosButton.setFont(new Font("FIRA CODE", Font.PLAIN, 25));
        cosButton.addActionListener(this);

        tanButton.setBounds(180, 195, 90, 60);
        this.add(tanButton);
        tanButton.setFocusable(false);
        tanButton.setBackground(Color.orange);
        tanButton.setForeground(Color.BLACK);
        tanButton.setFont(new Font("FIRA CODE", Font.PLAIN, 25));
        tanButton.addActionListener(this);

        cosecButton.setBounds(0, 255, 90, 60);
        this.add(cosecButton);
        cosecButton.setFocusable(false);
        cosecButton.setBackground(Color.orange);
        cosecButton.setForeground(Color.BLACK);
        cosecButton.setFont(new Font("FIRA CODE", Font.BOLD, 15));
        cosecButton.addActionListener(this);

        secButton.setBounds(90, 255, 90, 60);
        this.add(secButton);
        secButton.setFocusable(false);
        secButton.setBackground(Color.orange);
        secButton.setForeground(Color.BLACK);
        secButton.setFont(new Font("FIRA CODE", Font.PLAIN, 25));
        secButton.addActionListener(this);

        cotButton.setBounds(180, 255, 90, 60);
        this.add(cotButton);
        cotButton.setFocusable(false);
        cotButton.setBackground(Color.orange);
        cotButton.setForeground(Color.BLACK);
        cotButton.setFont(new Font("FIRA CODE", Font.PLAIN, 25));
        cotButton.addActionListener(this);

        Simple.setBounds(0, 495, 90, 60);
        this.add(Simple);
        Simple.setFocusable(false);
        Simple.setBackground(Color.orange);
        Simple.setForeground(Color.BLACK.darker());
        Simple.setFont(new Font("FIRA CODE", Font.PLAIN, 25));
        Simple.addActionListener(this);

        int x1 = 0;
        int y1 = 315;

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(button[i]);
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(new Font("Lusuda Sans Unicode", Font.PLAIN, 20));
            this.add(numberButtons[i]);
            numberButtons[i].setBackground(Color.DARK_GRAY);
            numberButtons[i].setForeground(Color.WHITE);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setFont(new Font("FIRA CODE", Font.PLAIN, 25));

            if (x1 <= 269) {
                numberButtons[i].setBounds(x1, y1, 90, 60);
                x1 = x1 + 90;
            } else {
                x1 = 0;
                y1 = y1 + 60;
                numberButtons[i].setBounds(x1, y1, 90, 60);
                x1 = x1 + 90;
            }
            if (i == 9) {
                numberButtons[9].setBounds(90, 495, 90, 60);
            }
        }

        equButton = new JButton("=");
        equButton.setBounds(270, 495, 90, 60);
        this.add(equButton);
        equButton.setBackground(Color.WHITE.darker());
        equButton.setForeground(Color.BLACK);
        equButton.setFocusable(false);
        equButton.setFont(new Font("FIRA CODE", Font.PLAIN, 20));
        equButton.addActionListener(this);

        X_2Button = new JButton("X^2");
        X_2Button.setBounds(270, 315, 90, 60);
        this.add(X_2Button);
        X_2Button.setBackground(Color.ORANGE);
        X_2Button.setForeground(Color.BLACK);
        X_2Button.setFocusable(false);
        X_2Button.setFont(new Font("FIRA CODE", Font.PLAIN, 20));
        X_2Button.addActionListener(this);

        e_xButton = new JButton("e^x");
        e_xButton.setBounds(270, 435, 90, 60);
        this.add(e_xButton);
        e_xButton.setBackground(Color.ORANGE);
        e_xButton.setForeground(Color.BLACK);
        e_xButton.setFocusable(false);
        e_xButton.setFont(new Font("FIRA CODE", Font.PLAIN, 20));
        e_xButton.addActionListener(this);

        CEButton = new JButton("CE");
        CEButton.setBounds(270, 195, 90, 60);
        this.add(CEButton);
        CEButton.setBackground(Color.WHITE.darker());
        CEButton.setForeground(Color.BLACK);
        CEButton.setFocusable(false);
        CEButton.setFont(new Font("FIRA CODE", Font.PLAIN, 20));
        CEButton.addActionListener(this);

        LogButton = new JButton("Ln");
        LogButton.setBounds(270, 255, 90, 60);
        this.add(LogButton);
        LogButton.setBackground(Color.ORANGE);
        LogButton.setForeground(Color.BLACK);
        LogButton.setFocusable(false);
        LogButton.setFont(new Font("FIRA CODEI", Font.PLAIN, 20));
        LogButton.addActionListener(this);

        X_XButton = new JButton("x^x");
        X_XButton.setBounds(270, 375, 90, 60);
        this.add(X_XButton);
        X_XButton.setBackground(Color.ORANGE);
        X_XButton.setForeground(Color.BLACK);
        X_XButton.setFocusable(false);
        X_XButton.setFont(new Font("FIRA CODE", Font.PLAIN, 20));
        X_XButton.addActionListener(this);

        DotButton = new JButton(".");
        DotButton.setBounds(180, 495, 90, 60);
        this.add(DotButton);
        DotButton.setBackground(Color.orange);
        DotButton.setForeground(Color.BLACK);
        DotButton.setFocusable(false);
        DotButton.addActionListener(this);
        DotButton.setFont(new Font("FIRA CODE", Font.PLAIN, 20));

        textField.setBounds(15, 60, 330, 50);
        this.add(textField);
        textField.setFont(new Font("Lusida Sans Unicode", Font.PLAIN, 30));
        textField.setEditable(false);
        textField.setBackground(Color.LIGHT_GRAY);
        textField.setForeground(Color.BLACK);
        textField.setFont(new Font("FIRA CODE", Font.PLAIN, 30));
    }

    public void actionPerformed(ActionEvent e) {
        String Text;
        String ans;
        double angleRadians, result;

        if (e.getSource() == Simple) {
            this.dispose();
            new CalculatorSimple();
        } else {

            for (int i = 0; i < 10; i++) {
                if (e.getSource() == numberButtons[i]) {
                    textField.setText(textField.getText().concat(button[i]));
                }
            }

            if (e.getSource() == DotButton) {
                textField.setText(textField.getText().concat("."));
            }

            if (e.getSource() == sinButton) {
                choice = 1;
                textField.setText("sin ");
            }

            if (e.getSource() == cosButton) {
                choice = 2;
                textField.setText("cos ");
            }
            if (e.getSource() == tanButton) {
                choice = 3;
                textField.setText("tan ");
            }
            if (e.getSource() == cotButton) {
                choice = 4;
                textField.setText("cot ");
            }
            if (e.getSource() == secButton) {
                choice = 5;
                textField.setText("sec ");
            }
            if (e.getSource() == cosecButton) {
                choice = 6;
                textField.setText("cosec ");
            }
            if (e.getSource() == e_xButton) {
                choice = 7;
                textField.setText("e^");
            }
            if (e.getSource() == CEButton) {

                textField.setText("");
            }
            if (e.getSource() == X_2Button) {
                num1 = Double.parseDouble(textField.getText());
                result = num1 * num1;

                textField.setText("" + result);
            }
            if (e.getSource() == X_XButton) {

                num3 = Integer.parseInt(textField.getText());
                String l = "" + num1;
                length = l.length();

                System.out.println(length);
                choice = 8;
                textField.setText(num3 + "^");
                num1 = num3;

            }
            if (e.getSource() == LogButton) {
                choice = 9;
                textField.setText("Ln ");
            }

            if (e.getSource() == equButton) {
                Text = textField.getText();

                switch (choice) {
                    case 1:
                        ans = Text.substring(4);

                        num1 = Double.parseDouble(ans);
                        angleRadians = Math.toRadians(num1);

                        double sinValue = Math.sin(angleRadians);
                        textField.setText("" + sinValue);

                        break;

                    case 2:
                        ans = Text.substring(4);

                        num1 = Double.parseDouble(ans);
                        angleRadians = Math.toRadians(num1);

                        double cosValue = Math.cos(angleRadians);
                        textField.setText("" + cosValue);

                        break;

                    case 3:
                        ans = Text.substring(4);

                        num1 = Double.parseDouble(ans);
                        angleRadians = Math.toRadians(num1);

                        double tanValue = Math.tan(angleRadians);
                        textField.setText("" + tanValue);

                        break;

                    case 4:
                        ans = Text.substring(4);

                        num1 = Double.parseDouble(ans);
                        angleRadians = Math.toRadians(num1);

                        tanValue = Math.tan(angleRadians);
                        double cotValue = 1 / tanValue;
                        textField.setText("" + cotValue);

                        break;

                    case 5:
                        ans = Text.substring(4);

                        num1 = Double.parseDouble(ans);
                        angleRadians = Math.toRadians(num1);

                        cosValue = Math.cos(angleRadians);
                        double secValue = 1 / cosValue;
                        textField.setText("" + secValue);

                        break;

                    case 6:
                        ans = Text.substring(6);

                        num1 = Double.parseDouble(ans);
                        angleRadians = Math.toRadians(num1);

                        sinValue = Math.sin(angleRadians);
                        double cosecValue = 1 / sinValue;
                        textField.setText("" + cosecValue);

                        break;

                    case 7:
                        ans = Text.substring(2);

                        num1 = Double.parseDouble(ans);
                        result = Math.exp(num1);

                        textField.setText("" + result);

                        break;

                    case 8:
                        ans = Text.substring(length - 1);

                        num2 = Double.parseDouble(ans);
                        result = Math.pow(num1, num2);

                        textField.setText("" + result);

                        break;

                    case 9:
                        ans = Text.substring(3);
                        num1 = Double.parseDouble(ans);
                        result = Math.log(num1);

                        textField.setText("" + result);

                        break;
                }
            }
        }
    }
}