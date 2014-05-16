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

import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class GUIMenu_Principal extends JFrame{

	private static final long serialVersionUID = 1L;
	private MediadorPrincipal mediadorPrincipal;
	private JFrame frmPrincipal;
	private JTable tablaNotificaciones;
	private Vector<Integer> anchos;
	private DefaultTableModel modelo;
	private Vector<Vector<String>> datosTabla;
	private Vector<String> nombreColumnas;
	
	public GUIMenu_Principal(MediadorPrincipal mediadorPrincipal) {
		this.mediadorPrincipal= mediadorPrincipal;
		cargarDatos();
		initialize();
	}

	private void cargarDatos() {
		nombreColumnas = new Vector<String>();
		anchos = new Vector<Integer>();
		nombreColumnas.add("TIPO");
		anchos.add(150);
		nombreColumnas.add("DETALLES");
		anchos.add(425);
		datosTabla = new Vector<Vector<String>>();
	}

	private void initialize() {
		
		setLocationRelativeTo(null);
		
		frmPrincipal = new JFrame();
		frmPrincipal.getContentPane().setBackground(UIManager.getColor("window"));
		frmPrincipal.setResizable(false);
		frmPrincipal.setLocationRelativeTo(null);

		String titulo = "USUARIO: "+mediadorPrincipal.getUsuario_repuesto().getNombre_usuario().toString() +" [ID: "+mediadorPrincipal.getUsuario_repuesto().getId().toString()+" ]";
		frmPrincipal.setTitle(titulo);
		frmPrincipal.setBounds(100, 100, 1100, 570);		
		frmPrincipal.setDefaultCloseOperation (JFrame.DO_NOTHING_ON_CLOSE);

		frmPrincipal.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				int eleccion = JOptionPane.showConfirmDialog(null, "Desea salir?","Salir",0,0,new ImageIcon(GUIMenu_Principal.class.getResource("/cliente/Recursos/Iconos/exit_login.png")));
				if ( eleccion == 0) {
					System.exit(0);
				}	
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		frmPrincipal.setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		JMenuItem mntmDesconectar = new JMenuItem("Desconectar");
		mntmDesconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				mediadorPrincipal.reiniciar();
			}
		});
		mnInicio.add(mntmDesconectar);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				mediadorPrincipal.salir();
			}
		});
		mnInicio.add(mntmSalir);
		
		
		// MENU USUARIOS //
		JMenu mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmAltaUsuario = new JMenuItem("Alta Usuario");

		mntmAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mediadorPrincipal.altaUsuario();
			}
		});
		mnUsuarios.add(mntmAltaUsuario);
		
		JMenuItem mntmGestionUsuario = new JMenuItem("Gestionar Usuarios");
		mntmGestionUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mediadorPrincipal.gestionarUsuario();
			}
		});
		mnUsuarios.add(mntmGestionUsuario);
		
		// MENU REGISTRANTES //
		JMenu mnRegistrantes = new JMenu("Registrantes");
		menuBar.add(mnRegistrantes);
		
		JMenuItem mntmAltaRegistrante = new JMenuItem("Alta Registrante");
		mntmAltaRegistrante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				//mediadorPrincipal.altaRegistrante();
			}
		});
		mnRegistrantes.add(mntmAltaRegistrante);
		
		JMenuItem mntmGestionRegistrante = new JMenuItem("Gestionar Registrantes");
		mntmGestionRegistrante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				//mediadorPrincipal.gestionarRegistrante();
			}
		});
		mnRegistrantes.add(mntmGestionRegistrante);
		
		JMenu mnReclamantes = new JMenu("Reclamantes");
		menuBar.add(mnReclamantes);
		
		JMenuItem mntmAltaReclamante = new JMenuItem("Alta Reclamante");
		mntmAltaReclamante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				//mediadorPrincipal.altaReclamante();
			}
		});
		mnReclamantes.add(mntmAltaReclamante);
		
		JMenuItem mntmGestionReclamante = new JMenuItem("Gestionar Reclamantes");
		mntmGestionReclamante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				//mediadorPrincipal.gestionarReclamante();
			}
		});
		mnReclamantes.add(mntmGestionReclamante);
		
		JMenu mnVehiculos = new JMenu("Vehiculos");
		menuBar.add(mnVehiculos);
		
		JMenuItem mntmAltaVehiculo = new JMenuItem("Alta Vehiculo");
		mntmAltaVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				//mediadorPrincipal.altaVehiculo();
			}
		});
		mnVehiculos.add(mntmAltaVehiculo);
		
		JMenuItem mntmGestionVehiculo = new JMenuItem("Gestionar Vehiculos");
		mntmGestionVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				//mediadorPrincipal.gestionarVehiculo();
			}
		});
		mnVehiculos.add(mntmGestionVehiculo);
		
		JMenu mnOrden = new JMenu("Ordenes");
		menuBar.add(mnOrden);
		
		JMenuItem mntmAltaOrden = new JMenuItem("Alta Orden");
		mntmAltaOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				//mediadorPrincipal.altaOrden();
			}
		});
		mnOrden.add(mntmAltaOrden);
		
		JMenuItem mntmGestionOrden = new JMenuItem("Gestion Orden");
		mntmGestionOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				//mediadorPrincipal.gestionarOrden();
			}
		});
		mnOrden.add(mntmGestionOrden);
		
		JMenu mnReclamos = new JMenu("Reclamos");
		menuBar.add(mnReclamos);
		
		JMenuItem mntmAltaReclamoAgente = new JMenuItem("Alta Reclamo Agente");
		mntmAltaReclamoAgente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				//mediadorPrincipal.altaReclamoAgente();
			}
		});
		mnReclamos.add(mntmAltaReclamoAgente);
		
		JMenuItem mntmGestionReclamoAgente = new JMenuItem("Gestionar Reclamos Agente");
		mntmGestionReclamoAgente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				//mediadorPrincipal.gestionarReclamoAgente();
			}
		});
		
		JMenuItem mntmAltaReclamoEntidad = new JMenuItem("Alta Reclamo Entidad");
		mntmAltaReclamoEntidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				//mediadorPrincipal.altaReclamoEntidad();
			}
		});
		mnReclamos.add(mntmAltaReclamoEntidad);
		mnReclamos.add(mntmGestionReclamoAgente);
		
		JMenuItem mntmGestionarReclamosEntidad = new JMenuItem("Gestionar Reclamos Entidad");
		mntmGestionarReclamosEntidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				//mediadorPrincipal.gestionarReclamoEntidad();
			}
		});
		mnReclamos.add(mntmGestionarReclamosEntidad);
		
		JMenu mnPedido = new JMenu("Pedidos");
		menuBar.add(mnPedido);
		
		JMenuItem mntmAltaPedidoAgente = new JMenuItem("Alta Pedido Agente");
		mntmAltaPedidoAgente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				//mediadorPrincipal.altaPedidoAgente();
			}
		});
		mnPedido.add(mntmAltaPedidoAgente);
		
		JMenuItem mntmGestionPedidoAgentes = new JMenuItem("Gestionar Pedidos Agentes");
		mntmGestionPedidoAgentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				//mediadorPrincipal.gestionarPedidoAgente();
			}
		});
		
		JMenuItem mntmNuevoPedidoEntidad = new JMenuItem("Alta Pedido Entidad");
		mntmNuevoPedidoEntidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				//mediadorPrincipal.altaPedidoEntidad();
			}
		});
		mnPedido.add(mntmNuevoPedidoEntidad);
		mnPedido.add(mntmGestionPedidoAgentes);
		
		JMenuItem mntmGestionPedidoEntidad = new JMenuItem("Gestion Pedidos Entidades");
		mntmGestionPedidoEntidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				//mediadorPrincipal.gestionarPedidoEntidad();
			}
		});
		mnPedido.add(mntmGestionPedidoEntidad);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmManual = new JMenuItem("Manual");
		mntmManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mediadorPrincipal.ayuda();
			}
		});
		mnAyuda.add(mntmManual);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de..");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frmPrincipal,"IT10 Cooperativa - www.it10coop.com.ar","Acerca de..",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(GUIMenu_Principal.class.getResource("/cliente/Resources/Icons/it10.png")));
			}
		});
		mnAyuda.add(mntmAcercaDe);
		frmPrincipal.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(420, 40, 600, 450);
		frmPrincipal.getContentPane().add(panel);
		
		modelo = new DefaultTableModel(datosTabla, nombreColumnas);
		tablaNotificaciones = new JTable(modelo) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false,
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		tablaNotificaciones.setBackground(SystemColor.window);
		// Agregamos el ordenador para las tablas de los usuarios
		// TableRowSorter<TableModel> ordenador = new TableRowSorter<TableModel>(modelo);
		// tablaNotificaciones.setRowSorter(ordenador);
		tablaNotificaciones.getTableHeader().setReorderingAllowed(false);
		for(int i = 0; i < tablaNotificaciones.getColumnCount(); i++) {
			tablaNotificaciones.getColumnModel().getColumn(i).setPreferredWidth(anchos.elementAt(i));
			tablaNotificaciones.getColumnModel().getColumn(i).setMinWidth(anchos.elementAt(i));
		}
		tablaNotificaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaNotificaciones.setBounds(0, 0, 750, 320);
		tablaNotificaciones.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPaneTabla = new JScrollPane(tablaNotificaciones);
		scrollPaneTabla.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		tablaNotificaciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getClickCount() == 2)
					verNotificacion();
			    else{
			    	e.consume();
			    }   
			}
		});
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(scrollPaneTabla, BorderLayout.CENTER);
	}

	protected void verNotificacion() {
		int row = tablaNotificaciones.getSelectedRow();
		if (row >= 0) {
			//mediadorPrincipal.verNotificacion(row);
		}else{
			JOptionPane.showMessageDialog(tablaNotificaciones,"Seleccione una notificacion primero.","Advertencia",JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void setVisible(boolean b) {
		frmPrincipal.setVisible(b);
	}

	public MediadorPrincipal getMediadorPrincipal() {
		return mediadorPrincipal;
	}

	public void setMediadorPrincipal(MediadorPrincipal mediadorPrincipal) {
		this.mediadorPrincipal = mediadorPrincipal;
	}

	public void reiniciar() {
		setVisible(false);
	}

}
