package ladder.domain.bridge;

import java.util.Objects;
import java.util.stream.IntStream;

public class Position {

    private static final int MINIMUM_POSITION_SIZE = 0;
    private static final int MAX_POSITION_SIZE = 10;
    private static final Position[] POSITIONS_CACHE = new Position[MAX_POSITION_SIZE + 1];


    static {
        IntStream.rangeClosed(MINIMUM_POSITION_SIZE, MAX_POSITION_SIZE)
                .forEach(number -> POSITIONS_CACHE[number] = new Position(number));
    }

    private final int value;

    private Position(final int value) {
        this.value = value;
    }

    public static Position valueOf(final int value) {
        if (value >= MINIMUM_POSITION_SIZE && value <= MAX_POSITION_SIZE) {
            return POSITIONS_CACHE[value];
        }
        return new Position(value);
    }

    public Position move(final Direction direction) {
        return valueOf(value + direction.getValue());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Position{" +
                "value=" + value +
                '}';
    }
}
