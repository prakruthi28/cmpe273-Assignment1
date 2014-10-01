package hello;


public class IDCard {
	private  Integer id;
	private  String name;
    private  String number;
    private  String date;

    public IDCard() {
    }

    public IDCard(Integer id, String name, String number, String date) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }
    public String getNumber() {
        return number;
    }
    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
    	return new StringBuffer(" id : ").append(this.id.toString())
                    .append(" name : ").append(this.name)
                    .append(" number : ").append(this.number).append(" date : ")
                    .append(this.date).toString();
        }
}
