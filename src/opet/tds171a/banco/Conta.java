package opet.tds171a.banco;

/**
 * 
 * @author Israel Block
 * @version 1.0.1
 * @since 6 de set de 2017
 */
public class Conta
{
    /**
     * 
     */
    private int conta;
    /**
     * 
     */
    private double saldo;

    /**
     * 
     */
    public Conta()
    {
    	//silence is gold
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
