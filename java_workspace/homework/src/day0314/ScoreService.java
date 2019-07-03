package day0314;

public class ScoreService {

	private Score[] scores = new Score[100];
	private int position = 0;
	
	public void addScore (Score score) {
		if (position < scores.length) {
			scores[position++] = score;
		}
	}
	
	// 모든 학생들의 학번/이름/국어/영어/수학/총점/평균 출력하기
	public void printAllScores() {
		for(Score s : scores) {
			printScore(s);
		}
	}
	
	// 전달받은 이름의 학생 학번/이름/국어/영어/수학/총점/평균 출력하기
	public void printScoreByName(String name) {
		Score s = null;
		for(Score student : scores) {
			if(student != null && student.getName().equals(name)) {
				s = student;
				break;
			}
		}
		if(s == null) {
			System.out.println("해당하는 학생정보가 없습니다.");
			return;
		}
		printScore(s);
	}
	
	// 전달받은 평균 이상을 평균점으로 획득한 학생들의 학번/이름/국어/영어/수학/총점/평균 출력하기
	public void printScoreByAverage(int average) {
		for(Score s : scores) {
			if(s != null && average <= s.getAverage()) {
				printScore(s);
			}
		}
	}
	
	// 전달받은 성씨로 동일한 성을 가진 학생들의 학번/이름/국어/영어/수학/총점/평균 출력하기
	public void printScoreByLastname(String lastname) {
		for(Score s : scores) {
//			if(s != null && lastname.equals(String.valueOf(s.getName().charAt(0)))) {
//			if(s != null && s.getName().substring(0, 1).equals(lastname)) {
//				printScore(s);
//			}
			if(s != null && s.getName().startsWith(lastname)) {
				printScore(s);
			}
		}
	}
	
	// 학생의 학번/이름/국어/영어/수학/총점/평균 출력하기
	public void printScore(Score s) {
		if (s != null) {
			System.out.println("학번: " + s.getNo());
			System.out.println("이름: " + s.getName());
			System.out.println("국어: " + s.getKor());
			System.out.println("영어: " + s.getEng());
			System.out.println("수학: " + s.getMath());
			System.out.println("총점: " + s.getTotal());
			System.out.println("평균: " + s.getAverage());
			System.out.println();
		}
	}
}
