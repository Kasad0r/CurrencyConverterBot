
import logic.currency.UpdateCurrency;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import telegram.TelegramController;

public class Main {
    static {
        ApiContextInitializer.init();
        System.out.println("Main.static initializer : Init updateCurrency...");
        final UpdateCurrency updateCurrency = new UpdateCurrency(true);
        System.out.println("Main.static initializer : Init done!");
    }
    public static void main(String[] args) {
        TelegramBotsApi botsApi = new TelegramBotsApi();
        System.out.println("Main.main : Register bot...");
        try {
            botsApi.registerBot(new TelegramController());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
        System.out.println("Main.main : Bot Registered!");
    }

}

