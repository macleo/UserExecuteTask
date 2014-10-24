package com.easyway.workflow.activiti.gateway;


import junit.framework.TestCase;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.test.ActivitiTestCase;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * ��Ҫ���ڲ���֮ǰ��һЩ��ʼ����������Ҫ������������ʵ��
 * �Ĺ��������������ṩ�Ļ�������
 * Ŀ�ģ��ÿ�������Ϥ������ʹ�ù���ʹ�õļ�������
 * 1.������صĹ�����ȫ�������ļ�activiti.cfg.xml�����ļ���Ϣ
 * 2.��ȡ��������صķ���(RepositoryService��RuntimeService��
 *    TaskService��HistoryService��FormService��ManagementService��
 *    IdentityService��)
 * 2.���ع������ļ�*.bpmn20.xml��Ϣ
 * 
 * 3.��������
 *    ���������ɶ��ַ�ʽ�����Ժ����̽���
 * 
 * @author longgangbai
 * 
 * 2011-12-17  ����07:48:59
 */
public abstract class AbstractTest extends TestCase {

	@Autowired
	private ProcessEngine processEngine;
	protected String deploymentId;
	protected RepositoryService repositoryService;
	protected RuntimeService runtimeService;
	protected TaskService taskService;
	protected FormService formService;
	protected HistoryService historyService;
	protected IdentityService identityService;
	protected ManagementService managementService;
	
	
	/**
	 * ����������ʼ��ʼ������
	 * 1.������صĹ������̶���ProcessEngine
	 * 2.������صķ���
	 * 3.
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		//����ProcessEngineΪ�̰߳�ȫ�Զ���������Ŀ���Թ���һ��
		if(processEngine==null) {
			//�˴�ʹ�ô��ַ������õ�activiti�������ļ�Ϊ classpath·���µ�activiti.cfg.xml
			//���õ�H2�����ݿ�
			processEngine = ProcessEngines.getDefaultProcessEngine();
		}
		//��ȡ�������ĸ��ַ�����Ϣ
		repositoryService = processEngine.getRepositoryService();
		runtimeService = processEngine.getRuntimeService();
		taskService = processEngine.getTaskService();
		formService = processEngine.getFormService();
		historyService = processEngine.getHistoryService();
		identityService = processEngine.getIdentityService();
		managementService = processEngine.getManagementService();
		//������չ�ĳ�ʼ������
		initialize();
		
	}
	
	/**
	 * test���ٷ���
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		destroy();
	}
	
	/**
	 * ��������Ĺ����ĳ�ʼ������չ����
	 * 
	 * 
	 * @throws Exception
	 */
	protected abstract void initialize() throws Exception;
	/**
	 * ��������Ĺ��������ٵ���չ����
	 * 
	 * @throws Exception
	 */
	protected abstract void destroy() throws Exception;
}