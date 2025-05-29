import java.util.Scanner;

public class CardFlagDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do cartão: ");
        String numeroCartao = scanner.nextLine();

        String bandeira = identificarBandeira(numeroCartao);
        System.out.println("Bandeira identificada: " + bandeira);

        scanner.close();
    }

    public static String identificarBandeira(String numero) {
        String clean = numero.replaceAll("\\D", "");

        if (clean.matches("^4[0-9]{12}(?:[0-9]{3})?$")) return "Visa";
        if (clean.matches("^5[1-5][0-9]{14}$")) return "MasterCard";
        if (clean.matches("^3[47][0-9]{13}$")) return "American Express";
        if (clean.matches("^3(?:0[0-5]|[68][0-9])[0-9]{11}$")) return "Diners Club";
        if (clean.matches("^6(?:011|5[0-9]{2})[0-9]{12}$")) return "Discover";
        if (clean.matches("^2(?:014|149)[0-9]{11}$")) return "enRoute";
        if (clean.matches("^(?:2131|1800|35\\d{3})\\d{11}$")) return "JCB";
        if (clean.matches("^8699[0-9]{11}$")) return "Voyager";
        if (clean.matches("^606282|3841(?:[0|4|6]{1})0")) return "HiperCard";
        if (clean.matches("^(50[0-9]{14,17})$")) return "Aura";

        return "Bandeira não identificada";
    }
}
