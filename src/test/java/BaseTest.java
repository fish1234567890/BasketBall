public class BaseTest {

    public static void main(String[] args) {
        String s = "sqlfirst.mysql1";
        String[] split = s.split("\\.");
        for(String c:split){
            System.out.println(c);
        }
    }
}
