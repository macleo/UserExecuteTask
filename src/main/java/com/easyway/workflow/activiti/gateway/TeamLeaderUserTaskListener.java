package com.easyway.workflow.activiti.gateway;


import java.util.logging.Logger;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
/**
 * 
 * 
 * <activiti:taskListener>Ԫ�ص�event���ԣ���һ�����������¼���"create"��"assignment"��"complete"���ֱ��ʾ���ִ�д����߼���ʱ��Ϊ���ڴ�����ʵ����ʱ���ڽ�㴦���߼���ָ��ʱ���ڽ�㴦���߼�ִ�����ʱ�����Ը����Լ�����Ҫ����ָ���� 
 * 
 * 
 * �������£�
 *     <userTask id="servicetask3" name="��Ŀ�鳤ͬ��" >
          <extensionElements>
          <activiti:taskListener event="complete" class="com.easyway.workflow.activiti.gateway.TeamLeaderUserTaskListener"/>
       </extensionElements>
    </userTask>
    
 * ��Ŀ�鳤��׼���
 *    ģ�⵱������Ա���С��3�죬�鳤��׼
 * @author longgangbai
 * 
 * 2011-12-17  ����09:07:37
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
		execution.setVariable("��Ŀ�鳤", "�������С��3�죬ͬ����١�");
		log.info("��Ŀ�鳤,�������С��3�죬ͬ����١�");
	}
}