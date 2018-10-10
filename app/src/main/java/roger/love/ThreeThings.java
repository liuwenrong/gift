package roger.love;

/**
 * I love three things in this world.
 * Sun, moon and you. Sun for morning,
 * moon for night, and you forever. Never change!
 * 浮世三千,吾爱有三.
 * 日月与卿,日为朝,
 * 月为暮,卿为朝朝暮暮.
 * @author Roger 猴子先森
 * @version 1.0, 2018/08/17
 */
public class ThreeThings extends Me {

    private static final String in_this_world = "";
    private static final String Sun = "";
    private static final String moon = "";
    private static final String and_you = "";
    private static final String and_you_ = "You";
    private static final String Sun_for_morning = "";
    private static final String moon_for_night = "";
    private static final String loveFirstThings = "Sun";
    private static final String loveSecondThings = "moon";
    private static final String loveThirdThings = "You";

    public static String MyLove() {
        return "I Love" + ThreeThings.in_this_world + Sun + moon + and_you
                + Sun_for_morning + moon_for_night + and_you_ + "forever. Never change!";
    }

    public static void main(int args[]) {
        System.out.println(MyLove());//I Love You forever. Never change!
    }

    public static void day() {
        int oneDay, oneAutumn = 1;
        Girl.collectWormwood(true);
        Me.meetEveryday(false);
        oneDay = oneAutumn * 3;
        //彼采萧兮，一日不见，如三秋兮。
    }

    //I have two wishes,The first wish is , Another wish is
}
