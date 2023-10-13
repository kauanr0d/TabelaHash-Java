package util;


public class TabelaHash {

    private int tamanho;
    private ListaEncadeada[] tabela;
    private int numElementos;

    public int getTamanho() {
        return tamanho;
    }

    public ListaEncadeada[] getTabela() {
        return tabela;
    }

    public int getNumElementos() {
        int numElementos = 0;
        for (int i = 0; i < this.tamanho; i++) {
            if (tabela[i] != null) {
                numElementos += tabela[i].getTamanho();
            }
        }
        return numElementos;
    }

    public TabelaHash(int tamanho) {
        this.tamanho = calculaTamanho(tamanho);
        int i = 0;
        this.numElementos = 0;
        this.tabela = new ListaEncadeada[this.tamanho];
    }

    public void inserir(int chave, Object elemento) {
        int acesso = hash(chave, this.tamanho);

        if (this.tabela[acesso] == null) {
            this.tabela[acesso] = new ListaEncadeada();
        }

        this.tabela[acesso].inserirObjeto(chave, elemento);

        // Verifica o fator de carga após a inserção
        double fatorDeCarga = (double) this.getNumElementos() / this.tamanho;
        if (fatorDeCarga > 0.75) {
            // Se o fator de carga é maior ou igual a 0.75 faz o rehashing
            rehash();
        }
    }

 
    public Object buscar(int chave) {
        int posicaoAcesso = hash(chave, this.tamanho);

        if (this.tabela[posicaoAcesso] != null) {
            Nodo no = this.tabela[posicaoAcesso].getInicio();

            while (no != null) {
                if (no.getChave() == chave) {
                    return no.getElemento().toString();
                }
                no = (Nodo) no.getProximo();
            }
        }
        return null;
    }
    
    //redimensionamento da tabela feito para ocasiões onde o número de elementos vai aumentando
    private void rehash() {
        int novoTamanho = calculaTamanho(this.tamanho);//calcular o tamanho novo

        ListaEncadeada[] novaTabela = new ListaEncadeada[novoTamanho];
        //reinserir os elementos pra nova tabela
        for (int i = 0; i < this.tamanho; i++) {
            if (this.tabela[i] != null) {
                Nodo no = this.tabela[i].getInicio();
                while (no != null) {//realocar os elemento para outros buckets
                    int novaPosicao = hash(no.getChave(), novoTamanho);
                    if (novaTabela[novaPosicao] == null) {
                        novaTabela[novaPosicao] = new ListaEncadeada();
                    }
                    novaTabela[novaPosicao].inserirObjeto(no.getChave(), no.getElemento());
                    no = (Nodo) no.getProximo();
                }
            }
        }
        this.tabela = novaTabela;
        this.tamanho = novoTamanho;
    }

    private int hash(int chave, int tamanho) {
        int quadrado = chave * chave;
        if (quadrado > 9) {
            String quadradoStr = String.valueOf(quadrado);
            int meio = quadradoStr.length() / 2;
            int valorMeio = Integer.parseInt(quadradoStr.substring(meio - 1, meio + 1));
            return valorMeio % tamanho;
        } else {
            return chave % tamanho;
        }
    }

    private int calculaTamanho(int tamElementos) {//calcula o tamanho ideal para a tabela hash
        int m = 2 * tamElementos;
        // m é o dobro dos elementos que se deseja adicionar na tabela
        // é recomendado o uso de um número primo mais próximo do valor m
        return fatorDeCarga(m, tamElementos);
    }
    
    //a função fator de carga vai selecionar se o primo mais próximo a direita
    //ou a esquerda representa um fator de carga mais pŕoximo de 0,50
    private int fatorDeCarga(int m, int tamElementos) {//retorna o valor que possui fator de carga mais próximo ao valor de 0.50
        int[] vet = BuscaPrimos.buscaPrimo(m);//busca o primo mais próximo de M
        double fatorDeCargaEsq = (double) tamElementos / vet[0];//calcula o o Fator de Carga do primo esquerdo
        double fatorDeCargaDir = (double) tamElementos / vet[1];//calcula o Fator de Carga do primo direito

        double diferencaEsq = Math.abs(fatorDeCargaEsq - 0.50);
        double diferencaDir = Math.abs(fatorDeCargaDir - 0.50);

        return BuscaPrimos.menorDiferenca(vet, diferencaEsq, diferencaDir);//verifica qual está mais próximo de 0.50
    }

    public void imprimir() {
        for (int i = 0; i < this.tamanho; i++) {
            System.out.print(i + ": ");
            if (this.tabela[i] != null) {
                this.tabela[i].imprimir();
            }else{
                System.out.println("Null");
            }
            System.out.println("");
        }
    }

    public void remover(int chave) {
        int posicaoAcesso = hash(chave, this.tamanho);
        if (this.tabela[posicaoAcesso] != null && this.tabela[posicaoAcesso].getTamanho() > 0) {
            this.tabela[posicaoAcesso].removerObjeto(chave);
        }
    }

}
