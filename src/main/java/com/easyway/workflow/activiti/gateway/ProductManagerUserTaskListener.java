package com.easyway.workflow.activiti.gateway;


import java.util.logging.Logger;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
/**
  * execute�����Ĳ���DelegateExecution execution�����������и������֮�䴫�����̱�����
  * 
  * <activiti:taskListener>Ԫ�ص�event���ԣ���һ�����������¼���"create"��"assignment"��"complete"���ֱ��ʾ���ִ�д����߼���ʱ��Ϊ���ڴ�����ʵ����ʱ���ڽ�㴦���߼���ָ��ʱ���ڽ�㴦���߼�ִ�����ʱ�����Ը����Լ�����Ҫ����ָ���� 

  * 
  * �������� 
 *    <userTask id="servicetask1" name="��Ŀ����ͬ��" >
       <extensionElements>
          <activiti:taskListener event="complete" class="com.easyway.workflow.activiti.gateway.DeveloperManagerUserTaskListener"/>
       </extensionElements>
    </userTask>
 * ��Ʒ������������
 * @author longgangbai
 * 
 * 2011-12-17  ����07:45:47
 */
public class ProductManagerUserTaskListener implements TaskListener {

	private final Logger log = Logger.getLogger(ProductManagerUserTaskListener.class.getName());


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
		execution.setVariable("��Ʒ����", "���������Լ3�죬ͬ����١�");
		log.info("��Ʒ����,���������Լ3�죬ͬ����١�");	
		
	}
}