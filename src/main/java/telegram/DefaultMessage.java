package telegram;

import org.telegram.telegrambots.api.methods.send.SendMessage;

public class DefaultMessage {
    public static SendMessage nothingFind(long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Nothing was found\uD83D\uDE2E");
        return sendMessage;
    }

    public static SendMessage wrongCommand(long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Invalid command, select items from the keyboard!");
        return sendMessage;
    }

    public static SendMessage wrongCurrency(long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("The wrong currency is entered!");
        return sendMessage;
    }

}
