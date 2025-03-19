const apiKey = 'YOUR_API_KEY'; // Replace with your OpenWeatherMap API key

async function getWeather() {
  const city = document.getElementById("cityInput").value;
  if (city === "") return;

  const url = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}&units=metric`;

  try {
    const response = await fetch(url);
    const data = await response.json();

    if (data.cod === "404") {
      alert("City not found");
      return;
    }

    document.getElementById("cityName").innerText = data.name;
    document.getElementById("temperature").innerText = `Temperature: ${data.main.temp}°C`;
    document.getElementById("weatherDescription").innerText = `Weather: ${data.weather[0].description}`;
    document.getElementById("humidity").innerText = `Humidity: ${data.main.humidity}%`;
    document.getElementById("windSpeed").innerText = `Wind Speed: ${data.wind.speed} m/s`;

  } catch (error) {
    alert("Error fetching weather data");
  }
}
