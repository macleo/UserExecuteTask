package com.easyway.workflow.activiti.gateway;


import java.util.logging.Logger;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
/**
  * execute方法的参数DelegateExecution execution可以在流程中各个结点之间传递流程变量。 
 *
 *<activiti:taskListener>元素的event属性，它一共包含三种事件："create"、"assignment"、"complete"，分别表示结点执行处理逻辑的时机为：在处理类实例化时、在结点处理逻辑被指派时、在结点处理逻辑执行完成时，可以根据自己的需要进行指定。 

 *    <userTask id="servicetask5" name="人事部门同意" >
        <extensionElements>
           <activiti:taskListener event="complete"  class="com.easyway.workflow.activiti.gateway.HumanResouceUserTaskListener"/>
        </extensionElements>
    </userTask>
    
 * 人事部门审批过程
 * @author longgangbai
 * 
 * 2011-12-17  下午07:45:47
 */
public class HumanResouceUserTaskListener implements TaskListener {

	private final Logger log = Logger.getLogger(HumanResouceUserTaskListener.class.getName());


	/* (non-Javadoc)
	 * @see org.activiti.engine.delegate.TaskListener#notify(org.activiti.engine.delegate.DelegateTask)
	 */
	@Override
	public void notify(DelegateTask delegateTask) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("variavles=" + delegateTask.getVariables());
		delegateTask.setVariable("人事部门", "请假天数大约3天，同意请假。");
		log.info("人事部门 ，请假天数大约3天，同意请假。");
		
	}
}