import java.awt.*;

public class MapGenerator {
    public int map[][];
    public int brickWidth;
    public int brickHeight;

    public MapGenerator(int row, int col) {
        map = new int[row][col];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = 1;//1 will detect that this brick is not intersected with ball
            }
        }

        brickWidth = 540 / col;
        brickHeight = 150 / row;

    }

    public void draw(Graphics2D g) { //when this function is called, the bricks will be created where value is 1
        for (int i = 0; i < map.length; i++) {

//            g.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] > 0) {
//                    if(i%2==0) {
//                        g.setColor(Color.white);
//                    }
//                    else{
//                        g.setColor(Color.red);
//                    }
                    g.setColor(Color.white);
                    g.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);

                    //to create borders in map
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
                }
            }
        }
    }

    public void setBrickValue(int value, int row, int col) {
        map[row][col]=value;
    }
}

