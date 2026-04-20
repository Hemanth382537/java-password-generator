import java.util.*;

public class PasswordGenerator {

    static String generatePassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%";
        Random rand = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return password.toString();
    }

    static String checkStrength(String password) {
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else hasSpecial = true;
        }

        if (password.length() >= 10 && hasUpper && hasLower && hasDigit && hasSpecial)
            return "Strong";
        else if (password.length() >= 6)
            return "Medium";
        else
            return "Weak";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password length: ");
        int length = sc.nextInt();

        String password = generatePassword(length);

        System.out.println("Generated Password: " + password);
        System.out.println("Strength: " + checkStrength(password));
    }
}
