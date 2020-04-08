package cn.ying.exception;

/**
 * 空供应商异常
 */
public class NullSupplierException extends Exception{
    public NullSupplierException(){}

    public NullSupplierException(String msg){
        super(msg);
    }
}
