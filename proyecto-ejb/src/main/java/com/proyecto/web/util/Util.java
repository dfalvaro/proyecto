/*
 * Util.java
 * 

 
 */
package com.proyecto.web.util;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.codec.binary.Base64;
import org.primefaces.event.FileUploadEvent;
import static org.apache.commons.io.FilenameUtils.getExtension;

/**
 * Class Util.
 *
 * @revision $Revision: 1.1 $$
 */
public final class Util {

    public static Util instance;
    public static String NUMEROS = "0123456789";

    public static String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";

    public static String ESPECIALES = "ñÑ";

    /**
     * Instancia un nuevo util.
     */
    private Util() {
    }

    /**
     * Gets the single instance of Util.
     *
     * @return single instance of Util
     */
    public static Util getInstance() {
        if (instance == null) {
            instance = new Util();
        }
        return instance;
    }

    public static Integer calcularEdad(final Date fechaNacimiento) {
        Date fechaHoy = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        int edad = fechaHoy.getYear() - fechaNacimiento.getYear();
        if ((fechaNacimiento.getMonth() - fechaHoy.getMonth()) > 0) {
            edad--;
        } else if ((fechaNacimiento.getMonth() - fechaHoy.getMonth()) == 0) {
            if ((fechaNacimiento.getDate() - fechaHoy.getDate()) > 0) {
                edad--;
            }
        }
        return edad;
    }

    public static Date sumarDias(final Date fecha, Integer dia) {

        Calendar cal = new GregorianCalendar();
        cal.setLenient(false);
        cal.setTime(fecha);
        cal.add(Calendar.DAY_OF_WEEK, dia);
        return cal.getTime();

    }

    /**
     * Retorna el día de la semana de la fecha específica enviada
     *
     * @param fecha
     * @return true valid email, otherwise false
     */
    public static String obtenerDiaTexto(Date fecha) {
        String diaSeleccionado = "";
        if (fecha != null) {
            int numeroDia = 0;
            Calendar cal = Calendar.getInstance();
            cal.setTime(fecha);
            numeroDia = cal.get(Calendar.DAY_OF_WEEK);

            if (numeroDia == 1) {
                diaSeleccionado = "Domingo";
            }
            if (numeroDia == 2) {
                diaSeleccionado = "Lunes";
            }
            if (numeroDia == 3) {
                diaSeleccionado = "Martes";
            }
            if (numeroDia == 4) {
                diaSeleccionado = "Miércoles";
            }
            if (numeroDia == 5) {
                diaSeleccionado = "Jueves";
            }
            if (numeroDia == 6) {
                diaSeleccionado = "Viernes";
            }
            if (numeroDia == 7) {
                diaSeleccionado = "Sábado";
            }
        }
        return diaSeleccionado;
    }

    public static Integer calcularAniosTranscurridos(final Date fechaInicio, final Date fechaFin) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        int edad = fechaInicio.getYear() - fechaFin.getYear();
        if ((fechaFin.getMonth() - fechaInicio.getMonth()) > 0) {
            edad--;
        } else if ((fechaFin.getMonth() - fechaInicio.getMonth()) == 0) {
            if ((fechaFin.getDate() - fechaInicio.getDate()) > 0) {
                edad--;
            }
        }
        return edad;
    }

    public static String documentoPDF(String tipo, String nombrePDF) throws IOException {
        Object request = FacesContext.getCurrentInstance().getExternalContext()
                .getRequest();
        String scheme = ((ServletRequest) request).getScheme();
        String serverName = ((ServletRequest) request).getServerName();
        int serverPort = ((ServletRequest) request).getServerPort();

        return scheme + ":" + File.separator + File.separator + serverName + ":" + serverPort
                + File.separator + tipo + File.separator + nombrePDF;

    }

    /**
     * Cambiar date a string.
     *
     * @param date the date
     * @param pattern the pattern
     * @return the string
     */
    public static String cambiarDateAString(final Date date, final String pattern) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    public static String SubirDocuHandleFileUpload(FileUploadEvent event, String identificacion, String TipoDocumento) {
        String result = "";
        try {
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
            String urlFinal = url + "welcome-content" + File.separator + TipoDocumento;
            java.io.File directorioInicial = new File(url + "welcome-content"
                    + File.separator);
            if (!directorioInicial.canWrite()) {
                directorioInicial.setWritable(true);
            }
            if (!directorioInicial.canRead()) {
                directorioInicial.setReadable(true);
            }
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
            String path = urlFinal;
            String archivo = path + File.separator + event.getFile().getFileName();
            String NombreDoc = "Doc" + identificacion + Util.obtenerAnio(new Date())
                    + Util.obtenerMes(new Date()) + Util.obtenerDia(new Date())
                    + directorioWindows.list().length + "." + getExtension(archivo);
            String archivoRenombrado = path + File.separator
                    + NombreDoc;

            java.io.File validarDirectorio = new File(archivo);
            result = NombreDoc;

            java.io.File validarDirectorioRenombrado = new File(archivoRenombrado);
            validarDirectorio.renameTo(validarDirectorioRenombrado);
            FileOutputStream fileOutputStream = new FileOutputStream(
                    archivoRenombrado);

            byte[] buffer = new byte[6124];
            int bulk;
            InputStream inputStream = event.getFile().getInputstream();

            while (true) {
                bulk = inputStream.read(buffer);
                if (bulk < 0) {
                    break;
                }
                fileOutputStream.write(buffer, 0, bulk);
                fileOutputStream.flush();
            }
            fileOutputStream.close();
            inputStream.close();
            FacesMessage msg = new FacesMessage("Documento subido exitosamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static String urlLocal() {
        Object request = FacesContext.getCurrentInstance().getExternalContext()
                .getRequest();
        String scheme = ((ServletRequest) request).getScheme();
        String serverName = ((ServletRequest) request).getServerName();

        int serverPort = ((ServletRequest) request).getServerPort();
        String url = scheme + "://" + serverName + ":" + serverPort + "/";

        return url;
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

    public static Date convertirStringDate(final String fechaString) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String dateInString = fechaString;
        Date fecha = sdf.parse(dateInString);
        return fecha;
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

    public static Date cambiarStringADate(final String date, final String pattern) {

        SimpleDateFormat formatoDelTexto = new SimpleDateFormat(pattern);
        String strFecha = date;
        Date fecha = null;
        try {
            fecha = formatoDelTexto.parse(strFecha);
        } catch (ParseException ex) {
        }
        return fecha;
    }

    /**
     * Validar cedula ruc.
     *
     * @param cedula
     * @return true, if successful
     */
    public static boolean validarCedula(final String cedula) {
        int suma = 0;
        if (cedula.length() != 10) {
            return false;
        } else {
            int a[] = new int[cedula.length() / 2];
            int b[] = new int[(cedula.length() / 2)];
            int c = 0;
            int d = 1;
            for (int i = 0; i < cedula.length() / 2; i++) {
                a[i] = Integer.parseInt(String.valueOf(cedula.charAt(c)));
                c = c + 2;
                if (i < (cedula.length() / 2) - 1) {
                    b[i] = Integer.parseInt(String.valueOf(cedula.charAt(d)));
                    d = d + 2;
                }
            }

            for (int i = 0; i < a.length; i++) {
                a[i] = a[i] * 2;
                if (a[i] > 9) {
                    a[i] = a[i] - 9;
                }
                suma = suma + a[i] + b[i];
            }
            int aux = suma / 10;
            int dec = (aux + 1) * 10;
            if ((dec - suma) == Integer.parseInt(String.valueOf(cedula.charAt(cedula.length() - 1)))) {
                return true;
            } else if (suma % 10 == 0 && cedula.charAt(cedula.length() - 1) == '0') {
                return true;
            } else {
                return false;
            }

        }
    }

    public static BigDecimal roundDecimal(final BigDecimal value, final int decimal) {
        BigDecimal num = value;
        num = value.setScale(decimal, BigDecimal.ROUND_HALF_UP);
        return num;
    }

    public static boolean validarFechaMayor(final Date fechaInicio, final Date fechaFin) {
        boolean result = true;
        if (fechaInicio != null && fechaFin != null) {
            if (fechaInicio.after(fechaFin)) {
                result = false;
            }
        }
        return result;
    }

    public static boolean validarFechaEntre(final Date fechaInicioExterno, final Date fechaInicioInterno,
            final Date fechaFinInterno, final Date fechaFinExterno) {
        boolean result = true;
        if (fechaInicioExterno != null && fechaInicioInterno != null && fechaFinInterno != null
                && fechaFinExterno != null) {
            if (fechaInicioExterno.after(fechaInicioInterno) || fechaFinExterno.before(fechaFinInterno)) {
                result = false;
            }
        }
        return result;
    }

    public static int obtenerDatosDatosDate(final Date date, final String pattern) {

        if (null == date) {
            return 0;
        } else {
            String formato = pattern;
            SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
            return Integer.parseInt(dateFormat.format(date));

        }

    }

    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     * Validate given email with regular expression.
     *
     * @param email email for validation
     * @return true valid email, otherwise false
     */
    public static boolean validarEmail(final String email) {

        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);

        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }

    /**
     *
     * @param args
     * @return
     * @throws Exception
     */
    public static String SHA256(final String args) {

        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");

            md.update(args.getBytes());
            md.digest();

            String hash = Base64.encodeBase64String(md.digest(args.getBytes()));
            return hash.trim();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Date sumarMeses(final Date fecha, Integer meses) {

        Calendar cal = new GregorianCalendar();
        cal.setLenient(false);
        cal.setTime(fecha);
        cal.add(Calendar.MONTH, meses);
        return cal.getTime();

    }

    public static Date sumarSemanas(final Date fecha, Integer semanas) {

        Calendar cal = new GregorianCalendar();
        cal.setLenient(false);
        cal.setTime(fecha);
        cal.add(Calendar.WEEK_OF_MONTH, semanas);
        return cal.getTime();

    }

    public static String horaActual() {
        Date fechaActual = new Date(System.currentTimeMillis());
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        String horaActual = formatoHora.format(fechaActual);
        return horaActual;
    }

    public static String formatoFecha(Date fecha) {
        java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("yyyy/MM/dd");
        String fechaResult = "";
        if (fecha != null) {
            fechaResult = formato.format(fecha);
        }
        return fechaResult;
    }

    public static String formatoValor(BigDecimal valor) {
        String valorResult = "";
        if (valor != null) {
            Locale locale = new Locale("es", "EC");
            NumberFormat valorForm = NumberFormat.getCurrencyInstance(locale);
            valorResult = valorForm.format(valor);
        }
        return valorResult;
    }

    public static void abrirDocumentoHandleFileUpload(String pathDocumento) {
        try {
            if (pathDocumento != null) {
                File path = new File(pathDocumento);
                Desktop.getDesktop().open(path);
            } else {
                FacesMessage msg = new FacesMessage("No existe ningun documento subido para el paciente");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        } catch (IOException ex) {
        }

    }

    public static void EnvioCorreo(String destinatario, String asunto, String cuerpo) {
        try {
            // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
            String remitente = "labclinicomoderno@gmail.com";  //Para la dirección nomcuenta@gmail.com
            String clave = "Labcm2019";
            Properties props = System.getProperties();
            props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
            props.put("mail.smtp.user", remitente);
            props.put("mail.smtp.clave", clave);    //La clave de la cuenta
            props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
            props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
            props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google
            Session session = Session.getDefaultInstance(props);
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(remitente));
            InternetAddress[] addresses = InternetAddress.parse(destinatario);//one or more addresses
            message.addRecipients(Message.RecipientType.TO, addresses);
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void redirectLogin(HttpServletRequest request) throws IOException {
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        String Urlseguridad = scheme + "://" + serverName + ":" + serverPort
                + "/proyecto-web/pages/secure/home.jsf";
        FacesContext.getCurrentInstance().getExternalContext()
                .redirect(Urlseguridad);
    }

    public static String subirImagenJpg(String imagenBase64, String nombreImagen, String tipoImagen) {
        try {
            if (imagenBase64 == null) {
                return null;
            }

            String base64 = imagenBase64.replaceAll("\n", "");
            ByteArrayInputStream imagenInputStream = new ByteArrayInputStream(java.util.Base64.getDecoder().decode(base64.getBytes()));
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            BufferedImage image = ImageIO.read(imagenInputStream);
            BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
            result.createGraphics().drawImage(image, 0, 0, Color.WHITE, null);
            ImageIO.write(result, "jpg", os);
            InputStream imagenInputStreamR = new ByteArrayInputStream(os.toByteArray());
            return procesarImagen(imagenInputStreamR, nombreImagen, tipoImagen);
        } catch (Exception ex) {
            return null;
        }
    }

    private static String procesarImagen(InputStream inputStream, String nombreImagen, String tipoImagen) {
        String result = "";
        try {
            String directorio = "CRAC";
            String urlFinal = File.separator + directorio + File.separator + tipoImagen;

            File directorioWindows = Util.crearDirecctorioPrincipal(urlFinal);

            directorioWindows.list();
            String path = urlFinal;
            String archivo = path + File.separator + nombreImagen;
            String NombreDoc = "Img" + Util.obtenerAnio(new Date())
                    + Util.obtenerMes(new Date()) + Util.obtenerDia(new Date())
                    + directorioWindows.list().length + ".jpg";

            String archivoRenombrado = path + File.separator + NombreDoc;

            java.io.File validarDirectorio = new File(archivo);
            result = NombreDoc;

            java.io.File validarDirectorioRenombrado = new File(archivoRenombrado);
            validarDirectorio.renameTo(validarDirectorioRenombrado);
            try (FileOutputStream fileOutputStream = new FileOutputStream(archivoRenombrado)) {
                byte[] buffer = new byte[6124];
                int bulk;
                // inputStream = imagenResize(inputStream);
                while (true) {
                    bulk = inputStream.read(buffer);
                    if (bulk < 0) {
                        break;
                    }
                    fileOutputStream.write(buffer, 0, bulk);
                    fileOutputStream.flush();
                }
            }
            inputStream.close();
        } catch (Exception ex) {
            return result;
        }
        return result;
    }

    public static String subirImagenJpgRedimencionada(String imagenBase64, String nombreImagen, String tipoImagen) {
        try {
            if (imagenBase64 == null) {
                return null;
            }
            String base64 = imagenBase64.replaceAll("\n", "");
            ByteArrayInputStream imagenInputStream = new ByteArrayInputStream(java.util.Base64.getDecoder().decode(base64.getBytes()));

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            BufferedImage image = ImageIO.read(imagenInputStream);
//            image = Scalr.resize(image, 100, 100);
            BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
            result.createGraphics().drawImage(image, 0, 0, Color.WHITE, null);
            ImageIO.write(result, "jpg", os);
            InputStream imagenInputStreamR = new ByteArrayInputStream(os.toByteArray());
            return procesarImagen(imagenInputStreamR, nombreImagen, tipoImagen);
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static File crearDirecctorioPrincipal(String directorio) {
        File directorioInicial = new File(directorio
                + File.separator);
        if (!directorioInicial.canWrite()) {
            directorioInicial.setWritable(true);
        }
        if (!directorioInicial.canRead()) {
            directorioInicial.setReadable(true);
        }

        File directorioWindows = new File(directorio);
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
        try {
            Runtime.getRuntime().exec("chmod 777 " + directorioWindows.getAbsolutePath());
        } catch (IOException ex) {
        }
        return directorioWindows;
    }

    public static boolean esNumeroDecimal(String cadena) {
        try {
            new BigDecimal(cadena);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //
    public static String getPinNumber() {
        return getPassword(NUMEROS, 4);
    }

    public static String getPassword() {
        return getPassword(8);
    }

    public static String getPassword(int length) {
        return getPassword(NUMEROS + MAYUSCULAS + MINUSCULAS, length);
    }

    public static String getPassword(String key, int length) {
        String pswd = "";

        for (int i = 0; i < length; i++) {
            pswd += (key.charAt((int) (Math.random() * key.length())));
        }

        return pswd;
    }

    public static String generarCerosSecuenciales(Long num, Integer longitud) {
        String cad = "";
        int iterador = longitud;
        iterador = iterador - num.toString().length();
        for (int i = 0; i < iterador; i++) {
            cad = cad + "0";
        }
        return cad + num;

    }

}
