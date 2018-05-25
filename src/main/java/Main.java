import logic.currency.CurrencyController;
import logic.currency.UpdateCurrency;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import telegram.TelegramController;

public class Main {
    public static void main(String[] args) {
        final UpdateCurrency updateCurrency = new UpdateCurrency(true);
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(new TelegramController());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

}

