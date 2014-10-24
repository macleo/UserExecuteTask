/**
 * 
 */
package com.easyway.workflow.activiti.gateway;
import java.util.Date;
import java.util.List;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.activiti.engine.test.Deployment;
import org.junit.Test;
/**
 * 测试实例如下
 * 
 * @author longgangbai
 * 
 * 2011-12-18  上午12:00:03
 */
public class ParallelGatewayTest extends AbstractTest { 
	private String deploymentId; 
	private Date start = null; 
	private Date end = null; 

	@Override 
	protected void initialize() throws Exception { 
		deploymentId = repositoryService.createDeployment() 
		.addClasspathResource("diagrams/UserExecuteTask.bpmn20.xml") 
		.deploy().getId(); 
	} 

	@Override 
	protected void destroy() throws Exception { 
			repositoryService.deleteDeployment(deploymentId, true); 
	} 


	@Deployment 
	public void testUnbalancedForkJoin() { 
		//获取流程实例对象
		ProcessInstance pi = runtimeService.startProcessInstanceByKey("UserExecuteTask"); 
		//获取任务服务对象的查询
		TaskQuery query = taskService.createTaskQuery().processInstanceId(pi.getId()).orderByTaskName().asc(); 
	   //获取所有的任务
		List<Task> tasks = query.list(); 
		assertEquals(3, tasks.size()); 
		start = new Date(); 
	   
		for(Task task : tasks) {
			//执行任务
			taskService.complete(task.getId());
			System.out.println("name =+"+task.getName());
			end = new Date(); 
			System.out.println("" + (end.getTime()-start.getTime()) + "ms."); 
		} 
		//查询任务
		tasks = query.list(); 
		assertEquals(1, tasks.size()); 
		for(Task task : tasks) { 
			taskService.complete(task.getId()); 
			System.out.println("name =+"+task.getName());
			end = new Date(); 
			System.out.println("" + (end.getTime()-start.getTime()) + "ms."); 
		} 
		end = new Date(); 
		System.out.println("" + (end.getTime()-start.getTime()) + "ms."); 
	} 
}


