package opet.tds171a.banco;

/**
 * 
 * @author Israel Block
 * @version 1.0.1
 * @since 6 de set de 2017
 */
public class ContaPoupanca extends Conta
{
    /**
     * 
     * @param conta
     */
    public ContaPoupanca(int conta)
    {
        setConta(conta);
        setSaldo(15000);
    }

}
