package xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)

public class User {
//	@XmlElementWrapper(name="users") 
//	@XmlElement(name = "users")
//	private List<User> list=new ArrayList<>();
	@XmlAttribute(name = "userName")
//	@XmlElement(name = "user")
	private String userName;
	
	@XmlElement(name = "score")
	private int score;
	
	@XmlElementWrapper(name="questions")  
	@XmlElement(name = "question")
	private List<Question> question =new ArrayList<>();

	public User() {
	}

	public List<Question> getQuestion() {
		return question;
	}
	public void setQuestion(Question e) {
		question.add(e);
	}
//	public void setList(List<User> list) {
//		this.list = list;
//	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	
}

class Question {
	private IsSolved isSolve;
	private long id;
	private String ques;
	private String answer;
	private String author;
	public Question() {
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getQues() {
		return ques;
	}
	public void setQues(String ques) {
		this.ques = ques;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public IsSolved getIsSolve() {
		return isSolve;
	}
	public void setIsSolve(IsSolved isSolve) {
		this.isSolve = isSolve;
	}
	
	@Override
	public String toString() {
		return "["+isSolve+"] "+id+": ["+ques+"] "+"from "+author;
	}
	
}

