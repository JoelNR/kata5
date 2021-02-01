package kata5.view;


public class MailParser {
    
    public static boolean isMail(String line) {
        return line.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
        
    }
}
