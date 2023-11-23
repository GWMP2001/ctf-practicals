import java.util.Base64;

public class FlagGen {
  public static void main(String[] paramArrayOfString) {
    String str = "Not an actual flag";
    System.out.println("flag{" + str + "}");
    printHint()
  }
  
  public static String generateFirstPart() {
    return "07b350";
  }
  
  public static String generateLastPart() {
    return "5cd689";
  }
  
  public static String xorHex(String paramString1, String paramString2) {
    char[] arrayOfChar = new char[paramString1.length()];
    for (byte b = 0; b < arrayOfChar.length; b++)
      arrayOfChar[b] = toHex(fromHex(paramString1.charAt(b)) ^ fromHex(paramString2.charAt(b))); 
    return new String(arrayOfChar);
  }
  
  public static void printHint() {
    byte[] arrayOfByte = Base64.getDecoder().decode("VGhlIGZpZWxkIGZsYWcgb2YgdGhlIGZ1bmN0aW9uIG1haW4gc2hvdWxkIGFjdHVhbGx5IGJ5IGRlZmluZWQgYnkgY29uY2F0ZW5pbmcgdGhlIHhvciBvZiB0aGUgb3V0cHV0IG9mIGdlbmVyYXRlRmlyc3RQYXJ0IHdpdGggZmJlYzgxIHdpdGggdGhlIHhvciBvZiB0aGUgb3V0cHV0IG9mIGdlbmVyYXRlTGFzdFBhcnQgd2l0aCA5NWQ4MGYuIE5vdGUgdGhhdCBhbGwgdGhlc2UgZWxlbWVudHMgYXJlIGhleGFkZWNpbWFsIHN0cmluZ3Mh");
    System.out.println("Hint: " + new String(arrayOfByte));
  }
  
  private static int fromHex(char paramChar) {
    if (paramChar >= '0' && paramChar <= '9')
      return paramChar - 48; 
    if (paramChar >= 'A' && paramChar <= 'F')
      return paramChar - 65 + 10; 
    if (paramChar >= 'a' && paramChar <= 'f')
      return paramChar - 97 + 10; 
    throw new IllegalArgumentException();
  }
  
  private static char toHex(int paramInt) {
    if (paramInt < 0 || paramInt > 15)
      throw new IllegalArgumentException(); 
    return "0123456789ABCDEF".charAt(paramInt);
  }
}
