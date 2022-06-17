import java.util.Random;
import java.util.Arrays;

static void LlenarTablero() {
    static int FIELD_SIZE = 10;

    public static void main(String[] args) {
        boolean UltimoBarco = false;
        Random random = new Random();
        int[][] field = new int[FIELD_SIZE][FIELD_SIZE];

        for (int i = 5; i > 0; i--) {

            if(i==1){
                i = 2;
                UltimoBarco = true;
            }
            //System.out.println("Placing ship with length: " + i);
            //start point of the ship and direction
            int x = random.nextInt(field.length);
            int y = random.nextInt(field.length);
            boolean vertical = random.nextBoolean();

            // Correct start point so that the ship could fit in the field
            if (vertical) {
                if (y + i > FIELD_SIZE) {
                    y -= i;
                }
            } else if (x + i > FIELD_SIZE) {
                x -= i;
            }
            //System.out.println("Start point: " + x + ", " + y + "; dir: " + (vertical ? "VERTICAL" : "HORIZONTAL"));

            boolean isFree = true;
            // Check for free space
            if (vertical) {
                for (int m = y; m < y + i; m++) {
                    if (field[m][x] != 0) {
                        //System.out.println("Neighbors found, " + x + ", " + m);
                        isFree = false;
                        break;
                    }
                }
            } else {
                for (int n = x; n < x + i; n++) {
                    if (field[y][n] != 0) {
                        //System.out.println("Neighbors found, " + n + ", " + y);
                        isFree = false;
                        break;
                    }
                }
            }

            if (!isFree) {  // No free space found, retry
                i++;
                continue;
            }

            // Fill in the adjacent cells
            if (vertical) {
                for (int m = Math.max(0, x - 1); m < Math.min(FIELD_SIZE, x + 2); m++) {
                    for (int n = Math.max(0, y - 1); n < Math.min(FIELD_SIZE, y + i + 1); n++) {
                        field[n][m] = 9;
                    }
                }
            } else {
                for (int m = Math.max(0, y - 1); m < Math.min(FIELD_SIZE, y + 2); m++) {
                    for (int n = Math.max(0, x - 1); n < Math.min(FIELD_SIZE, x + i + 1); n++) {
                        field[m][n] = 9;
                    }
                }
            }

            // Fill in the ship cells
            for (int j = 0; j < i; j++) {
                field[y][x] = i;
                if (vertical) {
                    y++;
                } else {
                    x++;
                }
            }
            if(UltimoBarco == true){
                break;
                //i = 1;
                //UltimoBarco = false;
            }
        }
        // FOR END


        // build char map
        char[][] map = new char[FIELD_SIZE][FIELD_SIZE];
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                map[i][j] = field[i][j] == 0 || field[i][j] == 9 ? '0' : '2';
            }
        }
        // print map
        Arrays.stream(map)
                .forEach(m -> System.out.println(Arrays.toString(m).replace(",", "")));
    }
}
