package opet.tds171a.menu;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import opet.tds171a.banco.ContaCorrente;
import opet.tds171a.banco.ContaExtrato;
import opet.tds171a.banco.ContaPoupanca;
import opet.tds171a.util.Leitor;
import opet.tds171a.util.Util;

/**
 * 
 * @author Israel Block
 * @version 1.0.1
 * @since 6 de set de 2017
 */
public class MenuOperacoes{
	
	/**
	 * 
	 */
	protected ArrayList<ContaCorrente> contaC = new ArrayList<ContaCorrente>();
    
	/**
	 * 
	 */
	protected ArrayList<ContaPoupanca> contaP = new ArrayList<ContaPoupanca>();
	
	/**
	 * 
	 */
	protected ArrayList<ContaExtrato> extrato = new ArrayList<ContaExtrato>();
	
	/**
	 * 
	 */
	public MenuOperacoes(){
		iniciaConta();
	}

	/**
	 * 
	 */
	private void iniciaConta(){
    	this.contaC.add(new ContaCorrente(1234));
    	this.contaP.add(new ContaPoupanca(5678));
    }

	/*
	 * operações de conta corrente
	 */
	
	/**
	 * 
	 * @param conta
	 */
	public void saldoCC(int conta){
    	for(ContaCorrente contaC : this.contaC){
    		if(contaC.getConta() == conta){
    			System.out.println("O saldo atual é de: "+contaC.getSaldo());
    		}
    	}
    }
	
	/**
	 * 
	 * @param conta
	 * @throws ParseException
	 */
    public void depositoCC(int conta) throws ParseException{
    	for(ContaCorrente contaC : this.contaC){
    		if(contaC.getConta() == conta){
    			System.out.println("O saldo atual é de: "+contaC.getSaldo());
    			System.out.println("======================================");
    			double valorDeposito = Leitor.readDouble("Digite o valor que deseja depositar ou digite 0 para cancelar a operação: ");
    			if(valorDeposito == 0){
    				System.out.println("Operação cancelada. Voltando para o menu de opções...");
    			}else
    			if(valorDeposito < 0){
    				System.out.println("Você está realizando uma operação de deposito. Não é possível debitar nesta operação.");
    				this.depositoCC(conta);
    			}else{
    				contaC.setSaldo((contaC.getSaldo() + valorDeposito));
    				System.out.println("======================================");
    				System.out.println("Operação realizada com sucesso. Seu novo saldo é de: "+ contaC.getSaldo());
    				salvaExtrato(conta, "Depósito", "Deposito em conta corrente no valor de "+valorDeposito);
    			}
    		}
    	}
    }
    
    /**
     * 
     * @param conta
     * @throws ParseException
     */
    public void saqueCC(int conta) throws ParseException{
    	for(ContaCorrente contaC : this.contaC){
    		if(contaC.getConta() == conta){
    			System.out.println("O saldo atual é de: "+contaC.getSaldo());
    			System.out.println("======================================");
    			double valorSaque = Leitor.readDouble("Digite o valor que deseja sacar ou digite 0 para cancelar a operação: ");
    			if(valorSaque == 0){
    				System.out.println("Operação cancelada. Voltando para o menu de opções...");
    			}else
    			if(valorSaque < 0){
    				System.out.println("Digite um valor positivo para realizar o saque.");
    				this.saqueCC(conta);
    			}else if(valorSaque > contaC.getSaldo()){
    				System.out.println("Saldo insuficiente. Digite um valor até "+contaC.getSaldo());
    				this.saqueCC(conta);
    			}
    			else{
    				contaC.setSaldo((contaC.getSaldo() - valorSaque));
    				System.out.println("======================================");
    				System.out.println("Operação realizada com sucesso. Seu novo saldo é de: "+ contaC.getSaldo());
    				salvaExtrato(conta, "Saque", "Saque em conta corrente no valor de "+valorSaque);
    			}
    		}
    	}
    }
    /**
     * 
     * @param conta
     * @throws ParseException
     */
    public void transferenciaCC(int conta) throws ParseException {
    	for(ContaCorrente contaC : this.contaC){
    		if(contaC.getConta() == conta){
    			System.out.println("O saldo atual é de: "+contaC.getSaldo());
    			System.out.println("======================================");
    			int favorecido = 0;
    			int favorecidoBusca = Leitor.readInt("Digite o número da conta a ser favorecida: ");
    			for(ContaCorrente busca : this.contaC){
    	    		if(busca.getConta() == favorecidoBusca){
    	    			favorecido = busca.getConta();
    	    			break;
    	    		}
    	    	}
    	    	for(ContaPoupanca busca : this.contaP){
    	    		if(busca.getConta() == favorecidoBusca){
    	    			favorecido = busca.getConta();
    	    			break;
    	    		}
    	    	}
    	    	if(favorecido != 0) {
    	    		System.out.println("Conta para transferencia encontrada.");
    	    		double valorTransf = Leitor.readDouble("Digite o valor que deseja transferir ou digite 0 para cancelar a operação: ");
        			if(valorTransf == 0){
        				System.out.println("Operação cancelada. Voltando para o menu de opções...");
        			}else
        			if(valorTransf < 0){
        				System.out.println("Digite um valor positivo para realizar a transferencia.");
        				this.transferenciaCC(conta);
        			}else if(valorTransf > contaC.getSaldo()){
        				System.out.println("Saldo insuficiente. Digite um valor até "+contaC.getSaldo());
        				this.transferenciaCC(conta);
        			}
        			else{
        				contaC.setSaldo((contaC.getSaldo() - valorTransf));
						for(ContaCorrente busca : this.contaC){
		    	    		if(busca.getConta() == favorecido){
		    	    			busca.setSaldo(busca.getSaldo()+valorTransf);
		    	    			break;
		    	    		}
		    	    	}
		    	    	for(ContaPoupanca busca : this.contaP){
		    	    		if(busca.getConta() == favorecido){
		    	    			busca.setSaldo(busca.getSaldo()+valorTransf);
		    	    			break;
		    	    		}
		    	    	}
        				System.out.println("======================================");
        				System.out.println("Operação realizada com sucesso. Seu novo saldo é de: "+ contaC.getSaldo());
        				salvaExtrato(conta, "Transfêrencia", "Transferencia no valor de "+valorTransf+" para a conta "+favorecido);
        				salvaExtrato(favorecido, "Transfêrencia", "Transferencia no valor de "+valorTransf+" recebido de "+conta);
        			}
    	    	}else {
    	    		System.out.println("A conta digitada não existe em nosso sistema. Por favor, verifique.");
    	    		transferenciaCC(conta);
    	    	}
    		}
    	}
    }
    
    /*
	 * operações de conta poupanca
	 */
    
    /**
     * 
     * @param conta
     */
    public void saldoCP(int conta){
    	for(ContaPoupanca contaP : this.contaP){
    		if(contaP.getConta() == conta){
    			System.out.println("O saldo atual é de: "+contaP.getSaldo());
    			
    		}
    	}
    }
    /**
     * 
     * @param conta
     * @throws ParseException
     */
    public void depositoCP(int conta) throws ParseException{
    	for(ContaPoupanca contaP : this.contaP){
    		if(contaP.getConta() == conta){
    			System.out.println("O saldo atual é de: "+contaP.getSaldo());
    			System.out.println("======================================");
    			double valorDeposito = Leitor.readDouble("Digite o valor que deseja depositar ou digite 0 para cancelar a operação: ");
    			if(valorDeposito == 0){
    				System.out.println("Operação cancelada. Voltando para o menu de opções...");
    			}else
    			if(valorDeposito < 0){
    				System.out.println("Você está realizando uma operação de deposito. Não é possível debitar nesta operação.");
    				this.depositoCP(conta);
    			}else{
    				contaP.setSaldo((contaP.getSaldo() + valorDeposito));
    				System.out.println("======================================");
    				System.out.println("Operação realizada com sucesso. Seu novo saldo é de: "+ contaP.getSaldo());
    				salvaExtrato(conta, "Depósito", "Deposito em conta poupança no valor de "+valorDeposito);
    			}
    		}
    	}
    }
    
    /**
     * 
     * @param conta
     * @throws ParseException
     */
    public void saqueCP(int conta) throws ParseException{
    	for(ContaPoupanca contaP : this.contaP){
    		if(contaP.getConta() == conta){
    			System.out.println("O saldo atual é de: "+contaP.getSaldo());
    			System.out.println("======================================");
    			double valorSaque = Leitor.readDouble("Digite o valor que deseja sacar ou digite 0 para cancelar a operação: ");
    			if(valorSaque == 0){
    				System.out.println("Operação cancelada. Voltando para o menu de opções...");
    			}else
    			if(valorSaque < 0){
    				System.out.println("Digite um valor positivo para realizar o saque.");
    				this.saqueCP(conta);
    			}else if(valorSaque > contaP.getSaldo()){
    				System.out.println("Saldo insuficiente. Digite um valor até "+contaP.getSaldo());
    				this.saqueCP(conta);
    			}
    			else{
    				contaP.setSaldo((contaP.getSaldo() - valorSaque));
    				System.out.println("======================================");
    				System.out.println("Operação realizada com sucesso. Seu novo saldo é de: "+ contaP.getSaldo());
    				salvaExtrato(conta, "saque", "Saque em conta poupança no valor de "+valorSaque);
    			}
    		}
    	}
    }
    /**
     * 
     * @param conta
     * @throws ParseException
     */
    public void transferenciaCP(int conta) throws ParseException {
    	for(ContaPoupanca contaP : this.contaP){
    		if(contaP.getConta() == conta){
    			System.out.println("O saldo atual é de: "+contaP.getSaldo());
    			System.out.println("======================================");
    			int favorecido = 0;
    			int favorecidoBusca = Leitor.readInt("Digite o número da conta a ser favorecida: ");
    			for(ContaCorrente busca : this.contaC){
    	    		if(busca.getConta() == favorecidoBusca){
    	    			favorecido = busca.getConta();
    	    			break;
    	    		}
    	    	}
    	    	for(ContaPoupanca busca : this.contaP){
    	    		if(busca.getConta() == favorecidoBusca){
    	    			favorecido = busca.getConta();
    	    			break;
    	    		}
    	    	}
    	    	if(favorecido != 0) {
    	    		System.out.println("Conta para transferencia encontrada.");
    	    		double valorTransf = Leitor.readDouble("Digite o valor que deseja transferir ou digite 0 para cancelar a operação: ");
        			if(valorTransf == 0){
        				System.out.println("Operação cancelada. Voltando para o menu de opções...");
        			}else
        			if(valorTransf < 0){
        				System.out.println("Digite um valor positivo para realizar a transferencia.");
        				this.transferenciaCP(conta);
        			}else if(valorTransf > contaP.getSaldo()){
        				System.out.println("Saldo insuficiente. Digite um valor até "+contaP.getSaldo());
        				this.transferenciaCP(conta);
        			}
        			else{
        				contaP.setSaldo((contaP.getSaldo() - valorTransf));
						for(ContaCorrente busca : this.contaC){
		    	    		if(busca.getConta() == favorecido){
		    	    			busca.setSaldo(busca.getSaldo()+valorTransf);
		    	    			break;
		    	    		}
		    	    	}
		    	    	for(ContaPoupanca busca : this.contaP){
		    	    		if(busca.getConta() == favorecido){
		    	    			busca.setSaldo(busca.getSaldo()+valorTransf);
		    	    			break;
		    	    		}
		    	    	}
        				System.out.println("======================================");
        				System.out.println("Operação realizada com sucesso. Seu novo saldo é de: "+ contaP.getSaldo());
        				salvaExtrato(conta, "Transfêrencia", "Transferencia no valor de "+valorTransf+" para a conta "+favorecido);
        				salvaExtrato(favorecido, "Transfêrencia", "Transferencia no valor de "+valorTransf+" recebido de "+conta);
        			}
    	    	}else {
    	    		System.out.println("A conta digitada não existe em nosso sistema. Por favor, verifique.");
    	    		transferenciaCC(conta);
    	    	}
    		}
    	}
    }
    
    /**
     * 
     * @param conta
     * @param operacao
     * @param resumo
     * @throws ParseException
     */
    private void salvaExtrato(int conta, String operacao, String resumo) throws ParseException {
    	/*DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);*/
		Calendar calendar = Calendar.getInstance();
		calendar.setLenient(false);
		Date dataAtual = calendar.getTime();
		
		Locale localeBrasil = new Locale("pt","BR");
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, localeBrasil);
		
		extrato.add(new ContaExtrato(conta, operacao, Util.formataData_(df.format(dataAtual)), resumo));
    }
    /**
     * 
     * @param conta
     * @throws ParseException
     */
    public void verificaExtrato(int conta) throws ParseException {
    	System.out.println("============================================");
    	System.out.println("              Extrato de conta              ");
    	System.out.println("============================================");
    	int ve = 0;
    	for(ContaExtrato contaE : this.extrato) {
    		if(contaE.getConta() == conta) {
    			System.out.print("Operação: "+contaE.getOperacao() +" - ");
    			System.out.print(Util.formataData_(contaE.getData()) +" - ");
    			System.out.println("Resumo: "+contaE.getResumo());
    			ve++;
    		}
    	}
    	if(ve == 0) {
    		System.out.println("Nenhuma operação recente a ser exibida");
    	}
    	for(ContaCorrente contaC : this.contaC){
    		if(contaC.getConta() == conta){
    			System.out.println("O saldo atual é de: "+contaC.getSaldo());
    			break;
    		}
    	}
    	for(ContaPoupanca contaP : this.contaP){
    		if(contaP.getConta() == conta){
    			System.out.println("O saldo atual é de: "+contaP.getSaldo());
    			break;
    		}
    	}
    }

}
