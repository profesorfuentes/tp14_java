package ar.edu.et7.business;

public class Calculos implements CalculosInterface {

    @Override
    public float descuentoPorCantidad(float quantity, float unitPrice) {
        float discount;

        // Determinar el descuento basado en la cantidad
        if (quantity >= 50) {
            discount = 0.3f; // 30% de descuento para 50 o más unidades
        } else if (quantity >= 20) {
            discount = 0.2f; // 20% de descuento para 20 o más unidades
        } else if (quantity >= 10) {
            discount = 0.1f; // 10% de descuento para 10 o más unidades
        } else {
            discount = 0.0f; // Sin descuento para menos de 10 unidades
        }

        // Calcular el precio total antes del descuento
        float totalPrice = quantity * unitPrice;

        // Calcular el precio total con descuento
        float totalPriceWithDiscount = totalPrice * (1 - discount);

        return totalPriceWithDiscount;
    }
}