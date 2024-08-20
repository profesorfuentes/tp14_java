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
	void testDiscount() {
		float result = calculos.discount(3.0f, 5.0f);
		assertEquals(result, 0);
	}
	@Test
	void testSistemaFrances() {
		float result = calculos.resultado(3.0f, 5.0f);
		assertEquals(result, 0);
	}
	
	//TODO escribir el test para cada cálculo

}
