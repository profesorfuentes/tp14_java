package ar.edu.et7.tabs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class TabPanel {
    protected JTextArea resultArea;
	protected JPanel panel;

    public abstract JPanel createPanel();

    protected JTextField[] addInputFields(JPanel panel, String label1, String label2, ActionListener action) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;

        JTextField[] fields = new JTextField[3];  // Inicialización correcta de fields
        int fieldIndex = 0;

        if (label1 != null) {
            panel.add(new JLabel(label1), gbc);
            gbc.gridx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            fields[fieldIndex] = new JTextField(10);
            panel.add(fields[fieldIndex], gbc);
            gbc.gridx = 0;
            gbc.gridy++;
            fieldIndex++;
        }

        if (label2 != null) {
            panel.add(new JLabel(label2), gbc);
            gbc.gridx = 1;
            fields[fieldIndex] = new JTextField(10);
            panel.add(fields[fieldIndex], gbc);
            gbc.gridx = 0;
            gbc.gridy++;
            fieldIndex++;
        }


        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(action);
        panel.add(calcularButton, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        resultArea = new JTextArea(5, 20);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane, gbc);

        return fields;
    }

    protected void calcularSuma(JTextField[] fields) {
        float sum = 0;
        for (JTextField field : fields) {
            if (field != null && !field.getText().isEmpty()) {
                try {
                    sum += Float.parseFloat(field.getText());
                } catch (NumberFormatException e) {
                    resultArea.setText("Error en la entrada: " + e.getMessage());
                    return;
                }
            }
        }
        resultArea.setText("Suma: " + sum);
    }
    
    public JPanel getPane( ) {
    	return panel;
    }

}
