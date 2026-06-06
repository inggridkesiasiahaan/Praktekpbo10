import java.io.Serializable;

public class Member implements Serializable {
    private static final long serialVersionUID = 1L;

    String id;
    String nama;

    public Member(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }
}