package Pilhas_Filas;

import java.util.LinkedList;
import java.util.List;

public class Fila<T> {
    private List<T> lista = new LinkedList<>();

    public void enqueue(T elemento) {
        lista.add(elemento);//adicionar no final
    }

    public T dequeue() {
        if (vazia()) {
            return null;
        }
        return lista.removeFirst();//remover do inicio
    }

    public T peek() {
        if (vazia()) {
            return null;
        }
        return lista.getFirst();
    }

    public boolean vazia() {
        return lista.isEmpty();
    }

    public int tamanho() {
        return lista.size();
    }

    public void clear() {
        if (vazia()) {
            return;
        }
        lista = new LinkedList<>();
    }

    @Override
    public String toString(){
        return lista.toString();
    }

}
