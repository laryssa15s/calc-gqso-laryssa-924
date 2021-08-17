package app;
import io.jooby.annotations.*;
import io.jooby.exception.*;

public class Soma{
    @Path ( "/soma/{x}/{y}")
    @GET 
    public String rotaSoma(@PathParam String x, @PathParam String y){
        try {
            double sum = Double.parseDouble(x) + Double.parseDouble(y);

            return String.format("%.2f", sum);
        } 
        catch (NumberFormatException nfe) {
           throw new BadRequestException(String.format("Contém parâmetro inválido"));
        }
        
    }
}