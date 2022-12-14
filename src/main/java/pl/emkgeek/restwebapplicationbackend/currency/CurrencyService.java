package pl.emkgeek.restwebapplicationbackend.currency;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyService {

    private final String NBP_API_URI = "http://api.nbp.pl/api/exchangerates/tables/A?format=json";

    public double getRate(CurrencyRequestBody currencyRequestBody) {
        String currency = currencyRequestBody.getCurrency();
        if (currency == null) {
            throw new IllegalArgumentException("Currency Needed!");
        }

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(NBP_API_URI, String.class);
        JSONObject jo = new JSONObject((new JSONArray(result)).get(0).toString());

        double rate = 0.0;

        JSONArray ja = jo.getJSONArray("rates");
        for (Object obj : ja) {
            String jsonString = obj.toString();
            if (jsonString.contains(currency.toUpperCase())) {
                JSONObject rateJSON = new JSONObject(jsonString);
                rate = rateJSON.getDouble("mid");
            }
        }

        if (rate == 0.0) {
            throw new IllegalArgumentException("Wrong Currency!");
        }

        return rate;
    }

}
