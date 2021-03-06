/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajofinal;

import javax.swing.JOptionPane;

/**
 *
 * @author Franco
 */
public class Tf {

    public static void main(String[] args) {

        double saldoBase = 3000.0;
        String acciones = "";
        ingresarUsuario(saldoBase, acciones);
        accionesARealizar(saldoBase, acciones);
    }

    public static void ingresarUsuario(double saldoBase, String acciones) {
        String usuarioBase = "franco0988";
        String passBase = "112358";
        String usuarioVista;
        String passVista;

        usuarioVista = "hola";

        while (!usuarioVista.equals("0")) {

            usuarioVista = JOptionPane.showInputDialog("Ingrese su usuario: ");
            //cdo se oprime salir o cancelar finaliza la ejecucion
            if (usuarioVista == null) {
                System.out.println("Mensaje interno: el usuario oprimio cancelar o cruz");
                ingresarUsuario(saldoBase, acciones);
            }
            if (usuarioVista.equals(usuarioBase)) {

                passVista = JOptionPane.showInputDialog("Ingrese su contraseña: ");
                if (passVista == null) {
                    System.out.println("Mensaje interno: el usuario oprimio cancelar o cruz");
                    ingresarUsuario(saldoBase, acciones);
                }
                if (passVista.equals(passBase)) {
                    System.out.println("Mensaje interno: el usuario ingresa al menú");
                    JOptionPane.showMessageDialog(null, "Bienvenido/a " + usuarioVista);
                    accionesARealizar(saldoBase, acciones);
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña Incorrecta ");
                }
            } else if (usuarioVista.equals("0")) {
                System.out.println("Mensaje interno: el usuario oprimio 0 para salir del sistema");
                JOptionPane.showMessageDialog(null, "“GRACIAS POR USAR NUESTRO SISTEMA”. ");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario Incorrecto");
            }
        }
    }

    public static void accionesARealizar(double saldoBase, String acciones) {
        String numTxt;
        int num = 0;

        numTxt = JOptionPane.showInputDialog("¿Qué acción desea realizar?\n 1 - DEPOSITAR \n 2 - SACAR PLATA \n 3 - MOSTRAR SALDO \n 4 - ACCIONES REALIZADAS \n 5 - SALIR");
        try {
            if (numTxt == null) {
                System.out.println("Mensaje interno: el usuario oprimio cancelar o cruz");
                ingresarUsuario(saldoBase, acciones);
            }
            num = Integer.parseInt(numTxt);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "la opción ingresada es incorrecta, solo se aceptan números", "Error", JOptionPane.ERROR_MESSAGE);
            accionesARealizar(saldoBase, acciones);
        }

        switch (num) {
            case 1:
                depositar(saldoBase, acciones);
                break;
            case 2:
                sacarPlata(saldoBase, acciones);
                break;
            case 3:
                mostrarSaldo(saldoBase, acciones);
                break;
            case 4:
                accionesRealizadas(saldoBase, acciones);
                break;
            case 5:
                salir(saldoBase, acciones);
                break;
            default:
                System.out.println("Mensaje Interno: Opción fuera del rango establecido");
                JOptionPane.showMessageDialog(null, "Opción incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                accionesARealizar(saldoBase, acciones);
                break;
        }

    }

    public static void depositar(double saldoBase, String acciones) {
        String saldoTxt;

        double saldoNuevo = 0.0;

        saldoTxt = JOptionPane.showInputDialog("Ingrese su saldo a depositar \n Debe ser multiplo de 100 y hasta $5000 por transacción");

        try {
            if (saldoTxt == null) {
                System.out.println("Mensaje interno: el usuario oprimio cancelar o cruz");
                accionesARealizar(saldoBase, acciones);
            }
            saldoNuevo = Double.parseDouble(saldoTxt);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "la opción ingresada es incorrecta, solo se aceptan números", "Error", JOptionPane.ERROR_MESSAGE);
            depositar(saldoBase, acciones);
        }

        if (saldoNuevo % 100 == 0 && saldoNuevo > 0 && saldoNuevo <= 5000) {
            saldoBase = saldoBase + saldoNuevo;
            System.out.println("Mensaje interno: el saldo actual es $ " + saldoBase);
            JOptionPane.showMessageDialog(null, "DINERO DEPOSITADO");
            acciones = acciones + "Depositar \n";
            accionesARealizar(saldoBase, acciones);
        } else {
            System.out.println("Mensaje interno: saldo mal ingresado");
            JOptionPane.showMessageDialog(null, "Saldo incorrecto");
            depositar(saldoBase, acciones);
        }
    }

    public static void sacarPlata(double saldoBase, String acciones) {

        String sacarTxt;
        double sacar = 0.0;

        sacarTxt = JOptionPane.showInputDialog("¿Cuánto dinero quiere extraer? \n Tiene que ser multiplo de 100 \n Y hasta $10000");
        try {
            if (sacarTxt == null) {
                System.out.println("Mensaje interno: el usuario oprimio cancelar o cruz");
                accionesARealizar(saldoBase, acciones);
            }
            sacar = Double.parseDouble(sacarTxt);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "la opción ingresada es incorrecta, solo se aceptan números", "Error", JOptionPane.ERROR_MESSAGE);
            sacarPlata(saldoBase, acciones);
        }

        if (sacar % 100 == 0 && sacar > 0 && sacar <= 10000 && sacar <= saldoBase) {
            saldoBase = saldoBase - sacar;
            System.out.println("Mensaje interno: saldo actual $ " + saldoBase);
            JOptionPane.showMessageDialog(null, "OPERACIÓN REALIZADA SATISFACTORIAMENTE");
            acciones = acciones + "Sacar Plata \n";
            accionesARealizar(saldoBase, acciones);
        } else if (saldoBase == 0) {
            JOptionPane.showMessageDialog(null, "su cuenta está en 0 pesos");
            System.out.println("Mensaje interno: cuenta en 0");
            accionesARealizar(saldoBase, acciones);
        } else {
            JOptionPane.showMessageDialog(null, "monto inválido, vuelva a ingresarlo");
            System.out.println("Mensaje Interno: monto inválido");
            sacarPlata(saldoBase, acciones);
        }

    }

    public static void mostrarSaldo(double saldoBase, String acciones) {

        System.out.println("Mensaje interno: el saldo actual es $ " + saldoBase);
        JOptionPane.showMessageDialog(null, "su monto actual es $ " + saldoBase);
        acciones = acciones + "Mostrar saldo \n";
        accionesARealizar(saldoBase, acciones);

    }

    public static void accionesRealizadas(double saldoBase, String acciones) {
        System.out.println("Mensaje Interno: las acciones q ha realizado el usuaiio son: \n" + acciones);
        JOptionPane.showMessageDialog(null, "las acciones realizadas son: \n " + acciones);
        accionesARealizar(saldoBase, acciones);
    }

    public static void salir(double saldoBase, String acciones) {
        System.out.println("Mensaje Interno: el usuario salio del menú");
        ingresarUsuario(saldoBase, acciones);
    }

}
