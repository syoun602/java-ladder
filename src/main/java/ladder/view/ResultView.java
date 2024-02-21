package ladder.view;

import java.util.List;
import ladder.LadderGame;
import ladder.domain.Line;
import ladder.domain.bridge.Bridge;
import ladder.domain.player.Name;
import ladder.domain.player.Players;

public class ResultView {

    private static final int NAME_FIELD_SIZE = 6;
    private static final String WALL = "|";
    private static final String BRIDGE_BUILT = "-----";
    private static final String BRIDGE_NOT_BUILT = "     ";
    private static final String BLANK = " ";
    private static final String LINE_BREAK = "\n";

    private ResultView() {
    }

    public static void printResult(final LadderGame ladderGame) {
        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n실행 결과\n");
        appendPlayers(stringBuilder, ladderGame.getPlayers());
        appendLadder(stringBuilder, ladderGame.getLadder().getLines());

        System.out.println(stringBuilder);
    }

    public static void appendPlayers(final StringBuilder stringBuilder, final Players players) {
        for (final Name name : players.getNames()) {
            final int requiredBlanks = NAME_FIELD_SIZE - name.getValue().length();
            stringBuilder.append(BLANK.repeat(requiredBlanks));
            stringBuilder.append(name.getValue());
        }
        stringBuilder.append(LINE_BREAK);
    }

    private static void appendLadder(final StringBuilder stringBuilder, final List<Line> lines) {
        for (final Line line : lines) {
            stringBuilder.append(BRIDGE_NOT_BUILT);
            appendWalls(stringBuilder, line);
            stringBuilder.append(WALL)
                    .append(LINE_BREAK);
        }
    }

    private static void appendWalls(final StringBuilder stringBuilder, final Line line) {
        for (final Bridge bridge : line.getLines()) {
            stringBuilder.append(WALL);
            appendBridges(stringBuilder, bridge);
        }
    }

    private static void appendBridges(final StringBuilder stringBuilder, final Bridge bridge) {
        if (bridge.isBuilt()) {
            stringBuilder.append(BRIDGE_BUILT);
        }
        if (bridge.isNotBuilt()) {
            stringBuilder.append(BRIDGE_NOT_BUILT);
        }
    }
}
