package ladder.domain.bridge;

import java.util.Arrays;

public enum State {

    BUILT(true),
    NOT_BUILT(false),
    ;

    private final boolean value;

    State(final boolean value) {
        this.value = value;
    }

    public static State from(final boolean value) {
        return Arrays.stream(values())
                .filter(it -> it.value == value)
                .findAny()
                .orElseThrow();
    }

    public boolean isBuilt() {
        return this == BUILT;
    }

    public boolean isNotBuilt() {
        return this == NOT_BUILT;
    }
}
