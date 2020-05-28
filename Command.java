import java.util.LinkedList;
import Exceptions.FailedCheckException;
import org.jetbrains.annotations.NotNull;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Collections;
import Exceptions.EndOfFileException;
import Exceptions.IncorrectFileNameException;
/**
 * Класс для обработки команд, вводимых в консоли
 */

public class Command {
    /**
     * Обработка команд
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
                System.out.println("Такой команды не существует!\n Введите 'help', чтобы посмотреть список доступных команд.");
        }
        return true;
    }
    
    
    public static Checker<Boolean> boolCheck = (Boolean B) -> {
        if (B != null) return B;
        else throw new FailedCheckException();
    };
}
    
    /**
     * help : вывести справку по доступным командам
     */
    public static void help() {
        System.out.println(
        				"help : вывести справку по доступным командам\n"
    					"info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n"+
    					"show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n"+
    					"add {element} : добавить новый элемент в коллекцию\n"+
    					"update id {element} : обновить значение элемента коллекции, id которого равен заданному\n"+
    					"remove_by_id id : удалить элемент из коллекции по его id\n"+
    					"clear : очистить коллекцию\n"+
    					"save : сохранить коллекцию в файл\n"+
    					"execute_script file_name : считать и исполнить скрипт из указанного файла.\n"+
    					"В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n"+
    					"exit : завершить программу (без сохранения в файл)\n"+
    					"remove_first : удалить первый элемент из коллекции\n"+
    					"head : вывести первый элемент коллекции\n"+
    					"remove_head : вывести первый элемент коллекции и удалить его\n"+
    					"remove_all_by_weapon_type weaponType : удалить из коллекции все элементы, значение поля weaponType которого эквивалентно заданному\n"+
    					"group_counting_by_chapter : сгруппировать элементы коллекции по значению поля chapter, вывести количество элементов в каждой группе\n"+
    					"filter_less_than_loyal loyal : вывести элементы, значение поля loyal которых меньше заданного\n"
                		
        );
    }
    
    //remove_first : удалить первый элемент из коллекции
    public static void removeFirst(Collection c) throws EndOfFileException {
        int size = c.list.size();
        int i = 0;
        if (i < size) {
                c.list.remove(c.list.get(i));
            }
        else catch (IncorrectFileNameException e) {
            System.out.println("\u001B[31m" + "В коллекции нет элементов" + "\u001B[0m");
        Collections.sort(c.list);
    }
      //  head : вывести первый элемент коллекции
        public static void head(Collection c) throws EndOfFileException {
            int size = c.list.size();
            int i = 0;
            if (i < size) {
            	System.out.println(c.list.get(i).toString());
                }
            else catch (IncorrectFileNameException e) {
                System.out.println("\u001B[31m" + "В коллекции нет элементов" + "\u001B[0m");
        }
    
    //remove_head : вывести первый элемент коллекции и удалить его
            public static void remove_head(Collection c) throws EndOfFileException {
                int size = c.list.size();
                int i = 0;
                if (i < size) {
                	System.out.println(c.list.get(i).toString());
                	c.list.remove(c.list.get(i));
                	Collections.sort(c.list);
                    }
                else catch (IncorrectFileNameException e) {
                    System.out.println("\u001B[31m" + "В коллекции нет элементов" + "\u001B[0m");
            }}
            //group_counting_by_chapter
            
            public static void group_counting_by_chapter(Collection c) {
                if (c.list.isEmpty()) {
                    System.out.println("В коллекции нет элементов");
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
     * Вывести в стандартный поток вывода информацию о коллекции
     */
    public static void info(Collection collection) {
        System.out.println("Тип: " + collection.list.getClass().getName());
        System.out.println("Колличество элементов: " + collection.list.size());
        System.out.println("Дата инициализации: " + collection.getDate());
    }
    
    /**
     * Вывести в стандартный поток вывода все элементы коллекции в строковом представлении
     */
    public static void show(Collection c) {
        if (c.list.isEmpty()) {
            System.out.println("В коллекции нет элементов");
            return;
        }
        for (SpaceMarine r : c.list) {
            System.out.println(r.toString());
        }
    }
    
    /**
     * Добавить элемент в коллекцию
     */
    public static void add(CommandReader reader, Collection c, String s) throws EndOfFileException {
        int id = c.getRandId();
        c.list.add(toAdd(reader, id, s));
        Collections.sort(c.list);
    }
    
    /**
     * Обновить значение элемента коллекции, id которого равен заданному
     */
    public static void update(AbstractReader reader, Collection c, String s) throws EndOfFileException {

        int id;
        try {
            id = SpaceMarine.idCheck.checker(Integer.parseInt(s));
        } catch (NumberFormatException | FailedCheckException e) {
            id = reader.handlerI("Введите id элемента: ", SpaceMarine.idCheck);
        }
        SpaceMarine r = c.searchById(id);
        if (r == null) {
            System.out.println("Элемент не найден");
            return;
        }
        String name = reader.handlerS("Введите String: name", SpaceMarine.nameCheck);
        c.list.set(c.list.indexOf(r), toAdd(reader, id, name));
        Collections.sort(c.list);
    }
    
    /**
     * Удалить элемент из коллекции по его id
     */
    public static void removeById(AbstractReader reader, Collection c, String s) throws EndOfFileException {
        int id;
        try {
            id = SpaceMarine.idCheck.checker(Integer.parseInt(s));
        } catch (NumberFormatException | FailedCheckException e) {
            id = reader.handlerI("Введите int id: ", SpaceMarine.idCheck);
        }
        SpaceMarine r = c.searchById(id);
        if (r == null) {
            System.out.println("\u001B[31m"+"Элемент не найден"+"\u001B[31m");
            return;
        }
        c.list.remove(r);
        Collections.sort(c.list);

    }
    
    /**
     * Сохраняет коллекцию в файл
     */
    public static void save(Collection c) {
        SaveManagement.saveToFile(c);
    }

    /**
     * Удаляет все элементы из коллекции
     */
    public static void clear(@NotNull Collection c) {
        c.list.clear();
    }
    
    /**
     * Считывает и исполняет скрипт из указанного файла.
     * В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме
     */
    public static boolean executeScript(Collection c, String s) {
        boolean programIsWorking = true;
        //Reader reader;
        try (Reader reader = new Reader(s)) {
            if (RecursionHandler.isContains(s)) {
                RecursionHandler.addToFiles(s);
                String[] com;
                System.out.print("\u001B[36m" + "Чтение команды в файле " + s + ": " + "\u001B[36m");
                String line = reader.read();
                while (line != null && programIsWorking) {
                    com = CommandReader.splitter(line);
                    programIsWorking = Command.switcher(reader, c, com[0], com[1]);
                    System.out.print("\u001B[33m" + "Чтение команды в файле " + s + ": " + "\u001B[0m");
                    line = reader.read();
                }
                RecursionHandler.removeLast();
            } else
                System.out.println("\u001B[31m" + "Найдено повторение" + "\u001B[0m");

        } catch (IncorrectFileNameException e) {
            System.out.println("\u001B[31m" + "Неверное имя файла" + "\u001B[0m");
        } catch (EndOfFileException e) {
            System.out.println("\u001B[31m" + "Неожиданный конец файла " + s + "\u001B[0m");
            RecursionHandler.removeLast();
        } catch (FileNotFoundException e) {
            System.out.println("\u001B[31m" + "Файл не найден" + "\u001B[0m");
        }
        return programIsWorking;
    }
    
    
    public static SpaceMarine toAdd(CommandReader reader, int id, String s) throws EndOfFileException {

        SpaceMarine sm = new SpaceMarine();
        sm.setId(id);

        try {
        	SpaceMarine.nameCheck.checker(s);
            System.out.println("Поле name: " + s);
        } catch (FailedCheckException e) {
            s = reader.handlerS("Введите String name, длиной больше 0: ", SpaceMarine.nameCheck);
        }
        sm.setName(s);

        System.out.println("Ввoд полей Coordinates");
        int cx = reader.handlerI("Введите int x: ", Coordinates.xCheck);
        Double cy = reader.handlerD("Введите Double y: ", Coordinates.yCheck);
        sm.setCoordinates(new Coordinates(cx, cy));

        LocalDate creationTime = LocalDate.now();
        sm.setCreationDate(creationTime);
        
        Double health = reader.handlerD("Введите Double health, больше 0:", SpaceMarine.healthCheck);
        sm.setHealth();

        boolean loyal = reader.handlerB("Введите boolean loyal", SpaceMarine.loyalCheck);
        sm.setHealth();
        
        String achievements = reader.handlerS("Введите String achievements", SpaceMarine.nameCheck);

        System.out.println("Ввoд полей Chapter");
        String name1 = reader.handlerS("Введите String name: ", Chapter.cCheck);
        String parentLegion1 = reader.handlerS("Введите String parentLegion: ", Chapter.cCheck);
        sm.setChapter(new Chapter(name1, parenLegion1));
        
        Weapon weaponType1 = reader.handlerS("Введите Weapon weaponType {\r\n" + 
        		"    HEAVY_BOLTGUN,\r\n" + 
        		"    BOLT_RIFLE,\r\n" + 
        		"    PLASMA_GUN,\r\n" + 
        		"    COMBI_PLASMA_GUN,\r\n" + 
        		"    INFERNO_PISTOL;\r\n" + 
        		"} ", SpaceMarine.WeaponCheck);
        sm.setWeaponType(weaponType1);

        return sm;
    }
