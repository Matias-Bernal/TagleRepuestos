/********************************************************
 This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *********************************************************/
package comun.DTOs;

import java.io.Serializable;
import java.sql.Date;

public class SolicitudDTO implements Serializable{

	protected static final long serialVersionUID = 1L;
	protected Long id;
	protected Date fecha_solicitud_solicitante;
	protected Date fecha_solicitud_proveedor;
	protected Date fecha_recepcion_proveedor;
	protected boolean stock_propio;
	protected boolean stock_fabrica;
	protected int cantidad;
	protected String orden_trabajo;
	protected String dominio;
	protected String numero_pedido;
	protected String estado;
	protected String cargo;
		
	protected SolicitanteDTO solicitante;
	protected UsuarioRepuestoDTO usuario_repuesto;
	protected PiezaDTO pieza;
	protected ProveedorDTO proveedor;
	
	public SolicitudDTO(){}
	
	public SolicitudDTO(Long id, Date fecha_solicitud_solicitante,
			Date fecha_solicitud_proveedor, Date fecha_recepcion_proveedor,
			boolean stock_propio, boolean stock_fabrica, int cantidad,
			String orden_trabajo, String dominio, String numero_pedido,
			String estado, String cargo, SolicitanteDTO solicitante,
			UsuarioRepuestoDTO usuario_repuesto, PiezaDTO pieza,
			ProveedorDTO proveedor) {
		super();
		this.id = id;
		this.fecha_solicitud_solicitante = fecha_solicitud_solicitante;
		this.fecha_solicitud_proveedor = fecha_solicitud_proveedor;
		this.fecha_recepcion_proveedor = fecha_recepcion_proveedor;
		this.stock_propio = stock_propio;
		this.stock_fabrica = stock_fabrica;
		this.cantidad = cantidad;
		this.orden_trabajo = orden_trabajo;
		this.dominio = dominio;
		this.numero_pedido = numero_pedido;
		this.estado = estado;
		this.cargo = cargo;
		this.solicitante = solicitante;
		this.usuario_repuesto = usuario_repuesto;
		this.pieza = pieza;
		this.proveedor = proveedor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha_solicitud_solicitante() {
		return fecha_solicitud_solicitante;
	}

	public void setFecha_solicitud_solicitante(Date fecha_solicitud_solicitante) {
		this.fecha_solicitud_solicitante = fecha_solicitud_solicitante;
	}

	public Date getFecha_solicitud_proveedor() {
		return fecha_solicitud_proveedor;
	}

	public void setFecha_solicitud_proveedor(Date fecha_solicitud_proveedor) {
		this.fecha_solicitud_proveedor = fecha_solicitud_proveedor;
	}

	public Date getFecha_recepcion_proveedor() {
		return fecha_recepcion_proveedor;
	}

	public void setFecha_recepcion_proveedor(Date fecha_recepcion_proveedor) {
		this.fecha_recepcion_proveedor = fecha_recepcion_proveedor;
	}

	public boolean isStock_propio() {
		return stock_propio;
	}

	public void setStock_propio(boolean stock_propio) {
		this.stock_propio = stock_propio;
	}

	public boolean isStock_fabrica() {
		return stock_fabrica;
	}

	public void setStock_fabrica(boolean stock_fabrica) {
		this.stock_fabrica = stock_fabrica;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getOrden_trabajo() {
		return orden_trabajo;
	}

	public void setOrden_trabajo(String orden_trabajo) {
		this.orden_trabajo = orden_trabajo;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public String getNumero_pedido() {
		return numero_pedido;
	}

	public void setNumero_pedido(String numero_pedido) {
		this.numero_pedido = numero_pedido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public SolicitanteDTO getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(SolicitanteDTO solicitante) {
		this.solicitante = solicitante;
	}

	public UsuarioRepuestoDTO getUsuario_repuesto() {
		return usuario_repuesto;
	}

	public void setUsuario_repuesto(UsuarioRepuestoDTO usuario_repuesto) {
		this.usuario_repuesto = usuario_repuesto;
	}

	public PiezaDTO getPieza() {
		return pieza;
	}

	public void setPieza(PiezaDTO pieza) {
		this.pieza = pieza;
	}

	public ProveedorDTO getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorDTO proveedor) {
		this.proveedor = proveedor;
	}

}
