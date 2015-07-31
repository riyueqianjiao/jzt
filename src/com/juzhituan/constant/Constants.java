package com.juzhituan.constant;

public class Constants
{
   /*
    * 用户类型
    * */
	public static final Byte USER_TYPE_EMPLOYEE=0;
	public static final Byte USER_TYPE_EMPLOYER=1;
	
	/*
	 * 排序类型
	 */
	public static final Byte ORDER_BY_PUBLICATION_TIME=0;
	public static final Byte ORDER_BY_START_DATE=1;
    public static final Byte ORDER_BY_SALARY=2;
    public static final Byte ORDER_BY_WORKDURATION=3;
    
    /*
     * 发布状态
     * */
    public static final Byte PUBLICATION_STATE_ACTIVE=0;
    public static final Byte PUBLICATION_STATE_APPLICATION_DONE=1;
    public static final Byte PUBLICATION_STATE_CANCELING=2;
    public static final Byte PUBLICATION_STATE_CANCELED=3;
    public static final Byte PUBLICATION_STATE_WORK_DONE=4;
    
	
    
   /*
    * 权限
    * */
   public static final String  USER_EXIST="用户已存在";
   public static final String  USER_NAME_EXIST="用户名已存在";
   public static final String  USER_NOT_EXIST="用户不存在或密码错误";
   public static final String  LICENSE_NOT_EXIST="许可证不存在";
   public static final String  LICENSE_IS_USED="该许可证已被使用";
   public static final String  PUBLICATION_NOT_EXIST="信息不存在";
   public static final String  CELLPHONE_EXIST="该手机号已注册";
   
   public static final String  RESULT_IS_EMPTY="记录数为空";
   public static final String  NO_ACCESS="无权限";
   public static final String  NEED_LOGIN="请先登录";
   
   
   
   /*
    * 数据校验
    * */
   public static final String ERROR_DATA_FORMAT="数据格式错误";
   public static final String ERROR_CELLPHONE_FORMAT="手机号错误";
   public static final String ERROR_IMAGE_CHECKCODE="图片验证码错误";
   public static final String ERROR_CELLPHONE_CHECKCODE="手机验证码错误";
   
   
   
   /*
    *  上传文件
    * */
   public static final String UPLOAD_FILENAME="file";
   public static final String UPLOAD_FAILED="文件上传失败";
   public static final String ERROR_FILE_TYPE="文件类型不支持";
   public static final String EXCESS_MAX_FILESIZE="头像大小应小于1M";
   public static final long   MAX_FILESIZE=1048576;
   public static final String SUPPORT_FILETYPES="jpg|JPG|jpeg|JPEG|gif|GIF|png|PNG|bmp|BMP";
   

   /*
    * 路径
    * */
   public static final String  ICON_PATH="/Users/ssl/icon/";

   /*
    * 保存在session中数据的key
    * */
   public static final String  USER_SESSION_KEY="user";
   public static final String  IMAGE_CODE_SESSION_KEY="iamgecode";
   public static final String  CELLPHONE_CODE_SESSION_KEY="cellphoneCode";
   public static final int     CHECKCODE_LENGTH=4; 
   /* 分页
    * */
   public static final Integer PAGE_Size=10;
   
   /* 用户锁定天数
    * */
   public static final Integer LOCK_TIME=1;
   
   /*
    * 报名类型类型
    * */
   public static final Byte  SIGNUP=0;
   public static final Byte  CANCELSIGNUP=1;
}
