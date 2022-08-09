package com.dspt.controller;

//import com.dspt.controller.ex.FileUploadException;
//import com.dspt.service.ex.*;
import com.dspt.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

/** 控制器类的基类 */
public class BaseController {
    /** 操作成功的状态码 */
    public static final int OK = 200;

    public static final int HAD= 461;//用户名重复
    public static final int PAFALSE = 462;//密码错误
    public static final int NOONE=463 ;//无该用户
    public static final int NOROOT = 464;//非管理员
    public static final int FALSE =460;//未知错误
//    /** @ExceptionHandler用于统一处理方法抛出的异常 */
//    @ExceptionHandler({ServiceException.class, FileUploadException.class})
//    public JsonResult<Void> handleException(Throwable e) {
//        JsonResult<Void> result = new JsonResult<Void>(e);
//        if (e instanceof ProductNotFoundException) {
//            result.setState(4006);
//        } else if (e instanceof CartNotFoundException) {
//            result.setState(4007);
//        } else if (e instanceof InsertException) {
//            result.setState(5000);
//        }
//        return result;
//    }
}
