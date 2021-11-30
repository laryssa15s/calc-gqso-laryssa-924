package app;
import io.jooby.annotations.*;
import io.jooby.exception.*;

public class Soma{
    @Path ( "/soma/{x}/{y}")
    @GET 
    public String rotaSoma(@PathParam String x , @PathParam String y) throws BadRequestException {
          try {
            double sqrt = soma(x,y);
            return String.format("%.2f", sqrt);
        } catch (IllegalArgumentException iae) {
            throw new BadRequestException(iae.getMessage());
        }
    }

    public double soma(String x, String y) throws IllegalArgumentException{
        double sum;
        try {
            sum = Double.parseDouble(x) + Double.parseDouble(y);
            return (sum);
        } catch (NumberFormatException nfe) {

            if(isInvalid(x) && isInvalid(y) == false){
                throw new IllegalArgumentException(String.format("Esse parâmetro não é válido: %s", x));
            } else if(isInvalid(x) == false && isInvalid(y)){
                throw new IllegalArgumentException(String.format("Esse parâmetro não é válido: %s", y));
            } 

            throw new IllegalArgumentException(String.format("Esses parâmetros não são válidos: %s e %s.", x, y));
        }
        
    }

    private Boolean isInvalid(String numero){
        try{
            Double.parseDouble(numero);
            return false;
        }catch(NumberFormatException nfe){
            return true;
        }
    }
}


