public class Forest extends BattleLoc{
    public Forest(Player player) {
        super(player,"Forest",new Vampire(), "Firewood",3);
    }

    @Override
    public boolean onLocation() {
        System.out.println("You're in the Forest!");
        System.out.println("Get ready for "+ randomObstacleNumber() +" vampires.");
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
