import javax.swing.*;
import java.awt.*;


public class CircleMidpointSquare extends JPanel {

    int x, y, r;
    int shapeType = 0;
    public CircleMidpointSquare(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
            drawCircle(g2d, x, y, r,0);
            drawCircle(g2d, x, y, r,1);



    }

    // Midpoint pentru desenarea cercului
    public void drawCircle(Graphics g, int x, int y, int r, int decesion) {
        int xc = r;
        int yc = 0;
        int p =1-r; //Pk = (Xk — 0.5)^2 + (yk + 1)^2 – r^2 ;
        // primul punct desenat este (r,0) si se afla pe axa Ox
        // P1 = (r – 0.5)^2 + (0+1)^2 – r^2 = 1.25 – r = 1 -r (rotunjit)
        while (xc >= yc) {
            g.setColor(Color.RED);
            g.drawLine(x + xc, y + yc, x + xc, y + yc);
            g.drawLine(x - xc, y + yc, x - xc, y + yc);
            g.setColor(Color.YELLOW);
            g.drawLine(x + yc, y + xc, x + yc, y + xc);
            g.drawLine(x - yc, y + xc, x - yc, y + xc);
            g.setColor(Color.BLUE);
            g.drawLine(x + xc, y - yc, x + xc, y - yc);
            g.drawLine(x - xc, y - yc, x - xc, y - yc);
            g.setColor(Color.BLACK);
            g.drawLine(x + yc, y - xc, x + yc, y - xc);
            g.drawLine(x - yc, y - xc, x - yc, y - xc);

            //Daca p < 0 atunci Midpoint este in interiorul perimetrului
            if (p < 0) {
                p = p + 2 * yc + 1;
                yc++;
            }
            // Altfel Midpoint este in afara perimetrului
            else {
                p = p + 2 * yc - 2 * xc + 1;
                yc++;
                if(decesion == 0)
                    xc--;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();
        CircleMidpointSquare st =new CircleMidpointSquare(300, 300, 100);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(st);
        frame.setVisible(true);

    }
}
