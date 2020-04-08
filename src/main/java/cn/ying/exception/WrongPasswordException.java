package cn.ying.exception;

/**
 * √‹¬Î¥ÌŒÛ“Ï≥£
 */
public class WrongPasswordException extends Exception{
    public WrongPasswordException(){}

    public WrongPasswordException(String msg){
        super(msg);}

}
