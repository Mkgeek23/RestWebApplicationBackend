package pl.emkgeek.restwebapplicationbackend.number;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "numbers")
public class NumberController {

    private final NumberService numberService;

    @Autowired
    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @CrossOrigin
    @PostMapping(path = "sort-command")
    public ResponseEntity<Map<String, Object>> sortNumbers(@RequestBody NumberSortRequestBody numberSortRequestBody) {
        Map<String, Object> response = new HashMap<>();
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            numberService.sortNumbers(numberSortRequestBody);
            response.put("numbers", numberSortRequestBody.getNumbers());
        } catch (IllegalArgumentException e) {
            response.put("message", e.getMessage());
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(response, httpStatus);
    }
}
