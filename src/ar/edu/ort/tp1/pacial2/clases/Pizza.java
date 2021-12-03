package ar.edu.ort.tp1.pacial2.clases;

public abstract class Pizza implements Mostrable {

	private static final String MSG_GANANCIA_INVALIDA = "Ganancia inválida";
	private static final String MSG_COSTO_INVALIDO = "Costo inválido";
	private static final String MSG_NOMBRE_INVALIDO = "Nombre inválido";
	//TODO A completar
	private String 	nombre;
	private float 	costoDeProduccion;
	private float 	porcentajeGanancia;

	public Pizza(String nombre, float costoDeProduccion, float porcentajeGanancia) {
		//TODO A completar
		this.setNombre(nombre);
		this.setCostoDeProduccion(costoDeProduccion);
		this.setPorcentajeGanancia(porcentajeGanancia);
	}

	//TODO A completar
	public abstract float getPrecioDeCosto();

	private void setNombre(String nombre) {
		if (nombre == null || nombre.isBlank()) {
			throw new IllegalArgumentException(MSG_NOMBRE_INVALIDO);
		}
		this.nombre = nombre;
	}

	private void setCostoDeProduccion(float costoDeProduccion) {
		if (costoDeProduccion <= 0) {
			throw new IllegalArgumentException(MSG_COSTO_INVALIDO);
		}
		this.costoDeProduccion = costoDeProduccion;
	}

	private void setPorcentajeGanancia(float porcentajeGanancia) {
		if (porcentajeGanancia < 0) {
			throw new IllegalArgumentException(MSG_GANANCIA_INVALIDA);
		}
		this.porcentajeGanancia = porcentajeGanancia;
	}

	public float getPrecioDeVenta() {
		//TODO A completar
		float costo = this.getPrecioDeCosto();
		return costo + (this.porcentajeGanancia * costo / 100);
	}


	protected float getCostoDeProduccion() {
		return costoDeProduccion;
	}

	public String getNombre() {
		return nombre;
	}
	
	public abstract TipoPizza tipo();
	
}
