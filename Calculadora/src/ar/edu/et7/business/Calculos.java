package ar.edu.et7.business;

import java.util.ArrayList;
import java.util.List;

public class Calculos implements CalculosInterface {

	@Override
	public float discount(float amount, float discount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String sistemaAleman(float amount, int cuotas, float tasa) {
		// TODO Auto-generated method stub
		return "";
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
	
}
