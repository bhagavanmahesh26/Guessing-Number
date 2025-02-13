import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessingGameGUI {
    private int numberToGuess;
    private int attemptsLeft = 5;
    private JTextField guessField;
    private JLabel messageLabel, attemptsLabel;

    public NumberGuessingGameGUI() {
        Random random = new Random();
        numberToGuess = random.nextInt(100) + 1; // 1 to 100

        JFrame frame = new JFrame("Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        JLabel promptLabel = new JLabel("Guess a number (1-100):");
        guessField = new JTextField(10);
        JButton guessButton = new JButton("Guess");
        messageLabel = new JLabel("");
        attemptsLabel = new JLabel("Attempts left: " + attemptsLeft);

        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        frame.add(promptLabel);
        frame.add(guessField);
        frame.add(guessButton);
        frame.add(attemptsLabel);
        frame.add(messageLabel);

        frame.setVisible(true);
    }

    private void checkGuess() {
        try {
            int guess = Integer.parseInt(guessField.getText());

            if (guess == numberToGuess) {
                messageLabel.setText("🎉 Correct! You Win!");
                guessField.setEnabled(false);
            } else if (guess > numberToGuess) {
                messageLabel.setText("🔼 Too High!");
            } else {
                messageLabel.setText("🔽 Too Low!");
            }

            attemptsLeft--;
            attemptsLabel.setText("Attempts left: " + attemptsLeft);

            if (attemptsLeft == 0 && guess != numberToGuess) {
                messageLabel.setText("❌ Game Over! Number was " + numberToGuess);
                guessField.setEnabled(false);
            }
        } catch (NumberFormatException ex) {
            messageLabel.setText("⚠️ Enter a valid number.");
        }
    }

    public static void main(String[] args) {
        new NumberGuessingGameGUI();
    }
}