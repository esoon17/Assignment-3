/*
 * Class: CMSC203 
 * Instructor: David Kuijt 
 * Description: Write a Java program to encrypt and decrypt a phrase using two similar approaches, each insecure by modern standards.  
 * Due: 10/18/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Esther Soon
*/

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		// For loop that lasts until there are no more characters in the string
		// Checks each character and sees if they are in the range
		for (int i=0; i<plainText.length(); i++)
		{
			if(plainText.charAt(i) < LOWER_BOUND || plainText.charAt(i) > UPPER_BOUND)
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		String encrypted = "";
		
		// For loop that lasts until there are no more characters in the string
		for (int i=0; i<plainText.length(); i++)
		{		
			// Subtracts range from key until key is in the range			
			if(key >= RANGE)
			{
				while(key >= 64)
				{
					key -= 64;
				}
			}
			
			// Offsets character by key and changes character into decimal
			int decimal = plainText.charAt(i)+key;
			
			// If the new character is out of range take minus the character with the range
			if(decimal > UPPER_BOUND)
			{
				decimal -= 64;
			}
			
			// Change new character from decimal to a character
			char character = (char) decimal;
			
			// Adds encrypted character into a string
			encrypted += character;
		}
		//returns the encrypted string
		return encrypted;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		int index = 0;
		String encrypted = "";
		int key = 0;
		
		// For loop that lasts until there are no more characters in the string
		for (int i=0; i<plainText.length(); i++)
		{
			key = bellasoStr.charAt(index);
			index++;
			
			// Resets key if reached the end of the bellaso key word
			if(bellasoStr.length() == index)
			{
				index = 0;
			}
			
			// Subtracts range from key until key is in the range			
			if(key >= RANGE)
			{
				while(key >= 64)
				{
				key -= 64;
				}
			}
			
			// Offsets character by key and changes character into decimal
			int decimal = plainText.charAt(i)+key;
			
			// If the new character is out of range minus the character with the range
			if(decimal > UPPER_BOUND)
			{
				decimal -= 64;
			}
						
			// Change new character from decimal to a character
			char character = (char) decimal;
			
			// Adds encrypted character into a string
			encrypted += character;
		}
		// returns the encrypted string
		return encrypted;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		String decrypted = "";
		
		// For loop that lasts until there are no more characters in the string
		for (int i=0; i<encryptedText.length(); i++)
		{		
			// Subtracts range from key until key is in the range			
			if(key >= RANGE)
			{
				while(key >= 64)
				{
					key -= 64;
				}
			}
			
			// Undos the offsets character by key and changes character into decimal
			int decimal = encryptedText.charAt(i)-key;
			
			// If the new character is out of range add the character with the range
			if(decimal < LOWER_BOUND)
			{
				decimal += 64;
			}
			
			// Change new character from decimal to a character
			char character = (char) decimal;
			
			// Adds decrypted character into a string
			decrypted += character;
		}
		//returns the decrypted string
		return decrypted;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		
		int index = 0;
		String decrypted = "";
		int key = 0;
		
		// For loop that lasts until there are no more characters in the string
		for (int i=0; i<encryptedText.length(); i++)
		{
			// Resets key if reached the end of the bellaso key word
			if(bellasoStr.length() == index)
			{
				index = 0;
			}		
			
			key = bellasoStr.charAt(index);
			
			// Subtracts range from key until key is in the range			
			if(key >= RANGE)
			{
				while(key >= 64)
				{
				key -= 64;
				}
			}
			
			// Undo the offsets character by key and changes character into decimal
			int decimal = encryptedText.charAt(i)-key;
			
			// If the new character is out of range add the character with the range
			if(decimal < LOWER_BOUND)
			{
				decimal += 64;
			}
						
			// Change new character from decimal to a character
			char character = (char) decimal;
			
			// Adds decrypted character into a string
			decrypted += character;
			
			index++;		
		}
		// returns the decrypted string
		return decrypted;
	}
}
