package Pilhas_Filas;

public class PrincipalFila {

    //1. Mover o Primeiro Elemento para o Final
    public static void moverPrimeiroParaFinal(Fila<Integer> fila) {
        if (fila.vazia()) {
            return;
        }
        Integer aux = fila.dequeue();
        fila.enqueue(aux);

    }

    //2. Combinar Duas Filas
    public static Fila<Integer> combinarFilas(Fila<Integer> f1, Fila<Integer> f2) {
        Fila<Integer> duasFilas = new Fila<>();

        int tamanhoFila1 = f1.tamanho();

        for (int i = 0; i < tamanhoFila1; i++) {
            int valor = f1.dequeue();

            duasFilas.enqueue(valor);
            f1.enqueue(valor);
        }

        int tamanhoFinal2 = f2.tamanho();
        for (int i = 0; i < tamanhoFinal2; i++) {
            int valor = f2.dequeue();

            duasFilas.enqueue(valor);
            f2.enqueue(valor);
        }
        return duasFilas;
    }

    //3. Inverter uma Fila
    public static void inverterFila(Fila<Integer> fila) {
        Pilha<Integer> auxPilha = new Pilha<>();

        while (!fila.vazia()) {
            int valor = fila.dequeue();
            auxPilha.push(valor);
        }
        while (!auxPilha.vazia()) {
            int valor = auxPilha.pop();
            fila.enqueue(valor);
        }
    }

    //4. contarOcorrencias
    public static int contarOcorrencias(Fila<String> fila, String valor) {
        int contador = 0;
        int n = fila.tamanho();            // quantas voltas dar
        for (int i = 0; i < n; i++) {
            String atual = fila.dequeue(); // tira da frente
            if (atual.equals(valor)) {     // compara conteúdo
                contador++;
            }
            fila.enqueue(atual);           // devolve no final
        }
        return contador;
    }

    public static void main(String[] args) {

        //1. moverPrimeiroParaFinal
        Fila<Integer> fila = new Fila<>();
        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);
        fila.enqueue(40); // frente da fila
        IO.println("Fila original: " + fila);
        moverPrimeiroParaFinal(fila);
        IO.println("Fila após mover o primeiro para o final: " + fila);
        IO.println();


        //2. combinarFilas
        Fila<Integer> f1 = new Fila<>();
        f1.enqueue(1);
        f1.enqueue(2);
        Fila<Integer> f2 = new Fila<>();
        f2.enqueue(3);
        f2.enqueue(4);
        Fila<Integer> combinada = combinarFilas(f1, f2);
        IO.println("f1: " + f1);
        IO.println("f2: " + f2);
        IO.println("Resultado: " + combinada);
        IO.println();

        //3. inveterFila
        Fila<Integer> filaInverter = new Fila<>();
        filaInverter.enqueue(1);
        filaInverter.enqueue(2);
        filaInverter.enqueue(3);
        IO.println("Antes: " + filaInverter);
        inverterFila(filaInverter);
        IO.println("Depois: " + filaInverter);
        IO.println();

        //4. contarOcorrencias
        Fila<String> filaContar = new Fila<>();
        filaContar.enqueue("a");
        filaContar.enqueue("b");
        filaContar.enqueue("a");
        filaContar.enqueue("c");
        filaContar.enqueue("a");
        IO.println("Fila: " + filaContar);
        IO.println("Ocorrências de \"a\": " + contarOcorrencias(filaContar, "a"));
        IO.println("Fila depois: " + filaContar);


    }
}
