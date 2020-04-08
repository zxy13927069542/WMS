package cn.ying.exception;

/**
 * ’Àªß¥ÌŒÛ“Ï≥£
 */
public class WrongNameException extends Exception{
    public WrongNameException(){}

    public WrongNameException(String msg){
        super(msg);
    }
}
