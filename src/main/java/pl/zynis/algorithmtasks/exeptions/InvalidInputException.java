package pl.zynis.algorithmtasks.exeptions;

public class InvalidInputException extends RuntimeException {

    public InvalidInputException(String s){
        super(s);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}
