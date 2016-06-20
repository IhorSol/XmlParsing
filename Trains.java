package XML.HomeWork.Task1;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ihor Solohub.
 */
@XmlRootElement(name = "trains")
public class Trains {

    @XmlElement(name = "train")
    private List<Train> trains = new ArrayList<>();

    public void add(Train train){
        trains.add(train);
    }

    public List<Train> getTrains() {
        return trains;
    }

    @Override
    public String toString() {
        return "Trains: "+ trains;
    }
}
