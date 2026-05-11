public class ListaSimples {
    private Node head;

    public ListaSimples() {
        this.head = null; 
    }

    /** Insere no INICIO da lista (O(1)). */
    public void insertFirst(Object item) {
        // Criamos um novo nó que aponta para onde o head apontava 
        Node novo = new Node(item, head);
        // O head agora passa a ser esse novo nó 
        this.head = novo;
    }

    public void imprimir() {
        Node atual = head; 
        while (atual != null) { 
            System.out.print(atual.item + " -> ");
            atual = atual.next; 
        }
        System.out.println("null"); 
    }

    public Node find(Object item) {
    Node atual = head;
    while (atual != null) {
        // equals para comparar o conteúdo dos objetos
        if (atual.item.equals(item)) {
            return atual;
        }
        atual = atual.next;
    }
    return null;
}

    public void insertAfter(Node x, Object item) {
        if (x == null) return;
        // 1. o novo nó apontando para o próximo de x
        Node novo = new Node(item, x.next);
        // 2. o x aponta para o novo nó
        x.next = novo;
    }

    public static void main ( String [] args ) {
        ListaSimples lista = new ListaSimples () ;
        lista.insertFirst("C");
        lista.insertFirst("B");
        lista.insertFirst("A");
        lista.imprimir(); // A -> B -> C -> null
        Node noB = lista.find ("B");
        if (noB != null) {
        lista.insertAfter(noB, "B2");
        }
        lista.imprimir(); // A -> B -> B2 -> C -> null
        Node noZ = lista.find("Z");
        System.out.println("Busca por Z: " + noZ);
    }
}