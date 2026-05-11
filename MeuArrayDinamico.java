public class MeuArrayDinamico {
    private int[] dados;
    private int tamanho; // quantos elementos realmente existem

    public MeuArrayDinamico(int capacidadeInicial){
        this.dados = new int[capacidadeInicial];
        this.tamanho = 0;
    }

    /**Dobra a capacidade do array interno. */
    private void resize(){
        int[] array2 = new int[tamanho*2]; // dobra o tamanho do array novo
        for (int i = 0; i < dados.length; i++){
            array2[i] = dados[i]; // copia os dados do array antigo para o novo
        }
        this.dados = array2; //dados agora é atribuido como um array maior
    }

    /** Adiciona ’valor ’ no final do array . */
    public void add(int valor){
        if(tamanho == dados.length){ // checa se o tamanho mudou
            resize();
        }
        dados[tamanho] = valor; // adiciona um elemento no primeiro espaço livre
        tamanho++; // conta o item adicionado, sinalizando a próxima posição
    }
    
    /** Retorna o elemento na posicao ’indice ’. */
    public int get(int indice){ 
        if (indice < 0 || indice >= tamanho){ 
            throw new IndexOutOfBoundsException("Indice invalido: " + 
                indice);
        }
        return dados[indice];
    }

    public int size(){ // fornece o tamanho do tamanho, ou seja, quantos índices o array atual tem
        return tamanho;
    }

    /** Imprime o array no formato [a, b, c]. */
    public void imprimir(){ 
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < tamanho; i++){
            sb.append(dados[i]);
            if (i< tamanho -1) sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public void remove(int indice){ 
        if (indice < 0 || indice >= tamanho){ 
            throw new IndexOutOfBoundsException("Indice invalido: " + 
                indice);
        }
        for (int i = indice; i <= tamanho - 2; i++){
            dados[i] = dados[i+1];
        }
        tamanho --;
    }
    // === Teste ===
    public static void main(String [] args){
        MeuArrayDinamico arr = new MeuArrayDinamico(2);
        arr.add(10);
        arr.add(20);
        arr.imprimir(); // [10 , 20]
        arr.add(30); // deve fazer resize aqui !
        arr.add(40);
        arr.imprimir(); // [10 , 20 , 30 , 40]
        System.out.println("Tamanho: " + arr.size()); // 4
        arr.remove(1); // remove 20
        arr.imprimir(); // [10,30,40]
        arr.remove(0); // remove 10
        arr.imprimir(); // [30,40]
        System.out.println("Tamanho: " + arr.size()); // 4
    }
}