package com.xuetu.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuetu.entity.Coupon;
import com.xuetu.service.CouService;

/**
 * Servlet implementation class couAddServlet
 */
@WebServlet("/couAddServlet")
public class CouAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CouService couService = new CouService();
    /**
     * Default constructor. 
     */
    public CouAddServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*设置编码
		 * 获得页面数据，封装成Coupon对象，调用Service层的添加方法
		 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String cou_num = request.getParameter("cou_num");
		String cou_info = request.getParameter("cou_info");	
		String cou_Validity = request.getParameter("cou_Validity");
		String cou_redeem_points = request.getParameter("cou_redeem_points");
		//创建Coupon对象
		Coupon coupon = new Coupon();
		coupon.setConNum(Integer.parseInt(cou_num));
		coupon.setCoouRedeemPoints(Integer.parseInt(cou_redeem_points));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			coupon.setConValidity(sdf.parse(cou_Validity));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//调用Service方法添加优惠券,sto_id还没获取
//		couService.CouponAdd(coupon, sto_id);
	}

}
