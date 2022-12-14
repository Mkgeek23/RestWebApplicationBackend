package pl.emkgeek.restwebapplicationbackend.number;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class NumberService {
    public void sortNumbers(NumberSortRequestBody numberSortRequestBody) throws IllegalArgumentException {
        List<Integer> numbers = numberSortRequestBody.getNumbers();
        if (numbers == null) {
            throw new IllegalArgumentException("Argument Numbers Is Required!");
        }

        String order = numberSortRequestBody.getOrder();

        if (order.equals("ASC")) {
            Collections.sort(numbers);
        } else if (order.equals("DESC")) {
            numbers.sort(Comparator.reverseOrder());
        } else {
            throw new IllegalArgumentException("Wrong Order Value!");
        }
    }
}
