package task;

class MarsRover {
    Position R;
    String name;

    MarsRover(String name) {
        this.name = name;
    }

    public void init() {
        R = new Position();
        R.input();
    }

    public void parser(String s) {
        s = s.toUpperCase();
        String str = "LRM";
        Integer i;
        Integer len = s.length();
        for (i = 0; i < len; i++) {
            if (str.indexOf(s.charAt(i)) == -1)

            {
                System.out.println("Invalid instruction");
                break;
            }
        }


    }

    public int rovercheck(int limit, int coordinate) {
        if (coordinate < 0 || limit < coordinate)
            return 0;
        return 1;
    }

    public void display(char ch) {
        System.out.println(name + ":" + R.getx() + " " + R.gety() + " " + ch);
    }

}

public class MarsRoverController {
    public static void main(String args[]) {

        System.out.println("Enter the upper right coordinates of the plateau");
        Position position = new Position();
        position.input();
        MarsRover mr = new MarsRover("mr1");
        System.out.println("Enter rover1 details");
        mr.init();

        if (position.boundaryCheck(position, mr)) {
            Direction d1 = new Direction(position, "LMLMLMLMM", mr, 'N');
            if (d1.checkDir()) {
                d1.evaluate();
            } else {
                System.out.println("invalid direction");
            }
            MarsRover mr1 = new MarsRover("mr2");
            System.out.println("Enter rover2 details");
            mr1.init();
            if (position.boundaryCheck(position, mr1)) {

                Direction d2 = new Direction(position, "MMRMMRMRRM", mr1, 'E');

                if (d2.checkDir()) {
                    d2.evaluate();
                } else {
                    System.out.println("invalid direction");
                }

            }
        } else {
            System.out.println("Incorrect placement..check again");
        }

    }
}
