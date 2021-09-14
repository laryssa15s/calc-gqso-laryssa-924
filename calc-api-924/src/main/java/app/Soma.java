package app;
import io.jooby.annotations.*;
import io.jooby.exception.*;

public class Soma{
    @Path ( "/soma/{x}/{y}")
    @GET 
    public String rotasoma(@PathParam String x , @PathParam String y) {
        try {
            double sum = Double.parseDouble(x) + Double.parseDouble(y);

            return String.format("%.2f", sum);
        } catch (NumberFormatException nfe) {

            if(isInvalid(x) && isInvalid(y) == false){
                throw new BadRequestException(String.format("O parâmetro não é válido: %s", x));
            } else if(isInvalid(x) == false && isInvalid(y)){
                throw new BadRequestException(String.format("O parâmetro não é válidos: %s", y));
            } 

            throw new BadRequestException(String.format("Os parâmetros não são válidos: %s e %s.", x, y));
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


