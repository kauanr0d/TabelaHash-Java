package questao2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ListaEncadeada;
import util.TabelaHash;

public class Main {

    public static void main(String[] args) {

        String caminho = "./src/entrada/questao2.txt";
        TabelaHash tabelaHash = new TabelaHash(1);
        ArrayList<Integer> lista = new ArrayList();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha = br.readLine();
            String[] token = linha.split(" ");//separando por espaço
            for (String i : token) {
                lista.add(Integer.valueOf(i));
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        int[] duplicatas = verificaDuplicatas(tabelaHash, lista);

        System.out.print("Duplicados:");
        System.out.print("{");
        for (int i : duplicatas) {
            System.out.print(i + " ");
        }
        System.out.print("}\n");
    }

    public static int[] verificaDuplicatas(TabelaHash t, ArrayList<Integer> lista) {
        int tam = t.getTamanho();
        int k = 0;
      
        ArrayList<Integer> duplicados = new ArrayList();
        int vet[];
        for (Integer i : lista) {
            if (k == 0) {
                t.inserir((int) i, (int) i);
            } else if ((t.buscar(i) == null)) {
                t.inserir((int) i, (int) i);
            } else {
                duplicados.add(i);
            }
            k++;
        }
        return vet = processa(duplicados);
    }

    public static int [] processa( ArrayList<Integer> lista) {
        int vet[] = new int [lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            vet[i] = lista.get(i);
        }
        return vet;

    }
}
