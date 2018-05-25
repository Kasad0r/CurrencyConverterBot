package telegram;

import logic.users.UserController;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class TelegramController extends TelegramLongPollingBot {
    private static final String username = "";
    private static final String token = "";
    private static UserController userController = new UserController();


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            long chatId = update.getMessage().getChatId();
            long userId = update.getMessage().getFrom().getId();
            userController.register(userId);
            if (update.getMessage().hasText()) {
                String messageText = update.getMessage().getText();

            }
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
