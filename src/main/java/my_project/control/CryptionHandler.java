package my_project.control;

public class CryptionHandler {


    public static String encrypt(String string){
        return crypt(string.toCharArray(),"test".toCharArray(),true);
    }

    public static String decrypt(String string){
        return crypt(string.toCharArray(),"test".toCharArray(),false);
    }

    public static String crypt(char[] plain, char[] key, boolean encrypt) {
        char[] output = new char[plain.length];
        for (int i = 0; i < plain.length; i++) {
            if (encrypt) {
                int result = (plain[i] + key[i % key.length]-194) % 26 ;
                output[i] = (char) (result+97);
            }else{
                int result;
                if (plain[i] - key[i % key.length] < 0) result = (plain[i]- key[i % key.length]+130) %26 + 97;
                else result = (plain[i] - key[i % key.length]) % 26 +97;
                output[i] = (char) result;
            }
        }
        return String.valueOf(output);
    }
}
