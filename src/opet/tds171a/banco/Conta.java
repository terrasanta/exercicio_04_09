package opet.tds171a.banco;


public class Conta
{
    
    private int conta;
    private double saldo;

    public Conta()
    {
        
    }

    /**
     * @return the conta
     */
    public int getConta()
    {
        return conta;
    }

    /**
     * @param pConta the conta to set
     */
    public void setConta(int pConta)
    {
        conta = pConta;
    }

	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
    
    
}
