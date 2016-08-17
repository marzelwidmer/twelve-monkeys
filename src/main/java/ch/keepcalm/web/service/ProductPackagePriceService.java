package ch.keepcalm.web.service;

import ch.helsana.services.spezialfunktionen.tarif.v2.BerechneBesterPreisBusinessFaultMessage;
import ch.helsana.services.spezialfunktionen.tarif.v2.BerechneBesterPreisSystemFaultMessage;
import ch.helsana.services.spezialfunktionen.tarif.v2.BerechnePraemieBusinessFaultMessage;
import ch.helsana.services.spezialfunktionen.tarif.v2.BerechnePraemieSystemFaultMessage;
import ch.helsana.services.spezialfunktionen.tarif.v2.berechnebesterpreisrequest.BerechneBesterPreisRequest;
import ch.helsana.services.spezialfunktionen.tarif.v2.berechnebesterpreisrequest.Person;
import ch.helsana.services.spezialfunktionen.tarif.v2.berechnebesterpreisrequest.ProduktListType;
import ch.helsana.services.spezialfunktionen.tarif.v2.berechnebesterpreisrequest.Versicherungsvertrag;
import ch.helsana.services.spezialfunktionen.tarif.v2.berechnebesterpreisrequest.Vertragsbaustein;
import ch.helsana.services.spezialfunktionen.tarif.v2.berechnebesterpreisresponse.BerechneBesterPreisResponse;
import ch.helsana.services.spezialfunktionen.tarif.v2.berechnepraemierequest.BerechnePraemieRequest;
import ch.helsana.services.spezialfunktionen.tarif.v2.berechnepraemierequest.PersonListType;
import ch.helsana.services.spezialfunktionen.tarif.v2.berechnepraemieresponse.BerechnePraemieResponse;
import ch.keepcalm.web.converter.CalendarConverter;
import ch.keepcalm.web.model.Customer;
import ch.keepcalm.web.model.Product;
import ch.keepcalm.web.model.ProductPackage;
import org.apache.commons.lang.StringUtils;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

import static ch.keepcalm.web.converter.UiConverter.convertGender;

@Service
public class ProductPackagePriceService {

    private static final String PRO_X = "PRO_x";
    private static final String BASE = "0BAS__HEL_IG";
    private static final String BENEFIT = "0BENE_HEL_IG";
    private static final String BENEFIT_PLUS_HAUSARZT = "0BEPH_HEL_IG";
    private static final String BENEFIT_PLUS_TELEMEDIZIN = "0BEPT_HEL_IG";
    private static final String PREMED_24 = "0PREM_HEL_IG";


    @Autowired
    private ProductPriceServiceConsumer priceServiceConsumer;

    @Autowired
    public void setPriceService(ProductPriceServiceConsumer priceServiceConsumer) {
        this.priceServiceConsumer = priceServiceConsumer;
    }


    public ch.helsana.services.spezialfunktionen.tarif.v2.berechnepraemieresponse.Preis getPrice(Customer customer) throws BerechneBesterPreisBusinessFaultMessage, BerechneBesterPreisSystemFaultMessage, BerechnePraemieSystemFaultMessage, BerechnePraemieBusinessFaultMessage {
        // TODO: 17.08.2016 isBestPrice flag is new on the productPackages
        /*if (customer.isBestPrice()) {

            // call best Price to get the real product ID (with marke/mandant/brand)
            BerechneBesterPreisResponse response = computeBestPrice(customer);

            ch.helsana.services.spezialfunktionen.tarif.v2.berechnebesterpreisresponse.Vertragsbaustein product = response.getProduktList().getProdukt()
                    .stream()
                    .filter(p -> p.getProduktId().contains(BASE) || p.getProduktId().contains(BENEFIT)
                            || p.getProduktId().contains(BENEFIT_PLUS_HAUSARZT) || p.getProduktId().contains(BENEFIT_PLUS_TELEMEDIZIN)
                            || p.getProduktId().contains(PREMED_24)).findAny().get();

            Product productResource = customer.getProducts()
                    .stream()
                    .filter(p -> p.getProduktId().contains(PRO_X))
                    .findAny().get();

            productResource.setProduktId(productResource.getProduktId().replace(PRO_X, "PRO_" + product.getMarke()));

            BerechnePraemieResponse berechnePraemieResponse = computePrice(customer);
            return berechnePraemieResponse.getPreis();
        }*/
        return null;

    }

    public ch.helsana.services.spezialfunktionen.tarif.v2.berechnepraemieresponse.Preis getPrice(Customer customer, ProductPackage productPackage) throws BerechneBesterPreisBusinessFaultMessage, BerechneBesterPreisSystemFaultMessage, BerechnePraemieSystemFaultMessage, BerechnePraemieBusinessFaultMessage {
        if (productPackage.isBestPrice()){
            // call best Price to get the real product ID (with marke/mandant/brand)
            BerechneBesterPreisResponse response = computeBestPrice(customer, productPackage);

            ch.helsana.services.spezialfunktionen.tarif.v2.berechnebesterpreisresponse.Vertragsbaustein product = response.getProduktList().getProdukt()
                    .stream()
                    .filter(p -> p.getProduktId().contains(BASE) || p.getProduktId().contains(BENEFIT)
                            || p.getProduktId().contains(BENEFIT_PLUS_HAUSARZT) || p.getProduktId().contains(BENEFIT_PLUS_TELEMEDIZIN)
                            || p.getProduktId().contains(PREMED_24)).findAny().get();


             for (Product packageProduct :  productPackage.getProducts()) {
                if (packageProduct.getProduktId().startsWith(PRO_X)){
                        packageProduct.setProduktId(packageProduct.getProduktId().replace(PRO_X, "PRO_" + product.getMarke()));
                }
            }
            BerechnePraemieResponse berechnePraemieResponse = computePrice(customer, productPackage);
            return berechnePraemieResponse.getPreis();
          /*  Product productResource = productPackage.getProducts()
                    .stream()
                    .filter(p -> p.getProduktId().contains(PRO_X))
                    .findAny().get(); // if no PRO_X
            productResource.setProduktId(productResource.getProduktId().replace(PRO_X, "PRO_" + product.getMarke()));*/
        }
            BerechnePraemieResponse berechnePraemieResponse = computePrice(customer, productPackage);
            return berechnePraemieResponse.getPreis();

    }


    /**
     * To get the Brand for BASIS products.
     *
     * @param customer
     * @return
     * @throws BerechneBesterPreisBusinessFaultMessage
     * @throws BerechneBesterPreisSystemFaultMessage
     */
    private BerechneBesterPreisResponse computeBestPrice(Customer customer, ProductPackage productPackage) throws BerechneBesterPreisBusinessFaultMessage, BerechneBesterPreisSystemFaultMessage {
        BerechneBesterPreisRequest request = new BerechneBesterPreisRequest();
        request.withAlleMarken(false);

        ProduktListType produktListType = new ProduktListType();
       // for (ProductPackage productPackage : customer.getProductPackage()) {
            for (Product product : productPackage.getProducts()) {
            //List<Product> products = customer.getProducts();
            //for (Product product : products) {
                produktListType
                    .withProdukt(new Vertragsbaustein()
                            .withFranchise(StringUtils.isNotEmpty(product.getFranchise()) ? product.getFranchise() : null)
                            .withProduktId(StringUtils.isNotEmpty(product.getProduktId()) ? product.getProduktId() : null)
                            .withUnfall(StringUtils.isNotEmpty(product.getUnfall()) ? product.getUnfall() : null)
                            .withDrittesKind(StringUtils.isNotEmpty(product.getDrittesKind()) ? product.getUnfall() : null)
                            .withEintrittsalter(StringUtils.isNotEmpty(product.getEintrittsalter()) ? product.getEintrittsalter() : null)
                            .withErgaenzungsmodul(StringUtils.isNotEmpty(product.getErgaenzungsmodul()) ? product.getErgaenzungsmodul() : null)
                            .withInstanz(StringUtils.isNotEmpty(product.getInstanz()) ? product.getInstanz() : null)
                            .withInvaliditaetskapital(StringUtils.isNotEmpty(product.getInvaliditaetskapital()) ? product.getInvaliditaetskapital() : null)
                            .withLeistungsdauer(StringUtils.isNotEmpty(product.getLeistungsdauer()) ? product.getLeistungsdauer() : null)
                            .withMutterschaft(StringUtils.isNotEmpty(product.getMutterschaft()) ? product.getMutterschaft() : null)
                            .withTodesfallkapital(StringUtils.isNotEmpty(product.getTodesfallkapital()) ? product.getTodesfallkapital() : null)
                            .withUnfallSistierung(StringUtils.isNotEmpty(product.getUnfallSistierung()) ? new BigDecimal(product.getUnfallSistierung()) : null)
                            .withVersicherterBetrag(StringUtils.isNotEmpty(product.getVersicherterBetrag()) ? new BigDecimal(product.getVersicherterBetrag()) : null)
                            .withVersicherterBetragCode(StringUtils.isNotEmpty(product.getVersicherterBetragCode()) ? product.getVersicherterBetragCode() : null)
                            .withVariante(StringUtils.isNotEmpty(product.getVariante()) ? product.getVariante() : null));
            }
        //}
        request.setCorrelationId(UUID.randomUUID().toString());
        request.withPerson(
                new Person()
                        .withGeburtsdatum(CalendarConverter.dateToXMLGregorianCalendar(customer.getDateOfBirth()))
                        .withGeschlecht(convertGender(customer.getGender()))
                        .withId(String.valueOf(customer.getId()))
                        .withProduktList(produktListType))
                .withVertrag(new Versicherungsvertrag()
                        .withGemeindeNummer(customer.getAddress().getMunicipalityNr())
                        .withMarke("H") // TODO: 12.08.2016
                        .withMarke("P")
                        .withPostleitzahl(customer.getAddress().getPostalCode())
                        .withPostleitzahlZusatz(customer.getAddress().getPostalCodeAddition())
                        .withVertragsbeginn(CalendarConverter.dateToXMLGregorianCalendar(new LocalDate().plusMonths(1).dayOfMonth().withMinimumValue().toDate())));

        return priceServiceConsumer.berechneBesterPreis(request);
    }

    public static boolean empty(final String s) {
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
    }

    /**
     * @param customer
     * @return
     * @throws BerechnePraemieSystemFaultMessage
     * @throws BerechnePraemieBusinessFaultMessage
     */
    private BerechnePraemieResponse computePrice(Customer customer, ProductPackage productPackage) throws BerechnePraemieSystemFaultMessage, BerechnePraemieBusinessFaultMessage {
        BerechnePraemieRequest request = new BerechnePraemieRequest();

        ch.helsana.services.spezialfunktionen.tarif.v2.berechnepraemierequest.ProduktListType produktListType = new ch.helsana.services.spezialfunktionen.tarif.v2.berechnepraemierequest.ProduktListType();
        // TODO: 17.08.2016  customerResource don't habe the products it self, they are new on the productPackages
        // for (Product product : customerResource.getProducts()) {

        //for (ProductPackage productPackage : customer.getProductPackage()) {
            for (Product product : productPackage.getProducts()) {
                produktListType
                    .withProdukt(new ch.helsana.services.spezialfunktionen.tarif.v2.berechnepraemierequest.Vertragsbaustein()
                            .withFranchise(StringUtils.isNotEmpty(product.getFranchise()) ? product.getFranchise() : null)
                            .withProduktId(StringUtils.isNotEmpty(product.getProduktId()) ? product.getProduktId() : null)
                            .withUnfall(StringUtils.isNotEmpty(product.getUnfall()) ? product.getUnfall() : null)
                            .withDrittesKind(StringUtils.isNotEmpty(product.getDrittesKind()) ? product.getUnfall() : null)
                            .withEintrittsalter(StringUtils.isNotEmpty(product.getEintrittsalter()) ? product.getEintrittsalter() : null)
                            .withErgaenzungsmodul(StringUtils.isNotEmpty(product.getErgaenzungsmodul()) ? product.getErgaenzungsmodul() : null)
                            .withInstanz(StringUtils.isNotEmpty(product.getInstanz()) ? product.getInstanz() : null)
                            .withInvaliditaetskapital(StringUtils.isNotEmpty(product.getInvaliditaetskapital()) ? product.getInvaliditaetskapital() : null)
                            .withLeistungsdauer(StringUtils.isNotEmpty(product.getLeistungsdauer()) ? product.getLeistungsdauer() : null)
                            .withMutterschaft(StringUtils.isNotEmpty(product.getMutterschaft()) ? product.getMutterschaft() : null)
                            .withTodesfallkapital(StringUtils.isNotEmpty(product.getTodesfallkapital()) ? product.getTodesfallkapital() : null)
                            .withUnfallSistierung(StringUtils.isNotEmpty(product.getUnfallSistierung()) ? new BigDecimal(product.getUnfallSistierung()) : null)
                            .withVersicherterBetrag(StringUtils.isNotEmpty(product.getVersicherterBetrag()) ? new BigDecimal(product.getVersicherterBetrag()) : null)
                            .withVersicherterBetragCode(StringUtils.isNotEmpty(product.getVersicherterBetragCode()) ? product.getVersicherterBetragCode() : null)
                            .withVariante(StringUtils.isNotEmpty(product.getVariante()) ? product.getVariante() : null));
            }
        //}

        request.setPersonList(new PersonListType()
                .withPerson(new ch.helsana.services.spezialfunktionen.tarif.v2.berechnepraemierequest.Person()
                        .withProduktList(produktListType)
                        .withGeburtsdatum(CalendarConverter.dateToXMLGregorianCalendar(customer.getDateOfBirth()))
                        .withGeschlecht(convertGender(customer.getGender()))
                        .withId(String.valueOf(customer.getId()))));

        request.setCorrelationId(UUID.randomUUID().toString());
        request.setVersicherungsvertrag(new ch.helsana.services.spezialfunktionen.tarif.v2.berechnepraemierequest.Versicherungsvertrag()
                .withGemeindeNummer(customer.getAddress().getMunicipalityNr())
                .withPostleitzahl(customer.getAddress().getPostalCode())
                .withPostleitzahlZusatz(customer.getAddress().getPostalCodeAddition())
                .withVertragsbeginn(CalendarConverter.dateToXMLGregorianCalendar(new LocalDate().plusMonths(1).dayOfMonth().withMinimumValue().toDate())));

        return priceServiceConsumer.berechnePraemie(request);
    }


}

