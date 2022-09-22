package my_project.control;

public class CryptionHandler {

    private static final String key="test";

    public static String encrypt(String string){
        return crypt(string.toCharArray(),key.toCharArray(),true);
    }

    public static String decrypt(String string){
        return crypt(string.toCharArray(),key.toCharArray(),false);
    }

    private static String crypt(char[] plain, char[] key, boolean encrypt){
        char[] output = new char[plain.length];
        for(int i = 0; i < plain.length; i++){
            if(encrypt) output[i] = (char) (((plain[i] + key[i % key.length] - 194) % 26)+97);
            else output[i] = (char) ((plain[i] - key[i % key.length] + 26) % 26 + 97);
        }
        return String.valueOf(output);
    }
}
