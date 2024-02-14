package poc.vivek.user.enc;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class RandomUtil {
    public static String getRandomString(int length) {
        try {
            SecureRandom random = SecureRandom.getInstanceStrong();
            byte[] randomBytes = new byte[length/2];
            random.nextBytes(randomBytes);
            return HexUtil.byteArrayToHexString(randomBytes).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(RandomUtil.getRandomString(64));
    }
}
