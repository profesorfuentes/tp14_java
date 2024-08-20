package ar.edu.et7.tabs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GermanSystemTab extends TabPanel {
    private JTextField montoField;
    private JTextField tnaField;
    private JTextField cuotasField;
    private JTextArea resultArea;

    public GermanSystemTab() {
        montoField = new JTextField(10);
        tnaField = new JTextField(10);
        cuotasField = new JTextField(10);
        resultArea = new JTextArea(10, 30); // Ampliado para manejar más texto
        createPanel();
    }

    @Override
    public JPanel createPanel() {
        panel = new JPanel(new GridBagLayout());
        addInputFields(panel, montoField, tnaField, cuotasField, this::calcular, resultArea);
        return panel;
    }
   
    private void calcular(ActionEvent e) {
        // Variables para los campos
        float monto;
        float tna;
        int cuotas;

        try {
            // Asignar el valor de cada campo a una variable
            monto = Float.parseFloat(montoField.getText());
            tna = Float.parseFloat(tnaField.getText());
            cuotas = Integer.parseInt(cuotasField.getText());
        } catch (NumberFormatException ex) {
            resultArea.setText("Error en la entrada: " + ex.getMessage());
            return;
        }

        // Calcular el resultado como calculadora con sistema alemán
        List<String> resultados = calcularCuotasAleman(monto, tna, cuotas);
        resultArea.setText(String.join("\n", resultados));
    }

    private List<String> calcularCuotasAleman(float monto, float tna, int cuotas) {
        List<String> resultado = new ArrayList<>();
       
        // Convertir la TNA a una tasa de interés mensual
        float tasaInteresMensual = tna / 100 / 12;
       
        // Calcular el monto fijo de principal por cuota
        float cuotaFijaPrincipal = monto / cuotas;
       
        // Calcular el valor de cada cuota
        for (int i = 1; i <= cuotas; i++) {
            float saldoDeuda = monto - (cuotaFijaPrincipal * (i - 1));
            float interes = saldoDeuda * tasaInteresMensual;
            float cuotaTotal = cuotaFijaPrincipal + interes;

            // Formatear el resultado para mostrar en el JTextArea
            resultado.add(String.format("Cuota %d: %.2f (Principal: %.2f, Interés: %.2f)",
                    i, cuotaTotal, cuotaFijaPrincipal, interes));
        }
       
        return resultado;
    }

    private void addInputFields(JPanel panel, JTextField field1, JTextField field2, JTextField field3, ActionListener action, JTextArea resultArea) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;

        if (field1 != null) {
            panel.add(new JLabel("Monto:"), gbc);
            gbc.gridx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            panel.add(field1, gbc);
            gbc.gridx = 0;
            gbc.gridy++;
        }

        if (field2 != null) {
            panel.add(new JLabel("TNA:"), gbc);
            gbc.gridx = 1;
            panel.add(field2, gbc);
            gbc.gridx = 0;
            gbc.gridy++;
        }

        if (field3 != null) {
            panel.add(new JLabel("Cuotas:"), gbc);
            gbc.gridx = 1;
            panel.add(field3, gbc);
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