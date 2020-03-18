package hu.lock.model.service;

public class LockUtil {

    public static String openResult(String pattern, String key) {
        String result;
        if (!isSameLength(pattern, key)) {
            result = "hibás hossz";
        } else {
            result = open(pattern, key) ? "sikeres" : "hibás kódszám";
        }
        return result;
    }

    public static boolean open(String pattern, String key) {
        return nyit(pattern, key);
    }

    public static boolean isSameLength(String pattern, String key) {
        return pattern.length() == key.length();
    }

    private static boolean nyit(String jo, String proba) {
        boolean egyezik = isSameLength(jo, proba);
        int elteres = 0;
        if (egyezik) {
            elteres = (int) jo.charAt(0) - (int) proba.charAt(0);
        }
        for (int i = 1; i < jo.length(); i++) {
            if ((elteres - ((int) jo.charAt(i) - (int) proba.charAt(i))) % 10 != 0) {
                egyezik = false;
                break;
            }
        }
        return egyezik;
    }
}
