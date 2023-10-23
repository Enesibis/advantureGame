import java.util.Scanner;

public class Player {
    Scanner scanner = new Scanner(System.in);
    private int damage;
    private int healthy;
    private int rhealty;
    private int money;
    private String characterName;
    private String name;
    private Inventory inventory;

    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectCha(){
        switch (chaMenu()){
            case 1:
                initPlayer("Samuray",5,21,15);
                break;
            case 2:
                initPlayer("Okçu",7,18,20);
                break;
            case 3:
                initPlayer("Şövalye",8,24,5);
                break;
            default:
                initPlayer("Samuray",5,21,15);
                break;
        }
        System.out.println("Karakter : " + getCharacterName() + "\t" + "Hasar : " + getDamage() + "\t" + "Sağlık : " + getHealthy() + "\t" + "Para : " + getMoney());

    }

    public void initPlayer(String characterName, int dmg, int hlthy, int mny){
        setCharacterName(characterName);
        setDamage(dmg);
        setHealthy(hlthy);
        setMoney(mny);
        setRhealty(healthy);
    }

    public int chaMenu(){
        System.out.println("Bir Karakter Seçiniz ");
        System.out.println("1- Samuray \t  Hasar : 5  \t Sağlık : 21 \t Para : 15");
        System.out.println("2- Okçu \t  Hasar : 7  \t Sağlık :18 \t Para : 20");
        System.out.println("3- Şövalye \t  Hasar : 8  \t Sağlık : 24 \t Para : 5");
        int chaID = scanner.nextInt();
        while (chaID < 1 || chaID > 3){
            System.out.println("Lütfen Geçerli Bir Seçim Yapınız ");
            chaID = scanner.nextInt();
        }
        return chaID;
    }

    public int getTotalDamage(){
        return this.getDamage() + this.getInventory().getDamage();
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        if (healthy < 0 ){
            this.healthy = 0;
        }
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRhealty() {
        return rhealty;
    }

    public void setRhealty(int rhealty) {
        this.rhealty = rhealty;
    }
}
