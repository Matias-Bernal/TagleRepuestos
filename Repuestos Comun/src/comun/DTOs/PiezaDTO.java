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

public class PiezaDTO implements Serializable{

	protected static final long serialVersionUID = 1L;
	protected Long id;
	protected String numero_pieza;
	protected String descripcion;

	public PiezaDTO(){}
			
	public PiezaDTO(Long id, String numero_pieza, String descripcion) {
		super();
		this.id = id;
		this.numero_pieza = numero_pieza;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumero_pieza() {
		return numero_pieza;
	}
	public void setNumero_pieza(String numero_pieza) {
		this.numero_pieza = numero_pieza;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
