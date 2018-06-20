package telegram.menus;

import entity.TempUserUnit;
import entity.emoji.Conversion;
import entity.enums.TriggeType;
import logic.users.UserController;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entity.emoji.Flag;
import telegram.DefaultMessage;

public class ConverterMenu{
    private List<String> commandList = new ArrayList<>();

    public SendMessage push(Message message) {
        SendMessage sendMessage = new SendMessage();
            sendMessage.setText("Select currency for exchange:");
        sendMessage.setChatId(message.getChatId());
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();
        KeyboardRow row4 = new KeyboardRow();
        KeyboardRow row5 = new KeyboardRow();
        row1.add(Conversion.UAtoUSA);
        row1.add(Conversion.USAtoUA);
        row2.add(Conversion.UAtoEU);
        row2.add(Conversion.EUtoUA);
        row3.add(Conversion.UAtoRU);
        row3.add(Conversion.RUtoUA);
        row4.add(Conversion.BTCtoUSA);
        row4.add(Conversion.USAtoTBC);
        row5.add("Back");
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row2, row3, row4, row5));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }


    public boolean checkCommand(String command) {
        return commandList.stream().anyMatch(f -> f.equals(command));
    }
}
