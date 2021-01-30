package logearse1;

import java.math.BigInteger;  
import java.nio.charset.StandardCharsets; 
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  
  
// Java program to calculate SHA hash value  
  
public class Sha256 {
    
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException 
    {  
        // Static getInstance method is called with hashing SHA  
        MessageDigest md = MessageDigest.getInstance("SHA-256");  
  
        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
    }
    
    public static String toHexString(byte[] hash) 
    {
        // Convert byte array into signum representation  
        BigInteger number = new BigInteger(1, hash);  
  
        // Convert message digest into hex value  
        StringBuilder hexString = new StringBuilder(number.toString(16));  
  
        // Pad with leading zeros 
        while (hexString.length() < 32)  
        {  
            hexString.insert(0, '0');  
        }  
  
        return hexString.toString();  
    } 
  
      
    public static void main(String args[]) 
    {  
        try 
        { 
            System.out.println("HashCode Generated by SHA-256 for:");  
  
            String u1 = "Matematica";
            
            long startTime = System.nanoTime();
            
            System.out.println("\n" + u1 + " : " + toHexString(getSHA(u1)));
            
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println("Tiempo: "+totalTime*Math.pow(10, -9));
            
            //System.out.println(toHexString(getSHA(u1)).length());
            String u2 = "Discreta";  
            System.out.println("\n" + u2 + " : " + toHexString(getSHA(u2)));  
        } 
        // For specifying wrong message digest algorithms  
        catch (NoSuchAlgorithmException e) {  
            System.out.println("Exception thrown for incorrect algorithm: " + e);  
        }  
    }
}