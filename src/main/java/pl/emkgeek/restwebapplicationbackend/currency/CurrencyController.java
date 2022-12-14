package pl.emkgeek.restwebapplicationbackend.currency;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController()
@RequestMapping(path = "currencies")
public class CurrencyController {

    private final CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }


    @PostMapping(path = "get-current-currency-value-command")
    public ResponseEntity<Map<String, Object>> getCurrentCurrencyValue(@RequestBody CurrencyRequestBody currencyRequestBody) {
        Map<String, Object> response = new HashMap<>();
        HttpStatus httpStatus = HttpStatus.OK;

        try {
            double result = currencyService.getRate(currencyRequestBody);
            response.put("value", result);
        } catch (IllegalArgumentException e) {
            response.put("message", e.getMessage());
            httpStatus = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(response, httpStatus);
    }
}
