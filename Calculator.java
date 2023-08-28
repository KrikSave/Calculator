import java.util.Scanner;

class Calculator {
    public static void main(String[] args) {
        try (Scanner consoleReading = new Scanner(System.in)) {
			System.out.print("Enter an arithmetic expression: ");
			String input = consoleReading.nextLine();
			try {
			    String result = calc(input);
			    System.out.println("Result: " + result);
			} catch (IllegalArgumentException er) {
			    System.out.println("Error: " + er.getMessage());
			}
		}
    }

    public static String calc(String input) {
        String[] tokens = input.split(" ");
        if (tokens.length != 3) {
            throw new IllegalArgumentException("Invalid input format, use a space between characters");
        }

        int first = parseNumber(tokens[0]);
        int second = parseNumber(tokens[2]);
        char middle = tokens[1].charAt(0);

        switch (middle) {
            case '+':
                return String.valueOf(first + second);
            case '-':
                return String.valueOf(first - second);
            case '*':
                return String.valueOf(first * second);
            case '/':
                return String.valueOf(first / second);
            default:
                throw new IllegalArgumentException("Invalid operator: " + middle);
        }
    }

    private static int parseNumber(String token) {
        int ending = Integer.parseInt(token);
        if (ending < 1 || ending > 10) {
            throw new IllegalArgumentException("Numbers should be between 1 and 10 inclusive");
        }
        return ending;
    }
}