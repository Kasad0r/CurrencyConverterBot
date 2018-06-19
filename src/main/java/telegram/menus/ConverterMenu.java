package telegram.menus;

import entity.TempUserUnit;
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

public class ConverterMenu implements Menu {
    private List<String> commandList = new ArrayList<>();

    @Override
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
        row1.add(String.format("%s-%s", Flag.UA, Flag.US));
        row1.add(String.format("%s-%s", Flag.US, Flag.UA));
        row2.add(String.format("%s-%s", Flag.UA, Flag.EU));
        row2.add(String.format("%s-%s", Flag.EU, Flag.UA));
        row3.add(String.format("%s-%s", Flag.UA, Flag.RU));
        row3.add(String.format("%s-%s", Flag.RU, Flag.UA));
        row4.add(String.format("%s-%s", Flag.BTC, Flag.US));
        row4.add(String.format("%s-%s", Flag.US, Flag.BTC));
        row5.add("Back");
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row2, row3, row4, row5));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    @Override
    public SendMessage perform(Message message) {
        TempUserUnit userUnit = UserController.find(message.getFrom().getId());
        if (userUnit.getToDo().getTriggerType() == TriggeType.NONE) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setText("How much should I exchange: ");
            UserController.find(message.getFrom().getId()).getToDo().setTriggerType(TriggeType.INPUTCURRENCYVALUE);
            sendMessage.setChatId(message.getChatId());
            return sendMessage;
        } else if (userUnit.getToDo().getTriggerType() == TriggeType.INPUTCURRENCYVALUE) {
            try {
                UserController.find(message.getFrom().getId()).setValue(new BigDecimal(message.getText()));
            } catch (Exception e) {
                UserController.find(message.getFrom().getId()).getToDo().setTriggerType(TriggeType.NONE);
            }
            push(message);
        } else {
            return DefaultMessage.wrongCommand(message.getChatId());
        }
        return DefaultMessage.wrongCurrency(message.getChatId());
    }

    @Override
    public boolean checkCommand(String command) {
        return commandList.stream().anyMatch(f -> f.equals(command));
    }
}
