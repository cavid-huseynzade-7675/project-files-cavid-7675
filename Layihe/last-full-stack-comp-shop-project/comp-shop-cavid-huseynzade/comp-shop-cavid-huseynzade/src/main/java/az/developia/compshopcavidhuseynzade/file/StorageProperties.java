package az.developia.compshopcavidhuseynzade.file;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {
    
    private String location ="upload-dir-comp-shopping-spring-ajax";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}