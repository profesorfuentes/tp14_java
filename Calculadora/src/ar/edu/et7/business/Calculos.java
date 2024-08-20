package ar.edu.et7.business;

public class Calculos implements CalculosInterface {

	@Override
	public float discount(float amount, float discount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float cft(float tna, float gastosAsociados) {
		// TODO Auto-generated method stub 
		float resultado;
		 resultado = tna + gastosAsociados;
		return resultado;
	}

	//TODO implementar los métodos de la interface


}
