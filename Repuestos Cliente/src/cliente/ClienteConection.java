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
package cliente;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import comun.RootAndIp;
import comun.GestionarPieza.IControlPieza;

public class ClienteConection {
	
	//Se deben poner como atributos todos los controladores que se quieran cargar
	private IControlPieza controlPieza = null;

	public ClienteConection (){
	}

	public void iniciar() throws Exception {

		comun.RootAndIp.setConf("");
        String ip = RootAndIp.getIp_cliente();
        int port = RootAndIp.getPort();
		
        Registry Naming = LocateRegistry.getRegistry(ip,port);
		String nombreServer = "";
		
		nombreServer = "rmi://" + ip + "/IControlPieza";
		setControlTest((IControlPieza)Naming.lookup(nombreServer));
		
		//Aca se deben cargar todos los demas controles
	}

	
	public IControlPieza getControlPieza() {
		return controlPieza;
	}

	public void setControlTest(IControlPieza controlPieza) {
		this.controlPieza = controlPieza;
	}

}
