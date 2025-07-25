package personal.yoinami.wowza_spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import personal.yoinami.wowza_spring.service.VideoService;


@Controller
public class HomeController {

    Logger logger = LoggerFactory.getLogger(HomeController.class);

    private final VideoService videoService;

    @Value("${wowza.api.baseurl}")
    String wowzaBaseurl;
    // exmple url: http://192.168.0.111:1935

    public HomeController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/")
    public String listVideos(Model model) {
        
        logger.info("Accessing home page to list videos.");
        model.addAttribute("videos", videoService.listVideoFiles());
        return "index";
    }

    @GetMapping("/stream/{videoName}")
    public String streamVideo(@PathVariable String videoName, Model model) {
        String streamUrl = wowzaBaseurl + "/vod/mp4:" + videoName + "/playlist.m3u8";
        model.addAttribute("streamUrl", streamUrl);
        model.addAttribute("videoName", videoName);

        return "player";
    }
}
