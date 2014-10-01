package hello;

import java.util.HashMap;
import java.util.Map;

import hello.IDCard;

public class Weblogin {
	private  Integer id;
	private  String url;
    private  String login;
    private  String password;
 //   private  Map<Integer, Weblogin> webData = new HashMap<Integer, Weblogin>();

    public Weblogin() {
    }

    public Weblogin(Integer id, String url, String login, String password) {
        this.id = id;
        this.url = url;
        this.login = login;
        this.password = password;
  
    }

    public Integer getId() {
        return id;
    }
    public String geturl() {
        return url;
    }
    public String getlogin() {
        return login;
    }
    public String getpassword() {
        return password;
    }
    
    
    @Override
    public String toString() {
    	return new StringBuffer(" id : ").append(this.id.toString())
                    .append(" url : ").append(this.url)
                    .append(" login : ").append(this.login)
                    .append(" password : ").append(this.password).toString();
        }
}
