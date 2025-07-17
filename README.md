# Wowza Spring Boot Video Streaming

This project is a simple video streaming web application built with Spring Boot and Wowza Streaming Engine. It allows users to browse available video files and stream them using HLS (HTTP Live Streaming) via a web interface.

## Features

- List available video files from a configured storage directory
- Stream selected videos using Wowza's HLS endpoint
- Modern web UI with Thymeleaf templates
- HLS.js integration for browser compatibility
- Swagger UI for API documentation (if extended)

## Technologies Used

- Java 21
- Spring Boot 3.5.3
- Spring Web
- Thymeleaf
- Wowza Streaming Engine (external)
- HLS.js (frontend)

## Project Structure

- `src/main/java/personal/yoinami/wowza_spring/`
  - `WowzaSpringApplication.java`: Main Spring Boot application
  - `controller/HomeController.java`: Handles web requests for listing and streaming videos
  - `service/VideoService.java`: Lists video files from the configured directory
- `src/main/resources/templates/`
  - `index.html`: Video library UI
  - `player.html`: HLS video player UI
  - `swagger-ui.html`: Swagger API documentation UI
- `src/main/resources/application.properties`: Configuration for Wowza API and video storage path

## Configuration

Edit `src/main/resources/application.properties` to set your Wowza server URL and video storage path:

```
spring.application.name=wowza-spring
wowza.api.baseurl=http://YOUR_WOWZA_SERVER:1935
video.storage.path=PATH_TO_YOUR_VIDEO_FILES
```

## Setup & Running

1. **Install Java 21**
2. **Clone this repository**
3. **Start Wowza Streaming Engine** and ensure it is accessible at the configured `wowza.api.baseurl`
4. **Configure Wowza Streaming Engine** make sure to set `${com.wowza.wms.context.VHostConfigHome}/content`
5. **Place your MP4 video files in the directory specified by `${com.wowza.wms.context.VHostConfigHome}/content`** and the `video.storage.path` shouldpoint to this storage location
6. **Run the application:**
   - On Windows:
     ```powershell
     .\mvnw.cmd spring-boot:run
     ```
   - On Linux/macOS:
     ```sh
     ./mvnw spring-boot:run
     ```
7. **Open your browser and go to** [http://localhost:8080](http://localhost:8080)

## Usage

1. The home page lists all available video files.
2. Click a video to open the player and start streaming via HLS.
3. The player uses HLS.js for compatibility with most browsers.

## API Endpoints

- `/` : Lists available videos
- `/stream/{videoName}` : Streams the selected video using HLS

## Customization

- Change the Wowza server address and video storage path in `application.properties`.
- Extend with more endpoints or authentication as needed.

## License

This project is licensed under the Apache License 2.0.
