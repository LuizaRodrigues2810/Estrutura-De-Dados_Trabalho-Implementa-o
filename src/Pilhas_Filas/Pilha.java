package Pilhas_Filas;
import java.util.LinkedList;
import java.util.List;

public class Pilha<T> {
    private List<T> lista = new LinkedList<>();

    public void push(T elemento) {
        lista.add(elemento);//adicionar no final
    }

    public T pop() {
        if (vazia()) {
            return null;
        }
        return lista.removeLast();//remover do final
    }

    public T peek() {//topo
        if (vazia()) {
            return null;
        }
        return lista.get(tamanho() - 1);
    }

    public int tamanho() {
        return lista.size();
    }

    public boolean vazia() {
        return lista.isEmpty();
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