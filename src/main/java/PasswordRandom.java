import java.util.Scanner;
import java.util.Random;
import java.util.random.*;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;

public class PasswordRandom {
    public static String generatePass(int length, String characters) {
        StringBuilder build = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            build.append(characters.charAt(index));
        }
        return build.toString();

    }

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);


        System.out.println("Hi! I am ready to generate a password for your parameters");

        System.out.println("Does the password have to contain letters? [Yes/No]");
        String useLetters = scanner.nextLine();
        boolean includeLetters = useLetters.equalsIgnoreCase("yes");

        System.out.println("Does the password have to contain digits? [Yes/No]");
        String useDigits = scanner.nextLine();
        boolean includeDigits = useDigits.equalsIgnoreCase("yes");

        System.out.println("Does the password have to contain special characters? (#,&,!,*,%,@)? [Yes/No]");
        String useCharacters = scanner.nextLine();
        boolean includeCharacters = useCharacters.equalsIgnoreCase("yes");

        String characters = "";

        if (includeLetters) {
            characters += "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz";
        }
        if (includeDigits) {
            characters += "0123456789";
        }
        if (includeCharacters) {
            characters += "!#$%^&*";
        }
        if (characters.isEmpty()) {
            System.out.println("You must include at least letters, digits or characters!");
            return;
        }

        System.out.println("Enter desired password length: ");
        int length = scanner.nextInt();

        String password = generatePass(length, characters);
        System.out.println("Generated password: " + password);

        scanner.nextLine();
        copyToClipboard(password);
        System.out.println("Password copied to clipboard");
    }
    public static void copyToClipboard(String password) {
        StringSelection selection = new StringSelection(password);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
    }
}



/*       /\_/\
        ( o.o )  "Mrreoooow....<3"
         > ^ <

*/