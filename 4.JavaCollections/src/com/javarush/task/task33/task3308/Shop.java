package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement
@XmlType(name = "shop")
public class Shop {
    public int count;
    public double profit;
    public String[] secretData;
    public Goods goods;

    static class Goods{

        @XmlElement(name = "names")
        List<String> names;

        public List<String> getNames() {
            return names;
        }
    }

    @Override
    public String toString() {
        StringBuilder secretData = new StringBuilder();
        for (String data : this.secretData) {
            secretData.append(data).append(" ");
        }

        StringBuilder names = new StringBuilder();
        for (String name : this.goods.names) {
            names.append(name).append(" ");
        }

        return "count - " + count + " profit " + profit + " secretData " + secretData + " names " + names;
    }
}
