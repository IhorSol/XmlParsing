package XML.HomeWork.Task1;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ihor Solohub.
 */
public final class Utils {
    private Utils() {
    }

    public static void findByDeparture(List<Train> trains, int fromHours, int fromMinutes, int toHours, int toMinutes) {
        List<Train> result = new ArrayList<>();
        checkTime(fromHours, fromMinutes);
        checkTime(toHours, toMinutes);

        for (Train train : trains) {
            String[] tokens = train.getDeparture().split(":");

            int departureHoursFromTimeTable = Integer.parseInt(tokens[0]);
            int departureMinutesFromTimeTable = Integer.parseInt(tokens[1]);
            checkTime(departureHoursFromTimeTable, departureMinutesFromTimeTable);

            if ((departureHoursFromTimeTable * 60 + departureMinutesFromTimeTable) >= (fromHours * 60 + fromMinutes)
                    && (departureHoursFromTimeTable * 60 + departureMinutesFromTimeTable) <= (toHours * 60 + toMinutes)) {
                result.add(train);
            }
        }
        System.out.println(result);
    }

    private static void checkTime(int hours, int minutes) {
        if (hours > 23 || hours < 0) {
            throw new IllegalArgumentException("Incorrect hour argument");
        } else if (minutes > 59 || minutes < 0) {
            throw new IllegalArgumentException("Incorrect minutes argument");
        }
    }

    public static void writeToXmlFile(Trains trains, File file){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(trains, file);
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }

    public static Trains readFromXmlFile (File file){
        Trains trains = new Trains();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            trains = (Trains) unmarshaller.unmarshal(file);
        } catch (JAXBException e){
            e.printStackTrace();
        }
        return trains;
    }
}
