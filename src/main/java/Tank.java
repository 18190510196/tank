import java.awt.*;

/**
 * @Description TODO
 * @Author weiqiang
 * @Date 2021/4/12 22:56
 **/
public class Tank {
    private static int x, y;
    Dir dir = Dir.DOWN;//默认方向
    private static final int SPEED = 10;//移动速度

    private boolean moving = false;//为false的时候坦克停止
    private TankFrame tf = null;

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        super();
        this.dir = dir;
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Dir getDir() {
        return dir;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.yellow);
        g.fillRect(x, y, 50, 50);
        g.setColor(c);
        move();

    }

    //判断坦克是否需要移动
    private void move() {
        if (!moving) return;
        switch (dir) {
            case DOWN:
                y += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            default:
                break;
        }
    }

    public void fire() {
        tf.bullets.add(new Bullet(this.x, this.y, this.dir,this.tf));
    }
}
