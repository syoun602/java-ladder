package ladder.domain.bridge;

import static ladder.domain.bridge.State.NOT_BUILT;

import java.util.function.BooleanSupplier;

public class Bridge {

    private final Position position;
    private State state;

    public Bridge(final int position) {
        this.position = Position.valueOf(position);
        this.state = NOT_BUILT;
    }

    public void build(final BooleanSupplier permission) {
        this.state = State.from(permission.getAsBoolean());
    }

    public boolean isSamePositionWhenMovedTo(final Bridge other, final Direction direction) {
        return this.position.move(direction).equals(other.position);
    }

    public boolean isBuilt() {
        return this.state.isBuilt();
    }

    public boolean isNotBuilt() {
        return this.state.isNotBuilt();
    }
}
