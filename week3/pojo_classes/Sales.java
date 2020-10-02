import java.util.Date;

public class Sales {
    private long id;
    private String status;
    private Cars car;
    private Clients clients;

    public Sales(){

    }

    public Sales(long id, String status, Cars car, Clients clients, Date dateOfSale) {
        this.id = id;
        this.status = status;
        this.car = car;
        this.clients = clients;
        this.dateOfSale = dateOfSale;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cars getCar() {
        return car;
    }

    public void setCar(Cars car) {
        this.car = car;
    }

    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }

    public Date getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(Date dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    private Date dateOfSale;
}
