package opet.tds171a.banco;

import java.util.Date;

public class ContaExtrato {

	private int conta;
	private String operacao;
	private Date data;
	private String resumo;
	
	private ContaExtrato() {
	}
	public ContaExtrato(int conta, String operacao, Date data, String resumo){
		setConta(conta);
		setOperacao(operacao);
		setData(data);
		setResumo(resumo);
	}

	/**
	 * @return the conta
	 */
	public int getConta() {
		return conta;
	}

	/**
	 * @param conta the conta to set
	 */
	public void setConta(int conta) {
		this.conta = conta;
	}

	/**
	 * @return the operacao
	 */
	public String getOperacao() {
		return operacao;
	}

	/**
	 * @param operacao the operacao to set
	 */
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * @return the resumo
	 */
	public String getResumo() {
		return resumo;
	}

	/**
	 * @param resumo the resumo to set
	 */
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

}
