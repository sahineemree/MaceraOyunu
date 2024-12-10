import java.util.*;

public abstract class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;


    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("You are here : " + this.getName());
        System.out.println("Be careful, there are "+ this.getObstacle().getName() +" here");
        System.out.println("<W>ar or <E>scape? : ");
        return true;
    }

    public boolean combat (int obsNumber){
        for (int i = 1; i<= obsNumber; i++){
            this.getObstacle().setHealth(this.getObstacle().getOrjHealth());
            playerStats();
            obstacleStats(i);

            while (this.getPlayer().getHealth()>0 &&this.getObstacle().getHealth()>0){
                System.out.print("<H>it or <E>scape? : ");
                String selectCombat=input.nextLine();
                selectCombat = selectCombat.toUpperCase();
                if (selectCombat.equals("H")){
                    System.out.println("You shoot!");
                    obstacle.setHealth(this.obstacle.getHealth()-this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth() > 0){
                        System.out.println(this.getObstacle().getName()+ " hit you!");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0){
                            obstacleDamage=0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                }
                else {
                    return false;
                }
            }

            if (this.getObstacle().getHealth()<this.getPlayer().getHealth()){
                System.out.println("You defeated all enemies!");
                System.out.println("You won : " + this.getObstacle().getAward());
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Money = " + this.getPlayer().getMoney());
                System.out.println();
            }

        }
        return false;
    }

    public void afterHit(){
        System.out.println("Your health = " + this.getPlayer().getHealth());
        if (this.getObstacle().getHealth() < 0 ){
            this.getObstacle().setHealth(0);
        }
        System.out.println(this.getObstacle().getName() + " health = " + this.getObstacle().getHealth());
        System.out.println();
    }

    public void playerStats(){
        System.out.println("Player Stats");
        System.out.println("------------------------");
        System.out.println("Health = " + this.getPlayer().getHealth());
        System.out.println("Damage = " + this.getPlayer().getTotalDamage());
        System.out.println("Money = " + this.getPlayer().getMoney());
        System.out.println("Weapon : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Armor : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block = " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println();
        System.out.println();

    }

    public void obstacleStats(int i){
        System.out.println(i + ". " + this.getObstacle().getName()+ " stats");
        System.out.println("------------------------");
        System.out.println("Health = " + this.getObstacle().getHealth());
        System.out.println("Damage = " + this.getObstacle().getDamage());
        System.out.println("Award =  " + this.getObstacle().getAward());
        System.out.println();
        System.out.println();
    }


    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(3)+1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
