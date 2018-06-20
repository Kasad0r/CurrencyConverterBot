package telegram.menus;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import telegram.DefaultMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneralMenu {

    private List<String> commandList = new ArrayList<>(Arrays.asList(
            "Conversion\uD83D\uDCC8",
            "Exchange Rate\uD83D\uDCCA",
            "Info\uD83D\uDCAC"));

    public SendMessage push(Message message) {
        SendMessage sendMessage = new SendMessage();
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();
        sendMessage.setParseMode("html");
        row1.add("Conversion\uD83D\uDCC8");
        row2.add("Exchange Rates\uD83D\uDCCA");
        row3.add("Info\uD83D\uDCAC");
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row2, row3));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        sendMessage.setText("General menu: ");
        sendMessage.setChatId(message.getChatId());
        return sendMessage;
    }

    public SendMessage perform(Message message) {
        if (!checkCommand(message.getText())) {
            return DefaultMessage.wrongCommand(message.getChatId());
        }
        return null;
    }


    public boolean checkCommand(String command) {
        return commandList.stream().anyMatch(f -> f.equals(command));
    }

}
