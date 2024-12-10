import java.util.Scanner;

public class Player {
    Location location = null;
    private int health;
    private int orjHealth;
    private int damage;
    private int money;
    private String name;
    private String charname;
    private Inventory inventory;
    private Scanner input = new Scanner(System.in);

    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar(){
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("---------------------------------------------------------------------");

        for(GameChar gameChar : charList){
            System.out.println("ID: "+gameChar.getId() +
                    "\t Character: "+ gameChar.getName() +
                    "\t Damage = " + gameChar.getDamage()+
                    "\t   Health = "+gameChar.getHealth()+
                    "\t Money = "+gameChar.getMoney());
        }
        System.out.println("---------------------------------------------------------------------");
        System.out.print("Enter the character ID : ");
        int selectChar = input.nextInt();
        switch (selectChar){

            case 1 :
                initPlayer(new Samurai());
                break;

            case 2 :
                initPlayer(new Archer());
                break;

            case 3 :
                initPlayer(new Knight());
                break;
        }
      /*  System.out.println("Your Character : " + this.getCharname()+
                "\t Damage = " + this.getDamage()+
                "\t  Health = " + this.getHealth()+
                "\t Money = " + this.getMoney());*/
    }

    public void initPlayer (GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrjHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharname(gameChar.getName());
    }

    public void printInfo(){
        System.out.println("Your Character : "+ this.getCharname()+
                "\tWeapon : " + this.getInventory().getWeapon().getName()+
                "\t Damage = " + this.getTotalDamage()+
                "\t  Armor : " + this.getInventory().getArmor().getName()+
                "\tBlock = " + this.getInventory().getArmor().getBlock()+
                "\t  Health = " + this.getHealth()+
                "\t Money = " + this.getMoney());
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharname() {
        return charname;
    }

    public void setCharname(String charname) {
        this.charname = charname;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getOrjHealth() {
        return orjHealth;
    }

    public void setOrjHealth(int orjHealth) {
        this.orjHealth = orjHealth;
    }
}
