package ar.edu.ort.tp1.pacial2.clases;

public class Tradicional extends Pizza{
	private TipoDeMasa tipo;
	
	public Tradicional(String nombre, float costoDeProduccion, float porcentajeGanancia, TipoDeMasa tipo) {
		super(nombre, costoDeProduccion, porcentajeGanancia);
		setTipo(tipo);
	}

	public TipoDeMasa getTipo() {
		return tipo;
	}

	private void setTipo(TipoDeMasa tipo) {
		this.tipo = tipo;
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		String mensaje = tipo().name() +" - " +super.getNombre()+" - Precio de venta: " +super.getPrecioDeVenta()+" - "+getTipo().name();
		System.out.println(mensaje);
	}

	@Override
	public float getPrecioDeCosto() {
		// TODO Auto-generated method stub
		return super.getCostoDeProduccion()*getTipo().getPorcentaje();
	}

	@Override
	public TipoPizza tipo() {
		// TODO Auto-generated method stub
		return TipoPizza.TRADICIONAL;
	}
	
	

}
