package member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import member.exception.DuplicationIdException;
import member.model.dao.MemberDAO;
import member.vo.Member;
import common.util.DataBaseUtil;

public class MemberService {
	private static MemberService inst = new MemberService();
	private DataBaseUtil dbUtil = DataBaseUtil.getInstance();
	private MemberDAO dao = MemberDAO.getInstance();
	
	private MemberService(){}
	
	public static MemberService getInstance(){
		return inst;
	}
	//가입
	public void joinMember(Member member) throws DuplicationIdException{
		Connection conn = null;
		try{
		conn = dbUtil.getConnection();
		conn.setAutoCommit(false);
		//TODO 회원 가입 DAO 불러오기
		if(dao.selectMemberById(member.getId())!=null){
			throw new DuplicationIdException("이미 있는 아이디 입니다.");
		}
		dao.insertMember(member);
		conn.commit();
		conn.setAutoCommit(true);
		}catch(SQLException e){
			try {
				e.printStackTrace();
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	//모든 회원정보를 가져옴
	public ArrayList<Member> getMemberList(){
		Connection conn = null;
		ArrayList<Member> members = null;
		try{
		conn = dbUtil.getConnection();
		conn.setAutoCommit(false);
		//TODO DAO 불러오기
		members = dao.selectAllMember();
		conn.commit();
		conn.setAutoCommit(true);
		}catch(SQLException e){
			try {
				e.printStackTrace();
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	return members;
	}
	//로그인 한 사람의 정보를 가져옴
	public Member getMemberById(String id){
		Connection conn = null;
		Member member = null;
		try{
		conn = dbUtil.getConnection();
		conn.setAutoCommit(false);
		//TODO DAO 불러오기
		member = dao.selectMemberById(id);
		conn.commit();
		conn.setAutoCommit(true);
		}catch(SQLException e){
			try {
				e.printStackTrace();
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return member;
	}
	//회원 정보 갱신
	public void modifyMember(Member member){
		Connection conn = null;
		
		try{
		conn = dbUtil.getConnection();
		conn.setAutoCommit(false);
		//TODO DAO 불러오기
		int count = dao.updateMember(member);
		conn.commit();
		conn.setAutoCommit(true);
		}catch(SQLException e){
			try {
				e.printStackTrace();
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	//회원 탈퇴
	public void removeMemberById(String id){
		Connection conn = null;
		
		try{
		conn = dbUtil.getConnection();
		conn.setAutoCommit(false);
		//TODO DAO 불러오기
		dao.deleteMemberById(id);
		conn.commit();
		conn.setAutoCommit(true);
		}catch(SQLException e){
			try {
				e.printStackTrace();
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public boolean loginMember(Member member){
		Connection conn = null;
		boolean flag = false;
		try{
			//TODO DAO 불러오기
			String id = member.getId();
			if(id==null){
				return flag;
			}
			conn = dbUtil.getConnection();
			conn.setAutoCommit(false);			
			Member selMember = dao.selectMemberById(id);
			if(selMember!=null&&member.getPassword().equals(selMember.getPassword())){
				flag = true;
			}
		conn.commit();
		conn.setAutoCommit(true);
		}catch(SQLException e){
			try {
				e.printStackTrace();
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return flag;
	}
	
}
