package az.developia.bookshoopinfgor.file;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileSystemStorageService implements StorageService {

private final Path rootlocation;

@Autowired
public FileSystemStorageService(StorageProperties properties){
    this.rootlocation=Paths.get(properties.getLocation());
}

    @Override
    public void deleteAll() {
  
    }

    @Override
    public void init() {
                try {
                    Files.createDirectories(rootlocation);
                } catch (Exception e) {
                    //TODO: handle exception
                    throw new StorageException("Qovluq yaradila bilmedi",e);
                }
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
