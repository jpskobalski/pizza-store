package ar.edu.ort.tp1.pacial2.clases;

public class Rectangular extends Pizza{

	private static final float PRECIO_PORCION = 52;
	
	private int largo;
	private int ancho;
	private AdicionalQueso queso;
	
	public Rectangular(String nombre, float costoDeProduccion, float porcentajeGanancia, int largo, int ancho, AdicionalQueso queso) {
		super(nombre, costoDeProduccion, porcentajeGanancia);
		setLargo(largo);
		setAncho(ancho);
		setQueso(queso);
	}

	public int getLargo() {
		return largo;
	}

	private void setLargo(int largo) {
		this.largo = largo;
	}

	public int getAncho() {
		return ancho;
	}
	
	public int getCantPorciones() {
		return ancho*largo;
	}


	private void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public AdicionalQueso getQueso() {
		return queso;
	}

	private void setQueso(AdicionalQueso queso) {
		this.queso = queso;
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		String mensaje = tipo().name() +" - " +super.getNombre()+" - Precio de venta: " +super.getPrecioDeVenta()+" - "+getCantPorciones()+" Prociones - "+getQueso().name();
		System.out.println(mensaje);		
	}

	@Override
	public float getPrecioDeCosto() {
		// TODO Auto-generated method stub
		return (super.getCostoDeProduccion()+(getCantPorciones()*PRECIO_PORCION))*getQueso().getMultiplicadorQueso();
	}

	@Override
	public TipoPizza tipo() {
		// TODO Auto-generated method stub
		return TipoPizza.RECTANGULAR;
	}
	
	

}
