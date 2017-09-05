package opet.tds171a.banco;

public class ContaCorrente extends Conta
{

    private ContaCorrente()
    {
    }
    public ContaCorrente(int conta)
    {
        setConta(conta);
        setSaldo(5000);
    }

}
