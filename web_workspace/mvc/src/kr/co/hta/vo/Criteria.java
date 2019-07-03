package kr.co.hta.vo;

public class Criteria {

	private int size;		// 한 화면에 표시할 데이터 개수(getAllBoardByRange)
	private String sort;	// 정렬방법	
	private String option;	// 검색옵션:제목/작성자/내용
	private String keyword;	// 검색어
	private int beginIndex;	// select 시작 row_number
	private int endIndex;	// select 종료 row_number

	public Criteria() {
		super();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	
}
