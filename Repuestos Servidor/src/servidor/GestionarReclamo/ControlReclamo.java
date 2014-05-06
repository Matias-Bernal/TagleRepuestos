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
package servidor.GestionarReclamo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import servidor.Assemblers.ReclamoAssembler;
import servidor.Persistencia.AccesoBD;
import servidor.Persistencia.Dominio.Reclamo;
import comun.DTOs.ReclamoDTO;
import comun.GestionarReclamo.IControlReclamo;



public class ControlReclamo extends UnicastRemoteObject implements
		IControlReclamo {

	private static final long serialVersionUID = 1L;

	public ControlReclamo() throws RemoteException {
		super();
	}

	@Override
	public Long agregarReclamo(ReclamoDTO reclamoDTO) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Long id = new Long(0);
		try {
			accesoBD.iniciarTransaccion();
			ReclamoAssembler reclamoAssemb = new ReclamoAssembler(accesoBD);
			Reclamo reclamo = reclamoAssemb.getReclamoNuevo(reclamoDTO);
			accesoBD.hacerPersistente(reclamo);
			id = reclamo.getId();
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return id;
	}

	@Override
	public void eliminarReclamo(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			ReclamoAssembler reclamoAssemb = new ReclamoAssembler(accesoBD);
			Reclamo reclamo = reclamoAssemb.getReclamo(buscarReclamo(id));
			accesoBD.eliminar(reclamo);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
	}

	@Override
	public void modificarReclamo(Long id, ReclamoDTO modificado) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		try {
			accesoBD.iniciarTransaccion();
			ReclamoAssembler reclamoAssemb = new ReclamoAssembler(accesoBD);
			Reclamo reclamo = reclamoAssemb.getReclamo(buscarReclamo(id));
			
			reclamo.setDescripcion(modificado.getDescripcion());
			reclamo.setFecha_reclamo(modificado.getFecha_reclamo());
	
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}

	}

	@Override
	public Vector<ReclamoDTO> obtenerReclamos() throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		Vector<ReclamoDTO> reclamosDTO = new Vector<ReclamoDTO>();
		try {
			accesoBD.iniciarTransaccion();
			@SuppressWarnings("unchecked")
			Vector<Reclamo> reclamos = new Vector<Reclamo> (accesoBD.buscarPorFiltro(Reclamo.class, ""));
			for (int i = 0; i < reclamos.size(); i++) {
				ReclamoDTO reclamoDTO = new ReclamoDTO();

				reclamoDTO.setId(reclamos.elementAt(i).getId());
				reclamoDTO.setDescripcion(reclamos.elementAt(i).getDescripcion());
				reclamoDTO.setFecha_reclamo(reclamos.elementAt(i).getFecha_reclamo());
				
				reclamosDTO.add(reclamoDTO);
			}
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return reclamosDTO;
	}

	
	@Override
	public boolean existeReclamo(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		boolean existe = false;
		try {
			accesoBD.iniciarTransaccion();
			existe = ((Reclamo) accesoBD.buscarPorId(Reclamo.class, id) != null);
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return existe;
	}

	
	@Override
	public ReclamoDTO buscarReclamo(Long id) throws Exception {
		AccesoBD accesoBD = new AccesoBD();
		ReclamoDTO reclamoDTO = null;
		try {
			accesoBD.iniciarTransaccion();
			ReclamoAssembler reclamoAssemb = new ReclamoAssembler(accesoBD);
			reclamoDTO = reclamoAssemb.getReclamoDTO((Reclamo) accesoBD.buscarPorId(Reclamo.class, id));
			accesoBD.concretarTransaccion();
		} catch (Exception e) {
			accesoBD.rollbackTransaccion();
		}
		return reclamoDTO;
	}

}