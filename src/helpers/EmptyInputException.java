package helpers;

public class EmptyInputException extends Exception{

    public EmptyInputException(String inputName){
        super(inputName);
    }

    @Override
    public String toString() {
        return "Campo vazio: " + super.getMessage();
    }
}
