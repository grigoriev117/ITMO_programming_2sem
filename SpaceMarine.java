import java.time.LocalDate;
import Exceptions.FailedCheckException;

public class SpaceMarine {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Double health; //Поле может быть null, Значение поля должно быть больше 0
    private boolean loyal;
    private String achievements; //Поле не может быть null
    private Weapon weaponType; //Поле может быть null
    private Chapter chapter; //Поле не может быть null
}

@Override
public String toString() {
    return "SpaceMarine{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", coordinates=" + coordinates +
            ", creationDate=" + creationDate +
            ", health=" + health +
            ", loyal=" + loyal +
            ", achievements=" + achievements +
            ", weaponType=" + weaponType +
            ", chapter=" + chapter +
            '}';
}

public String toXMLfile() {
   
}

public class Coordinates {
    private Integer x; //Поле не может быть null
    private Double y; //Поле не может быть null
}
public class Chapter {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String parentLegion;
}
public enum Weapon {
    HEAVY_BOLTGUN,
    BOLT_RIFLE,
    PLASMA_GUN,
    COMBI_PLASMA_GUN,
    INFERNO_PISTOL;
}

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public void setCoordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
}

public String getName() {
    return name;
}

public String getAchievements() {
    return achievements;
}
public void setId(String achievements) {
    this.achievements = achievements;
}

public void setName(String name) {
    this.name = name;
}

public Double getHealth() {
    return health;
}

public void setCreationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
}

public boolean getLoyal() {
    this.loyal = loyal;
}

public Weapon getWeaponType() {
    return weaponType;
}

public void setWeaponType(Weapon weaponType) {
    this.weaponType = weaponType;
}

public Chapter getChapter() {
    return chapter;
}

public void setChapter(Chapter chapter) {
    this.chapter = chapter;
}

/**
 * Конвертирование элемента списка в удобный для сохранения формат
 */
public String toCSVfile() {
    String CSV = id + "," + name + "," + coordinates.getX() + "," + coordinates.getY() + "," + creationDate + ",";
    return CSV;
}

/**
 * Проверка Weapon
 */
public static Checker<Weapon> WeaponCheck = (Weapon W) -> {
    if (W == null) return null;
    else if (W == "HEAVY_BOLTGUN" || W == "BOLT_RIFLE" || W == "PLASMA_GUN" || W == "COMBI_PLASMA_GUN" || W == "INFERNO_PISTOL") return L;
    else throw new FailedCheckException();
};


/**
 * Проверка Long
 */
public static Checker<Long> idCheck = (Long L) -> {
     if (L != null ) return L;
     else throw new FailedCheckException();
};
/**
 * Проверка Integer
 */
public static Checker<Integer> idCheck1 = (Integer I) -> {
    if (I != null && I > 0) return I;
    else throw new FailedCheckException();
};

/**
 * Проверка String
 */
public static Checker<String> nameCheck = (String S) -> {
    if (S != null && S.length() != 0) return S;
    else throw new FailedCheckException();
};

/**
 * Проверка Double
 */
public static Checker<Double> healthCheck = (Double D) -> {
    if (D != null && D.length() != 0) return D;
    else throw new FailedCheckException();
};

/**
 * Проверка boolean
 */
public static Checker<boolean> loyalCheck = (boolean B) -> {
    if (B == true || B== false) return B;
    else throw new FailedCheckException();
};

/**
 * Сравнение объектов. Сравнение объектов идет в первую очередь по имени, потом по дистанции
 */
@Override
public int compareTo(SpaceMarine sm) {
    int result = getName().compareTo(sm.getName());

    if (result == 0 && getHealth() != null && sm.getHealth() != null) {
        result = getHealth().compareTo(sm.getHealth());
    }
    return result;
}
}
