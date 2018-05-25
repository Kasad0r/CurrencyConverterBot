package telegram.menus;

import org.telegram.telegrambots.api.methods.send.SendMessage;

public class DefaultMessage {
    public static SendMessage nothingFind(long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Ничего не нашлось\uD83D\uDE2E");
        return sendMessage;
    }

    public static SendMessage wrongCommand(long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Не верная команда, выберите пункты с клавиатуры!⌨️");
        return sendMessage;
    }

    public static SendMessage wrongCurrency(long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Введена неверная валюта!");
        return sendMessage;
    }

}
