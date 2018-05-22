import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import telegram.TelegramController;

public class Main {
    public static void main(String[] args) {
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(new TelegramController());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

}

