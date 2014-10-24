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
 * ����ʵ������
 * 
 * @author longgangbai
 * 
 * 2011-12-18  ����12:00:03
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
		//��ȡ����ʵ������
		ProcessInstance pi = runtimeService.startProcessInstanceByKey("UserExecuteTask"); 
		//��ȡ����������Ĳ�ѯ
		TaskQuery query = taskService.createTaskQuery().processInstanceId(pi.getId()).orderByTaskName().asc(); 
	   //��ȡ���е�����
		List<Task> tasks = query.list(); 
		assertEquals(3, tasks.size()); 
		start = new Date(); 
	   
		for(Task task : tasks) {
			//ִ������
			taskService.complete(task.getId());
			System.out.println("name =+"+task.getName());
			end = new Date(); 
			System.out.println("" + (end.getTime()-start.getTime()) + "ms."); 
		} 
		//��ѯ����
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


