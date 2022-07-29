package demo_springjwt.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileDBResponse {
    private String name;
    private String url;
    private String type;
    private long size;

    public FileDBResponse(String name, String url, String type, long size) {
        this.name = name;
        this.url = url;
        this.type = type;
        this.size = size;
    }
}
