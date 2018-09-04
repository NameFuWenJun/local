package utilpojo;
/**
 * 日常分页常用工具类
 * @author fuwenjun01
 *
 */
public class Page {
	private int pageNow=1;  //当前页数,初始化为1
	private int pageSize=4;  //默认每页显示4条
	private int totalCount;   //总记录数
	private int totalPageCount;  //总页数
	
	private int startPos;   //开始位置,由0开始
	
	private boolean hasFirst;   //是否有首页
	
	private boolean hasPre;   //是否有前一页
	
	private boolean hasNext;    //是否有下一页
	
	private boolean hasLast; //是否有最后一页
	
	
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
