
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
import java.text.*;
import java.util.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class VentanaPrincipal extends JFrame {

    private JPanel Busqueda, Resultado, Listas;
    private JLabel Logo, Logo2, Logo3, Titulo, Titulo2, Titulo3, eFechas, eFechas2, eMag, eOrden, eRes, eRes1, eMagMAX;
    private JButton descargarDatos, cancelarDescarga;
    private JDateChooser fecha1, fecha2;
    public JProgressBar descarga;
    private JSlider slideMagnitudMIN, slideMagnitudMAX;
    private ButtonGroup grupo;
    private JRadioButton orMagnitude;
    private JRadioButton orMagnitudeAsc;
    private JRadioButton orNone;
    private JRadioButton orTime;
    private JLabel eLimite;
    private JTextField limite;
    private JRadioButton orTimeAsc;
    public JTree Tree;
    private JScrollPane Scroll;
    public JLabel Estado;
    private javax.swing.JList<String> Lista;
    private javax.swing.JScrollPane Scroll2;
    Proceso proc = new Proceso();

    public VentanaPrincipal() {
        super("United States Geological Survey");
        setIconImage(new ImageIcon("src/images/LOGO (1).png").getImage());
        JTabbedPane panelFichas = new JTabbedPane();

        //PAGINA 1
        Busqueda = new JPanel();
        fecha1 = new JDateChooser();
        fecha2 = new JDateChooser();
        Titulo = new JLabel();
        Logo = new JLabel();
        slideMagnitudMIN = new JSlider(0, 10, 0);
        slideMagnitudMAX = new JSlider(0, 10, 10);
        eFechas = new JLabel();
        eFechas2 = new JLabel();
        eMag = new JLabel();
        eMagMAX = new JLabel();
        grupo = new ButtonGroup();
        orTime = new JRadioButton();
        orTimeAsc = new JRadioButton();
        orMagnitude = new JRadioButton();
        orMagnitudeAsc = new JRadioButton();
        orNone = new JRadioButton();
        eOrden = new JLabel();
        descarga = new JProgressBar();
        cancelarDescarga = new JButton();
        descargarDatos = new JButton();
        limite = new JTextField();
        eLimite = new JLabel();
        Estado = new JLabel();
        
        Busqueda.setBackground(new Color(255, 255, 255));
        Busqueda.setLayout(new AbsoluteLayout());

        fecha1.setBackground(new Color(255, 255, 255));
        Busqueda.add(fecha1, new AbsoluteConstraints(171, 203, 321, -1));

        fecha2.setBackground(new Color(255, 255, 255));
        Busqueda.add(fecha2, new AbsoluteConstraints(538, 203, 321, -1));

        Titulo.setFont(new Font("Century Gothic", 1, 36));
        Titulo.setForeground(new Color(0, 113, 80));
        Titulo.setText("United States Geological Survey");
        Busqueda.add(Titulo, new AbsoluteConstraints(340, 72, -1, -1));

        Logo.setIcon(new ImageIcon("src/images/LOGO (1).png"));
        Busqueda.add(Logo, new AbsoluteConstraints(100, 57, -1, -1));

        slideMagnitudMIN.setBackground(new Color(255, 255, 255));
        slideMagnitudMIN.setPaintTicks(true);
        slideMagnitudMIN.setPaintLabels(true);
        slideMagnitudMIN.setMajorTickSpacing(1);
        Busqueda.add(slideMagnitudMIN, new AbsoluteConstraints(260, 285, 516, -1));

        slideMagnitudMAX.setBackground(new Color(255, 255, 255));
        slideMagnitudMAX.setPaintTicks(true);
        slideMagnitudMAX.setPaintLabels(true);
        slideMagnitudMAX.setMajorTickSpacing(1);
        Busqueda.add(slideMagnitudMAX, new AbsoluteConstraints(260, 360, 516, -1));

        eMagMAX.setFont(new Font("Century Gothic", 1, 18));
        eMagMAX.setForeground(new Color(0, 0, 0));
        eMagMAX.setText("Magnitud Máxima:");
        Busqueda.add(eMagMAX, new AbsoluteConstraints(440, 330, -1, -1));

        eFechas.setFont(new Font("Century Gothic", 1, 18));
        eFechas.setForeground(new Color(0, 0, 0));
        eFechas.setText("Buscar terremotos ocurridos entre las fechas de:");
        Busqueda.add(eFechas, new AbsoluteConstraints(295, 155, -1, -1));

        eFechas2.setFont(new Font("Century Gothic", 1, 18));
        eFechas2.setForeground(new Color(0, 0, 0));
        eFechas2.setText("y");
        Busqueda.add(eFechas2, new AbsoluteConstraints(510, 203, -1, -1));

        eMag.setFont(new Font("Century Gothic", 1, 18));
        eMag.setForeground(new Color(0, 0, 0));
        eMag.setText("Magnitud Minima:");
        Busqueda.add(eMag, new AbsoluteConstraints(440, 250, -1, -1));

        orTime.setBackground(new Color(255, 255, 255));
        orTime.setFont(new Font("Century Gothic", 1, 14));
        orTime.setForeground(new Color(0, 0, 0));
        orTime.setText("time");
        Busqueda.add(orTime, new AbsoluteConstraints(280, 470, -1, -1));
        grupo.add(orTime);

        orTimeAsc.setBackground(new Color(255, 255, 255));
        orTimeAsc.setFont(new Font("Century Gothic", 1, 14));
        orTimeAsc.setForeground(new Color(0, 0, 0));
        orTimeAsc.setText("time-asc");
        Busqueda.add(orTimeAsc, new AbsoluteConstraints(360, 470, -1, -1));
        grupo.add(orTimeAsc);

        orMagnitude.setBackground(new Color(255, 255, 255));
        orMagnitude.setFont(new Font("Century Gothic", 1, 14));
        orMagnitude.setForeground(new Color(0, 0, 0));
        orMagnitude.setText("magnitud");
        Busqueda.add(orMagnitude, new AbsoluteConstraints(460, 470, -1, -1));
        grupo.add(orMagnitude);

        orMagnitudeAsc.setBackground(new Color(255, 255, 255));
        orMagnitudeAsc.setFont(new Font("Century Gothic", 1, 14));
        orMagnitudeAsc.setForeground(new Color(0, 0, 0));
        orMagnitudeAsc.setText("magnitud-asc");
        Busqueda.add(orMagnitudeAsc, new AbsoluteConstraints(570, 470, -1, -1));
        grupo.add(orMagnitudeAsc);

        orNone.setBackground(new Color(255, 255, 255));
        orNone.setFont(new Font("Century Gothic", 1, 14));
        orNone.setForeground(new Color(0, 0, 0));
        orNone.setText("none");
        Busqueda.add(orNone, new AbsoluteConstraints(700, 470, -1, -1));
        grupo.add(orNone);

        eOrden.setFont(new Font("Century Gothic", 1, 18));
        eOrden.setForeground(new Color(0, 0, 0));
        eOrden.setText("Ordenar por:");
        Busqueda.add(eOrden, new AbsoluteConstraints(460, 440, -1, -1));

        descarga.setMaximumSize(new Dimension(32767, 20));
        descarga.setStringPainted(true);
        Busqueda.add(descarga, new AbsoluteConstraints(270, 530, 497, -1));

        cancelarDescarga.setIcon(new ImageIcon("src/images/Cancelar_OFF.png"));
        cancelarDescarga.setBorder(null);
        cancelarDescarga.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancelarDescarga.setRolloverIcon(new ImageIcon("src/images/Cancelar_ON.png"));
        cancelarDescarga.setRolloverSelectedIcon(new ImageIcon("src/images/Cancelar_ON.png"));
        cancelarDescarga.setSelectedIcon(new ImageIcon("src/images/Cancelar_ON.png"));
        Busqueda.add(cancelarDescarga, new AbsoluteConstraints(570, 560, -1, -1));

        descargarDatos.setIcon(new ImageIcon("src/images/Descargar_OFF.png"));
        descargarDatos.setBorder(null);
        descargarDatos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        descargarDatos.setRolloverIcon(new ImageIcon("src/images/Descargar_ON.png"));
        descargarDatos.setRolloverSelectedIcon(new ImageIcon("src/images/Descargar_ON.png"));
        descargarDatos.setSelectedIcon(new ImageIcon("src/images/Descargar_ON.png"));
        descargarDatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    descargarDatosActionPerformed(evt);
                } catch (Exception ex) {

                }
            }
        });
        Busqueda.add(descargarDatos, new AbsoluteConstraints(270, 560, -1, -1));

        limite.setBackground(new Color(255, 255, 255));
        limite.setFont(new Font("Century Gothic", 0, 12));
        limite.setForeground(new Color(0, 0, 0));
        limite.setText("100");
        limite.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                limiteKeyTyped(evt);
            }
        });
        Busqueda.add(limite, new AbsoluteConstraints(530, 410, 240, 23));

        eLimite.setFont(new Font("Century Gothic", 1, 18));
        eLimite.setForeground(new Color(0, 0, 0));
        eLimite.setText("Limitar cantidad de datos a: ");
        Busqueda.add(eLimite, new AbsoluteConstraints(270, 410, -1, -1));

        Estado.setFont(new Font("Century Gothic", 0, 12));
        Estado.setForeground(new Color(0, 0, 0));
        Estado.setText("");
        Busqueda.add(Estado, new AbsoluteConstraints(270, 500, -1, -1));

       
        panelFichas.addTab("Busqueda", null, Busqueda, "Establece los Parametros de Búsqueda");

        //PAGINA 2
        Resultado = new JPanel();
        Logo2 = new JLabel();
        Titulo2 = new JLabel();
        eRes = new JLabel();
        DefaultMutableTreeNode e = new DefaultMutableTreeNode("Esperando Resultados...");
        DefaultTreeModel limpio = new DefaultTreeModel(e);
        Tree = new JTree(limpio);
        Scroll = new JScrollPane();

        Resultado.setBackground(new Color(255, 255, 255));
        Resultado.setLayout(new AbsoluteLayout());

        Logo2.setIcon(new ImageIcon("src/images/LOGO (1).png"));
        Resultado.add(Logo2, new AbsoluteConstraints(100, 57, -1, -1));

        Titulo2.setFont(new Font("Century Gothic", 1, 36));
        Titulo2.setForeground(new Color(0, 113, 80));
        Titulo2.setText("United States Geological Survey");
        Resultado.add(Titulo2, new AbsoluteConstraints(340, 72, -1, -1));

        eRes.setFont(new Font("Century Gothic", 1, 18));
        eRes.setForeground(new Color(0, 0, 0));
        eRes.setText("Resultados de la búsqueda:");
        Resultado.add(eRes, new AbsoluteConstraints(392, 160, -1, -1));

        Tree.setBackground(new Color(255, 255, 255));
        Tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                String s = "";
                DefaultMutableTreeNode nodoSeleccionado;
                nodoSeleccionado = (DefaultMutableTreeNode) Tree.getLastSelectedPathComponent();

                DefaultListModel listado = new DefaultListModel();
                TreePath rutaSeleccionada = e.getPath();
                Object[] nodos = rutaSeleccionada.getPath();

                for (int i = 0; i < nodos.length; i++) {
                    Object nodo = nodos[i];
                    s += nodo.toString() + " / ";
                    s += "\n";
                    listado.addElement(s);
                }

                Lista.setModel(listado);
            }
        });
        Scroll.setViewportView(Tree);
        Resultado.add(Scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 201, 800, -1));
        panelFichas.addTab("Resultados de Busqueda", null, Resultado, "Muestra los resultados obtenidos");

        //PAGINA 3
        Listas = new JPanel();
        Logo3 = new JLabel();
        Titulo3 = new JLabel();
        eRes1 = new JLabel();
        Scroll2 = new JScrollPane();
        Lista = new javax.swing.JList<>();

        Listas.setBackground(new java.awt.Color(255, 255, 255));
        Listas.setLayout(new AbsoluteLayout());

        Logo3.setIcon(new ImageIcon("src/images/LOGO (1).png"));
        Listas.add(Logo3, new AbsoluteConstraints(100, 57, -1, -1));

        Titulo3.setFont(new Font("Century Gothic", 1, 36));
        Titulo3.setForeground(new Color(0, 113, 80));
        Titulo3.setText("United States Geological Survey");
        Listas.add(Titulo3, new AbsoluteConstraints(340, 72, -1, -1));

        eRes1.setFont(new Font("Century Gothic", 1, 18));
        eRes1.setForeground(new Color(0, 0, 0));
        eRes1.setText("Nodos Seleccionados:");
        Listas.add(eRes1, new AbsoluteConstraints(392, 160, -1, -1));

        Lista.setBackground(new Color(255, 255, 255));
        Lista.setFont(new Font("Century Gothic", 1, 14)); // NOI18N
        Lista.setForeground(new Color(0, 0, 0));
        Scroll2.setViewportView(Lista);

        Listas.add(Scroll2, new AbsoluteConstraints(40, 197, 890, 370));
        panelFichas.addTab("Rutas Seleccionadas", null, Listas, "Muestra la ruta de los Nodos Seleccionados en el arbol de Resultados");
        add(panelFichas);

    }

    private void limiteKeyTyped(KeyEvent evt) {
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresar solo valores numéricos.");
        }
    }

    private void descargarDatosActionPerformed(ActionEvent evt) throws Exception {
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdformat.parse(proc.getFecha(fecha1));
        Date date2 = sdformat.parse(proc.getFecha(fecha2));
        if (slideMagnitudMIN.getValue() > slideMagnitudMAX.getValue()) {
            JOptionPane.showMessageDialog(null, "El valor de la Magnitud Minima(" + slideMagnitudMIN.getValue()
                    + ") no puede ser mayor a la Magnitud Máxima(" + slideMagnitudMAX.getValue() + ")");
        } else if (proc.getFecha(fecha1).equals("null") && proc.getFecha(fecha2).equals("null")) {
            JOptionPane.showMessageDialog(null, "Ingrese fechas válidas");
        } else if (date1.after(date2)) {
            JOptionPane.showMessageDialog(null, "La fecha " + proc.getFecha(fecha1) + " no puede ser después de la fecha " + proc.getFecha(fecha2));
        } else if (limite.getText().equals("0")) {
            JOptionPane.showMessageDialog(null, "0 no es un número válido.");
        } else {
            descarga.setValue(0);
            Estado.setForeground(new Color(0, 0, 0));
            Estado.setText("Espere...");
            DefaultMutableTreeNode e = new DefaultMutableTreeNode("Esperando Resultados...");
            DefaultTreeModel limpio = new DefaultTreeModel(e);
            Tree.setModel(limpio);
            DefaultListModel listaLimpia = new DefaultListModel();
            listaLimpia.addElement("");
            Lista.setModel(listaLimpia);
            String ordenamiento = "";
            if (orTime.isSelected()) {
                ordenamiento = "time";
            } else if (orTimeAsc.isSelected()) {
                ordenamiento = "time-asc";
            } else if (orMagnitude.isSelected()) {
                ordenamiento = "magnitude";
            } else if (orMagnitudeAsc.isSelected()) {
                ordenamiento = "magnitude-asc";
            } else if (orNone.isSelected()) {
                ordenamiento = "";
            } else {
                ordenamiento = "";
            }
            System.out.println(proc.getFecha(fecha1) + " a " + proc.getFecha(fecha2) + " magnitud minima de " + String.valueOf(slideMagnitudMIN.getValue())
                    + " magnitud maxima de " + String.valueOf(slideMagnitudMAX.getValue()) + " en orden " + ordenamiento + " limitado a " + limite.getText());

            Descarga dw = new Descarga(proc.getFecha(fecha1), proc.getFecha(fecha2), String.valueOf(slideMagnitudMIN.getValue()),
                    String.valueOf(slideMagnitudMAX.getValue()), ordenamiento, limite.getText(), Tree, Estado);

            dw.addPropertyChangeListener(
                    new PropertyChangeListener() {
                public void propertyChange(PropertyChangeEvent e) {
                    if (e.getPropertyName().equals("progress")) {
                        int nuevoValor = (Integer) e.getNewValue();
                        descarga.setValue(nuevoValor);

                    }
                }
            });
            dw.execute();

            cancelarDescarga.addActionListener(
                    new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dw.cancel(true);
                }
            });
        }
    }

}
