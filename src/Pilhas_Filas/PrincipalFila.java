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
    //3. Inverter uma Fila
    public static void inverterFila(Fila<Integer> fila){
        Pilha<Integer> auxPilha = new Pilha<>();

        while(!fila.vazia()){
            int valor = fila.dequeue();
            auxPilha.push(valor);
        }
        while(!auxPilha.vazia()){
            int valor = auxPilha.pop();
            fila.enqueue(valor);
        }

    }
    public static void main(String[] args) {
         
         // Testando o método moverPrimeiroParaFinal
      Fila<Integer> fila = new Fila<>();
      fila.enqueue(10);
      fila.enqueue(20);
      fila.enqueue(30);
      fila.enqueue(40); // frente da fila 
     
      IO.println("Fila original: " + fila);
     
      moverPrimeiroParaFinal(fila);
     
      IO.println("Fila após mover o primeiro para o final: " + fila);

       Fila<Integer> fila = new Fila<>();
       fila.enqueue(1);
       fila.enqueue(2);
       fila.enqueue(3);

       IO.println("Antes: " + fila);
       inverterFila(fila);
       IO.println("Depois: " + fila);


       //Fila<Integer> f2 = new Fila<>();
       //f2.enqueue(3);
       //f2.enqueue(4);

       //Fila<Integer> resultaCombinacao = combinarFilas(f1,f2);

       //IO.println("f1: " + f1);
       //IO.println("f2: " + f2);
       //IO.println("Resultado: " + resultaCombinacao);



    }
}
