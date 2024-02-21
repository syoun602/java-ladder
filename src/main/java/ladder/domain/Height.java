package ladder.domain;

public class Height {

    private static final int MIN_DEPTH_LENGTH = 1;
    private static final int MAX_DEPTH_LENGTH = 10;

    private final int value;

    public Height(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(final int value) {
        if (value < MIN_DEPTH_LENGTH || value > MAX_DEPTH_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public int getValue() {
        return value;
    }
}
