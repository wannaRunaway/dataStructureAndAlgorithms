package observerpattern;

import java.util.ArrayList;
import java.util.Observable;

/*
 * 观察者模式
 * 对象之间一对多的关系，松耦合的方式来设计代码
 *
 * 内置java支持的观察者模式
 * 弊端：类不是接口，面向接口编程而不是面向对象编程
 * */
public class ObserverPattern {

    /* 观测数值改变时，主题就把这些状态当作参数，传递给观察者 */
    public interface Observer {
        public void update(float temp, float hunidity, float press);
    }

    /* 注册、去掉注册通知所有的观察者 */
    public interface Subject {
        public void registerObserver(Observer observer);

        public void removeObserver(Observer observer);

        public void notifyObservers();
    }

    /*   展示板、用来展示主题中的状态   */
    public interface DisplayElement {
        public void display();
    }

    /* weatherData */
    public static class WeatherData implements Subject {
        /* 存放所有的观察者 */
        private ArrayList observers;
        private float temperature;
        private float humidity;
        private float pressure;

        public WeatherData() {
            observers = new ArrayList();
        }

        @Override
        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void removeObserver(Observer observer) {
            if (observers.indexOf(observer) != -1) {
                observers.remove(observer);
            }
        }

        @Override
        public void notifyObservers() {
            for (int i = 0; i < observers.size(); i++) {
                Observer observer = (Observer) observers.get(i);
                observer.update(temperature, humidity, pressure);
            }
        }

        public void measurementsChanged() {
            notifyObservers();
        }

        public void setMeasurements(float temperature, float humidity, float pressure) {
            this.temperature = temperature;
            this.humidity = humidity;
            this.pressure = pressure;
            measurementsChanged();
        }
    }

    /* 展示板 */
    public static class CurrentConditionsDisplay implements Observer, DisplayElement {
        private float temperature;
        private float humidity;
        private Subject weatherData;

        public CurrentConditionsDisplay(Subject weatherData) {
            this.weatherData = weatherData;
            weatherData.registerObserver(this);
        }

        @Override
        public void display() {
            System.out.println("Current conditions: " + temperature +
                    "F degrees and " + humidity + "% humidity");
        }

        @Override
        public void update(float temp, float hunidity, float press) {
            this.temperature = temp;
            this.humidity = hunidity;
            display();
        }
    }

    /*
     * 启动气象站
     * */
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(100f,200f, 400f);
        weatherData.setMeasurements(90f,2f, 1f);
        weatherData.setMeasurements(0.9f,0.1f, 5);

        WeatherDataInside weatherDataInside = new WeatherDataInside();
        CurrentConditionsDisplayInside currentConditionsDisplayInside = new CurrentConditionsDisplayInside(weatherDataInside);
        weatherDataInside.setMeasurements(100f,200f, 400f);
        weatherDataInside.setMeasurements(90f,2f, 1f);
        weatherDataInside.setMeasurements(0.9f,0.1f, 5);
    }

    /*
    * 利用java内置的观察者模式支持重做气象站
    * */
    public static class WeatherDataInside extends Observable{
        private float temperature;
        private float humidity;
        private float pressure;

        public WeatherDataInside() {}
        public void measurementsChanged() {
            setChanged();
            notifyObservers();
        }

        public void setMeasurements(float temperature, float humidity, float pressure) {
            this.temperature = temperature;
            this.humidity = humidity;
            this.pressure = pressure;
            measurementsChanged();
        }

        public float getTemperature() {
            return temperature;
        }

        public float getHumidity() {
            return humidity;
        }

        public float getPressure() {
            return pressure;
        }
    }

    public static class CurrentConditionsDisplayInside implements java.util.Observer, DisplayElement{
        Observable observable;
        private float temperature;
        private float humidity;
        public CurrentConditionsDisplayInside(Observable observable) {
            this.observable = observable;
            observable.addObserver(this);
        }
        @Override
        public void update(Observable o, Object arg) {
            if (o instanceof WeatherDataInside){
                WeatherDataInside weatherDataInside = (WeatherDataInside) o;
                this.temperature = weatherDataInside.getTemperature();
                this.humidity = weatherDataInside.getHumidity();
                display();
            }
        }

        @Override
        public void display() {
            System.out.println("Current conditions : "+temperature
            + "F degrees and "+humidity + "% humidity");
        }
    }

}
