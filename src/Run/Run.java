package Run;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.TabelaHash;

public class Run {

    public static void main(String[] args) {
        String caminho = "./src/entrada/executarQuestao.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String questao = br.readLine();
            switch (questao) {
                case "questao2":
                    questao2.Main.main(args);
                    break;
                case "questao3":
                    questao3.Main.main(args);
                    break;
                default:
                    System.out.println("Questão inexistente");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.out.printf("%s\n", e);
        }
    }

}
