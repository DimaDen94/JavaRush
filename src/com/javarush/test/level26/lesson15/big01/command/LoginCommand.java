package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Dmitry on 17.02.2016.
 */
class LoginCommand implements Command
{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.login_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));

        while (true){
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String inCard = ConsoleHelper.readString();

            String inPin = ConsoleHelper.readString();

            if(validCreditCards.containsKey(inCard))
            {
                if ( validCreditCards.getString(inCard).equals(inPin)){
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"),inCard));
                }
                break;
            }else if(inCard.length()!=12||inPin.length()!=4){
                ConsoleHelper.writeMessage("try.again.with.details");
            }
            else {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), inCard));
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                continue;
            }
        }
    }
}
