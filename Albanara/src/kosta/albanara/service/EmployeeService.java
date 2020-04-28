package kosta.albanara.service;



import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import kosta.albanara.dao.EmployeeDao;
import kosta.albanara.model.Employees;
import kosta.albanara.model.Resumes;

public class EmployeeService {
	public static EmployeeService instance;
	public static EmployeeDao employeeDao;

	public static EmployeeService getInstance() {
		if (instance == null) {
			employeeDao = EmployeeDao.getInstance();
			instance = new EmployeeService();
		}
		return instance;
	}

	public int insertEmployeeService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");

		String employeeId = request.getParameter("employeeId");
		String employeePw = request.getParameter("employeePw");
		String employeeName = request.getParameter("employeeName");
		Date employeeBirthday = Date.valueOf(request.getParameter("employeeBirthYear") + "-"
				+ request.getParameter("employeeBirthMonth") + "-" + request.getParameter("employeeBirthDay"));
		String employeeEmail = request.getParameter("employeeEmailInput1")
				+ request.getParameter("employeeEmailInput2");
		String employeeGender = request.getParameter("employeeGender");
		String employeePhone = request.getParameter("employeePhone1") + request.getParameter("employeePhone2")
				+ request.getParameter("employeePhone3");
		String employeeAddress = request.getParameter("employeeAddress");

		String employeeLatitude = request.getParameter("latitude");
		String employeeLongitude = request.getParameter("longitude");
		

		/*
		 * String employeeId = "ID"; String employeePw = "Password"; String employeeName
		 * = "�̸�"; Date employeeBirthday = Date.valueOf("1992-05-11"); String
		 * employeeEmail = "employeeEmailInput1"+"employeeEmailInput2"; String
		 * employeeGender = "����"; String employeePhone = "010"+"2785"+"1111"; String
		 * employeeAddress ="����";
		 */

		Employees employees = new Employees(employeeId, employeePw, employeeName, employeeBirthday, employeeEmail,
				employeeGender, employeePhone, employeeAddress);

		return employeeDao.insertEmployee(employees);

	}
	
	public int insertResumeService(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		
		//���Ͼ��ε�(���, ����ũ��, ���ڵ�, �����̸���ø ��å)
		String uploadPath = request.getRealPath("upload/resumePicture");
		int size = 20 * 1024 * 1024;		//20MB
		
		//���Ͼ��ε� ������Ʈ�� ó�����ִ� API(�츮�� tomcat�� ���� cos.jar�� �ִ�). �� ��ü�� request ��ü�� ���� �־��ش�. �׷��� request��� multi�� �־��ش�.
		MultipartRequest multi =		
				new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		
		
		
		String resumeTitle = multi.getParameter("resumeTitle");
		String resumeContents = multi.getParameter("resumeContents");
		String desiredWorkingArea = multi.getParameter("desiredWorkingArea");
		String favoriteField = multi.getParameter("favoriteField");
		String pictureFilename = (String)multi.getFilesystemName("pictureFilename");
		
		
		
		/*
		//���Ͼ��ε� �� DB�� �����̸� �����ϴ� ��
				if(multi.getFilesystemName("pictureFilename") != null) {		//�ؼ� : ������ ���ε� ���� ��
				String pictureFilename = (String)multi.getFilesystemName("pictureFilename");
				

				}
		*/
		
		Resumes resume = new Resumes(pictureFilename, resumeTitle, resumeContents, desiredWorkingArea, favoriteField);
	System.out.println(resume.toString());
		
		return employeeDao.insertResume(resume);
	}

	public Resumes searchResumeService(int employeeSeq)throws Exception {
	System.out.println(employeeSeq);
		return employeeDao.searchResume(employeeSeq);
	}
	
	
	public int updateResumeService(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		
		String uploadPath = request.getRealPath("upload/resumePicture");
		int size = 20 * 1024 * 1024;
		
		MultipartRequest multi =
				new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		
		//String resumeSeq = multi.getParameter("resumeSeq");
		String resumeTitle = multi.getParameter("resumeTitle");
		String resumeContents = multi.getParameter("resumeContents");
		String desiredWorkingArea = multi.getParameter("desiredWorkingArea");
		String pictureFilename = (String)multi.getFilesystemName("pictureFilename");
		String favoriteField = multi.getParameter("favoriteField");
		
		Resumes resume = new Resumes(pictureFilename, resumeTitle, resumeContents, desiredWorkingArea, favoriteField);
		
	System.out.println(resume.toString());
		
		return employeeDao.updateResume(resume);
	}

	public Employees getEmployee(int seq) {
		return employeeDao.getEmployee(seq);
	}
	
	
	
	

}
