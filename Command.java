import java.util.LinkedList;
import Exceptions.FailedCheckException;
import org.jetbrains.annotations.NotNull;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Collections;
import Exceptions.EndOfFileException;
import Exceptions.IncorrectFileNameException;
/**
 * ����� ��� ��������� ������, �������� � �������
 */

public class Command {
    /**
     * ��������� ������
     */
    public static boolean switcher(CommandReader reader, Collection c, String s1, String s2) throws EndOfFileException {
        switch (s1) {
            case ("help"):
                help();
                break;
            case ("info"):
                info(c);
                break;
            case ("show"):
                show(c);
                break;
            case ("add"):
                add(reader, c, s2);
                break;
            case ("update"):
                update(reader, c, s2);
                break;
            case ("remove_by_id"):
                removeById(reader, c, s2);
                break;
            case ("clear"):
                clear(c);
                break;
            case ("save"):
                save(c);
                break;
            case ("execute_script"):
                return executeScript(c, s2);
            case ("exit"):
                return false;
            case ("remove_first"):
            	removeFirst(c);
                break;
            case ("head"):
            	head(c);
                break;
            case ("remove_head"):
            	remove_head(c);
                break;
            case ("remove_all_by_weapon_type"):
            	remove_all_by_weapon_type(reader, c, s2);
                break;
            case ("group_counting_by_chapter"):
            	group_counting_by_chapter(c);
                break;
            case ("filter_less_than_loyal"):
            	filter_less_than_loyal(reader, c, s2);
                break;
            default:
                System.out.println("����� ������� �� ����������!\n ������� 'help', ����� ���������� ������ ��������� ������.");
        }
        return true;
    }
    
    
    public static Checker<Boolean> boolCheck = (Boolean B) -> {
        if (B != null) return B;
        else throw new FailedCheckException();
    };
}
    
    /**
     * help : ������� ������� �� ��������� ��������
     */
    public static void help() {
        System.out.println(
        				"help : ������� ������� �� ��������� ��������\n"
    					"info : ������� � ����������� ����� ������ ���������� � ��������� (���, ���� �������������, ���������� ��������� � �.�.)\n"+
    					"show : ������� � ����������� ����� ������ ��� �������� ��������� � ��������� �������������\n"+
    					"add {element} : �������� ����� ������� � ���������\n"+
    					"update id {element} : �������� �������� �������� ���������, id �������� ����� ���������\n"+
    					"remove_by_id id : ������� ������� �� ��������� �� ��� id\n"+
    					"clear : �������� ���������\n"+
    					"save : ��������� ��������� � ����\n"+
    					"execute_script file_name : ������� � ��������� ������ �� ���������� �����.\n"+
    					"� ������� ���������� ������� � ����� �� ����, � ������� �� ������ ������������ � ������������� ������.\n"+
    					"exit : ��������� ��������� (��� ���������� � ����)\n"+
    					"remove_first : ������� ������ ������� �� ���������\n"+
    					"head : ������� ������ ������� ���������\n"+
    					"remove_head : ������� ������ ������� ��������� � ������� ���\n"+
    					"remove_all_by_weapon_type weaponType : ������� �� ��������� ��� ��������, �������� ���� weaponType �������� ������������ ���������\n"+
    					"group_counting_by_chapter : ������������� �������� ��������� �� �������� ���� chapter, ������� ���������� ��������� � ������ ������\n"+
    					"filter_less_than_loyal loyal : ������� ��������, �������� ���� loyal ������� ������ ���������\n"
                		
        );
    }
    
    //remove_first : ������� ������ ������� �� ���������
    public static void removeFirst(Collection c) throws EndOfFileException {
        int size = c.list.size();
        int i = 0;
        if (i < size) {
                c.list.remove(c.list.get(i));
            }
        else catch (IncorrectFileNameException e) {
            System.out.println("\u001B[31m" + "� ��������� ��� ���������" + "\u001B[0m");
        Collections.sort(c.list);
    }
      //  head : ������� ������ ������� ���������
        public static void head(Collection c) throws EndOfFileException {
            int size = c.list.size();
            int i = 0;
            if (i < size) {
            	System.out.println(c.list.get(i).toString());
                }
            else catch (IncorrectFileNameException e) {
                System.out.println("\u001B[31m" + "� ��������� ��� ���������" + "\u001B[0m");
        }
    
    //remove_head : ������� ������ ������� ��������� � ������� ���
            public static void remove_head(Collection c) throws EndOfFileException {
                int size = c.list.size();
                int i = 0;
                if (i < size) {
                	System.out.println(c.list.get(i).toString());
                	c.list.remove(c.list.get(i));
                	Collections.sort(c.list);
                    }
                else catch (IncorrectFileNameException e) {
                    System.out.println("\u001B[31m" + "� ��������� ��� ���������" + "\u001B[0m");
            }}
            //group_counting_by_chapter
            
            public static void group_counting_by_chapter(Collection c) {
                if (c.list.isEmpty()) {
                    System.out.println("� ��������� ��� ���������");
                    return;
                }
                for (SpaceMarine r : c.list) {
                    System.out.println(r.toString());
                }
            }
                
                /**
                 * remove_all_by_weapon_type
                 */
                public static void remove_all_by_weapon_type(CommandReader reader, Collection c, String s) throws EndOfFileException {
                    int id = c.getRandId();
                    Collections.sort(c.list);
                }
            
                /**
                 * filter_less_than_loyal
                 */
                public static void filter_less_than_loyal(CommandReader reader, Collection c, String s) throws EndOfFileException {
                    int id = c.getRandId();
                    Collections.sort(c.list);
                }
    /**
     * ������� � ����������� ����� ������ ���������� � ���������
     */
    public static void info(Collection collection) {
        System.out.println("���: " + collection.list.getClass().getName());
        System.out.println("����������� ���������: " + collection.list.size());
        System.out.println("���� �������������: " + collection.getDate());
    }
    
    /**
     * ������� � ����������� ����� ������ ��� �������� ��������� � ��������� �������������
     */
    public static void show(Collection c) {
        if (c.list.isEmpty()) {
            System.out.println("� ��������� ��� ���������");
            return;
        }
        for (SpaceMarine r : c.list) {
            System.out.println(r.toString());
        }
    }
    
    /**
     * �������� ������� � ���������
     */
    public static void add(CommandReader reader, Collection c, String s) throws EndOfFileException {
        int id = c.getRandId();
        c.list.add(toAdd(reader, id, s));
        Collections.sort(c.list);
    }
    
    /**
     * �������� �������� �������� ���������, id �������� ����� ���������
     */
    public static void update(AbstractReader reader, Collection c, String s) throws EndOfFileException {

        int id;
        try {
            id = SpaceMarine.idCheck.checker(Integer.parseInt(s));
        } catch (NumberFormatException | FailedCheckException e) {
            id = reader.handlerI("������� id ��������: ", SpaceMarine.idCheck);
        }
        SpaceMarine r = c.searchById(id);
        if (r == null) {
            System.out.println("������� �� ������");
            return;
        }
        String name = reader.handlerS("������� String: name", SpaceMarine.nameCheck);
        c.list.set(c.list.indexOf(r), toAdd(reader, id, name));
        Collections.sort(c.list);
    }
    
    /**
     * ������� ������� �� ��������� �� ��� id
     */
    public static void removeById(AbstractReader reader, Collection c, String s) throws EndOfFileException {
        int id;
        try {
            id = SpaceMarine.idCheck.checker(Integer.parseInt(s));
        } catch (NumberFormatException | FailedCheckException e) {
            id = reader.handlerI("������� int id: ", SpaceMarine.idCheck);
        }
        SpaceMarine r = c.searchById(id);
        if (r == null) {
            System.out.println("\u001B[31m"+"������� �� ������"+"\u001B[31m");
            return;
        }
        c.list.remove(r);
        Collections.sort(c.list);

    }
    
    /**
     * ��������� ��������� � ����
     */
    public static void save(Collection c) {
        SaveManagement.saveToFile(c);
    }

    /**
     * ������� ��� �������� �� ���������
     */
    public static void clear(@NotNull Collection c) {
        c.list.clear();
    }
    
    /**
     * ��������� � ��������� ������ �� ���������� �����.
     * � ������� ���������� ������� � ����� �� ����, � ������� �� ������ ������������ � ������������� ������
     */
    public static boolean executeScript(Collection c, String s) {
        boolean programIsWorking = true;
        //Reader reader;
        try (Reader reader = new Reader(s)) {
            if (RecursionHandler.isContains(s)) {
                RecursionHandler.addToFiles(s);
                String[] com;
                System.out.print("\u001B[36m" + "������ ������� � ����� " + s + ": " + "\u001B[36m");
                String line = reader.read();
                while (line != null && programIsWorking) {
                    com = CommandReader.splitter(line);
                    programIsWorking = Command.switcher(reader, c, com[0], com[1]);
                    System.out.print("\u001B[33m" + "������ ������� � ����� " + s + ": " + "\u001B[0m");
                    line = reader.read();
                }
                RecursionHandler.removeLast();
            } else
                System.out.println("\u001B[31m" + "������� ����������" + "\u001B[0m");

        } catch (IncorrectFileNameException e) {
            System.out.println("\u001B[31m" + "�������� ��� �����" + "\u001B[0m");
        } catch (EndOfFileException e) {
            System.out.println("\u001B[31m" + "����������� ����� ����� " + s + "\u001B[0m");
            RecursionHandler.removeLast();
        } catch (FileNotFoundException e) {
            System.out.println("\u001B[31m" + "���� �� ������" + "\u001B[0m");
        }
        return programIsWorking;
    }
    
    
    public static SpaceMarine toAdd(CommandReader reader, int id, String s) throws EndOfFileException {

        SpaceMarine sm = new SpaceMarine();
        sm.setId(id);

        try {
        	SpaceMarine.nameCheck.checker(s);
            System.out.println("���� name: " + s);
        } catch (FailedCheckException e) {
            s = reader.handlerS("������� String name, ������ ������ 0: ", SpaceMarine.nameCheck);
        }
        sm.setName(s);

        System.out.println("��o� ����� Coordinates");
        int cx = reader.handlerI("������� int x: ", Coordinates.xCheck);
        Double cy = reader.handlerD("������� Double y: ", Coordinates.yCheck);
        sm.setCoordinates(new Coordinates(cx, cy));

        LocalDate creationTime = LocalDate.now();
        sm.setCreationDate(creationTime);
        
        Double health = reader.handlerD("������� Double health, ������ 0:", SpaceMarine.healthCheck);
        sm.setHealth();

        boolean loyal = reader.handlerB("������� boolean loyal", SpaceMarine.loyalCheck);
        sm.setHealth();
        
        String achievements = reader.handlerS("������� String achievements", SpaceMarine.nameCheck);

        System.out.println("��o� ����� Chapter");
        String name1 = reader.handlerS("������� String name: ", Chapter.cCheck);
        String parentLegion1 = reader.handlerS("������� String parentLegion: ", Chapter.cCheck);
        sm.setChapter(new Chapter(name1, parenLegion1));
        
        Weapon weaponType1 = reader.handlerS("������� Weapon weaponType {\r\n" + 
        		"    HEAVY_BOLTGUN,\r\n" + 
        		"    BOLT_RIFLE,\r\n" + 
        		"    PLASMA_GUN,\r\n" + 
        		"    COMBI_PLASMA_GUN,\r\n" + 
        		"    INFERNO_PISTOL;\r\n" + 
        		"} ", SpaceMarine.WeaponCheck);
        sm.setWeaponType(weaponType1);

        return sm;
    }
