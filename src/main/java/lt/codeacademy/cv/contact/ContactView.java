package lt.codeacademy.cv.contact;

public class ContactView {

    private int id;
    private String value;
    private ContactType type;
    private String url;

    public ContactView() {
    }

    public ContactView(int id, String value, ContactType type, String url) {
        this.id = id;
        this.value = value;
        this.type = type;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public ContactType getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
