import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static Integer myNUmber = ThreadLocalRandom.current().nextInt(0, 100 + 1);
    static Integer tries = 0;
    static JFrame frame = new JFrame("Guess the Number");

    static JLabel text = new JLabel("Gib ein Zahl ein!");
    static JTextField textField = new JTextField();
    static JButton button = new JButton("Raten!");


    public static void main(String[] args) {
        openUI();
       //nextRound();
    }

    public static void openUI(){
        configOfUIFrame();
        configOfElemnts();
        buttonAction();
    }
    public static void configOfUIFrame(){
        frame.setSize(800,400);
        frame.setLocationRelativeTo(null); // to center on screen sonst frame.setLocation(x,y)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);
    }

    public static void configOfElemnts(){
        text.setBounds(50,50,300,30);
        textField.setBounds(50,150,300,50);
        button.setBounds(50,250,300,50);
        frame.add(text);
        frame.setLayout(null);
        frame.add(textField);
        frame.add(button);
        frame.setVisible(true);
    }

    public static void buttonAction(){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String textFromField = textField.getText();
                    Integer number = Integer.parseInt(textFromField);
                    guess(number);
                } catch (Exception error){
                    text.setText("Bitte gib ein Zahl !!");
                }
            }
        });
    }
    // only show in Terminal
    public static void nextRound(){
        //short form of (tries = tries + 1)
        tries++;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please give a number:");
        Integer number = scanner.nextInt();
        guess(number);
    }
    public static void guess(Integer number){
        if (number == myNUmber){
            text.setText("Correct !! Du hast " + tries + " Versuche gebraucht!!");
            textField.setBorder(new LineBorder(Color.GREEN));

        } else {
            tries++;
            textField.setBorder(new LineBorder(Color.RED));
            if(number < myNUmber){
                text.setText("Falsch getaren! Die Zahl is zu klein");
            } else {
                text.setText("Falsch getaren! Die Zahl is zu groß");
            }
            textField.setText("");
           // nextRound();
        }
    }
}