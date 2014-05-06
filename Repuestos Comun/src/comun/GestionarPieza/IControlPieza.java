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
package comun.GestionarPieza;

import java.rmi.Remote;
import java.util.Vector;

import comun.DTOs.PiezaDTO;

public interface IControlPieza extends Remote{
	
	public Long agregarPieza(PiezaDTO piezaDTO)throws Exception;
	public void eliminarPieza(Long id)throws Exception;
	public void modificarPieza(Long id,PiezaDTO modificado)throws Exception;
	
	public Vector<PiezaDTO> obtenerPiezas()throws Exception;
	public Vector<PiezaDTO> obtenerPiezas(String numero_pieza)throws Exception;
	
	public boolean existePieza(Long id) throws Exception;
	public boolean existePieza(String numero_pieza) throws Exception;

	public PiezaDTO buscarPieza(Long id) throws Exception;
	public PiezaDTO buscarPieza(String numero_pieza) throws Exception;
	
}