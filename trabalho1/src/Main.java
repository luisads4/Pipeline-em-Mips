import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Conversor conversor = new Conversor();
        LeitorArquivo leitorArquivo = new LeitorArquivo("instrucoes.txt");
        String[] linha;
        String resultado = "";

        while((linha = leitorArquivo.leLinha())!=null){
            resultado += conversor.converter(linha) + "\n";
        }
        leitorArquivo.escreveArquivo(resultado);
        System.out.println(resultado);

    }
}