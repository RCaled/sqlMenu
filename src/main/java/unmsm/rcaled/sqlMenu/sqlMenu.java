package unmsm.rcaled.sqlMenu;

import java.util.Scanner;

import unmsm.rcaled.sqlMenu.consultas;
import unmsm.rcaled.sqlMenu.edicion;

/**
 *
 * @author Ramirez Chero Alejandro
 */


public class sqlMenu {

	static void print_menu(){
		System.out.println("Sistema de Administracion Hospitalario");
		System.out.println("");
		System.out.println("Elija una opcion:");
		System.out.println("");
		System.out.println("1) Ver la lista completa de doctores.");
		System.out.println("2) Buscar medico por ID");
		System.out.println("3) Cambiar datos de un medico por ID");
		System.out.println("4) Eliminar un medico por ID");
		System.out.println("5) Seleccionar hora del dia");
		System.out.println("6) Ver medicos presentes");
		System.out.println("0) Salir");
		System.out.print("Opcion elegida: ");
	}

	static int getInt(Scanner input){
		int opcion = input.nextInt();	
		return opcion;
	}

	static void eleccion(){
		Scanner entrada = new Scanner(System.in);
		int opcion = getInt(entrada);
		int id = 0;
		consultas consult = new consultas();
		edicion edit = new edicion();
		switch (opcion){
		case 1:
			consult.imprimirListaMedicos();
			break;
		case 2:
			System.out.println("Digite la ID del medico:");
			id = getInt(entrada);
			consult.buscarIDMedico(id);
			break;
		case 3:
			System.out.println("Digite la ID del medico:");
			id= entrada.nextInt();
			entrada.nextLine();
			String columna = edit.eleccionDeColumna(entrada);
			entrada.nextLine();
			System.out.println("Ingrese el nuevo dato");
			String nuevoDato = entrada.nextLine();
			edit.cambiarDatoColumna(columna, nuevoDato,id);
			break;
		case 4:
			System.out.println("Digite la ID del medico:");
			id = entrada.nextInt();
			edit.borrarFila(id);
			break;
		case 5:
			edit.actualizarAsistencias(consult.eleccionDeHora(entrada));
			break;
		case 6:
			consult.mostrarDoctoresPresentes();
			break;
		case 0:
			System.out.println("opcion7");
			break;
		}
	}

    public static void main(String[] args) {
		print_menu();
		eleccion();
    }

}

