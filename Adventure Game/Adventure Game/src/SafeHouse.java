public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Safe House");

        }
        @Override
        public boolean onLocation() {
            System.out.println("You're in the safe house!");
            System.out.println("Health regeneration..");
            this.getPlayer().setHealth(this.getPlayer().getOrjHealth());
            return true;
    }
}
