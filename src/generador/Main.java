package generador;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Rafael Barragán Acevedo
 */
public class Main {

    static boolean mayusculas = false, numero = false, especial = false, letra = false;
    static int longitud = 0;

    public static void main(String[] arg) {
        String letras[] = {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "ñ", "z", "x", "c", "v", "b", "n", "m"};
        String letrasMayusculas[] = generarMayusculas(letras);
        String especiales[] = {"!", "#", "$", "%", "&"};
        String numeros[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        Scanner sc = new Scanner(System.in);

        do {
            menu();
            String contraseña[] = generarContraseña(letrasMayusculas, letras, especiales, numeros);
            if (contraseña != null) {
                System.out.println(arrayTostr(contraseña));
            }else{
                System.out.println("No se a elegido ninguna opcion");
            }
            System.out.println("¿Quiere hacer otra contraseña? digite Y o N");
            char op = sc.next().charAt(0);
            if (op == 'N' || op == 'n') {
                break;
            }
            
        } while (true);
    }

    private static void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------Generador de contraseñas----------");
        System.out.println("¿Quiere incluir minusculas? digite Y o N: ");
        char op0 = sc.next().charAt(0);
        System.out.println("¿Quiere incluir mayusculas? digite Y o N: ");
        char op1 = sc.next().charAt(0);
        System.out.println("¿Quiere incluir numeros? digite Y o N: ");
        char op2 = sc.next().charAt(0);
        System.out.println("¿Quiere incluir caracteres especiales? digite Y o N: ");
        char op3 = sc.next().charAt(0);
        System.out.println("Ingrese la longitud: ");
        longitud = sc.nextInt();
        if (op0 == 'y' || op0 == 'Y') {
            letra = true;
        }
        if (op1 == 'y' || op1 == 'Y') {
            mayusculas = true;
        }
        if (op2 == 'y' || op2 == 'Y') {
            numero = true;
        }
        if (op3 == 'y' || op3 == 'Y') {
            especial = true;
        }
    }

    private static String[] generarMayusculas(String[] letras) {
        int tamaño = letras.length;
        String resultado[] = new String[tamaño];
        for (int i = 0; i < tamaño; i++) {
            resultado[i] = letras[i].toUpperCase();
        }
        return resultado;
    }

    private static String[] generarContraseña(String[] letrasMayusculas, String[] letras, String[] especiales, String[] numeros) {
        Random r = new Random();
        String contraseña[] = new String[longitud];
        if (mayusculas && numero && especial && letra) {
            int tam = letras.length + letrasMayusculas.length + especiales.length + numeros.length;
            String aux[] = new String[tam];
            int pos = 0;
            System.arraycopy(numeros, 0, aux, pos, numeros.length);
            pos += numeros.length;
            System.arraycopy(letras, 0, aux, pos, letras.length);
            pos += letras.length;
            System.arraycopy(letrasMayusculas, 0, aux, pos, letrasMayusculas.length);
            pos += letrasMayusculas.length;
            System.arraycopy(especiales, 0, aux, pos, especiales.length);
            int con = 0;
            while (con < longitud) {
                contraseña[con] = aux[r.nextInt(tam)];
                con++;
            }
            mayusculas = false;
            numero = false;
            especial = false;
            letra = false;
            return contraseña;
        }
        if (letra && mayusculas && !numero && !especial) {
            int tam = letras.length + letrasMayusculas.length;
            String aux[] = new String[tam];
            int pos = 0;
            System.arraycopy(letras, 0, aux, pos, letras.length);
            pos += letras.length;
            System.arraycopy(letrasMayusculas, 0, aux, pos, letrasMayusculas.length);
            int con = 0;
            while (con < longitud) {
                contraseña[con] = aux[r.nextInt(tam)];
                con++;
            }
            mayusculas = false;
            letra = false;
            return contraseña;
        }
        if (letra && !mayusculas && numero && !especial) {
            int tam = letras.length + numeros.length;
            String aux[] = new String[tam];
            int pos = 0;
            System.arraycopy(letras, 0, aux, pos, letras.length);
            pos += letras.length;
            System.arraycopy(numeros, 0, aux, pos, numeros.length);
            int con = 0;
            while (con < longitud) {
                contraseña[con] = aux[r.nextInt(tam)];
                con++;
            }
            numero = false;
            letra = false;
            return contraseña;
        }
        if (letra && !mayusculas && !numero && especial) {
            int tam = letras.length + especiales.length;
            String aux[] = new String[tam];
            int pos = 0;
            System.arraycopy(letras, 0, aux, pos, letras.length);
            pos += letras.length;
            System.arraycopy(especiales, 0, aux, pos, especiales.length);
            int con = 0;
            while (con < longitud) {
                contraseña[con] = aux[r.nextInt(tam)];
                con++;
            }
            especial = false;
            letra = false;
            return contraseña;
        }
        if (!letra && mayusculas && numero && !especial) {
            int tam = letrasMayusculas.length + numeros.length;
            String aux[] = new String[tam];
            int pos = 0;
            System.arraycopy(letrasMayusculas, 0, aux, pos, letrasMayusculas.length);
            pos += letrasMayusculas.length;
            System.arraycopy(numeros, 0, aux, pos, numeros.length);
            int con = 0;
            while (con < longitud) {
                contraseña[con] = aux[r.nextInt(tam)];
                con++;
            }
            mayusculas = false;
            numero = false;
            return contraseña;
        }
        if (!letra && mayusculas && !numero && especial) {
            int tam = letrasMayusculas.length + especiales.length;
            String aux[] = new String[tam];
            int pos = 0;
            System.arraycopy(letrasMayusculas, 0, aux, pos, letrasMayusculas.length);
            pos += letrasMayusculas.length;
            System.arraycopy(especiales, 0, aux, pos, especiales.length);
            int con = 0;
            while (con < longitud) {
                contraseña[con] = aux[r.nextInt(tam)];
                con++;
            }
            mayusculas = false;
            especial = false;
            return contraseña;
        }
        if (!letra && !mayusculas && numero && especial) {
            int tam = numeros.length + especiales.length;
            String aux[] = new String[tam];
            int pos = 0;
            System.arraycopy(numeros, 0, aux, pos, numeros.length);
            pos += numeros.length;
            System.arraycopy(especiales, 0, aux, pos, especiales.length);
            int con = 0;
            while (con < longitud) {
                contraseña[con] = aux[r.nextInt(tam)];
                con++;
            }
            numero = false;
            especial = false;
            return contraseña;
        }
        if (letra && mayusculas && numero && !especial) {
            int tam = numeros.length + letrasMayusculas.length + letras.length;
            String aux[] = new String[tam];
            int pos = 0;
            System.arraycopy(numeros, 0, aux, pos, numeros.length);
            pos += numeros.length;
            System.arraycopy(letras, 0, aux, pos, letras.length);
            pos += letras.length;
            System.arraycopy(letrasMayusculas, 0, aux, pos, letrasMayusculas.length);
            int con = 0;
            while (con < longitud) {
                contraseña[con] = aux[r.nextInt(tam)];
                con++;
            }
             mayusculas = false;
            numero = false;
            letra = false;
            return contraseña;
        }
        if (letra && mayusculas && !numero && especial) {
            int tam = especiales.length + letrasMayusculas.length + letras.length;
            String aux[] = new String[tam];
            int pos = 0;
            System.arraycopy(especiales, 0, aux, pos, especiales.length);
            pos += especiales.length;
            System.arraycopy(letras, 0, aux, pos, letras.length);
            pos += letras.length;
            System.arraycopy(letrasMayusculas, 0, aux, pos, letrasMayusculas.length);
            int con = 0;
            while (con < longitud) {
                contraseña[con] = aux[r.nextInt(tam)];
                con++;
            }
             mayusculas = false;
            especial = false;
            letra = false;
            return contraseña;
        }
        if (!letra && mayusculas && numero && especial) {
            int tam = especiales.length + letrasMayusculas.length + numeros.length;
            String aux[] = new String[tam];
            int pos = 0;
            System.arraycopy(especiales, 0, aux, pos, especiales.length);
            pos += especiales.length;
            System.arraycopy(numeros, 0, aux, pos, numeros.length);
            pos += numeros.length;
            System.arraycopy(letrasMayusculas, 0, aux, pos, letrasMayusculas.length);
            int con = 0;
            while (con < longitud) {
                contraseña[con] = aux[r.nextInt(tam)];
                con++;
            }
            mayusculas = false;
            numero = false;
            especial = false;
            return contraseña;
        }
        if (letra && !mayusculas && !numero && !especial) {
            int tam = letras.length;
            int con = 0;
            while (con < longitud) {
                contraseña[con] = letras[r.nextInt(tam)];
                con++;
            }
            letra = false;
            return contraseña;
        }
        if (!letra && mayusculas && !numero && !especial) {
            int tam = letrasMayusculas.length;
            int con = 0;
            while (con < longitud) {
                contraseña[con] = letrasMayusculas[r.nextInt(tam)];
                con++;
            }
            mayusculas = false;
            return contraseña;
        }
        if (!letra && !mayusculas && numero && !especial) {
            int tam = numeros.length;
            int con = 0;
            while (con < longitud) {
                contraseña[con] = numeros[r.nextInt(tam)];
                con++;
            }
            numero = false;
            return contraseña;
        }
        if (!letra && !mayusculas && !numero && especial) {
            int tam = especiales.length;
            int con = 0;
            while (con < longitud) {
                contraseña[con] = especiales[r.nextInt(tam)];
                con++;
            }
            especial = false;
            return contraseña;
        }
        return null;
    }

    private static StringBuilder arrayTostr(String[] contraseña) {
        StringBuilder res = new StringBuilder();
        for (String a : contraseña) {
            res.append(a);
        }
        return res;
    }
}
