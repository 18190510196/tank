import com.weiqiang.tank.TankFrame;

/**
 * @Description Tank主方法
 * @Author weiqiang
 * @Date 2021/4/12 22:37
 **/
public class Main {
    public static void main(String[] args) throws Exception {
        TankFrame tf = new TankFrame();

        while (true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
