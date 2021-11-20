package az.developia.compshopcavidhuseynzade.file;


public class StorageFileFoundNotException  extends StorageException{
    

    
    public StorageFileFoundNotException(String message){
        super(message);
    }
    

    public StorageFileFoundNotException(String message,Throwable cause){
        super(message,cause);
    }
}
