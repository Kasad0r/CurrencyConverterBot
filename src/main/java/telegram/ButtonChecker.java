package telegram;

import entity.enums.Position;
import logic.users.UserController;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import telegram.menus.GeneralMenu;

public class ButtonChecker {
    public static SendMessage buttonBack(Update update, long userId) {
        if (UserController.find(userId).getPosition() != null &&
                !UserController.find(userId).getPosition().equals(Position.GENERALMENU)) {
            if (UserController.find(userId).getPosition().equals(Position.CURRENCYCHOICEMENU)) {
                UserController.find(userId).setPosition(Position.GENERALMENU);
                return new GeneralMenu().push(update.getMessage());

            }
        }
        return DefaultMessage.wrongCommand(update.getMessage().getChatId());
    }
}
