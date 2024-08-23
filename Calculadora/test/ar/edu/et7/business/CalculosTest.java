package ar.edu.et7.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculosTest {
	Calculos calculos;
	
    @BeforeEach                                         
    void setUp() {
        calculos = new Calculos();
    }
    
    @Test
    void testTNA() {
        // Asumimos que el método tnaTea devuelve un cálculo específico basado en entradas
        double result = calculos.tnaTea(20.0f, 12.0f); // Usamos double en lugar de float para la entrada
        double expected = 21.939; // Ajusta este valor si es necesario
        assertEquals(expected, result, 0.01);
    }
    
	//TODO escribir el test para cada cálculo

}
