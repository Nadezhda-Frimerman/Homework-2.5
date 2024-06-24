public class Main {
    private static final String validSymbols = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890_";

    public static void main(String[] args) {
        try {
            authenticationUser("hf2222y6", "hgy87", "hgy87");
        } catch (WrongLoginException wle) {
            System.out.println(wle.getMessage());
        } catch (WrongPasswordException wpe) {
            System.out.println(wpe.getMessage());
        }
    }


    public static void authenticationUser(String login, String password, String confirmPassword) {
        if (login.length() > 20) {
            throw new WrongLoginException();
        }
        if (password.length() > 20) {
            throw new WrongPasswordException();
        }
        for (int i = 0; i < login.length(); i++) {
            if (!validSymbols.contains(Character.toString(login.charAt(i)))) {
                throw new WrongLoginException();
            }
        }
        for (int i = 0; i < password.length(); i++) {
            if (!validSymbols.contains(Character.toString(password.charAt(i)))) {
                throw new WrongPasswordException();
            }
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
    }
}