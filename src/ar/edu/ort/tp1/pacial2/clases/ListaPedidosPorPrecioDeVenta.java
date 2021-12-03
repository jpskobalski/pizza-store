package ar.edu.ort.tp1.pacial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class ListaPedidosPorPrecioDeVenta extends ListaOrdenadaNodos<Float, Pedido> {

	@Override
	public int compare(Pedido dato1, Pedido dato2) {
		return compareByKey(dato1.getPizza().getPrecioDeVenta(), dato2);
	}


	@Override
	public int compareByKey(Float clave, Pedido elemento) {
		// TODO Auto-generated method stub
		int resultado = 0;
		if((clave - elemento.getPizza().getPrecioDeVenta())>0) {
			resultado=-1;
		}else {
			resultado=1;
		}
		return resultado;
	}

}