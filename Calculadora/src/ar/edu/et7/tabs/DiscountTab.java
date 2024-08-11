package ar.edu.et7.tabs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DiscountTab extends TabPanel {
    private JTextField amountField;
    private JTextField discountField;
    private JTextArea resultArea;
    
    public DiscountTab() {
    	amountField = new JTextField(10);
    	discountField = new JTextField(10);
    	resultArea = new JTextArea(5, 20);
        createPanel();
    }    
    
    @Override
    public JPanel createPanel() {
        panel = new JPanel(new GridBagLayout());
       addInputFields(panel, amountField, discountField, this::calcular, resultArea);
        return panel;
    }
    private void calcular(ActionEvent e) {
        float resultado = 0;
        
        //TODO declarar una variable para cada campo

        try {
        	//TODO asignar el valor de cada campo a una variable

        } catch (NumberFormatException ex) {
            resultArea.setText("Error en la entrada: " + ex.getMessage());
            return;
        }

        
        //TODO calcular el resultado
        resultado = 0;
        resultArea.setText("Resultado: " + resultado);
        
        
    }

    private void addInputFields(JPanel panel, JTextField field1, JTextField field2, ActionListener action, JTextArea resultArea) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;

        if (field1 != null) {
            panel.add(new JLabel("Importe:"), gbc);
            gbc.gridx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            panel.add(field1, gbc);
            gbc.gridx = 0;
            gbc.gridy++;
        }

        if (field2 != null) {
            panel.add(new JLabel("Descuento:"), gbc);
            gbc.gridx = 1;
            panel.add(field2, gbc);
            gbc.gridx = 0;
            gbc.gridy++;
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
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane, gbc);
    }
}
