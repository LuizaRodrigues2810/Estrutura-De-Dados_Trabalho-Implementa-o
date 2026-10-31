package Pilhas_Filas;

public class PrincipalPilha {

    //1.Remover elementos maiores que um valor  
    public static void removerMaioresQue(Pilha<Integer> pilha, int limite) {
        Pilha<Integer> aux = new Pilha<>();

        while (!pilha.vazia()) {
            Integer topo = pilha.pop();
            if (topo <= limite) {
                aux.push(topo);
            }
        }

        while (!aux.vazia()) {
            pilha.push(aux.pop());
        }

    }

    //2. Verificar palíndromo
    public static boolean ehPalindromo(String texto) {
        Pilha<Character> investida = new Pilha<>();

        int i = 0;
        while (i < texto.length()) {
            investida.push(texto.charAt(i));
            i++;
        }

        int j = 0;
        while (!investida.vazia()) {
            char topo = investida.pop();

            if (topo != texto.charAt(j)) {
                return false;
            }

            j++;
        }
        return true;
    }


    //3.Inverter as ordens dos elementos
    public static Pilha<Integer> inverterPilha(Pilha<Integer> original) {
        Pilha<Integer> nova = new Pilha<>();


        while (!original.vazia()) {
            Integer np = original.pop();
            nova.push(np);

        }
        return nova;
    }


    //4.Somar os elementos da pilha
    public static int somarElementos(Pilha<Integer> pilha) {
        int soma = 0;

        Pilha<Integer> auxSoma = new Pilha<>();

        while (!pilha.vazia()) {
            int valor = pilha.pop();
            soma += valor;
            auxSoma.push(valor);

        }
        while (!auxSoma.vazia()) {
            pilha.push(auxSoma.pop());
        }
        return soma;
    }


    //5.Parênteses balanceados
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

    void main() {
        // Testando o método: removerMaioresQue
        Pilha<Integer> pilhaRemover = new Pilha<>();
        pilhaRemover.push(2);
        pilhaRemover.push(8);
        pilhaRemover.push(4);
        pilhaRemover.push(10); // topo

        int limite = 5;
        IO.println("Pilha antes de remover: " + pilhaRemover);
        removerMaioresQue(pilhaRemover, limite);
        IO.println("Pilha após remover maiores que " + limite + ": " + pilhaRemover);
        IO.println();


        // Testando o método: ehPalindromo 
        String texto = "arara";
        boolean resultadoPalindromo = ehPalindromo(texto);
        IO.println("O texto \"" + texto + "\" é palíndromo? " + resultadoPalindromo);
        IO.println();


        // Testando o método: inverterPilha 
        Pilha<Integer> original = new Pilha<>();
        original.push(1);
        original.push(2);
        original.push(3); // topo

        IO.println("Pilha original: " + original);
        Pilha<Integer> invertida = inverterPilha(original);
        IO.println("Pilha invertida: " + invertida);


        // Testando o método: somarElementos
        Pilha<Integer> pilha = new Pilha<>();

        pilha.push(3);
        pilha.push(5);
        pilha.push(2); //topo

        int resultado = somarElementos(pilha);

        IO.println("Soma dos elementos: " + resultado);
        IO.println("Pilha: " + pilha);

        //Testando o método: verificarBalanceamento
         String[] expressoes = {
                "(a+b)*(c-d)",   
                "(()())",        
                "((a+b)",       
                "a+b)",          
                ")(",           
                ""             
        };
        for (String expressao : expressoes) {
            IO.println("\"" + expressao + "\" está balanceada? " + verificarBalanceamento(expressao));
        }


    }
}
