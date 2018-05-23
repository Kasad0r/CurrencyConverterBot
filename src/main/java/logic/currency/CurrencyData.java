package logic.currency;

import com.google.gson.*;
import entity.CurrencyEntity;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

final public class CurrencyData {

    public String getJsonFromSite() {
        StringBuilder jsonString = new StringBuilder();
        try {
            InputStream site = new URL("https://api.privatbank.ua/p24api/pubinfo?exchange&json&coursid=11").openStream();
            Scanner scanner = new Scanner(site);
            while (scanner.hasNext()) {
                jsonString.append(scanner.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString.toString();
    }

    public List<CurrencyEntity> parseJson() {
        String jsonString = getJsonFromSite();
        List<CurrencyEntity> result = new ArrayList<>();
        JsonParser jsonParser = new JsonParser();
        JsonArray currJsonArr = (JsonArray) jsonParser.parse(jsonString);

        for (JsonElement j : currJsonArr
                ) {
            JsonObject jsonObject = j.getAsJsonObject();
            result.add(new CurrencyEntity(jsonObject.get("ccy").getAsString(),
                    jsonObject.get("base_ccy").getAsString(),
                    jsonObject.get("buy").getAsDouble(),
                    jsonObject.get("sale").getAsDouble()));
        }
        return result;
    }

}
