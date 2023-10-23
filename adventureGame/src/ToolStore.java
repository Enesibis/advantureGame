public class ToolStore extends NormalLoc{
    ToolStore(Player player) {
        super(player,"Mağaza");
    }

    public boolean getLocation(){
        System.out.println("Bakiyeniz : " + player.getMoney());
        System.out.println("1-Silahlar");
        System.out.println("2-Zırhlar");
        System.out.println("3-Çıkış");
        System.out.println("Seçiminiz : ");
        int selTool = scanner.nextInt();
        int selItemID;
        switch (selTool){
            case 1:
                selItemID = weaponMenu();
                buyWeapon(selItemID);
                break;
            case 2:
                selItemID = armorMenu();
                buyArmor(selItemID);
                break;
            default:
                break;
            }
        return true;
    }
    public int armorMenu(){
        System.out.println("1-Hafif" + "\tFiyat : 15" + "\t\tEngelleme : 1");
        System.out.println("2-Orta" + "\tFiyat : 25" + "\t\tEngelleme : 3");
        System.out.println("3-Ağır" + "\tFiyat : 40" + "\t\tEngelleme : 5");
        System.out.println("4-Çıkış");
        System.out.println("Zırh Seçiniz : ");
        int selArmorID = scanner.nextInt();
        return selArmorID;
    }

    public void buyArmor(int itemID){
        int avoid = 0;
        int price = 0;
        String armorName = null;
        switch (itemID){
            case 1:
                avoid = 1;
                price = 15;
                armorName = "Hafif Zırh";
                break;
            case 2:
                avoid = 3;
                price =25;
                armorName = "Orta Zırh";
                break;
            case 3:
                avoid = 5;
                price = 40;
                armorName = "Ağır Zırh";
                break;
            case 4:
                System.out.println("Çıkış Yapılıyor.");
                break;
            default:
                System.out.println("Hatalı Seçim Yaptınız Tekrar Seçiniz : ");
                break;
        }
        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInventory().setArmor(avoid);
                player.getInventory().setArmorName(armorName);
                player.setMoney(player.getMoney() - price);
                System.out.println(armorName + " Satın Aldınız ! Satın Alımdan Sonraki Engellenen Hasar : " + player.getInventory().getArmor());
                System.out.println("Kalan Para : " + player.getMoney());
            }else{
                System.out.println("Bakiye Yetersiz !");
            }
        }
    }
    public int weaponMenu(){
        System.out.println("1-Tabanca" + "\tFiyat : 25" + "\tHasar : 2");
        System.out.println("2-Kılıç" + "\t\tFiyat : 35" + "\tHasar : 3");
        System.out.println("3-Tüfek" + "\t\tFiyat : 45" + "\tHasar : 7");
        System.out.println("4-Çıkış");
        System.out.println("Silah Seçiniz : ");
        int selWeaponID = scanner.nextInt();
        return selWeaponID;
    }
    public void buyWeapon(int itemID){
        int damage = 0;
        int price = 0;
        String weaponName = null;
        switch (itemID){
            case 1:
                damage = 2;
                price = 25;
                weaponName = "Tabanca";
                break;
            case 2:
                damage = 3;
                price =35;
                weaponName = "Kılıç";
                break;
            case 3:
                damage = 7;
                price = 45;
                weaponName = "Tüfek";
                break;
            case 4:
                System.out.println("Çıkış Yapılıyor.");
                break;
            default:
                System.out.println("Hatalı Seçim Yaptınız Tekrar Seçiniz : ");
                break;
        }
        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInventory().setDamage(damage);
                player.getInventory().setWeaponName(weaponName);
                player.setMoney(player.getMoney() - price);
                System.out.println(weaponName + " Satın Aldınız ! \n Satın Alımdan Önceki Hasar : " + player.getDamage() + "\tSatın Alımdan Sonraki Hasar : " + player.getTotalDamage());
                System.out.println("Kalan Para : " + player.getMoney());
            }else{
                System.out.println("Bakiye Yetersiz !");
            }
        }
    }
}
