package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.print.DocFlavor.URL;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.User;
import hello.IDCard;
import hello.Weblogin;
import hello.BankAccount;

@RestController
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    Map<Integer, User> userData = new HashMap<Integer, User>();

//    Map<Integer, Weblogin> webData = new HashMap<Integer, Weblogin>();
    
    //Map<Integer, Map<Integer, IDCard>> idCardData = new HashMap<Integer, HashMap<Integer, IDCard>>();
    
    int userId = 0;
    int cardId = 0;
    int webId = 0;
    int baId = 0;
  
    @RequestMapping(value = "/v1/users", method = RequestMethod.POST)
    public User CreateUser(@RequestBody User user) {
    	    	logger.info("Start create user.");
		userId++;
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		
		String formattedDate = dateFormat.format(date);
		User new_user = new User(userId, user.getEmail(), user.getPassword(), formattedDate, "");
		userData.put(userId, new_user);
		return new_user;
    }
    @RequestMapping(value = "/v1/users/{id}", method = RequestMethod.GET)
    public User ViewUser(@PathVariable("id") int userId) {
    	logger.info("Start view.");
    	
    	return userData.get(userId);
    }
    
    @RequestMapping(value = "/v1/users/{id}", method = RequestMethod.PUT)
    public User UpdateUser(@PathVariable("id") int userId, @RequestBody User user) {
    	logger.info("Start update.");
    	User oldUser = userData.get(userId);
    	userData.remove(userId);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		
		String formattedDate = dateFormat.format(date);
    	User newUser = new User(oldUser.getId(), user.getEmail(), user.getPassword(), oldUser.getCDate(),  formattedDate);
        userData.put(userId, newUser);
    	return newUser;
    }

    @RequestMapping(value = "/v1/users/{id}/idcards", method = RequestMethod.POST)
    public IDCard CreateID(@PathVariable("id") int userId, @RequestBody IDCard idcard) {
    	logger.info("Start create id card.");
		cardId++;
		IDCard new_id = new IDCard(cardId, idcard.getName(), idcard.getNumber(), idcard.getDate());
		User user = userData.get(userId);
		user.addCardData(new_id);
		return new_id;
    }
    @RequestMapping(value = "/v1/users/{id}/idcards", method = RequestMethod.GET)
    public String ListID(@PathVariable("id") int userId) {
      	logger.info("Start get id card.");
    	 return userData.get(userId).getCardData().toString();
    }
    @RequestMapping(value = "/v1/users/{id}/idcards/{cid}", method = RequestMethod.DELETE)
    public IDCard deleteID(@PathVariable("id") int userId, @PathVariable("cid") int cardId) {
      	logger.info("Start delete id card.");
      	IDCard id =     userData.get(userId).getCardData().remove(cardId);
      	return id;
    }
    @RequestMapping(value = "/v1/users/{id}/weblogins", method = RequestMethod.POST)
    public Weblogin CreateWeblogin(@PathVariable("id") int userId, @RequestBody Weblogin weblogin) {
    	logger.info("Start create web login.");
		webId++;
		Weblogin new_weblogin = new Weblogin(webId, weblogin.geturl(), weblogin.getlogin(), weblogin.getpassword());
		User webuser = userData.get(userId);
		webuser.addWebData(new_weblogin);
		return new_weblogin;
    }
    @RequestMapping(value = "/v1/users/{id}/weblogins", method = RequestMethod.GET)
    public String ListWeblogin(@PathVariable("id") int userId) {
      	logger.info("Start get web login.");
    	 return userData.get(userId).getWebData().toString();
    }
    @RequestMapping(value = "/v1/users/{id}/weblogins/{login_id}", method = RequestMethod.DELETE)
    public Weblogin deleteWeblogin(@PathVariable("id") int userId, @PathVariable("login_id") int loginID) {
      	logger.info("Start delete web login.");
      	Weblogin wid =     userData.get(userId).getWebData().remove(loginID);
      	return wid;
    }
    
    @RequestMapping(value = "/v1/users/{id}/bankaccounts", method = RequestMethod.POST)
    public BankAccount CreateBankAccount(@PathVariable("id") int userId, @RequestBody BankAccount bankacc) {
    	logger.info("Start create Bank Account.");
		baId++;
		BankAccount new_bankaccount = new BankAccount(baId, bankacc.getaccount_name(), bankacc.getrouting_number(), bankacc.getaccount_number());
		User bauser = userData.get(userId);
		bauser.addbankData(new_bankaccount);
		return new_bankaccount;
    }
    
    @RequestMapping(value = "/v1/users/{id}/bankaccounts", method = RequestMethod.GET)
    public String Listbankaccount(@PathVariable("id") int userId) {
      	logger.info("Start get bank account.");
    	 return userData.get(userId).getbankData().toString();
    }
    
    @RequestMapping(value = "/v1/users/{id}/bankaccounts/{bankacc_id}", method = RequestMethod.DELETE)
    public BankAccount deletebankaccount(@PathVariable("id") int userId, @PathVariable("bankacc_id") int bankacID) {
      	logger.info("Start delete web login.");
      	BankAccount bid =     userData.get(userId).getbankData().remove(bankacID);
      	return bid;
    }
}
