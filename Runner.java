package XML.HomeWork.Task1;

import java.io.File;
import java.util.List;

/**
 * @author Ihor Solohub.
 */
public class Runner {
    public static void main(String[] args) {
        File file = new File("D:\\Programming_Java\\JavaPRO\\src\\XML\\HomeWork\\Task1\\TimeTable.tld");

            /*-------Reading from file-------*/
        Trains trains = Utils.readFromXmlFile(file);

            /*-------Adding trains-------*/
        trains.add(new Train("Kiev", "Odessa", "19.06.2016", "15:25"));
        trains.add(new Train("Odessa", "Kiev", "21.06.2016", "20:25"));
        trains.add(new Train("Kiev", "Lviv", "19.06.2016", "15:25"));

            /*-------Writing to file-------*/
        Utils.writeToXmlFile(trains, file);

            /*-------Finding trains by departure time -------*/
        Utils.findByDeparture(trains.getTrains(), 15, 00, 19, 00);
    }
}
