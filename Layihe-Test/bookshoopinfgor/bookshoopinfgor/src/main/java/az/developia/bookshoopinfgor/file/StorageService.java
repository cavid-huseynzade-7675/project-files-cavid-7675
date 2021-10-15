package az.developia.bookshoopinfgor.file;

import java.nio.file.Path;

import javax.annotation.Resource;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    
    void init();

    String store(MultipartFile file);


    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();
}
