package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    private InputView() {
    }

    public static List<String> receivePlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        final String input = receiveUserInput();
        validateNullOrBlank(input);
        validateHasDelimiter(input);

        return Arrays.stream(input.split(DELIMITER))
                .map(String::strip)
                .toList();
    }

    public static int receiveDepth() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");

        final String input = receiveUserInput();
        validateNullOrBlank(input);
        validateIsNumber(input);

        return Integer.parseInt(input);
    }

    private static void validateNullOrBlank(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다.");
        }
    }

    private static void validateHasDelimiter(final String names) {
        if (!names.contains(DELIMITER)) {
            throw new IllegalArgumentException("[ERROR] 구분자는 쉼표(,) 입니다.");
        }
    }

    private static void validateIsNumber(final String depth) {
        final boolean isDigit = depth.chars()
                .allMatch(Character::isDigit);
        if (!isDigit) {
            throw new IllegalArgumentException("[ERROR] 정수만 입력 가능합니다.");
        }
    }

    private static String receiveUserInput() {
        return scanner.nextLine();
    }
}
