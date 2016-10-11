package xml;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
//		User user =new User();
//		Question ques = new Question();
//		ques.setAnswer("i am fine");
//		ques.setAuthor("s=user");
//		ques.setId(1111);
//		ques.setIsSolve(IsSolved.UNSOLVED);
//		ques.setQues("how ae you?");
//		user.setQuestion(ques);
//		user.setScore(0);
//		user.setUserName("user1");
//		System.out.println(XmlUtil.toXML(user));
		try {
			BufferedReader reader = new BufferedReader(new FileReader("user.xml"));
			StringWriter writer = new StringWriter();
			String line = reader.readLine();
			while(line!=null){
				writer.append(line);
				line = reader.readLine();
			}
//			System.out.println(writer.toString());
			reader.close();
			
			User user2 = (User)XmlUtil.fromXML(writer.toString(), User.class);
			List<Question> question = user2.getQuestion();
			System.out.print("请输入：");
			Scanner sc= new Scanner(System.in);
			String input=sc.nextLine();
			while(!"exit".equals(input)){
				if("list".equals(input)){
					if(question.size()==0){
						System.out.println("没有提问题");
					}else{
						for(Question q :question){
							System.out.println(q.toString());
						}
					}
				}else if("score".equals(input)){
					System.out.println("你的得分是："+user2.getScore());
				}else if("ask".equals(input)){
					System.out.print("请输入你的问题： ");
					String ques1;
					ques1 = sc.nextLine();
					Question q1 = new Question();
					q1.setIsSolve(IsSolved.UNSOLVED);
					q1.setAuthor(user2.getUserName());
					q1.setId(question.size()+1);
					q1.setAnswer(null);
					q1.setQues(ques1);
					question.add(q1);
					System.out.println("你的问题已被创建");
					XmlUtil.toXML(user2);
				}else if("answer".equals(input)){
					System.out.print("请输入回答问题的ID： ");
					String quesId = sc.nextLine();
					for(Question q :question){
						if(q.getId()==Integer.parseInt(quesId)){
							if(q.getIsSolve().equals(IsSolved.UNSOLVED)){
								System.out.print("请输入你的回答： ");
								String quesAnswer = sc.nextLine();
								q.setAnswer(quesAnswer);
								q.setIsSolve(IsSolved.SOLVED);
								user2.setScore(user2.getScore()+10);
								System.out.println("谢谢你提交的答案");
								XmlUtil.toXML(user2);
							}else{
								System.out.println("该问题已经解决了");
								System.out.println(q.getId()+" : [Answer:"+q.getAnswer()+"]  from "+q.getAuthor());
							}
							
						}
					}
				}else if("help".equals(input)){
					System.out.println("============帮助信息==============");
					System.out.println(" exit  : 退出");
					System.out.println(" help  : 列出帮助信息");
					System.out.println(" list  : 列出问题列表");
					System.out.println(" ask   : 提问题");
					System.out.println("answer : 回答问题");
				}
				System.out.print("请输入：");
				input=sc.nextLine();
			}
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
