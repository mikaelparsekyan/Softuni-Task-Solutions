package greedyTimes;

import java.util.HashMap;
import java.util.Map;

public class Bag {
    private long maxCapacity;
    private long currentCapacity;
    private Map<String, Long> gems;
    private Map<String, Long> cash;
    private long gemsCount;
    private long cashCount;
    private long goldCount;
    private boolean isGoldAdded;

    public Bag(long maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.gems = new HashMap<>();
        this.cash = new HashMap<>();
        this.isGoldAdded = false;
    }

    private boolean isCapacityOverflow(long amount) {
        return this.currentCapacity + amount > this.maxCapacity;
    }

    public void addCash(String cashName, long quantity) {
        if (!isCapacityOverflow(quantity)) {
            if (this.cashCount + quantity <= this.gemsCount) {
                if (this.cash.containsKey(cashName)) {
                    this.cash.put(cashName, this.cash.get(cashName) + quantity);
                } else {
                    this.cash.put(cashName, quantity);
                }
                this.currentCapacity += quantity;
                this.cashCount += quantity;
            }
        }
    }

    public void addGem(String gemName, long quantity) {
        if (!isCapacityOverflow(quantity)) {
            if (this.gemsCount + quantity <= this.goldCount) {
                if (this.gems.containsKey(gemName)) {
                    this.gems.put(gemName, this.gems.get(gemName) + quantity);
                } else {
                    this.gems.put(gemName, quantity);
                }
                this.currentCapacity += quantity;
                this.gemsCount += quantity;
            }
        }
    }

    public void addGold(long quantity) {
        if (!isCapacityOverflow(quantity)) {
            this.isGoldAdded = true;
            this.currentCapacity += quantity;
            this.goldCount += quantity;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        if (this.isGoldAdded) {
            str.append("<Gold> $").append(this.goldCount)
                    .append(System.lineSeparator());
            str.append("##Gold - ").append(this.goldCount)
                    .append(System.lineSeparator());
        }
        if (this.gems.size()>0) {
            str.append("<Gem> $").append(this.gemsCount)
                    .append(System.lineSeparator());
            this.gems.entrySet().stream().sorted((a, b) ->
                    b.getKey().compareTo(a.getKey())).forEach(e -> {
                str.append(String.format("##%s - %d" +
                                System.lineSeparator(),
                        e.getKey(), e.getValue()));
            });
        }
        if (this.cash.size() > 0) {
            str.append("<Cash> $").append(this.cashCount)
                    .append(System.lineSeparator());
            this.cash.entrySet().stream().sorted((a, b) ->
                    b.getKey().compareTo(a.getKey())).forEach(e -> {
                str.append(String.format("##%s - %d" +
                                System.lineSeparator(),
                        e.getKey(), e.getValue()));
            });
        }
        return str.toString();
    }
}
