import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;

public class Proceso {
    public String getFecha(JDateChooser jd) {
        SimpleDateFormat Formato = new SimpleDateFormat("yyyy-MM-dd");
        if (jd.getDate() != null) {
            return Formato.format(jd.getDate());
        } else {
            return null;
        }
    }

    public String getDateString(long timeInMilliseconds) {
        SimpleDateFormat formatter = new SimpleDateFormat("EE', 'dd-MMM-yyyy' a las 'h:mm:ss a, z");
        return formatter.format(timeInMilliseconds);
    }
        
}
