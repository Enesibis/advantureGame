import java.util.Scanner;

public class Login {
    Scanner scanner = new Scanner(System.in);
    private String name;
    public Login(){
        System.out.println("Macera Oyununa Hoş Geldiniz !");
        System.out.println("Oyuuna Başlamak İçin İsminizi Gİriniz : ");
        this.name = scanner.nextLine();
        name = this.name;
        System.out.println("Oyundaki İsminiz : " + name);
    }
}
