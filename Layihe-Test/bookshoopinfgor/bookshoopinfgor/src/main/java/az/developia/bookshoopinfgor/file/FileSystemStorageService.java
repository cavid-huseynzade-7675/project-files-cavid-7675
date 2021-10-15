package az.developia.bookshoopinfgor.file;

import java.nio.file.Path;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileSystemStorageService implements StorageService {

    @Override
    public void deleteAll() {
  
    }

    @Override
    public void init() {
                
    }

    @Override
    public Path load(String filename) {
        
        return null;
    }

    @Override
    public Resource loadAsResource(String filename) {
        
        return null;
    }

    @Override
    public String store(MultipartFile file) {
        
        return null;
    }
    
}
