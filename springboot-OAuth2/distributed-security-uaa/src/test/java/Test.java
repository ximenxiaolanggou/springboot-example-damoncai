import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author zhishun.cai
 * @date 2020/7/23 11:20
 * @note
 */
public class Test {
    public static void main(String[] args) {
        String encode = new BCryptPasswordEncoder().encode("23445");
        System.out.println(encode);
    }
}
