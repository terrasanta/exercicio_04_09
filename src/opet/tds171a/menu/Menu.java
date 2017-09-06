package opet.tds171a.menu;

import java.text.ParseException;

import opet.tds171a.banco.ContaCorrente;
import opet.tds171a.banco.ContaPoupanca;
import opet.tds171a.util.Leitor;

/**
 * 
 * @author Israel Block
 * @version 1.0.1
 * @since 6 de set de 2017
 */
public class Menu extends MenuOperacoes 
{
	
	/**
	 * 
	 */
    public Menu()
    {
        super();
    }
    
    /**
     * @throws ParseException 
     * 
     */
    public void inicio() throws ParseException{
    	int opc = 0;
        do {
            System.out.println("====================================");
            System.out.println("                MENU                ");
            System.out.println("====================================");
            System.out.println("Digite 1 para acessar sua conta: ");
            System.out.println("Digite 9 para sair");
            opc = Leitor.readInt("");
            switch(opc) {
                case 1:
                    login();
                    break;
                case 9:
                    System.out.println("Até logo!");
                    break;
                default:
                    System.out.println("A opção digitada não foi encontrada. Por favor, verifique.");
                    break;
            }
        }while(opc != 9);
    }
    
    /**
     * @throws ParseException 
     * 
     */
    public void login() throws ParseException {
        int nConta = Leitor.readInt("Digite o número da conta para acessar: ");
        int vc = verificaConta(nConta);
        if(vc == 1){
        	int vt = verificaTipoConta(nConta);
        	if(vt == 1){
        		this.menuPrincipalCC(nConta);
        	}
        	if(vt == 2){
        		this.menuPrincipalCP(nConta);
        	}
        }else if(vc == 0){
        	System.out.println("Conta inexistente. Por favor, verifique e tente novamente");
        }
    }
    
    /**
     * 
     * @param conta
     * @return
     */
    public int verificaConta(int conta) {
    	int verifica = 0;
        if(verifica == 0){
        	for(ContaCorrente contaC: this.contaC){
        		if(conta == contaC.getConta()){
        			verifica = 1;
        			break;
        		}
        	}
        }
        if(verifica == 0){
        	for(ContaPoupanca contaP: this.contaP){
        		if(conta == contaP.getConta()){
        			verifica = 1;
        			break;
        		}
        	}
        }
    	
        return verifica;
    }
    
    /**
     * 
     * @param conta
     * @return
     */
    public int verificaTipoConta(int conta) {
    	int verifica = 0;
        if(verifica == 0){
        	for(ContaCorrente contaC: this.contaC){
        		if(conta == contaC.getConta()){
        			verifica = 1;
        			break;
        		}
        	}
        }
        if(verifica == 0){
        	for(ContaPoupanca contaP: this.contaP){
        		if(conta == contaP.getConta()){
        			verifica = 2;
        			break;
        		}
        	}
        }
    	
        return verifica;
    }
    
    
    /**
     * @throws ParseException 
     * 
     */
    public void menuPrincipalCC(int nConta) throws ParseException{
    	int opc = 0;
    	System.out.println("Acessando a conta corrente");
        do {
            System.out.println("====================================");
            System.out.println("           MENU DA CONTA           ");
            System.out.println("====================================");
            System.out.println("Digite 1 para visualizar seu saldo: ");
            System.out.println("Digite 2 para imprimir seu extrato: ");
            System.out.println("Digite 3 para realizar um depósito em conta: ");
            System.out.println("Digite 4 para realizar um saque em conta: ");
            System.out.println("Digite 5 para realizar uma transferencia: ");
            System.out.println("Digite 9 para sair da sua conta.");
            opc = Leitor.readInt("");
            switch(opc) {
                case 1:
                	this.saldoCC(nConta);
                    break;
                case 2:
                	this.verificaExtrato(nConta);
                    break;
                case 3:
                	this.depositoCC(nConta);
                    break;
                case 4:
                	this.saqueCC(nConta);
                    break;
                case 5:
                	this.transferenciaCC(nConta);
                    break;
                case 9:
                	System.out.println("Até breve!");
                    break;
                default:
                    System.out.println("A opção digitada não foi encontrada. Por favor, verifique.");
                    break;
            }
        }while(opc != 9);
    }
    
    /**
     * @throws ParseException 
     * 
     */
    public void menuPrincipalCP(int nConta) throws ParseException{
    	int opc = 0;
    	System.out.println("Acessando a conta poupança");
        do {
            System.out.println("====================================");
            System.out.println("           MENU DA CONTA           ");
            System.out.println("====================================");
            System.out.println("Digite 1 para visualizar seu saldo: ");
            System.out.println("Digite 2 para imprimir seu extrato: ");
            System.out.println("Digite 3 para realizar um depósito em conta: ");
            System.out.println("Digite 4 para realizar um saque em conta: ");
            System.out.println("Digite 5 para realizar uma transferencia: ");
            System.out.println("Digite 9 para sair da sua conta.");
            opc = Leitor.readInt("");
            switch(opc) {
                case 1:
                	this.saldoCP(nConta);
                    break;
                case 2:
                	this.verificaExtrato(nConta);
                    break;
                case 3:
                	this.depositoCP(nConta);
                    break;
                case 4:
                	this.saqueCP(nConta);
                    break;
                case 5:
                	this.transferenciaCP(nConta);
                    break;
                case 9:
                	System.out.println("Até breve!");
                    break;
                default:
                    System.out.println("A opção digitada não foi encontrada. Por favor, verifique.");
                    break;
            }
        }while(opc != 9);
    }

}
