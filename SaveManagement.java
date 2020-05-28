import Exceptions.FailedCheckException;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.Scanner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * �����, ����������� � �������
 */

public class SaveManagement {
    private static File file;

    public static void setFile(File file) {
        SaveManagement.file = file;
    }

    /**
     * ���������� ����� � CSV ������
     */
    public static void saveToFile(Collection c) {
        if (file == null)
        	 private static final DateFormat sdf = new SimpleDateFormat("_yyyy_MM_dd__HH_mm_ss");
        	 private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("_yyyy_MM_dd__HH_mm_ss");
        	 Date date = new Date();
             file = new File("file"+sdf.format(date)+"file.csv");
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (SpaceMarine r : c.list) {
                fileWriter.write(r.toCSVfile() + "\n");
            }
        } catch (IOException e) {
            System.out.println("������ ������� � �����");
        }
    }

    /**
     * ���������� ��������� �� ������������ �����
     */
    @NotNull
    public static Collection listFromSave() {
        Collection collection = new Collection();
        try (Scanner scan = new Scanner(file)) {
            String[] args;
            for (int lineNum = 1; scan.hasNext(); lineNum++) {
                try {
                    String line = scan.nextLine();
                    args = line.split(",", 14);

                    SpaceMarine route = new SpaceMarine();
                    int id = SpaceMarine.idCheck.checker(Integer.parseInt(args[0]));
                    if (collection.searchById(id) == null)
                    	SpaceMarine.setId(id);
                    else {
                        System.out.println("������� �������� id");
                        throw new FailedCheckException();
                    }

                    SpaceMarine.setName(SpaceMarine.nameCheck.checker(args[1]));

                    int cx = Coordinates.xCheck.checker(Integer.parseInt(args[2]));
                    Long cy = Coordinates.yCheck.checker(Long.parseLong(args[3]));
                    SpaceMarine.setCoordinates(new Coordinates(cx, cy));

                    LocalDate  dateTime = LocalDate.parse(args[4]);
                    SpaceMarine.setCreationDate(dateTime);
                 
                    collection.list.add(route);
                } catch (ArrayIndexOutOfBoundsException | DateTimeParseException | NumberFormatException | FailedCheckException e) {
                    System.out.println("\u001B[31m" + "������ ������ �����, ������: " + "\u001B[0m" + lineNum);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("\u001B[31m" + "������ ������� � �����" + "\u001B[0m");
        }
        Collections.sort(collection.list);
        return collection;
    }
}