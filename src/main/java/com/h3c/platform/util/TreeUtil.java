package com.h3c.platform.util;

import java.util.ArrayList;
import java.util.List;

import com.h3c.platform.assetplan.entity.DeptTreeInfo;
import com.h3c.platform.common.config.UserCache;

public class TreeUtil {
	public static List<DeptTreeInfo> RecursiveAddress(List<DeptTreeInfo> treeNodes){
		List<DeptTreeInfo> trees = new ArrayList<DeptTreeInfo>();  
		        for (DeptTreeInfo treeNode : treeNodes) {  
		            //if ("".equals(treeNode.getSupDeptDode()) || null==treeNode.getSupDeptDode() ) {  
		        	if ("50040000".equals(treeNode.getSupDeptDode()) ) {  
		                trees.add(findAddressChildren(treeNode,treeNodes));  
		            }  
		        }  
		        return trees;  
		}
		 
		/** 
	     * 递归查找地址子节点 
	     * @param treeNodes 
	     * @return 
	     */  
	 public static DeptTreeInfo findAddressChildren(DeptTreeInfo treeNode,List<DeptTreeInfo> treeNodes) {  
	        for (DeptTreeInfo it : treeNodes) {  
	        	String deptLevel = it.getDeptLevel();
	        	//System.out.println(deptLevel);
	        	String supDeptDode = it.getSupDeptDode();
	        	//System.out.println(supDeptDode);
	        	
	        	
	            if((treeNode.getDeptCode()+"").equals(it.getSupDeptDode())) {  
	                if (treeNode.getChildren() == null) {  
	                    treeNode.setChildren(new ArrayList<DeptTreeInfo>());  
	                }  
	                treeNode.getChildren().add(findAddressChildren(it,treeNodes));  
	            }  
	        }  
	        return treeNode;  
	    } 
    
}
