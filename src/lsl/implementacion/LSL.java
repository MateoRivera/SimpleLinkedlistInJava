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
public class LSL {
    private nodoSimple primero;
    private nodoSimple ultimo;

    public nodoSimple primerNodo() {
        return primero;
    }

    public nodoSimple ultimoNodo() {
        return ultimo;
    }
    
    public boolean esVacia() {
        return primero == null;
    }
    
    
    public nodoSimple anterior(nodoSimple x){
        //Creación de las variables p e y
        nodoSimple p = primero, y = null;
        
        //Mientras p aún no apunta a x, avanzamos
        while (p != x){
            y = p;
            p = p.retornaLiga();            
        }
        return y;
    }
    
    public boolean  finDeRecorrido(nodoSimple x){
        return x == null;
    }
    
    public void recorre(){
        nodoSimple p = primerNodo();
        /*
        Mientras no hayamos finalizado el recorrido de la lista
        imprimimos su contenido
        */
        while ( !finDeRecorrido(p) ){
            //Imprimimos
            System.out.println(p.retornaDato());
            
            //Avanzamos al siguiente nodo
            p = p.retornaLiga();
        }
    }
    
    public nodoSimple buscaDondeInsertar(int d){
        nodoSimple p = primerNodo(),y = null;
        while (!finDeRecorrido(p) && p.retornaDato() < d){
            y = p;
            p = p.retornaLiga();
        }
        return y;
    }
    
    public void insertar(int d, nodoSimple y){
        nodoSimple x = new nodoSimple();
        x.asignaDato(d);
        conectar(x, y);
    }
    
    public void conectar(nodoSimple x, nodoSimple y){
        //Caso 2 y caso 4
        if (y == null){
            /*Si la lista está vacía, simplemente al caso 2
            le añadimos una verificación para asignar a ultimo*/
            if(esVacia())
                ultimo = x;
            x.asignaLiga(primero);
            primero = x;
        }
        //Caso 1 y caso 3
        else{
            x.asignaLiga(y.retornaLiga());
            y.asignaLiga(x);
            /*Si y es el último nodo, al caso 1 
            le añadimos una verificación, para asignar a ultimo*/
            if (y == ultimo){
                ultimo = x;
            }
        }        
    }
    
    public nodoSimple buscarDato(int d, nodoSimple y){
        nodoSimple p = primero;
        while(!finDeRecorrido(p) && p.retornaDato() != d){
            y = p;
            p = p.retornaLiga();           
        }
        return p;
    }
    
    public void borrar(nodoSimple x, nodoSimple y){
        if(x == null){
            System.out.println("El dato no existe");
            return;
        }
        desconectar(x,y);
    }
    
    public void desconectar(nodoSimple x, nodoSimple y){
        if(y != null){
            y.asignaLiga(x.retornaLiga());
            if(x == ultimo)
                ultimo = y;
        }
        else{
            primero = x.retornaLiga();
            if(primero == null)
                ultimo = null;
        }
    }
    
    
    
}
