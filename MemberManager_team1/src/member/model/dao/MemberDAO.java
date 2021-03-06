package member.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import member.vo.Member;

import common.util.DataBaseUtil;

public class MemberDAO {
	private static MemberDAO dao = new MemberDAO();
	private DataBaseUtil dbUtil = DataBaseUtil.getInstance();
	
	private MemberDAO(){}
	
	public static MemberDAO getInstance(){
		return dao;
	}
	//회원 가입시 DB에 등록할 메소드.
	public void insertMember(Member member){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="insert into member values(?,?,?,?,?)";
		try{
			conn=dbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setDate(5, new Date(member.getDate().getTime()));
			pstmt.executeUpdate();
			
		}catch(SQLException e ){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.close(pstmt, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("뭔가 안닫힘");
				e.printStackTrace();
			}
		}
	}
	//모든 회원 리스트 출력 메소드. ArrayList 리턴.
	public ArrayList<Member> selectAllMember(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql="select member_id,member_pwd,member_name,member_email,member_date from member";
		ArrayList<Member> members=new ArrayList<>();
		try{
			conn = dbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()){
				members.add(new Member(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getDate(5)));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.close(rset, pstmt, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("뭔가 안닫힘");
				e.printStackTrace();
			}
		}
		return members;
	}
	
	public Member selectMemberById(String id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		String sql="select member_id,member_pwd,member_name,member_email,member_date from member where member_id=?";
		try{
			conn = dbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			if(rset.next()){
				member =new Member(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getDate(5));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.close(rset, pstmt, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("뭔가 안닫힘");
				e.printStackTrace();
			}
		}
		return member;
	}
	
	public int updateMember(Member member){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="update member set member_pwd=?,member_name=?,member_email=? where member_id=?";
		int count = 0;
		try{
			conn=dbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getId());
			count = pstmt.executeUpdate();
			
		}catch(SQLException e ){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.close(pstmt, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("뭔가 안닫힘");
				e.printStackTrace();
			}
		}
		return count;
	}
	
	public void deleteMemberById(String id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="delete from member where member_id=?";
		try{
			conn = dbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.close(pstmt, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("뭔가 안닫힘");
				e.printStackTrace();
			}
		}
	}
}
