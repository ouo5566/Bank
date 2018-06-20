package serviceImpl;
import java.util.List;
import domain.*;
import service.MemberService;
import java.util.ArrayList;

public class MemberServiceImpl implements MemberService{
	List<MemberBean> list;
	public MemberServiceImpl() {
		list = new ArrayList<MemberBean>();
	}
	@Override
	public void createUser(UserBean user) {
		user.setCreditRating("7등급");
//		boolean flag = list.add(user);
//		String result = (flag)?"등록성공":"등록실패";
//		System.out.println("실행결과 : " + result);
		System.out.println("실행결과 : " + ((list.add(user))?"등록성공":"등록실패"));
	}

	@Override
	public void createStaff(StaffBean staff) {
		staff.setAccessNum("1234");
		System.out.println("실행결과 : " + ((list.add(staff))?"등록성공":"등록실패"));
	}

	@Override
	public List<MemberBean> list() {
		return list;
	}

	@Override
	public List<MemberBean> search(String param) {
		List<MemberBean> arr = new ArrayList<>();
		for( int i = 0 ; i < list.size() ; i++ ) {
			if(param.equals(list.get(i).getName())){
				arr.add(list.get(i));
			}
		}
		return arr;
	}

	@Override
	public MemberBean search(MemberBean member) {
		MemberBean temp = new MemberBean();
		for( int i = 0 ; i < list.size() ; i++ ) {
			if(member.getUid().equals(list.get(i).getUid())){
				temp = list.get(i);
				break;
			}
		}
		return temp;
	}

	@Override
	public void update(MemberBean member) {
		search(member).setPassword(member.getPassword());
	}

	@Override
	public void delete(MemberBean member) {
		list.remove(list.indexOf(search(member)));
		//list.remove(search(member));
	}
	
}