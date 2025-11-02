package lotto.model;

import java.util.Arrays;

public enum Rank {

    FIFTH(3, false, 5_000, "3개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, false, 2_000_000_000, "6개 일치");

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;
    private final String displayName;

    Rank(int matchCount, boolean matchBonus, int prize, String displayName) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
        this.displayName = displayName;
    }

    public static Rank of(int matchCount, boolean bonus) {
        return Arrays.stream(values())
                .filter(r -> r.matchCount == matchCount)
                .filter(r -> r.matchBonus == bonus || r.matchCount != 5)
                .findFirst()
                .orElse(null);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getMatchBonus() {
        return matchBonus;
    }

    public int getPrize() {
        return prize;
    }

    public String getDisplayName() {
        return displayName;
    }
}
