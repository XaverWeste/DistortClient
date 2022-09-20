package my_project.control;

public class EncryptionHandler {

    private static final String[] s=new String[]{"test"};

    public static String encrypt(String string){
        char[] c=string.toCharArray();
        for(String str:s){
            char[] d=str.toCharArray();
            for(int i=0;i<c.length;i++){
                int e = d[putInRange(d,i)];
                c[i]= (char) getC(c[i],e);
            }
        }
        return String.valueOf(c);
    }

    public static String decrypt(String s){

        return null;
    }

    private static int getC(int a,int i){
        i=a+i;
        if(i<0) i+=93;
        if(i>93) i-=93;
        return i;
    }

    private static int putInRange(char[] c,int i){
        while(true){
            if(i>=0&&i<c.length) return i;
            if(i>c.length) i-=c.length;
            if(i<c.length) i+=c.length;
        }
    }

}
