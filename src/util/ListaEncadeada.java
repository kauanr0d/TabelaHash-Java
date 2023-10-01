package util;

public class ListaEncadeada {

    private Nodo inicio;
    private Nodo fim;
    private int tamanho;

    public ListaEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public boolean inserirObjeto(int chave, Object obj) {
        Nodo node = new Nodo(chave, obj);

        if (this.tamanho == 0) {
            this.inicio = node;
            this.fim = node;
        } else {
            this.fim.setProximo(node);
            this.fim = node;
        }
        this.tamanho++;
        return true;

    }

    public Object buscarObjeto(int chave) {
        Nodo auxNodo = this.inicio;

        while (auxNodo != null) {
            if (auxNodo.getChave() == chave) {
                return "Encontrado:" + auxNodo.getElemento().toString();
            }
            auxNodo = (Nodo) auxNodo.getProximo();
        }
        return null;
    }

    public void imprimir() {
        Nodo auxNodo = this.inicio;
        int i = 1;
        if (this.inicio == null && this.tamanho == 0) {
            return;
        }
        while (auxNodo != null) {
            System.out.print(auxNodo.getElemento() + " ");
            auxNodo = (Nodo) auxNodo.getProximo();
            i++;
        }

    }

    public Object obterElementoNaPosicao(int pos) {
        Nodo atual = this.inicio;
        int i = 1;
        if (pos <= this.tamanho) {
            while (atual != null && i < pos) {
                atual = atual.getProximo();
                i++;
            }
            return atual.getElemento();
        }
        return null;
    }

    public Nodo obterNodoNaPosicao(int posicao) {
        Nodo nodoAtual = inicio;
        for (int i = 0; i < posicao; i++) {
            nodoAtual = nodoAtual.getProximo();
        }
        return nodoAtual;
    }

    public boolean removerObjeto(int chave) {
        Nodo atual = this.inicio;
        Nodo aux = null;

        while (atual != null) {
            if (atual.getChave() == chave) {
                if (aux != null) {
                    aux.setProximo(atual.getProximo());
                } else {
                    this.inicio = atual.getProximo();
                }

                if (atual == this.fim) {
                    this.fim = aux;
                }

                this.tamanho--;
                return true;
            }

            aux = atual;
            atual = atual.getProximo();
        }

        return false;
    }

}
