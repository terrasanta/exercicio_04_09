package opet.tds171a.banco;

public class ContaPoupanca extends Conta
{

    private ContaPoupanca()
    {
    }
    public ContaPoupanca(int conta)
    {
        setConta(conta);
        setSaldo(15000);
    }

}
