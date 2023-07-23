import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.prefs.Preferences;

import com.google.gson.Gson;

public class WeatherForecastApp extends JFrame {
    private static final String API_KEY = "91e4c06252b94d05e80e715b588df7ed";
    private JLabel resultLabel;
    private JTextField cityField;

    public WeatherForecastApp() {
        setTitle("Weather Forecast App");
        setSize(500, 280);
        setDefaultCloseOperation(EXIT_ON_CLOSE);



        JPanel mainPanel = new ImagePanel ("/photou.jpg");
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        Border border = BorderFactory.createLineBorder(Color.WHITE, 0);
        mainPanel.setBorder(BorderFactory.createCompoundBorder (border,BorderFactory.createEmptyBorder (10,10,10,10)));
        cityField = new JTextField();
        cityField.setMaximumSize (new Dimension (250,20));
        JButton fetchButton = new JButton("Get Weather");
        fetchButton.setMaximumSize ( new Dimension (120,25) );
        resultLabel = new JLabel("Enter a city name and click 'Get Weather'");
        resultLabel.setFont ( new Font ( "Arial",Font.BOLD,15 ) );


        JLabel city=new JLabel ("City: ");
        city.setFont ( new Font ( "Arial",Font.BOLD,15 ) );


        city.setAlignmentX(Component.LEFT_ALIGNMENT);
        cityField.setAlignmentX(Component.LEFT_ALIGNMENT);
        fetchButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        resultLabel.setAlignmentX(Component.LEFT_ALIGNMENT);


        mainPanel.add ( city );
        mainPanel.add ( cityField );
        mainPanel.add ( fetchButton );
        mainPanel.add(resultLabel);


        add(mainPanel);

        fetchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cityName = cityField.getText();
                WeatherData weatherData = getWeatherData(cityName);
                displayWeatherData(weatherData);
            }
        });
        setLocationRelativeTo ( null );
        setVisible(true);



    }

    private String convertTimes(long timestamp) {
        Date date = new Date(timestamp * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        return sdf.format(date);
    }

    private WeatherData getWeatherData(String cityName) {
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + API_KEY);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            Gson gson = new Gson();

            return gson.fromJson(response.toString(), WeatherData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void displayWeatherData(WeatherData weatherData) {
        if (weatherData != null) {
            double temp = weatherData.getMain().getTemp() - 273.15;

            double minTemp = weatherData.getMain().getTemp_min() - 273.15;
            double maxTemp = weatherData.getMain().getTemp_max() - 273.15;
            int humidity = weatherData.getMain().getHumidity();


            String country = weatherData.getSys().getCountry();

            long sunriseTimestamp = weatherData.getSys().getSunrise();
            long sunsetTimestamp = weatherData.getSys().getSunset();

            String sunriseTime = convertTimes(sunriseTimestamp);
            String sunsetTime = convertTimes(sunsetTimestamp);
            String weatherDescription = weatherData.getWeather().get(0).getDescription();

String message1= "<html><ul>" +
                    "<li>Temperature: " + String.format("%.2f", temp) + " °C</li>" +
                    "<li>Min Temperature: " + String.format("%.2f", minTemp) + " °C</li>" +
                    "<li>Max Temperature: " + String.format("%.2f", maxTemp) + " °C</li>" +
                    "<li>Humidity: " + humidity + "%</li>" +
                    "<li>Weather: " + weatherDescription + "</li>" +
                    "<li>Country: " + (country != null ? country : "N/A") + "</li>" +
                    "<li>Sunrise: " + sunriseTime + "</li>" +
                    "<li>Sunset: " + sunsetTime + "</li>" +
                    "</ul></html>";

             resultLabel.setText( message1);
        } else {
            resultLabel.setText("Failed to fetch weather data. Please check the city name.");
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WeatherForecastApp();
            }
        });
    }
}
