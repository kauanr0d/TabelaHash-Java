package questao3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        String caminho = "./src/entrada/entrada.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
        } catch (FileNotFoundException ex) {
            Logger.getLogger(questao3.Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(questao3.Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        int linhas = contarLinhas(caminho);
        System.out.println(linhas);
    }

    public static int contarLinhas(String caminhoArquivo) {
        int cont = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linhaCompleta = br.readLine();
            while (linhaCompleta != null) {
                linhaCompleta = br.readLine();
                cont++;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(questao3.Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(questao3.Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cont;
    }
}
