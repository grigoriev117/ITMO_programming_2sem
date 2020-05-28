import Exceptions.EndOfFileException;
import Exceptions.FailedCheckException;
import java.util.Scanner;


/**
 * ����������� �����, ��������������� ��� ����������� ������ � ������� � ���������� ������ �� �����
 */

public abstract class CommandReader implements AutoCloseable {
    protected CommandReader() {
    }

    /**
     * @return ���������� ��������� ������
     */
    public abstract String read() throws EndOfFileException;

    /**
     * ���� ���� Scanner, ��������������� ��� ���������� ������ ���� �� �����, ���� �� �������
     */
    protected Scanner scan;

    public void close() {
        scan.close();
    }

    public static String[] splitter(String line) {
        String[] s = line.split(" ", 2);
        if (s.length == 2) {
            s[1] = s[1].trim();
            return s;
        } else
            return new String[]{s[0], ""};
    }

    /**
     * ����� ��� �������� Integer
     */
    public Integer handlerI(String s, Checker<Integer> c) throws EndOfFileException {
        String line;

        while (true) {
            try {
                System.out.print(s);
                line = this.read();
                if (line == null)
                    throw new EndOfFileException("��������������� ����� �����!");
                else if (line.equals(""))
                    return c.checker(null);
                return c.checker(Integer.parseInt(line));
            } catch (NumberFormatException e) {
                System.out.println("\u001B[35m" + "������ �����, ���������� ��� ���" + "\u001B[35m");
            } catch (FailedCheckException e) {
                System.out.println("\u001B[35m" + "������� �� ���������, ���������� ��� ���" + "\u001B[35m");
            }
        }
    }

    /**
     * ����� ��� �������� Long
     */
    public Long handlerL(String s, Checker<Long> c) throws EndOfFileException {
        String line;

        while (true) {
            try {
                System.out.print(s);
                line = this.read();
                if (line == null)
                    throw new EndOfFileException("��������������� ����� �����!");
                else if (line.equals(""))
                    return c.checker(null);
                return c.checker(Long.parseLong(line));
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31m" + "������ �����, ���������� ��� ���" + "\u001B[0m");
            } catch (FailedCheckException e) {
                System.out.println("\u001B[31m" + "������� �� ���������, ���������� ��� ���" + "\u001B[0m");
            }
        }
    }

    /**
     * ����� ��� �������� Double
     */
    public Double handlerD(String s, Checker<Double> c) throws EndOfFileException {
        String line;

        while (true) {
            try {
                System.out.print(s);
                line = this.read();
                if (line == null)
                    throw new EndOfFileException("��������������� ����� �����!");
                else if (line.equals(""))
                    return c.checker(null);
                return c.checker(Double.parseDouble(line));
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31m" + "������ �����, ���������� ��� ���" + "\u001B[0m");
            } catch (FailedCheckException e) {
                System.out.println("\u001B[31m" + "������� �� ���������, ���������� ��� ���" + "\u001B[0m");
            }
        }
    }

    /**
     * ����� ��� �������� String
     */
    public String handlerS(String s, Checker<String> c) throws EndOfFileException {
        String line;
        while (true) {
            try {
                System.out.print(s);
                line = this.read();
                if (line == null)
                    throw new EndOfFileException("��������������� ����� �����!");
                else if (line.equals(""))
                    return c.checker(null);
                return c.checker(line);
            } catch (FailedCheckException e) {
                System.out.println("\u001B[31m" + "������� �� ���������, ���������� ��� ���" + "\u001B[0m");
            }
        }
    }

    /**
     * ����� ��� �������� Boolean
     */
    public Boolean handlerB(String s, Checker<Boolean> c) throws EndOfFileException {
        String line;

        while (true) {
            try {
                System.out.print(s);
                line = this.read();
                if (line == null)
                    throw new EndOfFileException("��������������� ����� �����!");
                else if (line.equals(""))
                    return c.checker(null);
                return c.checker(parseBoolean(line));
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31m" + "������ �����, ���������� ��� ���" + "\u001B[0m");
            } catch (FailedCheckException e) {
                System.out.println("\u001B[31m" + "������� �� ���������, ���������� ��� ���" + "\u001B[0m");
            }
        }
    }

    public static Boolean parseBoolean(String s) {
        if (s.equalsIgnoreCase("true") || s.equalsIgnoreCase("t") || s.equals("1") || s.equalsIgnoreCase("y"))
            return true;
        else if (s.equalsIgnoreCase("false") || s.equalsIgnoreCase("f") || s.equals("0") || s.equalsIgnoreCase("n"))
            return false;
        throw new NumberFormatException();
    }
}


