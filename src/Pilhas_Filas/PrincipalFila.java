package Pilhas_Filas;

public class PrincipalFila {

    //2. Combinar Duas Filas
    public static Fila<Integer> combinarFilas(Fila<Integer> f1, Fila<Integer> f2){
        Fila<Integer> duasFilas = new Fila<>();

        int tamanhoFila1 = f1.tamanho();

        for(int i = 0; i < tamanhoFila1; i++){
            int valor = f1.dequeue();

            duasFilas.enqueue(valor);
            f1.enqueue(valor);
        }

        int tamanhoFinal2 = f2.tamanho();
        for(int i = 0; i < tamanhoFinal2; i++){
          int valor = f2.dequeue();

          duasFilas.enqueue(valor);
          f2.enqueue(valor);
        }
        return duasFilas;
    }
    public static void main(String[] args) {

       Fila<Integer> f1 = new Fila<>();
       f1.enqueue(1);
       f1.enqueue(2);

       Fila<Integer> f2 = new Fila<>();
       f2.enqueue(3);
       f2.enqueue(4);

       Fila<Integer> resultaCombinacao = combinarFilas(f1,f2);
       IO.println("f1: " + f1);
       IO.println("f2: " + f2);
       IO.println("Resultado: " + resultaCombinacao);



    }
}