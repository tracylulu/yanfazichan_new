package com.h3c.platform.common.service;

public interface PlanTimeWindowsService {
	/**
	 * 验证第一环节提单 是否在时间窗口内
	 * @return
	 */
	boolean valitSubmitTimeWiondow() throws Exception;
}
