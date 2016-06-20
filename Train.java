package XML.HomeWork.Task1;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Ihor Solohub.
 */
@XmlRootElement(name = "train")
@XmlType(propOrder = {"from", "to", "date", "departure"})
public class Train {
    private String from;
    private String to;
    private String date;
    private String departure;

    public Train(){}

    public Train(String from, String to, String date, String departure) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.departure = departure;
    }
@XmlElement
    public void setFrom(String from) {
        this.from = from;
    }
@XmlElement
    public void setTo(String to) {
        this.to = to;
    }
@XmlElement
    public void setDate(String date) {
        this.date = date;
    }
@XmlElement
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDeparture() {
        return departure;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Train" +
                " from: " + from + "," +
                " to: " + to +
                " date: " + date + "," +
                " departure: " + departure + ","+'\n';
    }
}
