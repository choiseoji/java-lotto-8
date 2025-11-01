package lotto.model;

public enum Rank {

    FIFTH(3, 0, 5_000, "3개 일치"),
    FOURTH(4, 0, 50_000, "4개 일치"),
    THIRD(5, 0, 1_500_000, "5개 일치"),
    SECOND(5, 1, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 0, 2_000_000_000, "6개 일치");

    private final int matchCount;
    private final int bonusMatchCount;
    private final int prize;
    private final String displayName;

    public int getMatchCount() { return matchCount; }
    public int getBonusMatchCount() { return bonusMatchCount; }
    public int getPrize() { return prize; }
    public String getDisplayName() { return displayName; }

    Rank(int matchCount, int bonusMatchCount, int prize, String displayName) {
        this.matchCount = matchCount;
        this.bonusMatchCount = bonusMatchCount;
        this.prize = prize;
        this.displayName = displayName;
    }
}
