package az.developia.bookshoopinfgor.file;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
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
        FileSystemUtils.deleteRecursively(rootlocation.toFile());
  
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
        
     return rootlocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        
      try {
        Path file=load(filename);
        Resource resource=new UrlResource(file.toUri());
        if (resource.exists() || resource.isReadable()) {
            return resource;
            
        } else {
            throw new StorageFileFoundNotException("Fayl oxuna bilmedi"+filename);
        }  

      } catch (MalformedURLException e) {
        throw new StorageFileFoundNotException("Fayl oxuna bilmedi"+filename,e);
    }
    }

    @Override
    public String store(MultipartFile file) {
        
      String fileName=StringUtils.cleanPath(file.getOriginalFilename());
      String randomFilename="";
      try {
        try(InputStream inputStream=file.getInputStream()){
String originalFileName=file.getOriginalFilename();
UUID uuid=UUID.randomUUID();
randomFilename=originalFileName
.replace(originalFileName.substring(0,originalFileName.lastIndexOf(".")),
uuid.toString());
Files.copy(inputStream, this.rootlocation.resolve(randomFilename),
  StandardCopyOption.REPLACE_EXISTING);


        }  

      } catch (Exception e) {
       throw new StorageException("Fayl yadda saxlana bilmedi"+fileName,e);
      }
      return randomFilename;
    }
    
}
