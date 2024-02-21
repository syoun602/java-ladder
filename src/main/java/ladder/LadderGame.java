package ladder;

import java.util.List;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.player.Players;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;


    public LadderGame(final Players players, final Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public static LadderGame from(final List<String> names, final int height) {
        final Players players = Players.createFromNames(names);
        final Ladder ladder = Ladder.createLadderFromHeightAndWidth(
                new Height(height),
                players.getSize()
        );
        ladder.createBridges();

        return new LadderGame(players, ladder);
    }

    public Players getPlayers() {
        return players;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
