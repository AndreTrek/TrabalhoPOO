package controle;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.bopepo.Boleto;
import org.jrimum.bopepo.view.BoletoViewer;
import org.jrimum.domkee.comum.pessoa.endereco.CEP;
import org.jrimum.domkee.comum.pessoa.endereco.Endereco;
import org.jrimum.domkee.comum.pessoa.endereco.UnidadeFederativa;
import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.Cedente;
import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.jrimum.domkee.financeiro.banco.febraban.Sacado;
import org.jrimum.domkee.financeiro.banco.febraban.SacadorAvalista;
import org.jrimum.domkee.financeiro.banco.febraban.TipoDeTitulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo.EnumAceite;

/**
 * <p>
 * Exemplo de código para geração de um boleto simples.
 * </p>
 * <p>
 * Utiliza o Banco Bradesco como exemplo, já que possui um implementação
 * simples.
 * </p>
 *
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 *
 * @since 0.2
 *
 * @version 0.2
 */
public class MeuPrimeiroBoleto {
    
    public static Titulo tituloaux;
    public static boolean flag;
    
    public static Titulo getTitulo(){
        return tituloaux;
    }
    
    public static void setTitulo(Titulo tituloaux){
        MeuPrimeiroBoleto.tituloaux = tituloaux;
    }
    /*
    public static void setFlag(boolean flag){
        MeuPrimeiroBoleto.flag = flag;
    }
    
    public static boolean getFlag(){
        return flag;
    }*/
    public static void generateBoleto(Titulo tituloaux){
            Boleto boleto = new Boleto(tituloaux);
            boleto.setLocalPagamento("Pagável preferencialmente na Rede X ou em "
                    + "qualquer Banco até o Vencimento.");
            boleto.setInstrucaoAoSacado("Senhor sacado, sabemos sim que o valor "
                    + "cobrado não é o esperado, aproveite o DESCONTÃO!");
            boleto.setInstrucao1("PARA PAGAMENTO 1 até Hoje não cobrar nada!");
            boleto.setInstrucao2("PARA PAGAMENTO 2 até Amanhã Não cobre!");
            boleto.setInstrucao3("PARA PAGAMENTO 3 até Depois de amanhã, OK, não cobre.");
            boleto.setInstrucao4("PARA PAGAMENTO 4 até 04/xx/xxxx de 4 dias atrás COBRAR O VALOR DE: R$ 01,00");
            boleto.setInstrucao5("PARA PAGAMENTO 5 até 05/xx/xxxx COBRAR O VALOR DE: R$ 02,00");
            boleto.setInstrucao6("PARA PAGAMENTO 6 até 06/xx/xxxx COBRAR O VALOR DE: R$ 03,00");
            boleto.setInstrucao7("PARA PAGAMENTO 7 até xx/xx/xxxx COBRAR O VALOR QUE VOCÊ QUISER!");
            boleto.setInstrucao8("APÓS o Vencimento, Pagável Somente na Rede X.");

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
        //flag = getFlag();
        /*
        if(flag){
            
        }*/
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
