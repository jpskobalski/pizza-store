package ar.edu.ort.tp1.pacial2.clases;

public class Pedido {
	private Pizza pizza;
	private Topping topping;
	
	public Pedido(Pizza pizza, Topping topping) {
		setPizza(pizza);
		setTopping(topping);
	}

	private Topping getTopping() {
		return topping;
	}

	private void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setTopping(Topping topping) {
		this.topping = topping;
	}
	
	
}
