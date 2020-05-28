import java.io.File;
import java.util.Date;
import java.util.LinkedList;

/**
 * ����� ��� �������� � ��������� LinkedList
 */
public class Collection {

    /**
     * ���� �������� ������
     */
    private Date date = new Date();
    /**
     * ������, � ������� �������� �������� ���� SpaceMarine
     */
    public LinkedList<SpaceMarine> list = new LinkedList<>();

    /**
     * �����, ������������ ������, ������� ��� ���������� � ������ CSV
     */
    public static Collection startFromSave(String[] args) {
        if (args.length > 0) {
            File saveFile = new File(args[0]);
            if (saveFile.exists()) {
                SaveManagement.setFile(saveFile);
                return SaveManagement.listFromSave();
            }
        }
        return new Collection();
    }

    /**
     * �����, �������������� ����� �������� �� id
     */
    public SpaceMarine searchById(Integer id) {
        for (SpaceMarine r : list) {
            if (r.getId().equals(id))
                return r;
        }
        return null;
    }

    public Date getDate() {
        return date;
    }

    /**
     * �����, ������������ ���������� id
     */
    public int getRandId() {
        int id;
        do {
            id = (int) (1 + Math.random() * (Integer.MAX_VALUE - 1));
        } while (this.searchById(id) != null);
        return id;
    }
}