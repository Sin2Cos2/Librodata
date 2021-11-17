package Project;

public class Language {
    private final int ID;
    private String code;
    private String name;

    public Language(int ID, String code, String name) {
        this.ID = ID;
        this.code = code;
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
