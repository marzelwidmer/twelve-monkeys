package ch.keepcalm.web.converter;

/**
 * Created by hkesq on 21.07.2016.
 */
public class UiConverter {

    public static String convertGender(String value) {
        switch (value) {
            case "m": // Mann
                return "1";
            case "w": // Frau
                return "2";
            case "b": // Baby
                return "3";
            default:
                return "-1";
        }
    }
}
