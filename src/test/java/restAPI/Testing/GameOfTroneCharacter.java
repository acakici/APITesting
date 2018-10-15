package restAPI.Testing;

public class GameOfTroneCharacter {

	
	public int id;
	public String male;
	public String house;
	public String name;
	
	
	 /// Careat GOT_Character ---> id , male , house ,  name  
	  
	  String str  = " [\n" + 
	      "    {\n" + 
	      "        \"_id\": \"56ffc5be043244081938576d\",\n" + 
	      "        \"male\": true,\n" + 
	      "        \"house\": \"House Hightower\",\n" + 
	      "        \"slug\": \"Abelar_Hightower\",\n" + 
	      "        \"name\": \"Abelar Hightower\",\n" + 
	      "        \"__v\": 0,\n" + 
	      "        \"pageRank\": 2.5,\n" + 
	      "        \"books\": [\n" + 
	      "            \"The Hedge Knight\"\n" + 
	      "        ],\n" + 
	      "        \"updatedAt\": \"2016-04-02T13:14:38.834Z\",\n" + 
	      "        \"createdAt\": \"2016-04-02T13:14:38.834Z\",\n" + 
	      "        \"titles\": [\n" + 
	      "            \"Ser\"\n" + 
	      "        ]\n" + 
	      "    },\n" + 
	      "    {\n" + 
	      "        \"_id\": \"56ffc5be043244081938576e\",\n" + 
	      "        \"male\": true,\n" + 
	      "        \"house\": \"House Frey\",\n" + 
	      "        \"slug\": \"Addam_Frey\",\n" + 
	      "        \"name\": \"Addam Frey\",\n" + 
	      "        \"__v\": 0,\n" + 
	      "        \"pageRank\": 4.5,\n" + 
	      "        \"books\": [\n" + 
	      "            \"The Mystery Knight\"\n" + 
	      "        ],\n" + 
	      "        \"updatedAt\": \"2016-04-02T13:14:38.875Z\",\n" + 
	      "        \"createdAt\": \"2016-04-02T13:14:38.875Z\",\n" + 
	      "        \"titles\": [\n" + 
	      "            \"Ser\"\n" + 
	      "        ]\n" + 
	      "    },\n" + 
	      "    {\n" + 
	      "        \"_id\": \"56ffc5be043244081938576f\",\n" + 
	      "        \"male\": true,\n" + 
	      "        \"slug\": \"Addam\",\n" + 
	      "        \"name\": \"Addam\",\n" + 
	      "        \"__v\": 0,\n" + 
	      "        \"pageRank\": 1.5,\n" + 
	      "        \"books\": [\n" + 
	      "            \"The Mystery Knight\"\n" + 
	      "        ],\n" + 
	      "        \"updatedAt\": \"2016-04-02T13:14:38.877Z\",\n" + 
	      "        \"createdAt\": \"2016-04-02T13:14:38.877Z\",\n" + 
	      "        \"titles\": [\n" + 
	      "            \"Ser\"\n" + 
	      "        ]\n" + 
	      "    } ] " ;

	public GameOfTroneCharacter() {
		
	}
	
	  
	  
	public GameOfTroneCharacter(int id, String male, String house, String name) {
		super();
		this.id = id;
		this.male = male;
		this.house = house;
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMale() {
		return male;
	}


	public void setMale(String male) {
		this.male = male;
	}


	public String getHouse() {
		return house;
	}


	public void setHouse(String house) {
		this.house = house;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "GameOfTroneCharacter [id=" + id + ", male=" + male + ", house=" + house + ", name=" + name + ", str="
				+ str + "]";
	} 
	  
	  
	  
	}
	
	

