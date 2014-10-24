package com.easyway.workflow.activiti.gateway;


import java.util.logging.Logger;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
/**
 * execute�����Ĳ���DelegateExecution execution�����������и������֮�䴫�����̱����� 
 * <activiti:taskListener>Ԫ�ص�event���ԣ���һ�����������¼���"create"��"assignment"��"complete"���ֱ��ʾ���ִ�д����߼���ʱ��Ϊ���ڴ�����ʵ����ʱ���ڽ�㴦���߼���ָ��ʱ���ڽ�㴦���߼�ִ�����ʱ�����Ը����Լ�����Ҫ����ָ���� 
  *�������̶����У�4���������Ӧ�Ĵ�����
  *
  *<activiti:taskListener>Ԫ�ص�event���ԣ���һ�����������¼���"create"��"assignment"��"complete"���ֱ��ʾ���ִ�д����߼���ʱ��Ϊ���ڴ�����ʵ����ʱ���ڽ�㴦���߼���ָ��ʱ���ڽ�㴦���߼�ִ�����ʱ�����Ը����Լ�����Ҫ����ָ���� 
  *
 *<userTask id="servicetask2" name="��Ʒ����ͬ��">
       <extensionElements>
          <activiti:taskListener event="complete" class="com.easyway.workflow.activiti.gateway.ProductManagerUserTaskListener"/>
       </extensionElements>
    </userTask>
 *
 *
 * ��Ŀ������������
 * @author longgangbai
 * 
 * 
 * 2011-12-17  ����07:45:47
 */
public class DeveloperManagerUserTaskListener implements TaskListener 
{

	private final Logger log = Logger.getLogger(DeveloperManagerUserTaskListener.class.getName());


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
		delegateTask.setVariable("��Ŀ����", "���������Լ3�죬ͬ����١�");
		log.info("��Ŀ�������������Լ3�죬ͬ����١�.");
		
	}
}