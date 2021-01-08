import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.tree.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class Descarga extends SwingWorker<Void, Integer> {

    DefaultMutableTreeNode title;
    private static HttpURLConnection connection;
    private final String inicio, hasta, order, limite;
    private final String magnitudMIN, magnitudMAX;
    JScrollPane Scroll;
    JTree arbol;
    JPanel panel;
    JLabel estado;
    Proceso proc = new Proceso();
    String json;
    private boolean detenido = false;
    VentanaPrincipal gui = new VentanaPrincipal();

    public Descarga(String start, String end, String mag, String magMax, String order, String limit, JTree arbol, JLabel estado) {
        this.inicio = start;
        this.hasta = end;
        this.magnitudMIN = mag;
        this.order = order;
        this.limite = limit;
        this.arbol = arbol;
        this.estado = estado;
        this.magnitudMAX = magMax;
    }

    @Override
    public Void doInBackground() {
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        try {
            URL url = new URL("https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=+" + inicio
                    + "&endtime=" + hasta + "&minmagnitude=" + magnitudMIN + "&maxmagnitude=" + magnitudMAX + "&orderby=" + order + "&limit=" + limite);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }

            json = responseContent.toString();

            DefaultMutableTreeNode principal = new DefaultMutableTreeNode("Terremotos");

            JSONObject earthquake = new JSONObject(json);
            JSONArray terre = earthquake.getJSONArray("features");
            estado.setText("Descargando...");
            for (int i = 0; i < terre.length(); i++) {
                Thread.sleep(100);
                setProgress(100 * (i + 1) / terre.length());
                JSONObject terr = terre.getJSONObject(i);
                JSONObject pro = terr.getJSONObject("properties");

                DefaultTreeModel modelo = new DefaultTreeModel(principal);
                
                DefaultMutableTreeNode fecha = new DefaultMutableTreeNode(proc.getDateString(pro.getLong("time")));
                DefaultMutableTreeNode magnitud = new DefaultMutableTreeNode("M " + pro.getDouble("mag"));
                DefaultMutableTreeNode title = new DefaultMutableTreeNode(pro.getString("title"));
                DefaultMutableTreeNode tiMag = new DefaultMutableTreeNode("Tipo de Magnitud: " + pro.getString("magType"));
                DefaultMutableTreeNode tiplace = new DefaultMutableTreeNode("Ubicación: " + pro.getString("place"));
                DefaultMutableTreeNode tidate = new DefaultMutableTreeNode("Fecha de Actualización: " + proc.getDateString(pro.getLong("updated")));
                DefaultMutableTreeNode tiurlt = new DefaultMutableTreeNode("URL: " + pro.getString("url"));

                modelo.insertNodeInto(tiMag, title, 0);
                modelo.insertNodeInto(tiplace, title, 1);
                modelo.insertNodeInto(tidate, title, 2);
                modelo.insertNodeInto(tiurlt, title, 3);
                magnitud.add(title);
                fecha.add(magnitud);
                principal.add(fecha);
                
                arbol.setModel(modelo);
            }
        } catch (MalformedURLException e) {
            System.out.println("Error de URL");
            estado.setForeground(new Color(255, 0, 0));
            estado.setText("Error al descargar los datos.");
            JOptionPane.showMessageDialog(null, "Error al descargar los datos, intente de nuevo. " + e.getMessage());
            detenido = true;
            cancel(true);
        } catch (IOException e) {
            System.out.println("Error de IO");
            estado.setForeground(new Color(255, 0, 0));
            estado.setText("Error al descargar los datos.");
            JOptionPane.showMessageDialog(null, "Error al descargar los datos, intente de nuevo. " + e.getMessage());
            detenido = true;
            cancel(true);
        } catch (InterruptedException ex) {
        }

        return null;
    }

    protected void done() {
        if (!isCancelled() && detenido == false) {
            estado.setForeground(new Color(0, 255, 0));
            estado.setText("Descargado.");
            JOptionPane.showMessageDialog(null, "Datos descargados Exitosamente.");
            cancel(true);
        } else if (isCancelled()) {
            estado.setForeground(new Color(255, 0, 0));
            estado.setText("Cancelado.");
            JOptionPane.showMessageDialog(null, "Descarga Cancelada.");
        }
    }
}
