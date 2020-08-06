package com.h3c.platform.response;

/**
 * 响应结果包装类
 * 
 * @author sYS2403
 *
 */
/**
 * @author s21046 sunliguo
 * @创建日期 2020年2月19日 下午3:34:07
 */
/**
 * @author s21046 sunliguo
 * @创建日期 2020年2月19日 下午3:35:45
 */
public class ResponseResult {

    //状态码
    private int status;
    //表单提交是否成功返回标志，true表示成功，false表示失败
    private boolean success;
    //信息
    private String message;
    //当前页码
    private long pageNum;
    //查询数据的总数
    private long total;
    //tableHead
    private Object tableHeadData;
    //数据
    private Object data;
    
    //信息
    //private String msg;
    //个数
    //private long size;
    

    public ResponseResult() {
        super();
    }
    
    public static ResponseResult success(boolean success, String message) {
        return new ResponseResult(true, message);
    }

    public static ResponseResult fail(boolean success, String message) {
        return new ResponseResult(false, message);
    }

    public static ResponseResult success() {
        return success(null);
    }

    public static ResponseResult success(String message) {
        return success(null, message);
    }

    public static ResponseResult success(Object data) {
        return success(data, "");
    }

    public static ResponseResult success(Object data, String message) {
        return success(data, message, 0);
    }

    public static ResponseResult success(Object data, String message, long total) {
        return success(0, message, data, total);
    }

    public static ResponseResult success(Object data, long size) {
        return success(0, "", data, size);
    }

    public static ResponseResult success(int status, String message,
            Object data, long total) {
        return new ResponseResult(status, message, data, total);
    }
    
    //add start by chenlulu
    public static ResponseResult success(int status, String message,long pageNum,
    		long total,Object tableHeadData,Object allData) {
        return new ResponseResult(status, message, pageNum, total,tableHeadData, allData);
    }
    //add end by chenlulu
    
    public static ResponseResult fail(Object data) {
        return fail(data, "");
    }


    public static ResponseResult fail(Object data, String message) {
		return fail(data, message, 0);
    }
    
    public static ResponseResult fail(Object data, String message, long size) {
        return fail(1, message, data, size);
    }

    public static ResponseResult fail(int status, String message, Object data,
            long size) {
        return new ResponseResult(status, message, data);
    }

    public static ResponseResult fail(String message) {
        return fail(1, message, null, 0);
    }
    
    public static ResponseResult loginOut(String message) {
    	 return success(2, message, null, 0);
    }
    
    public ResponseResult(int status, String message, Object data) {
        super();
        this.status = status;
        this.data = data;
        this.message = message;
        // 0:成功|1:失败
        if (0 == status) {
            this.success = true;
        } else if (1 == status) {
            this.success = false;
        }
    }
    
    public ResponseResult(int status, String message, Object data, Long total) {
        super();
        this.status = status;
        this.data = data;
        this.message = message;
        this.total = total;
        // 0:成功|1:失败|2 token验证失败，需重新登录
        if (0 == status|| 2==status) {
            this.success = true;
        } else if (1 == status) {
            this.success = false;
        }
    }
    public ResponseResult(int status, String message,long pageNum,long total,Object tableHeadData,Object allData) {
        super();
        this.status = status;
        this.data = allData;
        this.tableHeadData = tableHeadData;
        this.message = message;
        this.pageNum = pageNum;
        this.total = total;
        // 0:成功|1:失败|2 token验证失败，需重新登录
        if (0 == status) {
            this.success = true;
        } else if (1 == status) {
            this.success = false;
        }
    }

    public ResponseResult(boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }
    
    
    
    

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /*public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }*/

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getPageNum() {
		return pageNum;
	}

	public void setPageNum(long pageNum) {
		this.pageNum = pageNum;
	}

	public Object getTableHeadData() {
		return tableHeadData;
	}

	public void setTableHeadData(Object tableHeadData) {
		this.tableHeadData = tableHeadData;
	}

	/*public Object getPageData() {
		return pageData;
	}

	public void setPageData(Object pageData) {
		this.pageData = pageData;
	}*/
}
