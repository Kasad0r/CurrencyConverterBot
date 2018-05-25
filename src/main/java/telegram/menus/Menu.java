package telegram.menus;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

import java.util.ArrayList;
import java.util.List;

public interface Menu {

    List<String> commandList = new ArrayList<>(
    );

    SendMessage push(Message message);

    SendMessage perform(Message message);

    default boolean checkCommand(String command) {
        return commandList.stream().anyMatch(f -> f.equals(command));
    }
}
