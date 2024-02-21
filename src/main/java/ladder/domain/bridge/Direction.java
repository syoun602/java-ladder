package ladder.domain.bridge;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    ;

    private final int value;

    Direction(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
