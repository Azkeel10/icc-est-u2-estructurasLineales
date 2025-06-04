package Controllers;

import java.util.EmptyStackException;
import Models.NodeGeneric;
import Models.Persona;

public class QueueGeneric<T> {
//-------------------------------------------------------------------------------
    private NodeGeneric<T> primero;
    private NodeGeneric<T> ultimo;
    private int size;
//-------------------------------------------------------------------------------
    public QueueGeneric() {
        this.primero = null;
        this.ultimo = null;
        this.size = 0;
    }
//-------------------------------------------------------------------------------
    public void add(T value) {
        NodeGeneric<T> newnode = new NodeGeneric<>(value);

        if (isEmpty()) {
            primero = newnode;
            ultimo = newnode;
        } else {
            ultimo.setNext(newnode);
            ultimo = newnode;
        }
        size++;
    }
//-------------------------------------------------------------------------------
    public T remove() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            T aux = primero.getValue();
            primero = primero.getNext();
            size--;
            return aux;
        }
    }
//-------------------------------------------------------------------------------
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return primero.getValue();
        }
    }
//-------------------------------------------------------------------------------
    public int size() {
        return size;
    }
//-------------------------------------------------------------------------------
    public boolean isEmpty() {
        return primero == null;
    }
//-------------------------------------------------------------------------------
    public void printCola(){
        NodeGeneric<T> aux = primero;
        while (aux != null) {
            System.out.print(aux.getValue() + " | ");
            aux = aux.getNext();
        }
    }
//-------------------------------------------------------------------------------
    public Persona findByName(String busca){
        NodeGeneric<T> aux = primero;

        while (aux != null) {
            Persona persona = (Persona) aux.getValue();

            if (persona.getNombre().equals(busca)) {
                return persona;
            }
            aux = aux.getNext();
        }
        return null;
    }
//-------------------------------------------------------------------------------
    public Persona deleteByName(String eliminar){
        NodeGeneric<T> aux = primero;
        NodeGeneric<T> anterior = null;

        while (aux != null) {
            Persona persona = (Persona) aux.getValue();

            if (persona.getNombre().equals(eliminar)) {
                if (anterior == null) {
                    // El nodo a eliminar es el primero
                    primero = aux.getNext();
                } else {
                    // Saltamos el nodo actual
                    anterior.setNext(aux.getNext());
                }
                return persona;
            }
            anterior = aux;
            aux = aux.getNext();
        }
        return null;


    }
//-------------------------------------------------------------------------------
}
