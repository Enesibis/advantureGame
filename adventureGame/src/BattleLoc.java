public abstract class BattleLoc extends Location{
    protected Obstacle obstacle;
    protected String award;
    BattleLoc(Player player, String name, Obstacle obstacle, String award) {
        super(player);
        this.name = name;
        this.obstacle = obstacle;
        this.award = award;
    }

    public boolean getLocation(){
        int obsCount = obstacle.obstacleCount();
        String selCase;
        System.out.println("Şuan Buradasınız : " + this.getName());
        System.out.println("Burada " + obsCount + " tane " + obstacle.getName() + " var.");
        System.out.println("Savaşmak İçin Tuşlayınız : 'S' ");
        System.out.println("Kaçmak İçin Tuşlayınız : 'K' ");
        selCase = scanner.next();
        selCase = selCase.toUpperCase();
        if (selCase.equals("S")){
            if (combat(obsCount)){
                System.out.println(this.getName() + "Bölgesindeki Tüm Yaratıkları Öldürdünüz !");
                if (this.award.equals("Food") && player.getInventory().isFood() == false){
                    System.out.println(this.award + " Kazandınız !");
                    player.getInventory().setFood(true);
                }else if (this.award.equals("Water") && player.getInventory().isWater() == false){
                    System.out.println(this.award + " Kazandınız !");
                    player.getInventory().setWater(true);
                }else if (this.award.equals("Firewood") && player.getInventory().isFirewood() == false){
                    System.out.println(this.award + " Kazandınız !");
                    player.getInventory().setFirewood(true);
                }
                return true;
            }else if (selCase.equals("K")){

            }else{
                System.out.println("Öldünüz !");
                return false;
            }
        }
        return true;
    }

    public boolean combat(int obsCount){
        for (int i = 0 ; i < obsCount; i++){
            int defaulObstHealth = obstacle.getHealth();
            playerStats();
            enemyStats();
            while(player.getHealthy() > 0 && obstacle.getHealth() > 0){
                System.out.println("Vurmak İçin Tuşlayınız : 'V' ");
                System.out.println("Kaçmak İçin Tuşlayınız : 'K' ");
                String selCase = scanner.next();
                selCase = selCase.toUpperCase();
                if (selCase.equals("V")){
                    System.out.println("Siz Vurdunuz !");
                    obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                    afterHit();
                    if (obstacle.getHealth() > 0){
                        System.out.println();
                        System.out.println("Canavar Size Vurdu ! ");
                        player.setHealthy(player.getHealthy() + player.getInventory().getArmor() - obstacle.getDamage());
                        afterHit();
                    }
                }else {
                    return false;
                }
            }
            if (obstacle.getHealth() <= 0 && player.getHealthy() > 0) {
                System.out.println("Düşmanı Öldürdünüz !");
                player.setMoney(player.getMoney() + obstacle.getAward());
                System.out.println("Güncel Paranız : " + player.getMoney());
                obstacle.setHealth(defaulObstHealth);
            }else {
                return false;
            }
            System.out.println("------------------------------");
        }
        return true;
    }

    public void playerStats(){
        System.out.println("Oyuncu Değerleri\n-------------------------------");
        System.out.println("Sağlık : " + player.getHealthy());
        System.out.println("Hasar : " + player.getTotalDamage());
        System.out.println("Bakiye : " + player.getMoney());
        if (player.getInventory().getDamage() > 0){
            System.out.println("Silah : " + player.getInventory().getWeaponName());
        }
        if (player.getInventory().getArmor() > 0){
            System.out.println("Zırh : " + player.getInventory().getArmorName());
        }
    }

    public void enemyStats(){
        System.out.println();
        System.out.println(obstacle.getName() + " Değerleri\n------------------------------");
        System.out.println("Sağlık : " + obstacle.getHealth());
        System.out.println("Hasar : " + obstacle.getDamage());
        System.out.println("Ödül : " + obstacle.getAward());
    }

    public void afterHit(){
        System.out.println("Oyuncu Canı : " + player.getHealthy());
        System.out.println(obstacle.getName() + " Canı : " + obstacle.getHealth() );
        System.out.println();
    }
}
