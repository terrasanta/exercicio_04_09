package opet.tds171a.main;

import java.text.ParseException;

import opet.tds171a.banco.Conta;
import opet.tds171a.menu.Menu;

public class Main
{

    public static void main(String[] args) throws ParseException
    {
        Conta conta = new Conta();
        Menu menu = new Menu();
        menu.inicio();
    }

}
