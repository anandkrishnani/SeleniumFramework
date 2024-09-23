package personal.anand.qa.opencart.exceptions;

import personal.anand.qa.opencart.errors.AppError;

public class BrowserException  extends RuntimeException{

    public BrowserException(String message){
        super(message);
    }
}
