package com.javarush.task.task17.task1714;

/* Еще одна слассная задача, теперь на интерфейс сравнения - наслаждайся
*
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
    }

    //в процентах считаем насколько качество пляжа выше/ниже
    //если качество равно, то в процентах считаем насколько один пляж больше/меньше
    @Override
    public synchronized int compareTo(Beach o) {
        int result = 0;
        if(this.getQuality() != o.getQuality() || this.getDistance() != o.getDistance()){
            int distancePart1 = (int)(this.getDistance()*1000/(this.getDistance() + o.getDistance()));
            int distancePart2 = (int)(o.getDistance()*1000/(this.getDistance() + o.getDistance()));

            result = this.getQuality()*distancePart1 - o.getQuality()*distancePart2;
        }

        return result;
    }
}
