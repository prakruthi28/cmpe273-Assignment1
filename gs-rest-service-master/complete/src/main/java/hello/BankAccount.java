package hello;

import java.util.HashMap;
import java.util.Map;

import hello.IDCard;

public class BankAccount {
	private  Integer id;
	private  String account_name;
    private  String routing_number;
    private  String account_number;
 
    public BankAccount() {
    }

    public BankAccount(Integer id, String account_name, String routing_number, String account_number) {
        this.id = id;
        this.account_name = account_name;
        this.routing_number = routing_number;
        this.account_number = account_number;
  
    }

    public Integer getba_Id() {
        return id;
    }
    public String getaccount_name() {
        return account_name;
    }
    public String getrouting_number() {
        return routing_number;
    }
    public String getaccount_number() {
        return account_number;
    }
    
    @Override
    public String toString() {
    	return new StringBuffer(" id : ").append(this.id.toString())
                    .append(" account_name : ").append(this.account_name)
                    .append(" routing_number : ").append(this.routing_number)
                    .append(" account_number : ").append(this.account_number).toString();
        }
}
