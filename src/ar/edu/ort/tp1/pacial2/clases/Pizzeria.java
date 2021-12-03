package ar.edu.ort.tp1.pacial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.PilaNodos;
import ar.edu.ort.tp1.tdas.interfaces.Pila;

public class Pizzeria implements Mostrable{

	private static final String MSG_PIZZA_TOPPINGS_NULO = "No se pudo fabricar Pizza o Topping nulo.";
	private static final String MSG_TOPPINGS = "Error de parámetros incorporando toppings";
	private static final String MSG_TOTALES = "La venta total fue: $%8.2f\n";
	private static final String MSG_CANTIDADES = "Se han fabricado: %d Tradicionales, %d Especiales y %d Rectangulares\n";
	
	private Pila<String> pilaErrores;
	private String nombre;
	private int[][] cantToping;
	private ListaPedidosPorPrecioDeVenta listaPedidos;
	
	public Pizzeria(String nombre) {
		// TODO A completar
		this.nombre = nombre;
		pilaErrores = new PilaNodos<>();
		cantToping = new int[TipoPizza.values().length][Topping.values().length];
		listaPedidos = new ListaPedidosPorPrecioDeVenta();
	}

	public void incorporarTopping(TipoPizza tipoPizza, Topping topping, int cantidad) {
		// TODO A completar
		if(cantidad>0) {
			cantToping[tipoPizza.ordinal()][topping.ordinal()] += cantidad;
		}
	}

	public void ingresarPedido(Pizza p, Topping topping) {
		// TODO A completar
		String error = MSG_PIZZA_TOPPINGS_NULO;
		if(p != null && topping != null) {
			if(cantToping[p.tipo().ordinal()][topping.ordinal()]>0){
				listaPedidos.add(new Pedido(p, topping));
				cantToping[p.tipo().ordinal()][topping.ordinal()] -= 1;
			} else {
				error = "No se pudo fabricar "+p.getNombre()+" por falta de topping "+ topping.getNombre();
				pilaErrores.push(error);
				throw new RuntimeException(error);
			}
		} else {
			pilaErrores.push(error);
			throw new RuntimeException(error);
		}
	}
	
	public float importeTotalVentasPorNombrePizza(String tipoNombrePizza) {
		float total = 0;
		
		for(Pedido p: listaPedidos) {
			if(p.getPizza().getNombre().equals(tipoNombrePizza)) {
				total += p.getPizza().getPrecioDeVenta();
			}
		}
		
		return total;
	}
	
	

	public String getNombre() {
		return nombre;
	}
	
	public void mostrarCantPizzaPorTipo() {
		int[] cantPizzaTipo = new int [TipoPizza.values().length];
		float total = 0;
		for(Pedido p: listaPedidos) {
			total += p.getPizza().getPrecioDeVenta();
			if(p.getPizza().tipo() == TipoPizza.ESPECIAL) {
				cantPizzaTipo[TipoPizza.ESPECIAL.ordinal()] += 1;
			}
			if(p.getPizza().tipo() == TipoPizza.TRADICIONAL) {
				cantPizzaTipo[TipoPizza.TRADICIONAL.ordinal()] += 1;
			}
			if(p.getPizza().tipo() == TipoPizza.RECTANGULAR) {
				cantPizzaTipo[TipoPizza.RECTANGULAR.ordinal()] += 1;
			}
		}
		System.out.printf(MSG_CANTIDADES, cantPizzaTipo[1], cantPizzaTipo[0], cantPizzaTipo[2]);
		System.out.printf(MSG_TOTALES, total);
	}
	
	
	public void mostrarPedidos() {
		for(Pedido p: listaPedidos) {
			p.getPizza().mostrar();
		}
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		System.out.println("Pizzeria: "+getNombre());
		mostrarCantPizzaPorTipo();
		System.out.println("-----------------");
		mostrarPedidos();
		System.out.println("-----------------");
		Pila<String> pilaAux = new PilaNodos<>();
		String aux = null;
		while(!pilaErrores.isEmpty()) {
			aux = pilaErrores.pop();
			System.out.println(aux);
			pilaAux.push(aux);
		}
		while(!pilaAux.isEmpty()) {
			pilaErrores.push(pilaAux.pop());
		}
	}
	
	

}
