import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    public double balance = 0;

    JFrame frame;
    JPanel panel;
    JLabel label;
    JLabel label2;
    JLabel label3;
    JLabel blankLabel;
    JLabel blankLabel2;
    JLabel label4;
    JButton button;
    JButton depositButton;
    JButton withdrawButton;
    JTextField text;
    JTextField depositText;
    JTextField withdrawText;

    public GUI(){
        label4 = new JLabel("Set Initial Balance:");

        frame = new JFrame("Bank Balance");

        label = new JLabel("New balance:");

        text = new JTextField();
        text.setPreferredSize(new Dimension(250,30));

        button = new JButton("Submit");
        button.addActionListener(this);

        label2 = new JLabel("Balance: Unknown");

        label3 = new JLabel("Deposit or Withdraw:");

        blankLabel = new JLabel();

        blankLabel2 = new JLabel();

        depositText = new JTextField();

        depositButton = new JButton("Deposit");
        depositButton.addActionListener(this);

        withdrawText = new JTextField();

        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(this);

        panel = new JPanel();
        panel.setLayout(new GridLayout(6,2));
        panel.add(label4);
        panel.add(blankLabel2);
        panel.add(label);
        panel.add(text);
        panel.add(label2);
        panel.add(button);
        panel.add(label3);
        panel.add(blankLabel);
        panel.add(depositText);
        panel.add(depositButton);
        panel.add(withdrawText);
        panel.add(withdrawButton);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "Submit") {
            try {
                balance = Double.parseDouble(text.getText());
                label2.setText(String.format("Balance: $%.2f", balance));
            } catch (Exception ex) {
                label2.setText("Something went wrong.");
            }
        }

        if(e.getActionCommand() == "Deposit") {
            try {
                balance += Double.parseDouble(depositText.getText());
                label2.setText(String.format("Balance: $%.2f", balance));
            } catch (Exception ex) {
                label2.setText("Something went wrong.");
            }
        }

        if(e.getActionCommand() == "Withdraw") {
            try {
                balance -= Double.parseDouble(withdrawText.getText());
                label2.setText(String.format("Balance: $%.2f", balance));
            } catch (Exception ex) {
                label2.setText("Something went wrong.");
            }
        }
    }
}
