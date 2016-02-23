package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Dmitry on 17.02.2016.
 */
class DepositCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.deposit_en");

    public void execute() throws InterruptOperationException
    {

            ConsoleHelper.writeMessage(res.getString("before"));
            String currencyCode = ConsoleHelper.askCurrencyCode();
            CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
            String[] moneyAndAmount = ConsoleHelper.getValidTwoDigits(currencyCode);
            try
            {
                int k = Integer.parseInt(moneyAndAmount[0]);
                int l = Integer.parseInt(moneyAndAmount[1]);
                currencyManipulator.addAmount(k, l);
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), k * l, currencyCode));
            } catch (NumberFormatException e)
            {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
            }


    }
}
