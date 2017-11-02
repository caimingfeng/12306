package com.neuedu.tipd.my12306.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.tipd.my12306.bean.Circuit;
import com.neuedu.tipd.my12306.service.CircuitService;
import com.neuedu.tipd.my12306.service.impl.CircuitServiceImpl;
import com.neuedu.tipd.my12306.util.DateUtil;


/**
 * Servlet implementation class LineManagement
 */
@WebServlet("/LineManagement")
public class LineManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ADD = "add";
	private static final String UPDATE = "update";
	private static final String DELETE = "delete";
	private static final String QUERY = "query";
	private CircuitService service = new CircuitServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LineManagement() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("2222");
		String management = request.getParameter("management");
		//System.out.println(management);
		if (management != null) {
			switch (management) {
			case ADD:
				addLine(request, response);
				break;
			case DELETE:
				deleteLine(request, response);
				break;
			case UPDATE:
				updateLine(request, response);
				break;
			case QUERY:
				queryLine(request, response);
				break;
			default:
				break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void addLine(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		String trainId = req.getParameter("trainId");
		String sId = req.getParameter("stationId");
		String starTime = req.getParameter("startTime");
		String eTime = req.getParameter("endTime");
		String staTime = req.getParameter("stayTime");
		String tTime = req.getParameter("takeTime");
		String mileage = req.getParameter("mileage");
		String sNo = req.getParameter("stationNo");

		// System.out.println(starTime);

		int stationId = 0;
		int stationNo = 0;
		if (sId != "")
			stationId = Integer.parseInt(sId);
		if (sNo != "")
			stationNo = Integer.parseInt(sNo);
		Date startTime = DateUtil.parseDate(starTime, DateUtil.LONG);
		Date endTime = DateUtil.parseDate(eTime, DateUtil.LONG);
		Date stayTime = DateUtil.parseDate(staTime, DateUtil.LONG);
		Date takeTime = DateUtil.parseDate(tTime, DateUtil.LONG);

		// System.out.println(startTime);

		Circuit line = new Circuit(0, trainId, stationId, startTime, endTime, mileage, stayTime, takeTime, stationNo);
		boolean b = service.addCircuit(line);

		if (b) {
			System.out.println("新增线路成功");
			//resp.sendRedirect("Admin/LineManagement.jsp");
			queryLine(req, resp);
		} else {
			System.out.println("新增线路失败");
			HttpSession se = req.getSession();
			se.setAttribute("addError", "新增线路失败");
			resp.sendRedirect("Admin/LineAddError.jsp");
		}
	}

	private void deleteLine(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cId = req.getParameter("checkbox");
		//String[] cIds = req.getParameterValues("checkbox");
		//System.out.println(cId);
		
		if (cId!=null||cId!="") {
			int circuitId = Integer.parseInt(cId);
			boolean b = service.deleteCircuit(circuitId);
			
			if (b) {
				//System.out.println("删除后的分页大小:" + req.getParameter("pageSize"));
				queryLine(req, resp);
			} else {
				System.out.println("删除失败");
			}
		}
		
		

	}

	private void updateLine(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cId = req.getParameter("circuitId");
		String trainId = req.getParameter("trainId");
		String sId = req.getParameter("stationId");
		String starTime = req.getParameter("startTime");
		String eTime = req.getParameter("endTime");
		String staTime = req.getParameter("stayTime");
		String tTime = req.getParameter("takeTime");
		String mileage = req.getParameter("mileage");
		String sNo = req.getParameter("stationNo");

		// System.out.println(starTime);
		int circuitId = 0;
		int stationId = 0;
		int stationNo = 0;

		if (cId != "")
			circuitId = Integer.parseInt(cId);
		if (sId != "")
			stationId = Integer.parseInt(sId);
		if (sNo != "")
			stationNo = Integer.parseInt(sNo);
		Date startTime = DateUtil.parseDate(starTime, DateUtil.LONG);
		Date endTime = DateUtil.parseDate(eTime, DateUtil.LONG);
		Date stayTime = DateUtil.parseDate(staTime, DateUtil.LONG);
		Date takeTime = DateUtil.parseDate(tTime, DateUtil.LONG);

		 System.out.println(startTime);

		Circuit line = new Circuit(circuitId, trainId, stationId, startTime, endTime, mileage, stayTime, takeTime, stationNo);
		boolean b = service.updateCircuit(line);
		if (b) {
			queryLine(req, resp);
		} else {
			System.out.println("修改失败");
		}
	}

	private void queryLine(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String flag = req.getParameter("flag");
		
		if (flag == null) {//按照默认分页查询

			String pNo = req.getParameter("pageNo");
			String pSize = req.getParameter("pageSize");
			System.out.println(pSize);
			System.out.println(pNo);

			int pageSize = 10;
			int pageNo = 1;
			if (pSize != null) {
				pageSize = Integer.parseInt(pSize);
			}
			if (pNo != null) {
				pageNo = Integer.parseInt(pNo);
			}

			List<Circuit> list = service.findCircuitByPage(pageNo, pageSize);
			//System.out.println("查询到数据记录的条数："+list.size());
			HttpSession session = req.getSession();
			session.setAttribute("listLine", list);
			resp.sendRedirect("Admin/LineManagement.jsp");
			System.out.println("结束");
		} else if (flag.equals("findByPage") ) {//指定分页大小的查询
			String pSize = req.getParameter("pageSize");
			System.out.println(pSize);
			
			int pageSize = 10;
			if (pSize!=null) {
				pageSize = Integer.parseInt(pSize);
			}
			
			List<Circuit> list = service.findCircuitByPage(1, pageSize);
			//System.out.println("查询到数据记录的条数："+list.size());
			HttpSession session = req.getSession();
			session.setAttribute("listLine", list);
			session.setAttribute("pageSize", pageSize);
			System.out.println("传回界面的pageSize："+pageSize);
			if (list!=null) {
				resp.setContentType("application/json;charset=utf-8"); 
				PrintWriter out=resp.getWriter();
				out.write("{\"result\":\"true\"}");
				out.flush();
				out.close();
			} else System.out.println("分页查询失败");
			System.out.println("分页查询结束");
		} else if (flag.equals("update")) {//按照线路Id查询
			String cirId = req.getParameter("circuitid");
			System.out.println(cirId);
			if (cirId!=null) {
				int circuitId = Integer.parseInt(cirId);
				Circuit line = service.findCircuitById(circuitId);
				HttpSession se = req.getSession();
				se.setAttribute("line", line);
				resp.sendRedirect("Admin/LineUpdate.jsp");
			}
			
		}  else {//按照车次或车站名查询
			String trainId = req.getParameter("trainId");
			String sId = req.getParameter("stationId");
			
			if (trainId==""&&sId=="") {
				resp.sendRedirect("noMessage.html");
				return;
			}
			int stationId = -1;
			if (sId!="") {
				stationId = Integer.parseInt(sId);
			}
			if (trainId=="") {
				System.out.println("trainId为空");
				trainId="";
			}
			System.out.println("查询条件：trainId=" + trainId + " stationId="+ sId );
			List<Circuit> list = service.queryService(trainId, stationId);
			HttpSession session = req.getSession();
			session.setAttribute("listLine", list);
			session.setAttribute("sId", sId);
			session.setAttribute("trainId", trainId);
			resp.sendRedirect("Admin/LineManagement.jsp");
			System.out.println("条件查询结束");
			
			
//				List<Circuit> list = service.findCircuitBySName(Integer.parseInt(sId));
//				HttpSession session = req.getSession();
//				session.setAttribute("listLine", list);
//				session.setAttribute("sId", sId);
//				resp.sendRedirect("Admin/LineManagement.jsp");
//				System.out.println("按照车站名查询结束");
//				
//				List<Circuit> list = service.findCircuitByTrainId(trainId);
//				HttpSession session = req.getSession();
//				session.setAttribute("listLine", list);
//				session.setAttribute("trainId", trainId);
//				resp.sendRedirect("Admin/LineManagement.jsp");
//				System.out.println("按照车次查询结束");
			}
		}
	}


