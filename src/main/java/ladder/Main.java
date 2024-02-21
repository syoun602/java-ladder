package ladder;

import java.util.List;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {

    public static void main(final String... args) {
        final List<String> names = InputView.receivePlayerNames();
        final int height = InputView.receiveDepth();

        final LadderGame ladderGame = LadderGame.from(names, height);

        ResultView.printResult(ladderGame);
    }
}
