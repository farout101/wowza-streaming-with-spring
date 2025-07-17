package personal.yoinami.wowza_spring.service;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class VideoService {
    
    @Value("${video.storage.path}")
    private String videoStoragePath;

    public List<String> listVideoFiles() {
        File videoDir = new File(videoStoragePath);
        if (videoDir.exists() && videoDir.isDirectory()) {
            return Arrays.stream(videoDir.listFiles())
                    .map(File::getName)
                    .collect(Collectors.toList());
        };

        return Collections.emptyList();
    }
}
