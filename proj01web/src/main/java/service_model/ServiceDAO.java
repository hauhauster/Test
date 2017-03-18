package service_model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ServiceDAO implements ServiceDAO_interface{
	public static DataSource ds = null;
	static{
		try {
			Context ctx = new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/jdbc/xxx");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static final String inserstmt = "INSERT INTO services (服務代號,服務分類編號,服務項目名稱,"
			+ "服務描述,服務上架時間,服務狀態) VALUES (?,?,?,?,?,?)";
	private static final String get_all = "SELECT 服務代號,服務分類編號,服務項目名稱,服務描述,服務照片,服務上架時間,服務狀態"
			+ " FROM services ORDER BY 服務代號";
	private static final String get_one = "SELECT 服務代號,服務分類編號,服務項目名稱,服務描述,服務照片,服務上架時間,服務狀態"
			+ " FROM services WHERE 服務代號=?";
	private static final String updatestmt="update services set 服務分類編號=?,服務項目名稱=?,服務描述=?"
			+ ",服務上架時間=?,服務狀態=? where 服務代號=?";
	private static final String deletestmt = "delete from services where 服務代號=?";
	
	@Override
	public void insert(ServiceVO serviceVO) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(inserstmt);
			pstmt.setString(1, serviceVO.getServno());
			pstmt.setString(2, serviceVO.getServclassno());
			pstmt.setString(3, serviceVO.getServname());
			pstmt.setString(4, serviceVO.getServdiscribe());
			pstmt.setDate(5, serviceVO.getServupdate());
			pstmt.setInt(6, serviceVO.getStatus());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. "
					+ e.getMessage());
		}finally{
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}

	@Override
	public void update(ServiceVO serviceVO) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(updatestmt);
			pstmt.setString(1, serviceVO.getServclassno());
			pstmt.setString(2, serviceVO.getServname());
			pstmt.setString(3, serviceVO.getServdiscribe());
			pstmt.setDate(4, serviceVO.getServupdate());
			pstmt.setInt(5, serviceVO.getStatus());
			pstmt.setString(6, serviceVO.getServno());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("A database error occured. "
					+ e.getMessage());
		}finally{
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}

	@Override
	public void delete(String servno) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(deletestmt);
			pstmt.setString(1, servno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. "
					+ e.getMessage());
		}finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
		
	}

	@Override
	public ServiceVO getOne(String servno) {
		ServiceVO serviceVO=null;
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(get_one);
			pstmt.setString(1, servno);
			rs=pstmt.executeQuery();
			while(rs.next()){
				serviceVO=new ServiceVO();
				serviceVO.setServno(rs.getString(1));
				serviceVO.setServclassno(rs.getString(2));
				serviceVO.setServname(rs.getString(3));
				serviceVO.setServdiscribe(rs.getString(4));
				serviceVO.setServimage(rs.getBytes(5));
				serviceVO.setServupdate(rs.getDate(6));
				serviceVO.setStatus(rs.getInt(7));
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. "
					+ e.getMessage());
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return serviceVO;
	}

	@Override
	public List<ServiceVO> getAll() {
		List<ServiceVO> list = new ArrayList<ServiceVO>();
		ServiceVO serviceVO = null;
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(get_all);
			rs=pstmt.executeQuery();
			while(rs.next()){
				serviceVO=new ServiceVO();
				serviceVO.setServno(rs.getString(1));
				serviceVO.setServclassno(rs.getString(2));
				serviceVO.setServname(rs.getString(3));
				serviceVO.setServdiscribe(rs.getString(4));
				serviceVO.setServimage(rs.getBytes(5));
				serviceVO.setServupdate(rs.getDate(6));
				serviceVO.setStatus(rs.getInt(7));
				list.add(serviceVO);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. "
					+ e.getMessage());
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
		return list;
	}

}
