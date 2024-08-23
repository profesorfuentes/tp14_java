package ar.edu.et7.business;

public class Calculos implements CalculosInterface {

    @Override
    public float discount(float amount, float discount) {
        // Implementar cálculo de descuento si es necesario
        // Ejemplo de implementación:
        return amount * (1 - discount / 100);
    }

    @Override
    public float tnaTea(float tna, float periodsPerYear) {
        // Convertir TNA de porcentaje a decimal
        double TNA_decimal = tna / 100.0;
        
        // Verificar que periodsPerYear no sea cero para evitar división por cero
        if (periodsPerYear <= 0) {
            throw new IllegalArgumentException("El número de períodos por año debe ser mayor que cero.");
        }

        // Calcular TEA
        double TEA_decimal = Math.pow(1 + TNA_decimal / periodsPerYear, periodsPerYear) - 1;
        
        // Convertir TEA de decimal a porcentaje
        return (float) (TEA_decimal * 100);
    }

    // Implementar otros métodos de la interfaz si es necesario
}
