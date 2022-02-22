/*
 * Util.java
 * 
 */
package com.proyecto.web.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 * Class Util.
 *
 * @revision $Revision: 1.1 $$
 */
public final class UtilVista {

    public static UtilVista instance;
    static BigDecimal b100 = BigDecimal.ZERO, b50 = BigDecimal.ZERO, b20 = BigDecimal.ZERO, b10 = BigDecimal.ZERO, b5 = BigDecimal.ZERO, b2 = BigDecimal.ZERO, b1 = BigDecimal.ZERO;
    static BigDecimal m = BigDecimal.ZERO, m50 = BigDecimal.ZERO, m25 = BigDecimal.ZERO, m10 = BigDecimal.ZERO, m5 = BigDecimal.ZERO, m1 = BigDecimal.ZERO, total = BigDecimal.ZERO;

    /**
     * Instancia un nuevo util.
     */
    public UtilVista() {

    }

    public static Date sumarRestarDiasFecha(Date fecha, int dias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha); // Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
        return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos

    }

    public static String fomatoFechaXML(Date fecha) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(fecha);
    }

    public static Date primerDiaDelMes(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.getActualMinimum(Calendar.DAY_OF_MONTH),
                cal.getMinimum(Calendar.HOUR_OF_DAY), cal.getMinimum(Calendar.MINUTE), cal.getMinimum(Calendar.SECOND));

        return cal.getTime();

    }

    /**
     * Gets the single instance of Util.
     *
     * @return single instance of Util
     */
    public static UtilVista getInstance() {
        if (instance == null) {
            instance = new UtilVista();
        }
        return instance;
    }

    public static Integer obtenerAnio(final Date date) {

        if (null == date) {
            return 0;
        } else {
            String formato = "yyyy";
            SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
            return Integer.parseInt(dateFormat.format(date));

        }

    }

    public static int obtenerDia(final Date date) {

        if (null == date) {
            return 0;
        } else {
            String formato = "dd";
            SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
            return Integer.parseInt(dateFormat.format(date));

        }

    }

    public static Integer obtenerMes(final Date date) {
        if (null == date) {
            return 0;
        } else {
            String formato = "MM";
            SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
            return Integer.parseInt(dateFormat.format(date));
        }

    }

    public static String formatoHora(Date fecha) {
        java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("HH:mm:ss");
        String fechaResult = "";
        if (fecha != null) {
            fechaResult = formato.format(fecha);
        }
        return fechaResult;
    }

    public static Date convertirStringDate(final String fechaString) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String dateInString = fechaString;
        Date fecha = sdf.parse(dateInString);
        return fecha;
    }

    public static DefaultStreamedContent verImagen(String nombreImagen) {
        DefaultStreamedContent result = new DefaultStreamedContent();
        String pathImagen = File.separator + "DIRECTORIO_EMPRESAS" + File.separator + nombreImagen;
        File file = new File(pathImagen);
        if (!file.exists()) {
            pathImagen = File.separator + "DIRECTORIO_EMPRESAS" + File.separator + "noImagen.jpg";
            file = new File(pathImagen);
            if (!file.exists()) {
                return null;
            }
        }
        try {
            byte[] o = Files.readAllBytes(file.toPath());
            result = new DefaultStreamedContent(new ByteArrayInputStream(o));
        } catch (FileNotFoundException e) {
        } catch (IOException ex) {
            Logger.getLogger(UtilVista.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public static DefaultStreamedContent verImagenProducto(String nombreImagen, String tipoImagen, Long empresa) {
        DefaultStreamedContent result = new DefaultStreamedContent();
        String pathImagen = File.separator + "DIRECTORIO_EMPRESAS" + File.separator + "empresa_" + empresa + File.separator + tipoImagen + File.separator + nombreImagen;
        File file = new File(pathImagen);
        if (!file.exists()) {
            pathImagen = File.separator + "DIRECTORIO_EMPRESAS" + File.separator + "noImagen.jpg";
            file = new File(pathImagen);
            if (!file.exists()) {
                return null;
            }
        }
        try {
            byte[] o = Files.readAllBytes(file.toPath());
            result = new DefaultStreamedContent(new ByteArrayInputStream(o));
        } catch (FileNotFoundException e) {
        } catch (IOException ex) {
            Logger.getLogger(UtilVista.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public static DefaultStreamedContent verImagenEmpresa(String nombreImagen, String tipoImagen, Long empresa) {
        DefaultStreamedContent result = new DefaultStreamedContent();
        String pathImagen = File.separator + "DIRECTORIO_EMPRESAS" + File.separator + "empresa_" + empresa + File.separator + tipoImagen + File.separator + nombreImagen;
        File file = new File(pathImagen);
        if (!file.exists() || nombreImagen.trim().isEmpty()) {
            pathImagen = File.separator + "DIRECTORIO_EMPRESAS" + File.separator + "noImagen.jpg";
            file = new File(pathImagen);
            if (!file.exists()) {
                return null;
            }
        }
        try {
            byte[] o = Files.readAllBytes(file.toPath());
            result = new DefaultStreamedContent(new ByteArrayInputStream(o));
        } catch (FileNotFoundException e) {
        } catch (IOException ex) {
            Logger.getLogger(UtilVista.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public static Integer calcularEdad(Date fecha) {
        Calendar fechaActual = Calendar.getInstance();

        Calendar fechaNac = Calendar.getInstance();
        fechaNac.setTime(fecha);

        // Cálculo de las diferencias.
        int years = fechaActual.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);

        int months = fechaActual.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);

        int days = fechaActual.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);

        // Hay que comprobar si el día de su cumpleaños es posterior
        // a la fecha actual, para restar 1 a la diferencia de años,
        // pues aún no ha sido su cumpleaños.
        if (months < 0 // Aún no es el mes de su cumpleaños

                || (months == 0 && days < 0)) { // o es el mes pero no ha llegado el día.

            years--;

        }

        return years;
    }

    public static String agregarCeros(String string, int largo) {
        String ceros = "";

        int cantidad = largo - string.length();

        if (cantidad >= 1) {
            for (int i = 0; i < cantidad; i++) {
                ceros += "0";
            }
            return ceros + string;
        } else {
            return string;
        }
    }

    public static String abrirArchivoPDF(String tipo, String nombrePDF) throws IOException {
        Object request = FacesContext.getCurrentInstance().getExternalContext()
                .getRequest();
        String scheme = ((ServletRequest) request).getScheme();
        String serverName = ((ServletRequest) request).getServerName();
        int serverPort = ((ServletRequest) request).getServerPort();

        return scheme + ":" + File.separator + File.separator + serverName + ":" + serverPort
                + File.separator + tipo + File.separator + nombrePDF;

    }

    public static String crearDirectorio(String directorio) throws IOException {
        File f = new File(".");
        int tamanioFinal = f.getCanonicalPath().length() - 3;
        String url = f.getCanonicalPath().substring(0, tamanioFinal);
        java.io.File servidor = new File(url);
        if (!servidor.canWrite()) {
            servidor.setWritable(true);
        }
        if (!servidor.canRead()) {
            servidor.setReadable(true);
        }
        String urlFinal = url + "welcome-content" + File.separator + directorio + File.separator;
        java.io.File directorioWindows = new File(urlFinal);
        if (directorioWindows.exists()) {
            if (!directorioWindows.canRead()) {
                directorioWindows.setReadable(true);
            }
            if (!directorioWindows.canWrite()) {
                directorioWindows.setWritable(true);
            }
        }
        if (!directorioWindows.exists()) {
            directorioWindows.mkdir();
        }
        directorioWindows.list();
        return urlFinal;

    }

    public static byte[] documentoByte(String nombreDocumento, String tipoDocumento, Long empresa) throws IOException {

        String pathImagen = File.separator + "DIRECTORIO_EMPRESAS" + File.separator + "empresa_" + empresa + File.separator + tipoDocumento + File.separator + nombreDocumento;
        File file = new File(pathImagen);
        if (!file.exists()) {
            pathImagen = File.separator + "DIRECTORIO_EMPRESAS" + File.separator + "noImagen.jpg";
            file = new File(pathImagen);
            if (!file.exists()) {
                return null;
            }
        }

        byte[] o = Files.readAllBytes(file.toPath());

        return o;
    }

    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

    public static StreamedContent mostrarImagenBase(String nombreImagen, String tipoImagen) {
        try {

            if (nombreImagen == null) {
                nombreImagen = "";
            }
            String directorio = "CRAC";
            String pathImagen = File.separator + directorio + File.separator + tipoImagen + File.separator + nombreImagen;
            File file = new File(pathImagen);
            String mimeType = "";
            if (!file.exists() || !file.isFile()) {
                pathImagen = File.separator + directorio + File.separator + "noImagen.jpg";
                file = new File(pathImagen);
                if (!file.exists() || !file.isFile()) {
                    return null;
                }
            }

            if (file.getName().endsWith("png")) {
                mimeType = "image/png";
            } else if (file.getName().endsWith("jpg") || file.getName().endsWith("jpeg")) {
                mimeType = "image/jpeg";
            }
            return new DefaultStreamedContent(new FileInputStream(file), mimeType);
        } catch (FileNotFoundException e) {
            return null;
        }

    }

    public static String convertirImagenBase64(InputStream imStream) throws IOException {
        byte[] encoded = Base64.getEncoder().encode(IOUtils.toByteArray(imStream));
        return new String(encoded, StandardCharsets.US_ASCII);
    }

}
