package ar.edu.ort.tp1.pacial2.clases;

public class Especial extends Pizza{

	private static final float PRECIO_FAINA = 38;
	
	private TamanioDePizza tamanio;
	private int cantFaina;

	public Especial(String nombre, float costoDeProduccion, float porcentajeGanancia, int cantFaina, TamanioDePizza tamanio) {
		super(nombre, costoDeProduccion, porcentajeGanancia);
		setTamanio(tamanio);
		setCantFaina(cantFaina);
	}

	public TamanioDePizza getTamanio() {
		return tamanio;
	}

	private void setTamanio(TamanioDePizza tamanio) {
		this.tamanio = tamanio;
	}

	public int getCantFaina() {
		return cantFaina;
	}

	private void setCantFaina(int cantFaina) {
		this.cantFaina = cantFaina;
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		String mensaje = tipo().name() +" - " +super.getNombre()+" - Precio de venta: " +super.getPrecioDeVenta()+" - "+getCantFaina()+" Fainas - "+getTamanio().name();
		System.out.println(mensaje);
		
	}

	@Override
	public float getPrecioDeCosto() {
		// TODO Auto-generated method stub
		return (PRECIO_FAINA *getCantFaina())+(super.getCostoDeProduccion()*getTamanio().getPorcentaje());
	}

	@Override
	public TipoPizza tipo() {
		// TODO Auto-generated method stub
		return TipoPizza.ESPECIAL;
	}
	
	
	
	
}
