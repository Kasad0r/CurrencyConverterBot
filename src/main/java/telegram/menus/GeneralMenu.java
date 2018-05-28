package telegram.menus;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import telegram.DefaultMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneralMenu implements Menu {

    private List<String> commandList = new ArrayList<>(Arrays.asList(
            "Конвертация\uD83D\uDCC8",
            "Курсы Валют\uD83D\uDCCA",
            "Инфо\uD83D\uDCAC"));

    @Override
    public SendMessage push(Message message) {
        SendMessage sendMessage = new SendMessage();
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();
        row1.add("<b>Конвертация</b>\uD83D\uDCC8");
        row2.add("<b>Курсы Валют</b>\uD83D\uDCCA");
        row3.add("<b>Инфо</b>\uD83D\uDCAC");
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row2, row3));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        sendMessage.setText("Главное меню: ");
        sendMessage.enableHtml(true);
        return sendMessage;
    }

    @Override
    public SendMessage perform(Message message) {
        if (!checkCommand(message.getText())) {
            return DefaultMessage.wrongCommand(message.getChatId());
        } else if (message.getText().equals(commandList.get(0))) {//Конвертация📈

        } else if (message.getText().equals(commandList.get(1))) {//Курсы Валют📊

        } else if (message.getText().equals(commandList.get(2))) {//Инфо💬

        }
        return null;
    }

    @Override
    public boolean checkCommand(String command) {
        return commandList.stream().anyMatch(f -> f.equals(command));
    }

}
