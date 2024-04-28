package Thanh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LinearEquationSolver extends JFrame implements ActionListener {
    private JTextField coefficientA, coefficientB, resultField;
    private JButton solveButton;

    public LinearEquationSolver() {
        setTitle("Linear Equation Solver");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Panel for text fields
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));

        JLabel labelA = new JLabel("Enter coefficient a: ");
        JLabel labelB = new JLabel("Enter coefficient b: ");
        JLabel labelResult = new JLabel("Result: ");

        coefficientA = new JTextField(10);
        coefficientB = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);

        inputPanel.add(labelA);
        inputPanel.add(coefficientA);
        inputPanel.add(labelB);
        inputPanel.add(coefficientB);
        inputPanel.add(labelResult);
        inputPanel.add(resultField);

        // Panel for solve button
        JPanel buttonPanel = new JPanel();
        solveButton = new JButton("Solve");
        solveButton.addActionListener(this);
        buttonPanel.add(solveButton);

        // Add panels to content pane
        Container contentPane = getContentPane();
        contentPane.add(inputPanel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == solveButton) {
            try {
                double a = Double.parseDouble(coefficientA.getText());
                double b = Double.parseDouble(coefficientB.getText());

                if (a == 0) {
                    if (b == 0) {
                        resultField.setText("Infinite solutions");
                    } else {
                        resultField.setText("No solution");
                    }
                } else {
                    double result = -b / a;
                    resultField.setText(Double.toString(result));
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter valid coefficients.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LinearEquationSolver solver = new LinearEquationSolver();
            solver.setVisible(true);
        });
    }
}
