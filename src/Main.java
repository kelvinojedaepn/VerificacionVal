import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String cedula;
        String password;

        cedula = JOptionPane.showInputDialog(null, "Ingrese su cédula", "Log in", JOptionPane.INFORMATION_MESSAGE);
        if (validarCedula(cedula)) {
            password = JOptionPane.showInputDialog(null, "Ingrese su contraseña", "Log in", JOptionPane.INFORMATION_MESSAGE);
            if (validarContrasenia(password)) {
                JOptionPane.showMessageDialog(null, "Ingreso correctamente", "Log in", JOptionPane.INFORMATION_MESSAGE);
                Almacenamiento almacenamiento = new Almacenamiento();
                almacenamiento.almacenarDatos(new Persona(cedula, password));

            } else {
                JOptionPane.showMessageDialog(null, "La contraseña no es válida", "Log in", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "La cédula no es válida", "Log in", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static boolean validarContrasenia(String password) {
        Pattern pat = Pattern.compile("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");
        Matcher mat = pat.matcher(password);
        return mat.matches() ? true : false;
    }

    public static boolean validarCedula(String cedula) {
        Pattern pat = Pattern.compile("^\\d{10}$");
        Matcher mat = pat.matcher(cedula);
        return mat.matches() ? true : false;
    }

}