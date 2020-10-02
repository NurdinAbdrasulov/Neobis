import java.util.Date;

public class Clients {
    private long id;
    private String fio;
    private String gender;
    private String phoneNumber;
    private Date dateOfBirth;
    private Date registrationDate;
    private String address;

    public Clients(){

    }

    public Clients(long id, String fio, String gender, String phoneNumber, Date dateOfBirth, Date registrationDate, String address) {
        this.id = id;
        this.fio = fio;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.registrationDate = registrationDate;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
