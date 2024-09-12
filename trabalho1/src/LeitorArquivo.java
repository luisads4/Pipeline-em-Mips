import java.io.*;

public class LeitorArquivo {
    private String diretorioArquivo;
    BufferedReader entradaDeDados;

    public LeitorArquivo(String diretorioArquivo) throws FileNotFoundException {
        this.diretorioArquivo = diretorioArquivo;
        this.entradaDeDados = new BufferedReader(new FileReader(diretorioArquivo));
    }

    public String[] leLinha() {
        String[] linhaArray = null; //vai guardar cada palavra da linha
        try {
            String linha = entradaDeDados.readLine();
            if (linha != null) {
                //remove o que nao faz parte da instrucao
                linha = linha.replace(",", "");
                linha = linha.replace("(", " ");
                linha = linha.replace(")", "");

                // Remove espaços extras
                linha = linha.trim().replaceAll("\\s+", " ");

                linhaArray = linha.split(" ");

            } else {
                entradaDeDados.close();
                linhaArray = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhaArray;
    }
    public void escreveArquivo(String escreverArquivo){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("resultado.txt"));
            bufferedWriter.write(escreverArquivo, 0, escreverArquivo.length());
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
