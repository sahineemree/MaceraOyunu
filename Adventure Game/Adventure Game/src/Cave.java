public class Cave extends BattleLoc{

    public Cave(Player player) {
        super(player, "Cave", new Zombie(), "Food",3);
    }

    @Override
    public boolean onLocation() {
        System.out.println("You're in the cave!");
        System.out.println("Get ready for "+ randomObstacleNumber() +" zombies. ");
        System.out.print("<W>ar or <E>scape? : ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("W")){
            System.out.println("The war has begun!!");
            if (combat(randomObstacleNumber())){
                System.out.println(this.getName() + " defeated all enemies!!");
                return true;

            }
        }
        if (this.getPlayer().getHealth()<0){
            System.out.println();
            return false;
        }
        return true;
    }

}
