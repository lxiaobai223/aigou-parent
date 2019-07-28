package cc.wenjun.util;

public class AjaxResult {

    private boolean success=true;
    private String message="操作成功了......！！！";
    private Object resultObj;
    //错误代码
    private Integer errorCode;


    private AjaxResult(){}
//    private Object AjaxResult;

    public boolean isSuccess() {
        return success;
    }

    public AjaxResult setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public AjaxResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getResultObj() {
        return resultObj;
    }

    public Object setResultObj(Object resultObj) {
        this.resultObj = resultObj;
        return this;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public AjaxResult  setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public static  AjaxResult ajax(){
        return new  AjaxResult();
    }
}
