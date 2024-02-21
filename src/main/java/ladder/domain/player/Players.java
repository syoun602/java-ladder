package ladder.domain.player;

import java.util.List;

public class Players {

    private final List<Name> names;

    private Players(final List<Name> names) {
        this.names = names;
    }

    public static Players createFromNames(final List<String> rawNames) {
        final List<Name> names = rawNames.stream()
                .map(Name::new)
                .toList();
        return new Players(names);
    }

    public int getSize() {
        return names.size();
    }

    public List<Name> getNames() {
        return names;
    }
}
