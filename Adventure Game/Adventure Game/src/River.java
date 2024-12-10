public class River extends BattleLoc {
    public River(Player player) {
        super(player, "River",new Witch(), "Water",2);
    }

    @Override
    public boolean onLocation() {
        System.out.println("You're in the River!");
        System.out.println("Get ready for "+ randomObstacleNumber() +" witches.");
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
            System.out.println("Game Over!!");
            return false;
        }
        return true;
    }
}
