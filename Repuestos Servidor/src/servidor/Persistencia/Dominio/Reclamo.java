package servidor.Persistencia.Dominio;

import java.sql.Date;

public class Reclamo {
			
	protected static final long serialVersionUID = 1L;
	protected Long id;
	protected Date fecha_reclamo;
	protected String descripcion;
	
	public Reclamo(){}
			
	public Reclamo(Date fecha_reclamo, String descripcion, Long id) {
		this.fecha_reclamo = fecha_reclamo;
		this.descripcion = descripcion;
		this.id = id;
	}
	
	public Date getFecha_reclamo() {
		return fecha_reclamo;
	}
	public void setFecha_reclamo(Date fecha_reclamo) {
		this.fecha_reclamo = fecha_reclamo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
