import java.util.List;

class WeatherData {
    private Sys sys;
    private String name;
    private Main main;
    private java.util.List<Weather> weather;

    public Main getMain ( ) {
        return main;
    }
    public List<Weather> getWeather ( ) {
        return weather;
    }

    public Sys getSys ( ) {
        return sys;
    }

    static class Main {
        private double temp;
        private int humidity;
        private double temp_min;
        private double temp_max;

        public double getTemp_min ( ) {
            return temp_min;
        }

        public double getTemp_max ( ) {
            return temp_max;
        }

        public double getTemp ( ) {
            return temp;
        }

        public int getHumidity ( ) {
            return humidity;
        }


    }
    static class Sys {
        private String  sys;
        private String country;
        private long sunrise;
        private long sunset;
        public String getsys ( ) {
            return sys;
        }
        public String getCountry ( ) {
            return country;
        }

        public void setCountry ( String country ) {
            this.country = country;
        }

        public long getSunrise ( ) {
            return sunrise;
        }

        public void setSunrise ( long sunrise ) {
            this.sunrise = sunrise;
        }

        public long getSunset ( ) {
            return sunset;
        }

        public void setSunset ( long sunset ) {
            this.sunset = sunset;
        }
    }
    static class Weather {
        private String description;

        public String getDescription ( ) {
            return description;
        }

    }}