package controle;

import java.io.File;
import java.io.IOException;
import org.jrimum.bopepo.Boleto;
import org.jrimum.bopepo.view.BoletoViewer;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
public class MeuPrimeiroBoleto {
    
    public static Titulo tituloaux;
    
    public static Titulo getTitulo(){
        return tituloaux;
    }
    
    public static void setTitulo(Titulo tituloaux){
        MeuPrimeiroBoleto.tituloaux = tituloaux;
    }

    public static void generateBoleto(Titulo tituloaux, String loc, String inst, 
            String in1,
            String in2,
            String in3,
            String in4,
            String in5,
            String in6,
            String in7,
            String in8){
            Boleto boleto = new Boleto(tituloaux);
            boleto.setLocalPagamento(loc);
            boleto.setInstrucaoAoSacado(inst);
            boleto.setInstrucao1(in1);
            boleto.setInstrucao2(in2);
            boleto.setInstrucao3(in3);
            boleto.setInstrucao4(in4);
            boleto.setInstrucao5(in5);
            boleto.setInstrucao6(in6);
            boleto.setInstrucao7(in7);
            boleto.setInstrucao8(in8);
            /*
                     * GERANDO O BOLETO BANCÁRIO.
             */
            // Instanciando um objeto "BoletoViewer", classe responsável pela
            // geração do boleto bancário.
            BoletoViewer boletoViewer = new BoletoViewer(boleto);

            // Gerando o arquivo. No caso o arquivo mencionado será salvo na mesma
            // pasta do projeto. Outros exemplos:
            // WINDOWS: boletoViewer.getAsPDF("C:/Temp/MeuBoleto.pdf");
            // LINUX: boletoViewer.getAsPDF("/home/temp/MeuBoleto.pdf");
            File arquivoPdf = boletoViewer.getPdfAsFile("MeuPrimeiroBoleto.pdf");

            // Mostrando o boleto gerado na tela.
            mostreBoletoNaTela(arquivoPdf);
    }

    public static void main(String[] args) { 
                        
        controle.Interface.main(args);
    }

    /**
     * Exibe o arquivo na tela.
     *
     * @param arquivoBoleto
     */
    private static void mostreBoletoNaTela(File arquivoBoleto) {

        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

        try {
            desktop.open(arquivoBoleto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
