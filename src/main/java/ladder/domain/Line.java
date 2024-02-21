package ladder.domain;

import static ladder.domain.bridge.Direction.values;

import java.util.Arrays;
import java.util.List;
import java.util.random.RandomGenerator;
import ladder.domain.bridge.Bridge;

public class Line {

    private static final RandomGenerator BUILD_PERMISSION = RandomGenerator.getDefault();

    private final List<Bridge> bridges;
    private final Height height;

    public Line(List<Bridge> bridges, Height height) {
        this.bridges = bridges;
        this.height = height;
    }

    public void createBridges() {
        for (final Bridge bridge : bridges) {
            final boolean canBuild = findAdjacentBridges(bridge).stream()
                    .allMatch(Bridge::isNotBuilt);
            if (canBuild) {
                bridge.build(BUILD_PERMISSION::nextBoolean);
            }
        }
    }

    private List<Bridge> findAdjacentBridges(final Bridge bridge) {
        return bridges.stream()
                .filter(other -> Arrays.stream(values())
                        .anyMatch(direction -> bridge.isSamePositionWhenMovedTo(other, direction)))
                .toList();
    }

    public List<Bridge> getLines() {
        return bridges;
    }
}
