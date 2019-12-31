package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
//import java.util.Set;
import java.util.ArrayList;


//import db.DB;
import dao.RequestDao;
import models.Request;
import util.JDBCConnection;

//can't make static, so use the service layer 
public class RequestDaoImpl implements RequestDao {
	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public boolean addReq(Request u) {
//		DB.users.put(u.getReqId(), u);
//		return true;
		System.out.println("Submitting to ReqDaoImpl: "+u);
		String sql = "CALL add_new_reqtable(?,?,?,?, ?,?,?,? ,?,?,?)";
		try {
			CallableStatement cs = conn.prepareCall(sql);//broke here!!
//			cs.setString(1, Integer.toString(u.getReqId()));
			cs.setString(1, Integer.toString(u.getUserId()));
			cs.setString(2, u.getReqName());
			cs.setString(3, u.getReqType());
			cs.setString(4, u.getReqDesc());
			cs.setString(5, u.getReqJustify());
			cs.setString(6, u.getReqDatetime());
			cs.setString(7, u.getReqPlace());
			cs.setString(8, u.getReqGradeType());
			cs.setString(9, u.getReqGradePass());
			cs.setString(10, Double.toString(u.getReqAmt()));
			cs.setString(11, Integer.toString(u.getReqStage()));
			System.out.println("success to request!: " );
			cs.execute();
			return true;

		} catch (SQLException e) {
			System.out.println("Double Check add_new_reqtable DB SQL");
			System.out.println(e);
		}
		return false;
	}

	@Override
	public Request getReq(int reqid) {
//		return DB.users.get(id);
		try {
			String sql = "SELECT * FROM reqtable WHERE reqid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(reqid));
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
			return new Request(
					rs.getInt("reqid"),
					rs.getInt("userid"), 
					rs.getString("reqName"), 
					rs.getString("reqType"),  
					rs.getString("reqDesc"),  
					rs.getString("reqJustify"),
					rs.getString("reqDatetime"), 
					rs.getString("reqPlace"),  
					rs.getString("reqGradeType"),  
					rs.getString("reqGradePass"), 
					rs.getDouble("reqAmt"), 
					rs.getInt("reqStage")); 
			}
	}		catch (Exception e) {
		System.out.println("SQL issue with getting REQ: \n"+e);
	}
			return null;
		};  
		
//	@Override
//	public Request getReq(String r) {
//		return DB.requests.get(r);
//		try {
//			String sql = "SELECT * FROM reqtable WHERE username = ?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, getString(username));
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next())
//			{
//				return new Request(rs.getInt("userid"),
//						rs.getInt("deptid"), 
//						rs.getInt("superid"), 
//				rs.getString("username"),  
//				rs.getString("password"),  
//				rs.getString("email"));
//			}
//	}		catch (Exception e) {
//		System.out.println("SQL issue with getting USER: \n"+e);
//	}
//			return null;
//	};
 

	@Override
	public List<Request> listReq() {
//		List<Request> reqList = new ArrayList<Request>();
//		Set<Integer> keys = DB.reqs.keySet();
//		for (Integer k : keys)
//			reqList.add(DB.reqs.get(k));
//		return reqList;
		String sql = "SELECT * FROM reqtable";
		List<Request> reqArr = new ArrayList<Request>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			// preparedStatements are safe from SQL injection & sanitize inputs
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reqArr.add(new Request(rs.getInt("reqid"),
						rs.getInt("userid"), 
						rs.getString("reqName"), 
						rs.getString("reqType"),  
						rs.getString("reqDesc"),  
						rs.getString("reqJustify"),
						rs.getString("reqDatetime"), 
						rs.getString("reqPlace"),  
						rs.getString("reqGradeType"),  
						rs.getString("reqGradePass"), 
						rs.getDouble("reqAmt"), 
						rs.getInt("reqStage"))); 
			}
			System.out.println("SQL is All Good!");
			return reqArr;
		} catch (SQLException e) {
			System.out.println("SQL issue with getting All REQUESTS:\n "+e);
		}
		return null;
	}

//	@Override
//	public boolean updateReq(Request change) {
//		DB.users.replace(change.getReqId(), change);
//		return true;
//		String sql = "UPDATE usertable SET password=?, fullname=?, iscust=?, isowner=? WHERE username = ?";
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql); 
////			ps.setString(6, Integer.toString(change.getReqID()));
//			ps.setString(1, change.getPassword());
//			ps.setString(2, change.getReqName());
//			ps.setString(3, Integer.toString(change.isCust()));
//			ps.setString(4, Integer.toString(change.isOwner())); 
//			ps.setString(5, change.getReqname());
//			ps.executeQuery();
//		
//			return true;
//		} catch (SQLException e) {
//			System.out.println("SQL issue with updating USER:\n "+e);
//		}
//		return false;
//	}

	@Override
	public boolean deleteReq(String req) {
//		DB.users.remove(req);
//		String sql = "DELETE usertable WHERE username = ?";
//		
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql); 
//			ps.setString(1, u);
//			
////			int var = 1;
////			System.out.println(var);
////			System.out.println("never delete ... ");
//			
//			return true;
//		} catch (Exception e) {
//	 System.out.println("doublecheck deletions: \n"+e);
//		}
//		return false;
//		}
		return false;
	}

}
