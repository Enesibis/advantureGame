import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    Player player;
    Location location;
    public void login(){
        System.out.println("Macera Oyununa Hoş Geldiniz !");
        System.out.println("Oyuuna Başlamak İçin İsminizi Gİriniz : ");
        String playerName = scanner.nextLine();
        player = new Player(playerName);
        player.selectCha();
        start();
    }

    public void start(){
        while (true){
            System.out.println();
            System.out.println("=======================================================");
            System.out.println();
            System.out.println("Gitmek İstediğiniz Mekanı Seçiniz : ");
            System.out.println("1-Güvenli Ev --> Size Ait Güvenli Bir Mekan, Düşman Yok.");
            System.out.println("2-Mağara -->Karşınıza Zombi Çıkabilir.");
            System.out.println("3-Orman -->Karşınıza Vampir Çıkabilir.");
            System.out.println("4-Nehir -->Karşınıza Ayı Çıkabilir.");
            System.out.println("5-Mağaza -->Silah veya Zırh Alabilirsiniz.");
            System.out.println("Gitmek İstediğiniz Yer : ");
            int selLoc = scanner.nextInt();
            while (selLoc < 1 || selLoc > 5){
                System.out.println("Hatalı Seçim Yaptınız !! / Tekrar Seçim Yapınız.");
                selLoc = scanner.nextInt();
            }
            switch (selLoc){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Cave(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if(!location.getLocation()){
                System.out.println("Oyun Bitti !");
                break;
            }
        }
    }
}
