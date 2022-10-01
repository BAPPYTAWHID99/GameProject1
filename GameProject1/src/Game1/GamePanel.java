package Game1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 15;
    static final int GAME_UNITS = 24000;
    static final int DELAY = 75;
    final int[] x = new int[24000];
    final int[] y = new int[24000];
    int bodyparts = 6;
    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random = new Random();

    GamePanel() {
        this.setPreferredSize(new Dimension(600, 600));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        this.startGame();
    }

    public void startGame() {
        this.newApple();
        this.running = true;
        this.timer = new Timer(75, this);
        this.timer.start();
    }

    public void paintComponent(Graphics var1) {
        super.paintComponent(var1);
        this.draw(var1);
    }

    public void draw(Graphics var1) {
        if (this.running) {
            int var2;
            for(var2 = 0; var2 < 40; ++var2) {
                var1.drawLine(var2 * 15, 0, var2 * 15, 600);
                var1.drawLine(0, var2 * 15, 600, var2 * 15);
            }

            var1.setColor(Color.blue);
            var1.fillOval(this.appleX, this.appleY, 15, 15);

            for(var2 = 0; var2 < this.bodyparts; ++var2) {
                if (var2 == 0) {
                    var1.setColor(Color.green);
                    var1.fillRect(this.x[var2], this.y[var2], 15, 15);
                } else {
                    var1.setColor(new Color(45, 180, 0));
                    var1.fillRect(this.x[var2], this.y[var2], 15, 15);
                }
            }

            var1.setColor(Color.red);
            var1.setFont(new Font("Ink Free", 1, 40));
            FontMetrics var3 = this.getFontMetrics(var1.getFont());
            var1.drawString("SCORE:" + this.applesEaten, (600 - var3.stringWidth("SCORE :" + this.applesEaten)) / 2, var1.getFont().getSize());
        } else {
            this.gameOver(var1);
        }

    }

    public void newApple() {
        this.appleX = this.random.nextInt(40) * 15;
        this.appleY = this.random.nextInt(40) * 15;
    }

    public void move() {
        for(int var1 = this.bodyparts; var1 > 0; --var1) {
            this.x[var1] = this.x[var1 - 1];
            this.y[var1] = this.y[var1 - 1];
        }

        switch (this.direction) {
            case 'D':
                this.y[0] += 15;
                break;
            case 'L':
                this.x[0] -= 15;
                break;
            case 'R':
                this.x[0] += 15;
                break;
            case 'U':
                this.y[0] -= 15;
        }

    }

    public void checkApple() {
        if (this.x[0] == this.appleX && this.y[0] == this.appleY) {
            ++this.bodyparts;
            ++this.applesEaten;
            this.newApple();
        }

    }

    public void checkCollisions() {
        for(int var1 = this.bodyparts; var1 > 0; --var1) {
            if (this.x[0] == this.x[var1] && this.y[0] == this.y[var1]) {
                this.running = false;
            }
        }

        if (this.x[0] < 0) {
            this.running = false;
        }

        if (this.x[0] > 600) {
            this.running = false;
        }

        if (this.y[0] < 0) {
            this.running = false;
        }

        if (this.y[0] > 600) {
            this.running = false;
        }

        if (!this.running) {
            this.timer.stop();
        }

    }

    public void gameOver(Graphics var1) {
        var1.setColor(Color.red);
        var1.setFont(new Font("Ink Free", 1, 75));
        FontMetrics var2 = this.getFontMetrics(var1.getFont());
        var1.drawString("GAME OVER :", (600 - var2.stringWidth("GAME OVER:")) / 2, 300);
    }

    public void actionPerformed(ActionEvent var1) {
        if (this.running) {
            this.move();
            this.checkApple();
            this.checkCollisions();
        }

        this.repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        public MyKeyAdapter() {
        }

        public void keyPressed(KeyEvent var1) {
            switch (var1.getKeyCode()) {
                case 37:
                    if (GamePanel.this.direction != 'R') {
                        GamePanel.this.direction = 'L';
                    }
                    break;
                case 38:
                    if (GamePanel.this.direction != 'D') {
                        GamePanel.this.direction = 'U';
                    }
                    break;
                case 39:
                    if (GamePanel.this.direction != 'L') {
                        GamePanel.this.direction = 'R';
                    }
                    break;
                case 40:
                    if (GamePanel.this.direction != 'U') {
                        GamePanel.this.direction = 'D';
                    }
            }

        }
    }
}
