package telegram;

import entity.TempUserUnit;
import entity.emoji.Conversion;
import entity.emoji.Flag;
import entity.enums.Position;
import entity.enums.TriggeType;
import logic.users.UserController;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import telegram.menus.ConverterMenu;
import telegram.menus.GeneralMenu;

import java.math.BigDecimal;

import static logic.users.UserController.*;

public class TelegramController extends TelegramLongPollingBot {
    private static final String username = "CurrencyUaTelegrambot";
    private static final String token = "523356545:AAFfZcPaw5vtQnFsX0LxUNAiIaMYwJ6vaH8";
    private static UserController userController = new UserController();


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            long chatId = update.getMessage().getChatId();
            long userId = update.getMessage().getFrom().getId();
            System.out.println(userId);
            userController.register(userId);
            showList();
            if (update.getMessage().hasText()) {
                String messageText = update.getMessage().getText();
                if (messageText.equals("/start")) {
                    output(new GeneralMenu().push(update.getMessage()));
                } else if (Conversion.getConversionList().contains(messageText)) {
                    find(userId).setTriggerType(TriggeType.INPUTCURRENCYVALUE);
                    find(userId).setCurrencyToConvert(messageText);
                    output(DefaultMessage.inputValue(chatId));
                } else if (!find(userId).getTriggerType().equals(TriggeType.NONE)) {
                    TempUserUnit user = find(userId);
                    if (user.getTriggerType().equals(TriggeType.INPUTCURRENCYVALUE)) {
                        try {
                            user.setValue(new BigDecimal(messageText));
                            user.setTriggerType(TriggeType.NONE);

                        } catch (IllegalArgumentException e) {
                            output(DefaultMessage.wrongCurrency(chatId));
                            e.printStackTrace();
                        }
                    }
                } else if (messageText.equals("Conversion\uD83D\uDCC8") &&
                        find(userId).getPosition().equals(Position.GENERALMENU)) {
                    find(userId).setPosition(Position.CURRENCYCHOICEMENU);
                    output(new ConverterMenu().push(update.getMessage()));
                } else if (messageText.equals("Exchange Rates\uD83D\uDCC8") &&
                        find(userId).getPosition().equals(Position.GENERALMENU)) {

                } else if (messageText.equals("Back")) {
                    output(ButtonChecker.buttonBack(update, userId));
                }

            }
        }
    }

    private static void output(SendMessage sendMessage) {
        try {
            new TelegramController().execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
