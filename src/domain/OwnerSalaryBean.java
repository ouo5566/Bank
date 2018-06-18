package domain;

public class OwnerSalaryBean {
	public static final String DEPT = "이사회";
	protected int share;
	public void setShare(String share) {
		this.share = Integer.parseInt(share);
	}
	public int getShare() {
		return share;
	}
}
