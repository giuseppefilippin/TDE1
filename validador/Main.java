public class Main {
    public static void main(String[] args) {
        Expressao expressao = new Expressao();

        String expr1 = "(1+5)*(56+12)"; // expressão válida
        String expr2 = "(1+5))*56+12)"; // expressão inválida
        String expr3 = "(1+5)*[56+12)"; // expressão inválida
        String expr4 = "(((1+2) - 3 )* 6)"; // expressão válida

        System.out.println(expr1 + " => " + (expressao.verificaExpressao(expr1) ? "válida" : "inválida"));
        System.out.println(expr2 + " => " + (expressao.verificaExpressao(expr2) ? "válida" : "inválida"));
        System.out.println(expr3 + " => " + (expressao.verificaExpressao(expr3) ? "válida" : "inválida"));
        System.out.println(expr4 + " => " + (expressao.verificaExpressao(expr4) ? "válida" : "inválida"));
    }
}

class Pilha {
    int topo;
    char[] dados;
    int MAX;

    public Pilha(int n) {
        this.MAX = n;
        this.dados = new char[MAX];
        this.topo = -1;
    }

    public void empilha(char elemento) {
        if (topo < MAX - 1) {
            dados[++topo] = elemento;
        } else {
            throw new IllegalStateException("Pilha cheia");
        }
    }

    public char desempilha() {
        if (topo != -1) {
            return dados[topo--];
        }
        throw new IllegalStateException("Pilha vazia");
    }

    public char topo() {
        if (topo != -1) {
            return dados[topo];
        }
        throw new IllegalStateException("Pilha vazia");
    }

    public boolean vazia() {
        return topo == -1;
    }
}

class Expressao {
    public boolean verificaExpressao(String expressao) {
        Pilha pilha = new Pilha(expressao.length());

        for (int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);

            if (caractere == '(' || caractere == '{' || caractere == '[') {
                pilha.empilha(caractere);
            } else if (caractere == ')' || caractere == '}' || caractere == ']') {
                if (pilha.vazia()) {
                    return false;
                }
                char topo = pilha.desempilha();
                if (!combinacaoValida(topo, caractere)) {
                    return false;
                }
            }
        }
        return pilha.vazia();
    }

    private boolean combinacaoValida(char abertura, char fechamento) {
        return (abertura == '(' && fechamento == ')') ||
               (abertura == '{' && fechamento == '}') ||
               (abertura == '[' && fechamento == ']');
    }
}
