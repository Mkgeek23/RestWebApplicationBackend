package pl.emkgeek.restwebapplicationbackend.number;

import org.springframework.lang.Nullable;

import java.util.List;

public class NumberSortRequestBody {
    @Nullable
    private List<Integer> numbers;
    private String order = "ASC";

    public NumberSortRequestBody(List<Integer> numbers, String order) {
        this.numbers = numbers;
        this.order = order;
    }

    public NumberSortRequestBody() {
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
