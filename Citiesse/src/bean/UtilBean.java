package bean;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author italobruno
 */
@ManagedBean
@RequestScoped
public class UtilBean {

    public UtilBean() {
    }

    public String formatDate(Date date) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatter.format(date);
        } catch (Exception e) {
        }
        return null;
    }

    public String formatDateAndHour(Date date) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
        try {
            return formatter.format(date);
        } catch (Exception e) {
        }
        return null;
    }

    public String formatHour(Date date) {
        DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        try {
            return formatter.format(date);
        } catch (Exception e) {
        }
        return null;
    }

    public String formatPorcentagem(Double valor) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(valor * 100) + "%";
    }

    public String formatDouble(Double valor) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(valor);
    }
}
