// Source code is decompiled from a .class file using FernFlower decompiler.
import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;

public class CryptoUtilsDecrypt2 {
   public CryptoUtilsDecrypt2() {
   }

   public static String getMD5(String var0) {
      try {
         MessageDigest var1 = MessageDigest.getInstance("MD5");
         var1.update(var0.getBytes(), 0, var0.length());
         return (new BigInteger(1, var1.digest())).toString(16);
      } catch (Exception var2) {
         System.err.println(var2);
         return "error";
      }
   }

   public static void main(String[] var0) {
      if (var0.length > 0) {
         System.out.println(getMD5(var0[0]));
         if ("0d1d6d8ecf6ef05dea8624dc4b2dbc06".equals(getMD5(var0[0]))) {
            String var1 = "K013IgszolnYk7Xb";
            File var2 = new File("flag.enc");
            File var3 = new File("output.txt");

            try {
               CryptoUtils2.decrypt(var1, var2, var3);
            } catch (CryptoException2 var5) {
               System.out.println(var5.getMessage());
               var5.printStackTrace();
            }
         } else {
            System.out.println("Wrong password");
         }
      } else {
         System.out.println("Usage: java CryptoUtilsDecrypt password");
      }

   }
}