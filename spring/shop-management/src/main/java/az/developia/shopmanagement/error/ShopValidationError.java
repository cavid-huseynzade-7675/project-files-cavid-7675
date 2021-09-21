package az.developia.shopmanagement.error;


import org.springframework.validation.BindingResult;

public class ShopValidationError  extends RuntimeException{
    public BindingResult br;
   
    public ShopValidationError(BindingResult br){

        this.br=br;
    }

}
