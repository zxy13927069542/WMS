package cn.ying.exception;

import org.springframework.stereotype.Component;

/**
 * ø’’À∫≈“Ï≥£
 */
@Component
public class NullUserException extends Exception{
    public NullUserException(){}
    public NullUserException(String msg){
        super(msg);

    }
}
