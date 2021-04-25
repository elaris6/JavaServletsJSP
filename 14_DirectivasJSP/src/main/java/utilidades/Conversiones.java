package utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversiones {

    private static final String FORMATO_FECHA = "dd-MM-YYYY";

    public static String formateaFecha(Date fecha) {

        SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(fecha);
    }

    public static String formateaFecha(String fecha) {

        SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(fecha);
    }

}
