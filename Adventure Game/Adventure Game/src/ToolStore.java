public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println();
        System.out.println("------ Welcome the Tool Store! ------");
        System.out.println();
        boolean showMenu = true;
        while(showMenu){
            System.out.println("1 - Weapons");
            System.out.println("2 - Armors");
            System.out.println("0 - Exit");
            System.out.print("Enter your choice : ");
            int selectCase = input.nextInt();
            while (selectCase<0 || selectCase>2){
                System.out.print("The value entered is invalid. Enter again : ");
                selectCase = input.nextInt();
            }
            switch (selectCase){
                case 1 :
                    printWeapons();
                    buyWeapon();
                    break;

                case 2 :
                    printArmors();
                    buyArmor();
                    break;

                case 0 :
                    System.out.println("See you later!");
                    showMenu = false;
                    break;
            }
        }
    return true;
    }

    public void printWeapons(){
        System.out.println();
        System.out.println("----- Weapons -----");
        System.out.println();
        for(Weapon w : Weapon.weapons()){
            System.out.println(w.getId()+ ") "+w.getName() + "\t Damage = " + w.getDamage() + "\t Price = " + w.getPrice());
        }
        System.out.println("0) Back");

    }
    public void buyWeapon() {
        System.out.print("Select your weapon : ");

        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length){
            System.out.print("The value entered is invalid. Enter again : ");
            selectWeaponID = input.nextInt();
        }

        if (selectWeaponID!=0){
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);

            if (selectedWeapon!= null){
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("You do not have enough balance!");
                    System.out.println("Money = " + this.getPlayer().getMoney());
                } else {
                    System.out.println(selectedWeapon.getName() + " you bought a weapon!");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Remaining money = " + this.getPlayer().getMoney());
                    System.out.println("Ex weapon : " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("New weapon : " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }
    }

    public void printArmors(){
        System.out.println();
        System.out.println("----- Armors -----");
        System.out.println();
        for(Armor a : Armor.armors()){
            System.out.println(a.getId()+ ") "+a.getName() + "\t Block = " + a.getBlock() + "\t Price = " + a.getPrice());
        }
    }

    public void buyArmor(){
        System.out.print("Select your armor : ");

        int selectArmorID = input.nextInt();
        while (selectArmorID<1 || selectArmorID > Armor.armors().length){
            System.out.print("The value entered is invalid. Enter again : ");
            selectArmorID = input.nextInt();
        }
        if (selectArmorID != 0){
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);

            if (selectedArmor!=null){
                if (selectedArmor.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("You do not have enough balance!");
                    System.out.println("Money = " + this.getPlayer().getMoney());
                }
                else {
                    System.out.println(selectedArmor.getName() + " you bought an armor!");
                    this.getPlayer().setMoney(this.getPlayer().getMoney()-selectedArmor.getPrice());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Remaining money = " + this.getPlayer().getMoney());
                }
            }
        }


    }
}
