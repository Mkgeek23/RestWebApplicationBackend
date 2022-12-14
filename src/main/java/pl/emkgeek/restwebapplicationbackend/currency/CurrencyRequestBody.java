package pl.emkgeek.restwebapplicationbackend.currency;

public class CurrencyRequestBody {
    String currency;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public CurrencyRequestBody() {
    }

    public CurrencyRequestBody(String currency) {
        this.currency = currency;
    }
}
