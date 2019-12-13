package helpers;

public class PlacaFormatException extends Exception {
    public PlacaFormatException(String placa){
        super(placa);
    }

    @Override
    public String toString() {
        return "Placa inválida: " + super.getMessage() + " siga o seguinte modelo (LVV-1234)";
    }
}
