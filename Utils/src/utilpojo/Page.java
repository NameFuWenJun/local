package utilpojo;
/**
 * �ճ���ҳ���ù�����
 * @author fuwenjun01
 *
 */
public class Page {
	private int pageNow=1;  //��ǰҳ��,��ʼ��Ϊ1
	private int pageSize=4;  //Ĭ��ÿҳ��ʾ4��
	private int totalCount;   //�ܼ�¼��
	private int totalPageCount;  //��ҳ��
	
	private int startPos;   //��ʼλ��,��0��ʼ
	
	private boolean hasFirst;   //�Ƿ�����ҳ
	
	private boolean hasPre;   //�Ƿ���ǰһҳ
	
	private boolean hasNext;    //�Ƿ�����һҳ
	
	private boolean hasLast; //�Ƿ������һҳ
	
	
	public Page(int totalCount,int pageNow) {
		this.totalCount=totalCount;
		this.pageNow=pageNow;
	}


	public int getPageNow() {
		return pageNow;
	}


	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public int getTotalPageCount() {
		return totalPageCount;
	}


	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}


	public int getStartPos() {
		return startPos;
	}


	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}


	public boolean isHasFirst() {
		return hasFirst;
	}


	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}


	public boolean isHasPre() {
		return hasPre;
	}


	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}


	public boolean isHasNext() {
		return hasNext;
	}


	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}


	public boolean isHasLast() {
		return hasLast;
	}


	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}
	
}
