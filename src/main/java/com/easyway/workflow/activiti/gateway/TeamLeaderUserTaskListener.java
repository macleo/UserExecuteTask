package com.easyway.workflow.activiti.gateway;


import java.util.logging.Logger;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
/**
 * 
 * 
 * <activiti:taskListener>元素的event属性，它一共包含三种事件："create"、"assignment"、"complete"，分别表示结点执行处理逻辑的时机为：在处理类实例化时、在结点处理逻辑被指派时、在结点处理逻辑执行完成时，可以根据自己的需要进行指定。 
 * 
 * 
 * 配置如下：
 *     <userTask id="servicetask3" name="项目组长同意" >
          <extensionElements>
          <activiti:taskListener event="complete" class="com.easyway.workflow.activiti.gateway.TeamLeaderUserTaskListener"/>
       </extensionElements>
    </userTask>
    
 * 项目组长批准请假
 *    模拟当开发人员请假小于3天，组长比准
 * @author longgangbai
 * 
 * 2011-12-17  上午09:07:37
 */
public class TeamLeaderUserTaskListener implements TaskListener {

	private final Logger log = Logger.getLogger(TeamLeaderUserTaskListener.class.getName());


	/* (non-Javadoc)
	 * @see org.activiti.engine.delegate.TaskListener#notify(org.activiti.engine.delegate.DelegateTask)
	 */
	@Override
	public void notify(DelegateTask execution) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("variavles=" + execution.getVariables());
		execution.setVariable("项目组长", "请假天数小于3天，同意请假。");
		log.info("项目组长,请假天数小于3天，同意请假。");
	}
}