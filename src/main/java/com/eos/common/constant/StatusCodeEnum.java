/**
 *
 */
package com.eos.common.constant;

/**
 * @author s17742
 *
 */
public enum StatusCodeEnum {
    // 204** 未系统代码，201** 预留，202** 通用编号，203** log专用编码，205** face专用编码，206** rpa专用编码，207** esb专用编码，一般 偶数是肯定，奇数是否定
    NORMAL(20000, "成功"),
    TEST_EXCEP_ERROR(20401, "测试异常"),
    UNKNOW_ERROR(20402, "未知错误"),
    FUSE_ERROR(20403, "熔断器触发保护"),

    USERID_NOT_FIND(20201, "userId不能为空"),
    AUTH_NOT_FIND(20202, "Authorization不能为空"),
    ERROR_FORMAT(202021, "Authorization格式不对"),
    TOKEN_NOT_FIND(20203, "token不能为空"),
    TOKEN_FAIL(20204, "token失效"),
    ROLE_NOT_FIND(20205, "用户角色不能为空"),
    UN_AUTH(20206, "没有权限"),
    PWD_ERROR(20207, "密码错误"),
    SEND_SUCCESS(20208, "发送错误"),
    VERIFY_CODE_NOT_FIND(20209, "验证码不能为空"),
    VERIFY_CODE_FAIL(202091, "验证码错误"),

    ADD_SUCCESS(20210, "添加成功"),
    ADD_FAIl(20211, "添加失败"),
    REMVOE_SUCCESS(20212, "删除成功"),
    REMVOE_FAIl(20213, "删除失败"),
    UPDATE_SUCCESS(20214, "修改成功"),
    UPDATE_FAIl(20215, "修改失败"),
    SEARCH_SUCCESS(20216, "查询成功"),
    SEARCH_FAIl(20217, "查询失败"),
    SUBMIT_SUCCESS(20218, "提交成功"),
    SUBMIT_FAIl(20219, "提交失败"),

    LOGIN_SUCCESS(20220, "登录成功"),
    LOGIN_FAIL(20221, "登录失败"),
    USER_EXIST(20222, "用户已存在"),
    USER_NOT_EXIST(20223, "用户不存在"),


    DEPARTMENT_EXIST(20230, "部门已存在"),
    DEPARTMENT_NOT_EXIST(20231, "部门不存在"),


    APP_EXIST(20240, "应用已存在"),
    APP_NOT_EXIST(20241, "应用不存在"),

    RECO_SUCESS(20500, "识别成功"),
    NOT_FIND_FACE(20501, "没有找到"),
    INVALID_FACE(20502, "无效的人脸"),


    ROBOT_EXIST(20600, "机器人已存在"),
    ROBOT_NOT_EXIST(20601, "机器人不存在"),

    FDUTY_EXIST(20602, "机器人类型已存在"),
    FDUTY_NOT_EXIST(20603, "机器人类型不存在"),

    REQ_RESEND_SUCCESS(20700, "重发成功"),
    REQ_RESEND_FAIL(20701, "重发失败"),
    REQ_DOWNLOAD_SUCCESS(20702, "下载成功"),
    REQ_DOWNLOAD_FAIL(20703, "下载失败"),
    REQ_UPLOAD_SUCCESS(20704, "上传成功"),
    REQ_UPLOAD_FAIL(20705, "上传失败");

    private Integer code;


    private String massage;

    StatusCodeEnum(Integer code, String massage) {
        this.code = code;
        this.massage = massage;
    }

    public Integer getCode() {
        return code;
    }

    public String getMassage() {
        return massage;
    }
}
