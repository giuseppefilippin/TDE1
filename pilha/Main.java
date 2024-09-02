public class Main {
    public static void main(String[] args) {
        Pilha pilha = new Pilha(5);
        Empilha empilha = new Empilha();
        Desempilha desempilha = new Desempilha();
        Topo topo = new Topo();
        Vazia vazia = new Vazia();
        Cheia cheia = new Cheia();
        
        empilha.empilha(pilha, 10); // pilha.dados[0] = 10
        empilha.empilha(pilha, 20); // pilha.dados[1] = 20
        empilha.empilha(pilha, 30); // pilha.dados[2] = 30
        
        System.out.println("Elemento no topo: " + topo.topo(pilha));
        System.out.println("Pilha está vazia? " + vazia.vazia(pilha));
        System.out.println("Pilha está cheia? " + cheia.cheia(pilha));
        System.out.println();
        System.out.println("Elemento desempilhado: " + desempilha.desempilha(pilha));
        System.out.println("Elemento no topo após desempilhar: " + topo.topo(pilha));
        System.out.println();
        System.out.println("Segundo elemento desempilhado: " + desempilha.desempilha(pilha));
        System.out.println("Elemento no topo após desempilhar: " + topo.topo(pilha));
        System.out.println();
        //System.out.println("Terceiro elemento desempilhado: " + desempilha.desempilha(pilha));
        //System.out.println("Elemento no topo após desempilhar: " + topo.topo(pilha));
    }
}
class Pilha {
    int topo;
    int[] dados;
    int MAX;

    public Pilha(int n) {
        this.MAX = n;
        this.dados = new int[MAX];
        this.topo = -1;
    }
}

class Topo {
    public int topo(Pilha pilha) {
        if (pilha.topo != -1) {
            return pilha.dados[pilha.topo];
        }
        System.out.println("Pilha vazia");
        return -1;
    }
}

class Vazia {
    public boolean vazia(Pilha pilha) {
        return pilha.topo == -1;
    }
}

class Cheia {
    public boolean cheia(Pilha pilha) {
        return pilha.topo == pilha.MAX - 1;
    }
}

class Empilha {
    public void empilha(Pilha pilha, int elemento) {
        if (pilha.topo < pilha.MAX - 1) {
            pilha.dados[++pilha.topo] = elemento;
        } else {
            System.out.println("Pilha cheia");
        }
    }
}

class Desempilha {
    public int desempilha(Pilha pilha) {
        if (pilha.topo != -1) {
            return pilha.dados[pilha.topo--];
        }
        System.out.println("Pilha vazia");
        return -1;
    }
}
