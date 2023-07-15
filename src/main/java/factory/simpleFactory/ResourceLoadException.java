package factory.simpleFactory;

public class ResourceLoadException extends RuntimeException{

    public ResourceLoadException(){
        super("error when loading resources");
    }

    public ResourceLoadException(String message){
        super(message);
    }


}
