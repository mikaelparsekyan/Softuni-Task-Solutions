package telephony;

import telephony.interfaces.Browsable;
import telephony.interfaces.Callable;

import java.util.LinkedList;
import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.setNumbers(numbers);
        this.setUrls(urls);
    }

    private void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    private void setUrls(List<String> urls) {
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder result = new StringBuilder();
        for (String url : this.urls) {
            boolean isValid = true;
            for (int j = 0; j < url.length(); j++) {
                if (Character.isDigit(url.charAt(j))) {
                    isValid = false;
                }
            }
            if (isValid) {
                result.append("Browsing: ").append(url).append("!");
            } else {
                result.append("Invalid URL!");
            }
            result.append(System.lineSeparator());
        }

        return result.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder result = new StringBuilder();
        for (String number : this.numbers) {
            boolean isValid = true;
            for (int j = 0; j < number.length(); j++) {
                if (!Character.isDigit(number.charAt(j))) {
                    isValid = false;
                }
            }
            if (isValid) {
                result.append("Calling... ").append(number);
            } else {
                result.append("Invalid number!");
            }
            result.append(System.lineSeparator());
        }
        return result.toString().trim();
    }
}
