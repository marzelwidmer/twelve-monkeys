package ch.keepcalm.web.converter;

import org.joda.time.DateTime;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Marcel Widmer  on 25/12/15.
 */
public final class CalendarConverter {

    private static DatatypeFactory df;

    private CalendarConverter() {
        // hide constructor of utility class
    }

    /**
     *
     * @param date
     * @return null if conversion fails.
     */
    public static XMLGregorianCalendar dateToXMLGregorianCalendar(Date date){
        try {
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(date);
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (DatatypeConfigurationException e1) {
            e1.printStackTrace();
        }
        return null;
    }


    static {
        try {
            df = DatatypeFactory.newInstance();
        } catch (final DatatypeConfigurationException e) {
            throw new IllegalStateException("Error while trying to obtain a new instance of DatatypeFactory", e);
        }
    }

    /**
     * Convert to date time.
     *
     * @param xmlGregorianCalendar the xml gregorian calendar
     * @return the date time
     */
    public static DateTime convertBirthdayToDateTime(final XMLGregorianCalendar xmlGregorianCalendar) {
        if (xmlGregorianCalendar == null) {
            return new DateTime();
        } else {
            return new DateTime(xmlGregorianCalendar.getYear(), xmlGregorianCalendar.getMonth(), xmlGregorianCalendar.getDay(), 0, 0, 0, 0);
        }
    }

    /**
     * Diese Methode gibt ein Objekt des Typs XMLGregorianCalendar zurueck, das dem 31. Dezember des spezifizierten Jahres entspricht.
     *
     * @param year Das Jahr
     * @return {@link XMLGregorianCalendar}
     */
    public static XMLGregorianCalendar toMaxXMLGregorianCalendar(final int year) {
        final XMLGregorianCalendar cal = df.newXMLGregorianCalendar();
        cal.setYear(year);
        cal.setMonth(12);
        cal.setDay(31);
        return cal;
    }

    /**
     * Diese Methode gibt ein Objekt des Typs XMLGregorianCalendar zurueck, das dem 1. Januar des spezifizierten Jahres entspricht.
     *
     * @param year Das Jahr
     * @return {@link XMLGregorianCalendar}
     */
    public static XMLGregorianCalendar toMinXMLGregorianCalendar(final int year) {
        final XMLGregorianCalendar cal = df.newXMLGregorianCalendar();
        cal.setYear(year);
        cal.setMonth(1);
        cal.setDay(1);
        return cal;
    }

}