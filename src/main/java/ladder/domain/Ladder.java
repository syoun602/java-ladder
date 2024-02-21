package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import ladder.domain.bridge.Bridge;

public class Ladder {

    public static final int INITIAL_DEPTH = 1;
    public static final int STARTING_BRIDGE = 1;

    private final List<Line> lines;
    private final int width;

    private Ladder(final List<Line> lines, final int width) {
        this.lines = new ArrayList<>(lines);
        this.width = width;
    }

    public static Ladder createLadderFromHeightAndWidth(final Height height, final int width) {
        return new Ladder(
                IntStream.rangeClosed(INITIAL_DEPTH, height.getValue())
                        .mapToObj(it -> new Line(createBridges(width), new Height(it)))
                        .toList(),
                width
        );
    }

    private static List<Bridge> createBridges(final int size) {
        return IntStream.range(STARTING_BRIDGE, size)
                .mapToObj(Bridge::new)
                .toList();
    }

    public void createBridges() {
        lines.forEach(Line::createBridges);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
