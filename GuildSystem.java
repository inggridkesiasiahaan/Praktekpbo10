import java.io.*;
import java.util.ArrayList;

public class GuildSystem {

    public static void main(String[] args) {

        String namaFile = "guild_data.dat";

        // =========================
        // SKENARIO 1 : SAVE DATA
        // =========================
        ArrayList<Member> daftarMember = new ArrayList<>();

        daftarMember.add(new Member("M001", "Andi"));
        daftarMember.add(new Member("M002", "Budi"));
        daftarMember.add(new Member("M003", "Citra"));

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(namaFile))) {

            oos.writeObject(daftarMember);
            System.out.println("Data berhasil disimpan ke " + namaFile);

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan data!");
            e.printStackTrace();
        }

        // =========================
        // SKENARIO 2 : LOAD DATA
        // =========================
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(namaFile))) {

            ArrayList<Member> hasilLoad =
                    (ArrayList<Member>) ois.readObject();

            System.out.println("\n=== DATA MEMBER HASIL LOAD ===");

            for (Member m : hasilLoad) {
                System.out.println("ID   : " + m.getId());
                System.out.println("Nama : " + m.getNama());
                System.out.println("-------------------");
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Terjadi kesalahan saat membaca data!");
            e.printStackTrace();
        }
    }
}