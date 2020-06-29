import Exceptions.FailedCheckException;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import Exceptions.EndOfFileException;
import Exceptions.IncorrectFileNameException;
import java.util.Date;
import java.util.LinkedList;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.Collections;
/**
 * Класс для обработки команд, вводимых в консоли
 */

public class Command {
    /**
     * Обработка команд
     * @throws IOException 
     * @throws NumberFormatException 
     */
    public static boolean switcher(CommandReader reader, Collection c, String s1, String s2) throws EndOfFileException, NumberFormatException, IOException {
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
            case ("upload"):
                upload(reader, c, s2);
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
        
 interface Comparable<T> extends java.lang.Comparable<T> {

    }  


public static Checker<Boolean> boolCheck = (Boolean B) -> {
    if (B != null) return B;
    else throw new FailedCheckException();
};
    /**
     * help : вывести справку по доступным командам
     */
    public static void help() {
        System.out.println(
        				"help : вывести справку по доступным командам\n"+
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
        else  {
            System.out.println("\u001B[31m" + "В коллекции нет элементов" + "\u001B[0m");}
        Collections.sort(c.list);
    }
      //  head : вывести первый элемент коллекции
        public static void head(Collection c) throws EndOfFileException {
            int size = c.list.size();
            int i = 0;
            if (i < size) {
            	System.out.println(c.list.get(i).toString());
                }
            else {
                System.out.println("\u001B[31m" + "В коллекции нет элементов" + "\u001B[0m");
        }
        }
    //remove_head : вывести первый элемент коллекции и удалить его
            public static void remove_head(Collection c) throws EndOfFileException {
                int size = c.list.size();
                int i = 0;
                if (i < size) {
                	System.out.println(c.list.get(i).toString());
                	c.list.remove(c.list.get(i));
                	// Collections.sort(c.list);
                    }
                else {
                    System.out.println("\u001B[31m" + "В коллекции нет элементов" + "\u001B[0m");
            }}
            //group_counting_by_chapter
            
                        public static void group_counting_by_chapter(Collection c) {
                if (c.list.isEmpty()) {
                    System.out.println("В коллекции нет элементов");
                    return;
                }
                else {
                	LinkedList<String> lan = new LinkedList<>();
                	//boolean contains(Object element);
                	for (SpaceMarine sm : c.list) {
                        if (!lan.contains(sm.getChapter().getParentLegion())) {
                        	lan.add(sm.getChapter().getParentLegion());
                        }
                	}
                	for (int j = 0; j < lan.size(); j++) {
                		System.out.println("Легион:");
                		System.out.println(lan.get(j));
                		int k = 0;
                		for (SpaceMarine sm : c.list) {
                			if (sm.getChapter().getParentLegion().equals(lan.get(j))) {
                				System.out.println(sm.toString());
                				k = k+1;
                			}
                		}
                	 System.out.println("Всего элементов: " + k);
                	}

               
            }}            
                /**
                 * remove_all_by_weapon_type
                 */
                public static void remove_all_by_weapon_type(CommandReader reader, Collection c, String s) {
        if (s.equals("HEAVY_BOLTGUN") || s.equals("BOLT_RIFLE") || s.equals("PLASMA_GUN") || s.equals("COMBI_PLASMA_GUN") || s.equals("INFERNO_PISTOL"))
        {
		int size = c.list.size();
        	int i = 0;
		List<Integer> num = new ArrayList<Integer>();

                   for (SpaceMarine sm : c.list) {
                        if (sm.getWeaponType().toString().equals(s)) {
				num.add(i);
                        	 }
			else {
				i = i+1;
			}}
		for (int j = 0; j < num.size(); j++)
		{
		c.list.remove(c.list.get(num.get(j)));
                  }
		Collections.sort(c.list);
        }
        else {
        	System.out.println("\u001B[32m" + "Такого типа оружия пока нет!" + "\u001B[32m");
        	}
                }

            
                /**
                 * filter_less_than_loyal
                 */
                public static void filter_less_than_loyal(CommandReader reader, Collection c, String s) throws EndOfFileException {
                    if (s == "0") System.out.println("Таких элементов нет");
                    else {
                    	for (SpaceMarine sm : c.list) {
                            if (sm.getLoyal() == false)
                            	System.out.println(sm.toString());;
                        }
                    }
                    Collections.sort(c.list);
                }
                
                
             public static void upload(CommandReader reader, Collection c, String s) throws EndOfFileException, NumberFormatException, IOException {
    	BufferedReader reader1 = new BufferedReader(new FileReader(s));
        // считываем построчно
        String line = null;
        Scanner scanner = null;
        int index = 0;
        int cx = 1;
        Double cy = 1.0;
        String n1 = null;
        String n2 = null;
 
        while ((line = reader1.readLine()) != null) {
        	SpaceMarine sm = new SpaceMarine();
            scanner = new Scanner(line);
          
            
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0)
                    sm.setId(Long.parseLong(data));
                else if (index == 1)
                    sm.setName(data);
                else if (index == 2)
                	cx = Integer.parseInt(data.replace("Coordinates{x=", ""));
                else if (index == 3) {
                	cy = Double.parseDouble(data.replace("y=", "").replace("}", ""));
                    sm.setCoordinates(new Coordinates(cx, cy)); }
                else if (index == 4) {
                	String aa = data;
                	LocalDate creationTime = LocalDate.now();
                    sm.setCreationDate(creationTime);
                }
                else if (index == 5)
                	sm.setHealth(Double.parseDouble(data));
                else if (index == 6)
                	sm.setLoyal(Boolean.parseBoolean(data));
                else if (index == 7)
                	sm.setAchievements(data);
                else if (index == 8) {
                	String weaponType1 = data;
                	if (weaponType1.equals("HEAVY_BOLTGUN") || weaponType1.equals("BOLT_RIFLE") || weaponType1.equals("PLASMA_GUN") || weaponType1.equals("COMBI_PLASMA_GUN") || weaponType1.equals("INFERNO_PISTOL"))
                    {
                    	sm.setWeaponType(SpaceMarine.Weapon.valueOf(weaponType1));
                    }
                }
                else if (index == 9)
                	n1 = data.replace("Chapter{name=", "");
                else if (index == 10) {
                	n2 = data.replace("parentLegion=", "").replace("}", "");
                	sm.setChapter(new Chapter(n1, n2));
                }
                else
                    System.out.println("/");
                index++;
            }
            index = 0;
            c.list.add(sm);
        }
         
        //закрываем наш ридер
        reader.close();
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
        Long id = c.getRandId();
        c.list.add(toAdd(reader, id, s));
        Collections.sort(c.list);
       
    }
    
    /**
     * Обновить значение элемента коллекции, id которого равен заданному
     */
    public static void update(CommandReader reader, Collection c, String s) throws EndOfFileException {

        Long id;
        try {
            id = SpaceMarine.idCheck.checker(Long.parseLong(s));
        } catch (NumberFormatException | FailedCheckException e) {
            id = reader.handlerL("Введите id элемента: ", SpaceMarine.idCheck);
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
    public static void removeById(CommandReader reader, Collection c, String s) throws EndOfFileException {
        Long id;
        try {
            id = SpaceMarine.idCheck.checker(Long.parseLong(s));
        } catch (NumberFormatException | FailedCheckException e) {
            id = reader.handlerL("Введите int id: ", SpaceMarine.idCheck);
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
    public static void clear(Collection c) {
        c.list.clear();
    }
    
     /**
     * Считывает и исполняет скрипт из указанного файла.
     * В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме
     * @throws IOException 
     * @throws NumberFormatException 
     */
    public static boolean executeScript(Collection c, String s) throws NumberFormatException, IOException {
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
    
    
    public static SpaceMarine toAdd(CommandReader reader, Long id, String s) throws EndOfFileException {

        SpaceMarine sm = new SpaceMarine();
        sm.setId(id);

        try {
        	SpaceMarine.nameCheck.checker(s);
            System.out.println("Поле name: " + s);
        } catch (FailedCheckException e) {
            s = reader.handlerS("Введите String name, длиной больше 0: ", SpaceMarine.nameCheck);
        }
        sm.setName(s);

        System.out.println("Ввoд полей Coordinates:");
        int cx = reader.handlerI("Введите int x: ", Coordinates.xCheck);
        Double cy = reader.handlerD("Введите Double y: ", Coordinates.yCheck);
        sm.setCoordinates(new Coordinates(cx, cy));

        LocalDate creationTime = LocalDate.now();
        sm.setCreationDate(creationTime);
        
        Double health1 = reader.handlerD("Введите Double health, больше 0:", SpaceMarine.healthCheck);
        sm.setHealth(health1);

        boolean loyal1 = reader.handlerB("Введите boolean loyal", boolCheck);
        sm.setLoyal(loyal1);
        
        String achievements = reader.handlerS("Введите String achievements", SpaceMarine.nameCheck);
        sm.setAchievements(achievements);

        System.out.println("Ввoд полей Chapter");
        String name1 = reader.handlerS("Введите String name: ", Chapter.cCheck);
        String parentLegion1 = reader.handlerS("Введите String parentLegion: ", Chapter.cCheck);
        sm.setChapter(new Chapter(name1, parentLegion1));
        
        String weaponType1 = reader.handlerS("Введите Weapon weaponType {\r\n" + 
        		"    HEAVY_BOLTGUN,\r\n" + 
        		"    BOLT_RIFLE,\r\n" + 
        		"    PLASMA_GUN,\r\n" + 
        		"    COMBI_PLASMA_GUN,\r\n" + 
        		"    INFERNO_PISTOL;\r\n" + 
        		"} ", SpaceMarine.nameCheck);
        
        if (weaponType1.equals("HEAVY_BOLTGUN") || weaponType1.equals("BOLT_RIFLE") || weaponType1.equals("PLASMA_GUN") || weaponType1.equals("COMBI_PLASMA_GUN") || weaponType1.equals("INFERNO_PISTOL"))
        {
        	sm.setWeaponType(SpaceMarine.Weapon.valueOf(weaponType1));
        }
        else {
        	System.out.println("Введите из предложенных");
        	System.out.println("    HEAVY_BOLTGUN,\r\n" + 
    		"    BOLT_RIFLE,\r\n" + 
    		"    PLASMA_GUN,\r\n" + 
    		"    COMBI_PLASMA_GUN,\r\n" + 
    		"    INFERNO_PISTOL;\r\n"
    		);
        }

        return sm;
    }
}
