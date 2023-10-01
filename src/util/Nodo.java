package util;

public class Nodo {

    private Nodo proximo;
    private Object elemento;
    private int chave;

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public Nodo(int chave, Object elemento) {
        this.elemento = elemento;
        this.chave = chave;
        this.proximo = null;
    }

    public Nodo getProximo() {
        return proximo;
    }

    public void setProximo(Nodo proximo) {
        this.proximo = proximo;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

}
