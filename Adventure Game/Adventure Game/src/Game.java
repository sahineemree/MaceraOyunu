import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Welcome to Adventure Game!!");
        System.out.print("Please enter name : ");
       // String playerName = input.nextLine();
        Player player = new Player("Emre");
        System.out.println("Welcome to this dark and foggy night, "+player.getName()+"!");
        System.out.println("Everything that happens here is real..");
        player.selectChar();
        Location location = null;

        while (true){
            player.printInfo();
            System.out.println();
            System.out.println("########  Places  ########");
            System.out.println();
            System.out.println("1 - Safe House --> There is no enemy in a safe house for you.");
            System.out.println("2 - Tool Store --> You can buy weapons and armour.");
            System.out.println("3 - Cave --> Go to the cave. Be careful there are zombies here. PRİCE: FOOD");
            System.out.println("4 - Forest --> Go to the forest. Be careful there are vampires here. PRİCE: FİREWOOD");
            System.out.println("5 - River --> Go to the river. Be careful there are witches here. PRİCE: WATER");
            System.out.println("0 - Log Out.");
            System.out.print("Enter your destination : ");
            int selectLoc = input.nextInt();

            switch (selectLoc){
                case 0 :
                    location = null;
                    break;

                case 1 :
                    location = new SafeHouse(player);
                    break;

                case 2 :
                    location = new ToolStore(player);
                    break;

                case 3 :
                    location = new Cave(player);
                    break;

                case 4 :
                    location = new Forest(player);
                    break;

                case 5 :
                    location = new River(player);
                    break;

                default :
                    location = new SafeHouse(player);
            }

            if (location==null){
                System.out.println("You left this foggy island too soon..");
                break;
            }
            if (!location.onLocation()){
                System.out.println("GAME OVER!!");
                break;
            }
        }
    }
}
