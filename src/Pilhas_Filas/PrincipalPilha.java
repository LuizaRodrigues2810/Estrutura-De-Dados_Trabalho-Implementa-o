package Pilhas_Filas;

public class PrincipalPilha {
    
    //método para somar todos os elementos da pilha, sem perder os elementos originais
    public static int somarElementos(Pilha<Integer> pilha){
        int soma = 0;

        Pilha<Integer> auxSoma = new Pilha<>();

        while(!pilha.vazia()){
            int valor = pilha.pop();
            soma += valor;
            auxSoma.push(valor);

        }
        while(!auxSoma.vazia()){
            pilha.push(auxSoma.pop());
        }
        return soma;
    }
    void main(){
        //testando o método do item 4
        Pilha<Integer> pilha = new Pilha<>();

        pilha.push(3);
        pilha.push(5);
        pilha.push(2); //topo

        int resultado = somarElementos(pilha);

        IO.println("Soma dos elementos: " + resultado);
        IO.println("Pilha: " + pilha);

    }

}
