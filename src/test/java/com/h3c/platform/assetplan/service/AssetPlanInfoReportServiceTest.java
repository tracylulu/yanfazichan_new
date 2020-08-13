package com.h3c.platform.assetplan.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.h3c.platform.WebApplication;
import com.h3c.platform.common.service.SysDicInfoService;



@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={WebApplication.class})
//@ContextConfiguration
@Transactional
//@Rollback(false)
//springboot中使用junit编写单元测试，@Transactional默认是事物回滚的，这样测试的脏数据不影响数据库。具体看控制台输出也能看来
//为了验证测试方法是否正确应该关闭自动事物回滚，使用@Rollback(false)关闭回滚
public class AssetPlanInfoReportServiceTest {

	@Autowired
    private AssetPlanInfoReportService assetPlanInfoReportService;
  
	@Autowired
	private SysDicInfoService sysDicInfoService;

	@Autowired
	private SysDicInfoService dicService;
	
	
	//必须静态方法
    @BeforeClass
    public static void testBeforeClass(){
        //可以进行一些初始化的操作，比如加载数据库，加载配置文件 等等
        System.out.println("-------------------beforeClass-----------------------");
    }
    //必须静态方法
    @AfterClass
    public static void testAfterClass(){
        System.out.println("----------------------afterClass-----------------------");
    }
    @Before
    public void testBefore(){
        System.out.println("-----------------------before---------------------------");
    }
    @After
    public void testAfter(){
        System.out.println("-----------------------after-------------------------------");
    }
    
    @Test(timeout = 3000)
    public void testTimeout() throws InterruptedException {
        Thread.sleep(2);
        System.out.println("Complete");
    }
	
	
    
	@Test
	public void testListofAssetPlanInfoForReport() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDataForPieChart() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDataForDept3BarChart() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDataForDept2BarChart() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDataForLineChart() {
		fail("Not yet implemented");
	}

}
