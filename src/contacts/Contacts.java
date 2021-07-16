package contacts;

public class Contacts {

    private int PhoneNumber;
    private String Name;

    public Contacts(int getPhoneNumber, String getName) {
        this.PhoneNumber = getPhoneNumber;
        this.Name = getName;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int getPhoneNumber) {
        this.PhoneNumber = getPhoneNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String getName) {
        this.Name = getName;
    }
}
