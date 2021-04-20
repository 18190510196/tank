import com.weiqiang.tank.Dir;
import com.weiqiang.tank.Group;
import com.weiqiang.tank.Tank;
import com.weiqiang.tank.TankFrame;

/**
 * @Description TODO
 * @Author weiqiang
 * @Date 2021/4/12 22:37
 **/
public class Main {
    public static void main(String[] args) throws Exception {
        TankFrame tf = new TankFrame();
        for (int i = 0; i < 5; i++) {
            tf.tanks.add(new Tank(50 + i * 50, 200, Dir.DOWN, Group.BAD, tf));

        }
        while (true) {

            Thread.sleep(50);
            tf.repaint();
        }
    }
}
