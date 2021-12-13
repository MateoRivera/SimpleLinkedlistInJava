/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lsl.implementacion;

/**
 *
 * @author mateo
 */
public class nodoSimple {
    private int dato;
    private nodoSimple liga;

    public int retornaDato() {
        return dato;
    }

    public void asignaDato(int dato) {
        this.dato = dato;
    }

    public nodoSimple retornaLiga() {
        return liga;
    }

    public void asignaLiga(nodoSimple liga) {
        this.liga = liga;
    }
}
