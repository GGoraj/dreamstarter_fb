package dreamstarter.com.dreamstarter.defaultDataProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import dreamstarter.com.dreamstarter.model.Product;


/**
 * Created by q on 5/5/17.
 */

public class DefaultProductDataProvider {

    public static List<Product> defaultProductList;
    public static Map<String, Product> defaultProductMap;



    private static void addItem(Product product) {
        defaultProductList.add(product);
        defaultProductMap.put(product.getProductId(), product);
    }



    static {

        defaultProductList = new ArrayList<>();
        defaultProductMap = new HashMap<>();

        addItem(new Product(null, "Mobile Phones", "Samsung Galaxy S8",
                "Samsung Galaxy S8" +
                        " Mobilen er en smuk blanding af eksklusivitet og elegance." +
                        " Udtrykket er let takket være den store 5.8” Infinity-skærm," +
                        "" +
                        " der ser ud til at svæve i hånden på dig pga. de næsten usynlige kanter." +
                        " Gorilla Glass 5 og IP68-klassificeringen beskytter hardwaren, mens iris-scanneren " +
                        "beskytter det indre. Du får masser af kraft med den lynhurtige processor, " +
                        "og du kan altid tage imponerende billeder med det avancerede kamera. ", "galaxy_s8.jpeg", 2400.0)
        );

        addItem(new Product(null, "Mobile Phones", "Lenovo A660 Waterproof Dual-Core 1GHz",
                "CPU & GPU:Dual-core 1 GHz MTK6577\n" +
                        "Memory: RAM 512MB , ROM 4GB\n" +
                        "Screen:4.0 inch Super AMOLED Plus, 800 x 480 resolution\n" +
                        "Network: WCDMA + GSM, 5.0 MP ,Android OS 4.0, battery 1500 mAh ", "lenovo_a660.jpeg", 3888.0)
        );


        addItem(new Product(null, "Mobile Phones", "Samsung Galaxy S6",
                "CPU & GPU:Dual-core 1 GHz MTK6577\n" +
                        "Memory: RAM 512MB , ROM 4GB\n" +
                        "Screen:4.0 inch Super AMOLED Plus, 800 x 480 resolution\n" +
                        "Network: WCDMA + GSM, 5.0 MP ,Android OS 4.0, battery 1500 mAh ", "galaxy_s6.jpg", 2800.9)
        );


        addItem(new Product(null, "Mobile Phones", "Galaxy A5 2017",
                "CPU & GPU:Dual-core 1 GHz MTK6577\n" +
                        "Memory: RAM 512MB , ROM 4GB\n" +
                        "Screen:4.0 inch Super AMOLED Plus, 800 x 480 resolution\n" +
                        "Network: WCDMA + GSM, 5.0 MP ,Android OS 4.0, battery 1500 mAh ", "galaxy_a5_2017.jpg", 3999.0)
        );


        addItem(new Product(null, "Mobile Phones", "Iphone_9",
                "CPU & GPU:Dual-core 1 GHz MTK6577\n" +
                        "Memory: RAM 512MB , ROM 4GB\n" +
                        "Screen:4.0 inch Super AMOLED Plus, 800 x 480 resolution\n" +
                        "Network: WCDMA + GSM, 5.0 MP ,Android OS 4.0, battery 1500 mAh ", "iphone_7.jpg", 6432.0)
        );





        addItem(new Product(null, "Mobile Phones", "Samsung Galaxy S4",
                "Samsung Galaxy S8" +
                        " Mobilen er en smuk blanding af eksklusivitet og elegance." +
                        " Udtrykket er let takket være den store 5.8” Infinity-skærm," +
                        "" +
                        " der ser ud til at svæve i hånden på dig pga. de næsten usynlige kanter." +
                        " Gorilla Glass 5 og IP68-klassificeringen beskytter hardwaren, mens iris-scanneren " +
                        "beskytter det indre. Du får masser af kraft med den lynhurtige processor, " +
                        "og du kan altid tage imponerende billeder med det avancerede kamera. ", "galaxy_s8.jpeg", 2400.0)
        );

        addItem(new Product(null, "Mobile Phones", "Lenovo A660 Waterproof Dual-Core 1.1GHz",
                "CPU & GPU:Dual-core 1 GHz MTK6577\n" +
                        "Memory: RAM 512MB , ROM 4GB\n" +
                        "Screen:4.0 inch Super AMOLED Plus, 800 x 480 resolution\n" +
                        "Network: WCDMA + GSM, 5.0 MP ,Android OS 4.0, battery 1500 mAh ", "lenovo_a660.jpeg", 3888.0)
        );



        addItem(new Product(null, "Mobile Phones", "Galaxy A5 2018",
                "CPU & GPU:Dual-core 1 GHz MTK6577\n" +
                        "Memory: RAM 512MB , ROM 4GB\n" +
                        "Screen:4.0 inch Super AMOLED Plus, 800 x 480 resolution\n" +
                        "Network: WCDMA + GSM, 5.0 MP ,Android OS 4.0, battery 1500 mAh ", "galaxy_a5_2017.jpg", 3999.0)
        );

        addItem(new Product(null, "Mobile Phones", "Samsung Galaxy S2",
                "CPU & GPU:Dual-core 1 GHz MTK6577\n" +
                        "Memory: RAM 512MB , ROM 4GB\n" +
                        "Screen:4.0 inch Super AMOLED Plus, 800 x 480 resolution\n" +
                        "Network: WCDMA + GSM, 5.0 MP ,Android OS 4.0, battery 1500 mAh ", "galaxy_s6.jpg", 2800.9)
        );

        addItem(new Product(null, "Mobile Phones", "Samsung Galaxy S0",
                "Samsung Galaxy S8" +
                        " Mobilen er en smuk blanding af eksklusivitet og elegance." +
                        " Udtrykket er let takket være den store 5.8” Infinity-skærm," +
                        "" +
                        " der ser ud til at svæve i hånden på dig pga. de næsten usynlige kanter." +
                        " Gorilla Glass 5 og IP68-klassificeringen beskytter hardwaren, mens iris-scanneren " +
                        "beskytter det indre. Du får masser af kraft med den lynhurtige processor, " +
                        "og du kan altid tage imponerende billeder med det avancerede kamera. ", "galaxy_s8.jpeg", 2400.0)
        );





        addItem(new Product(null, "Mobile Phones", "Iphone_1",
                "CPU & GPU:Dual-core 1 GHz MTK6577\n" +
                        "Memory: RAM 512MB , ROM 4GB\n" +
                        "Screen:4.0 inch Super AMOLED Plus, 800 x 480 resolution\n" +
                        "Network: WCDMA + GSM, 5.0 MP ,Android OS 4.0, battery 1500 mAh ", "iphone_7.jpg", 6432.0)
        );







    }
}
