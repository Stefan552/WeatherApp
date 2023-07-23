# Weather Forecast App

The Weather Forecast App is a Java Swing application that allows users to fetch and display weather data for a given city using the OpenWeatherMap API. The application provides information such as current temperature, minimum and maximum temperatures, humidity, weather description, country, sunrise, and sunset times.

## Table of Contents
1. [Introduction](#introduction)
2. [Dependencies](#dependencies)
3. [Installation](#installation)
4. [Usage](#usage)
5. [API Key](#api-key)
6. [License](#license)

## Introduction
The Weather Forecast App is a graphical user interface (GUI) application built using Java Swing. It utilizes the OpenWeatherMap API to retrieve weather data based on the city name entered by the user. The weather data is presented in a user-friendly format, providing valuable information about the weather conditions.

## Dependencies
To run the Weather Forecast App, you need to have the following dependencies installed:

- Java Development Kit (JDK) version 8 or higher
- The Java Swing library
- The Google Gson library

## Installation
Follow the steps below to set up and run the Weather Forecast App:

1. Install Java Development Kit (JDK) version 8 or higher on your system if you haven't already.
2. Download or clone this repository to your local machine.
3. Ensure you have the Gson library (gson-*.jar) available in your classpath. You can download it from the official Gson GitHub repository: [https://github.com/google/gson](https://github.com/google/gson)
4. Compile the Java source files using the following command:

```bash
javac WeatherForecastApp.java
```

## Usage
After successfully compiling the source files, run the application using the following command:

```bash
java WeatherForecastApp
```

The application window will appear, prompting you to enter a city name. Type the name of the city for which you want to retrieve weather data and click the "Get Weather" button. The application will fetch the weather data using the OpenWeatherMap API and display it on the screen.

## API Key
Please note that the Weather Forecast App uses the OpenWeatherMap API to fetch weather data. The API requires an API key for authentication. In the source code, you will find a variable named `API_KEY` with a placeholder value. To use the application with a valid API key, replace the placeholder value with your own OpenWeatherMap API key.

You can obtain an API key by signing up for a free or paid account on the OpenWeatherMap website: [https://openweathermap.org/appid](https://openweathermap.org/appid)

## License
The Weather Forecast App is open-source and distributed under the MIT License. You can find a copy of the license in the `LICENSE` file included with this repository.

## Disclaimer
The Weather Forecast App is a demonstration application and should not be used for critical or production purposes. The accuracy and reliability of the weather data provided by the OpenWeatherMap API are subject to the data sources and conditions managed by OpenWeatherMap. Always verify the data before making important decisions based on the weather information presented by this application. The developers of this application are not responsible for any inaccuracies or damages caused by the use of the application.
