package tn.esprit.b3.esprit1718b3hrboard.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import tn.esprit.b3.esprit1718b3hrboard.entities.Comment;
import tn.esprit.b3.esprit1718b3hrboard.entities.Condidate;
import tn.esprit.b3.esprit1718b3hrboard.entities.Department;
import tn.esprit.b3.esprit1718b3hrboard.entities.Employee;
import tn.esprit.b3.esprit1718b3hrboard.entities.Project;
import tn.esprit.b3.esprit1718b3hrboard.entities.Topic;
import tn.esprit.b3.esprit1718b3hrboard.entities.User;
import tn.esprit.b3.esprit1718b3hrboard.entities.Vacation;
import tn.esprit.b3.esprit1718b3hrboard.services.CheckInServiceLocal;
import tn.esprit.b3.esprit1718b3hrboard.services.CommentServiceLocal;
import tn.esprit.b3.esprit1718b3hrboard.services.DepartmentServiceLocal;
import tn.esprit.b3.esprit1718b3hrboard.services.ProjectServiceLocal;
import tn.esprit.b3.esprit1718b3hrboard.services.TopicServiceLocal;
import tn.esprit.b3.esprit1718b3hrboard.services.UserServiceLocal;
import tn.esprit.b3.esprit1718b3hrboard.services.VacationServiceLocal;

@Singleton
@Startup
public class DBPopulator {
	@EJB
	private UserServiceLocal userServiceLocal;
	@EJB
	private CheckInServiceLocal checkInServiceLocal;
	@EJB
	private DepartmentServiceLocal departmentServiceLocal;
	@EJB
	private VacationServiceLocal vacationServiceLocal;
	@EJB
	private ProjectServiceLocal projectServiceLocal;
	@EJB
	private TopicServiceLocal topicServiceLocal;
	@EJB
	private CommentServiceLocal commentServiceLocal;
	
	public DBPopulator() {
	}

	@PostConstruct
	public void init() {
		SimpleDateFormat format = new SimpleDateFormat( "dd/MM/yyyy" );
		Date myDate1;
		Date myDate2;
		
		try {
			myDate1 = format.parse( "18/03/2016" );
			myDate2 = format.parse( "18/03/2018" );
			Vacation vacation=new Vacation(6,myDate1,myDate2,"approuved");
			vacationServiceLocal.update(vacation);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Department department=new Department("commerciale", "reponsable de vente des produit","External and Internal",14,"2nd floor");
		Department department1=new Department("informatique", "reponsable de developpement des applications web et mobile et gére les matériel info","Internal",10,"7rd floor");
		Department department2=new Department("financiére", "reponsable des ressources financciéres de la société et le bilan financiére","External and Internal",11,"4rd floor");
		
		Department department000=new Department(1,"commerciale", "reponsable de vente des produit","External and Internal",14,"2nd floor");
		Department department111=new Department(2,"informatique", "reponsable de developpement des applications web et mobile et gére les matériel info","Internal",10,"7rd floor");
		
		
		
		
		
		
		
		Employee employee1=new Employee("abdou","trigui","trigui","0000","trigui.abdou95@gmail.com","Responsable","employee","0z7e468678","07468678","soukra",department000);
		Employee employee2=new Employee("ali","tijani","ali","0000","tijani.ali@gmail.com","technicien","employee","ZA748Z52","01857485","ariana soughra",department111);
		Employee employee3=new Employee("mohamed","guesmi","mohamed","0000","med.ali@gmail.com","ingenieur","employee","ZA748882","01333485","marsa",department111);
		Employee employee4=new Employee("alaa","bouazizi","alaa","0000","alaa.ali@gmail.com","ingenieur","employee","ZDFR8882","74853485","Sfax",department111);
		Employee employee5=new Employee("hatem","trigui","hatem","0000","Htaem.trigui@esprit.com","Responsable","employee","48578882","20157774","Sidi bouzid",department111);
		Employee employee6=new Employee("olfa","sallemi","olfa","0000","olfa.sallemi@gmail.com","technicien","employee","ZAz74882","25543485","marsa",department000);
		Employee employee7=new Employee("ahlem","turki","ahlem","0000","ahlem.sallemi@gmail.com","technicien","employee","ZAz88882","2017663","sfax",department111);
		Employee employee8=new Employee("slim","sallemi","slim","0000","slim.dammak@gmail.com","ingenieur","employee","ZBBz4882","25543485","ghazela",department111);
		Employee employee9=new Employee("ahmed","mrabbet","ahmed","0000","ahmed.mrabet@gmail.com","technicien","employee","ZAz77485","25369748","raoued",department111);
		Employee employee10=new Employee("mahdi","guesmi","mahdi","0000","mahdi.mrabet@gmail.com","technicien","employee","ZIU77485","25374848","soukra",department111);
		Employee employee11=new Employee("mahmoud","trigui","mahmoud","0000","mahmoud.mrabet@gmail.com","technicien","employee","ZA798485","24749748","manzah",department111);

		Condidate condidate=new Condidate("dali","trigui","dali","456", "aloalo","Rrh","pdf");
		


		SimpleDateFormat format1 = new SimpleDateFormat( "dd-MM-yyyy hh:mm:ss" );
		Date myDate;
		Date myDate12;
		try {
			myDate = format1.parse( "15-03-2018 08:00:00" );
			myDate12 = format1.parse( "15-03-2018 08:00:00" );
			myDate12.setTime(myDate.getTime() + ((15 * 24 * 3600 * 1000)+32400000));
		Project project=new Project(1,"dev app","ce projet consiste a developpe une app mobile",6,myDate,18,"OK","not finish","this projeict could be edited any time",myDate12);       //Add test
		projectServiceLocal.update(project);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Employee employee333=new Employee(4,"mohamed","guesmi","mohamed","0000","med.ali@gmail.com","ingenieur","employee","ZA748882","01333485","marsa");

		Employee employee111=new Employee(1,"abdou","trigui","trigui","0000","trigui.abdou95@gmail.com","Responsable","employee","0z7e468678","07468678","soukra");
		Topic topic=new Topic("Java string to date conversion", "Note that many of the answers ignore subtleties like locales and timezones. I'd recommend a close reading of the documentation for the Date, Calendar, TimeZone, Locale, and SimpleDateFormat classes before using any of them", "2018/05/01 18:26:18", "null",0,0,0, "independent", 0, 0, "unresolved", "java ,html , skype", 0, employee111);
		Topic topic2=new Topic("Jon Skeet Answers Your Questions IRL", "In January, Jon Skeet’s rep crossed over one million. To thank him for his generous efforts and contributions, we hosted a brunch in his honor at our New York Headquarters in February. We also asked the community if they had any questions for him to answer in an IRL Q&A Please enjoy this delightful interview in which Jon discusses everything from his origin story, to overload resolution, to banana flower pants. We’re immensely grateful for Jon’s continued devotion to thion rep!", "2018/01/01 00:26:18", "null",0,0,0, "independent", 0, 0, "resolved", "jee,jsf,xhtml,uml,js,jquery", 0, employee111);
		Employee employee666=new Employee(7,"olfa","sallemi","olfa","0000","olfa.sallemi@gmail.com","technicien","employee","ZAz74882","25543485","marsa");
		Topic topic3=new Topic("Adding state labels and tooltip with value to D3 US Map"," I am mapping the number of pizza restaurants each state has. I am having trouble adding the state labels and a tool tip that shows me the corresponding value for each state to the map. I would like to be able to hover on a state and then have a tool tip that tells me what state it is and the value for it. This is what I have done so far.", "2018/05/01 18:26:18", "null",0,0,0, "independent", 0, 0, "unresolved", "DOCTYPE html,meta charset,body", 0, employee666);
		Employee employee222=new Employee(3,"ali","tijani","ali","0000","tijani.ali@gmail.com","technicien","employee","ZA748Z52","01857485","ariana soughra");
		Topic topic4=new Topic("Remove NA in front of one specific string but leave in front of another specific string, by group", "From zoo with na.locf and is.na, notice it assuming you data is ordered. \n df[!(na.locf(df$status,fromLast = T)=='a'&is.na(df$status)),]\n" + 
				"   id status\n" + 
				"2   1      a\n" + 
				"3   1      c\n" + 
				"4   1      a\n" + 
				"5   2   <NA>\n" + 
				"6   2      b\n" + 
				"7   2      c\n" + 
				"8   2      c\n" + 
				"11  3      a\n" + 
				"12  3      c\n" + 
				"13  4   <NA>\n" + 
				"14  4   <NA>", "2018/05/01 18:26:18", "null",0,0,0, "independent", 0, 0, "unresolved", "java ,html , skype", 0, employee222);

		Topic topic5=new Topic("Différences entre BLOB et TEXT", "BLOB stocke les informations en binaire directement, ce qui permet par exemple d'y insérer le contenu d'une image ou d'un exécutable mais on peut aussi y mettre du texte comme dans TEXT (il n'y a alors pas besoin de définir un interclassement) et la seule différence restante ", "2010/05/07 09:26:18", "null",0,0,0, "independent", 0, 0, "unresolved", "java ,html , skype", 0, employee222);
		Topic topic6=new Topic(" Lob Annotation", "A Lob annotation specifies that a persistent property or field should be persisted as a large object to a database-supported large object type. Portable applications should use the  Lob annotation when mapping to a database Lob type. The Lob annotation may be used in conjunction with the  Basic annotation ", "2009/01/07 09:26:18", "null",0,0,0, "independent", 0, 0, "unresolved", "java ,html , skype", 0, employee111);
		Topic topic7=new Topic("Parsing XML, need to get element text from a child node which is not always present\n", "Fairly new to Python. I'm parsing XML element text to ultimately be passed to a database but am printing to screen to QA my script. The following (edited to reduce sample length) gives me exactly what I'm looking for. My question is: how do I bring in the FreeRents node values without eliminating records which have BaseRents nodes but not FreeRents? I've tried a for loop but this clearly eliminates records which do not have both BaseRent and Fre ", "2017/03/07 10:26:18", "null",0,0,0, "independent", 0, 0, "unresolved", "xhtml ,department ", 0, employee333);
		Topic topic8=new Topic("always end up with a LONGTEXTin MySQL.", "On Hibernate JPA MYSQL, using @Lob plus @Column annotation on a String field gives \"wrong column type, expected longtext but column type is text\". But the problem is solved when I used @Column(columnDefinition = \"text\") ", "2010/05/07 09:26:18", "null",0,0,0, "independent", 0, 0, "unresolved", "java ,html , skype", 0, employee333);

		
		
		
		
		Topic topic888=new Topic(4,"always end up with a LONGTEXTin MySQL.", "On Hibernate JPA MYSQL, using @Lob plus @Column annotation on a String field gives \"wrong column type, expected longtext but column type is text\". But the problem is solved when I used @Column(columnDefinition = \"text\") ", "2010/05/07 09:26:18", "null",0,0,0, "independent", 0, 0, "unresolved", "java ,html , skype", 0, employee333);
		Topic topic555=new Topic(6,"Différences entre BLOB et TEXT", "BLOB stocke les informations en binaire directement, ce qui permet par exemple d'y insérer le contenu d'une image ou d'un exécutable mais on peut aussi y mettre du texte comme dans TEXT (il n'y a alors pas besoin de définir un interclassement) et la seule différence restante ", "2010/05/07 09:26:18", "null",0,0,0, "independent", 0, 0, "unresolved", "java ,html , skype", 0, employee222);
		Topic topic777=new Topic(8,"Parsing XML, need to get element text from a child node which is not always present\n", "Fairly new to Python. I'm parsing XML element text to ultimately be passed to a database but am printing to screen to QA my script. The following (edited to reduce sample length) gives me exactly what I'm looking for. My question is: how do I bring in the FreeRents node values without eliminating records which have BaseRents nodes but not FreeRents? I've tried a for loop but this clearly eliminates records which do not have both BaseRent and Fre ", "2017/03/07 10:26:18", "null",0,0,0, "independent", 0, 0, "unresolved", "xhtml ,department ", 0, employee333);
		Topic topic666=new Topic(7," Lob Annotation", "A Lob annotation specifies that a persistent property or field should be persisted as a large object to a database-supported large object type. Portable applications should use the  Lob annotation when mapping to a database Lob type. The Lob annotation may be used in conjunction with the  Basic annotation ", "2009/01/07 09:26:18", "null",0,0,0, "independent", 0, 0, "unresolved", "java ,html , skype", 0, employee111);
		Topic topic000=new Topic(1,"Java string to date conversion", "Note that many of the answers ignore subtleties like locales and timezones. I'd recommend a close reading of the documentation for the Date, Calendar, TimeZone, Locale, and SimpleDateFormat classes before using any of them", "2018/05/01 18:26:18", "null",0,0,0, "independent", 0, 0, "unresolved", "java ,html , skype", 0, employee111);
		Topic topic222=new Topic(3,"Jon Skeet Answers Your Questions IRL", "In January, Jon Skeet’s rep crossed over one million. To thank him for his generous efforts and contributions, we hosted a brunch in his honor at our New York Headquarters in February. We also asked the community if they had any questions for him to answer in an IRL Q&A Please enjoy this delightful interview in which Jon discusses everything from his origin story, to overload resolution, to banana flower pants. We’re immensely grateful for Jon’s continued devotion to thion rep!", "2018/01/01 00:26:18", "null",0,0,0, "independent", 0, 0, "resolved", "jee,jsf,xhtml,uml,js,jquery", 0, employee111);
		Topic topic333=new Topic(2,"Adding state labels and tooltip with value to D3 US Map"," I am mapping the number of pizza restaurants each state has. I am having trouble adding the state labels and a tool tip that shows me the corresponding value for each state to the map. I would like to be able to hover on a state and then have a tool tip that tells me what state it is and the value for it. This is what I have done so far.", "2018/05/01 18:26:18", "null",0,0,0, "independent", 0, 0, "unresolved", "DOCTYPE html,meta charset,body", 0, employee666);
		Topic topic444=new Topic(5,"Remove NA in front of one specific string but leave in front of another specific string, by group", "From zoo with na.locf and is.na, notice it assuming you data is ordered. \n df[!(na.locf(df$status,fromLast = T)=='a'&is.na(df$status)),]\n" + 
				"   id status\n" + 
				"2   1      a\n" + 
				"3   1      c\n" + 
				"4   1      a\n" + 
				"5   2   <NA>\n" + 
				"6   2      b\n" + 
				"7   2      c\n" + 
				"8   2      c\n" + 
				"11  3      a\n" + 
				"12  3      c\n" + 
				"13  4   <NA>\n" + 
				"14  4   <NA>", "2018/05/01 18:26:18", "null",0,0,0, "independent", 0, 0, "unresolved", "java ,html , skype", 0, employee222);

		
		
		
		Comment comment1=new Comment("guesmi", "2018/05/01 17:26:18", 0, 0, 0, "Realized that my for loops were incorrectly written - I'd tried to nest too deeply resulting in incomplete results.", "not interesting", topic888);
		Comment comment2=new Comment("trigui", "2017/02/11 20:26:18", 0, 0, 0, "This is not a good solution, as TEXT data column is not available in all the databases engines, e.g. HSQLDB", "not interesting", topic777);
		Comment comment3=new Comment("bouazizi", "2017/12/21 19:26:18", 0, 0, 0, "Find this better, because I can directly choose which Text-Type the column will have in database.", "not interesting", topic888);
		Comment comment4=new Comment("tijani", "2018/03/07 01:26:18", 0, 0, 0, "his is what i wanted because it is what is available in all production databases, and does not have the issue with \"longtext\" when i don't want it. ", "not interesting", topic333);
		Comment comment5=new Comment("guesmi", "2018/04/18 18:26:18", 0, 0, 0, "What's the sense in combining @Lob and @Column(", "not interesting", topic444);
		Comment comment6=new Comment("sallemi", "2018/03/19 18:26:18", 0, 0, 0, "Worked great, thank you a lot! +1", "not interesting", topic555);
		Comment comment7=new Comment("sallemi", "2018/02/20 18:26:18", 0, 0, 0, "As we continued in comments, it was possible to get closer and closer to an answer that is more personalized. At the end of the discussion, you said something which spawned this answer.", "not interesting", topic666);
		Comment comment8=new Comment("turki", "2018/02/21 19:26:18", 0, 0, 0, "I'd actually argue that its slightly different. Its not that this stuff is ultimately not worth the thought, but rather that this stuff may be worth not thinking..", "not interesting", topic777);
		Comment comment9=new Comment("mrabbet", "2018/03/19 18:26:18", 0, 0, 0, "Life isn't a journey. You were supposed to dance.", "not interesting", topic000);
		Comment comment10=new Comment("sallemi", "2018/04/21 12:26:18", 0, 0, 0, "If I were to offer one \"truth,\" I would have to offer a wise quote from the Matrix. Myself, I self-identify as a radical skeptic", "not interesting", topic000);
		Comment comment11=new Comment("trigui", "2018/01/05 18:26:18", 0, 0, 0, "Can you acknowledge the absurd and remain hopeful? I mentioned that I identify as a radical skeptic.", "not interesting", topic222);
		Comment comment12=new Comment("turki", "2018/05/01 19:26:18", 0, 0, 0, " I think much about life but things do not look grim.", "not interesting", topic888);
		Comment comment13=new Comment("trigui", "2018/05/03 19:26:18", 0, 0, 0, "problem solved, thanks for your help.", "not interesting", topic000);

		
		
		
		
		//userServiceLocal.update(condidate);
		
		departmentServiceLocal.update(department);
		departmentServiceLocal.update(department1);
		departmentServiceLocal.update(department2);
		userServiceLocal.update(employee1);
		userServiceLocal.update(employee2);
		userServiceLocal.update(employee3);
		userServiceLocal.update(employee4);
		userServiceLocal.update(employee5);
		userServiceLocal.update(employee6);
		userServiceLocal.update(employee7);
		userServiceLocal.update(employee8);
		userServiceLocal.update(employee9);
		userServiceLocal.update(employee10);
		userServiceLocal.update(employee11);
		topicServiceLocal.update(topic);
		topicServiceLocal.update(topic3);
		topicServiceLocal.update(topic2);
		topicServiceLocal.update(topic8);
		topicServiceLocal.update(topic4);
		topicServiceLocal.update(topic5);
		topicServiceLocal.update(topic6);
		topicServiceLocal.update(topic7);
		commentServiceLocal.update(comment1);
		commentServiceLocal.update(comment2);
		commentServiceLocal.update(comment3);
		commentServiceLocal.update(comment4);
		commentServiceLocal.update(comment5);
		commentServiceLocal.update(comment6);
		commentServiceLocal.update(comment7);
		commentServiceLocal.update(comment8);
		commentServiceLocal.update(comment9);
		commentServiceLocal.update(comment10);
		commentServiceLocal.update(comment11);
		commentServiceLocal.update(comment12);
		commentServiceLocal.update(comment13);
		
		
		
	}
}
