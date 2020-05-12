package com.mcommandes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.DependsOn;

import com.mcommandes.dao.CommandesDao;
import com.mcommandes.model.Commande;

@SpringBootApplication 
public class McommandesApplication {
@Autowired
CommandesDao  commandesDao;

//@PostConstruct
//void init() {
////	TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
//	TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
//	DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//	try {
//		commandesDao.save(new Commande(23,df.parse("12-01-1981"),5,true));
//		
//	} catch (ParseException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//
//}

	public static void main(String[] args) throws ParseException {
	ApplicationContext ctx=	SpringApplication.run(McommandesApplication.class, args);
	CommandesDao  commandesDao=ctx.getBean(CommandesDao.class);
	DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	commandesDao.save(new Commande(21,df.parse("12-01-1981"),5,true));
	commandesDao.save(new Commande(22,df.parse("12-01-1981"),5,true));
//	commandesDao.save(new Commande(23,df.parse("10-01-1983"),5,true));
//	commandesDao.save(new Commande(24,df.parse("14-01-1985"),5,false));
	List<Commande> cmds=commandesDao.findAll();
	cmds.forEach(s->System.out.println("le date de chaque commande "+s.getDateCommande()));
	
	}
	
}
