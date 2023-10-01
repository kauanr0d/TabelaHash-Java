package util;

public class BuscaPrimos {

    
    
    public static int [] buscaPrimo(int valor){
        int primoEsquerda = encontrarPrimoEsquerda(valor);
        int primoDireita = encontrarPrimoDireita(valor);
        int []vet = {primoEsquerda,primoDireita};
        return vet;
    }
    public static int menorDiferenca(int [] vet,double difEsq, double difDir){
        if (difEsq < difDir) {
            return vet[0];
        } else {
            return vet[1];
        }
    }
    private static boolean ehPrimo(int valor) {
        if (valor <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(valor); i++) {
            if (valor % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int encontrarPrimoEsquerda(int valor) {
        int primo = valor - 1;
        while (primo > 1) {
            if (ehPrimo(primo)) {
                return primo;
            }
            primo--;
        }
        return -1;
    }

    private static int encontrarPrimoDireita(int valor) {
        int primo = valor + 1;
        while (true) {
            if (ehPrimo(primo)) {
                return primo;
            }
            primo++;
        }
    }
}
