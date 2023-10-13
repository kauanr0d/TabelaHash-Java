package questao3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.TabelaHash;

public class Main {

    public static void main(String[] args) {
        String caminho = "./src/entrada/entrada.txt";
        int tamanhoInicial = contarLinhas(caminho);
        TabelaHash tabelaHash = new TabelaHash(tamanhoInicial);

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha = br.readLine();
            while (linha != null) {
                String[] token = linha.split(";");
                int id = Integer.parseInt(token[0]);
                String nome, email, cidade;
                nome = token[1];
                email = token[2];
                cidade = token[3];
                Cliente c = new Cliente(id, nome, email, cidade);
                tabelaHash.inserir(id, c);
                linha = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(questao3.Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(questao3.Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        caminho = "./src/entrada/exec.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            String[] token;
            linha = br.readLine();
            while (linha != null) {
                token = linha.split(";");
                switch (token[0]) {
                    case "inserir":
                        String[] token2 = linha.split(";");
                        int idCliente = Integer.parseInt(token[1]);
                        String nome,
                         email,
                         cidade;
                        int id = Integer.parseInt(token[1]);
                        nome = token[2];
                        email = token[3];
                        cidade = token[4];
                        Cliente c = new Cliente(id, nome, email, cidade);
                        tabelaHash.inserir(id, c);
                        break;
                    case "remover":
                        tabelaHash.remover(Integer.parseInt(token[1]));
                        break;
                    case "imprimir":
                        tabelaHash.imprimir();
                        break;
                    case "buscar":
                        System.out.println("Encontrado:"+tabelaHash.buscar(Integer.parseInt(token[1])));
                     
                        break;
                }
                linha = br.readLine();

            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
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
