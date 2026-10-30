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


    // método que verifica se o texto inserido (que tenha parenteses) está balanceado no fechamento dos '()'
    public static boolean verificarBalanceamento(String texto) {
        Pilha<Character> pilha = new Pilha<>();
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c == '(') {
                pilha.push(c);
            } else if (c == ')') {
                if (pilha.vazia()) {
                    return false;
                }
                pilha.pop();
            }
        }
        return pilha.vazia();
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
