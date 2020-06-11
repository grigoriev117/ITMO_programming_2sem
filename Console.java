import Exceptions.EndOfFileException;

import java.util.Scanner;

/**
 * Класс, считывающий строки из консоли
 */
public class Console extends CommandReader {
    public static Console console = new Console();

    Console() {
        scan = new Scanner(System.in);
    }

    @Override
    public void close() {
    }

    @Override
    public String read() throws EndOfFileException {
        if (scan.hasNextLine())
            return scan.nextLine();
        throw new EndOfFileException("Конец ввода косоли!");
    }
}
