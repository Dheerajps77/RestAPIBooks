package SerialAndDeserialisation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class ConvertPojoToJson {
	
	public static void main(String[] args) throws JsonProcessingException {
		Person person=new Person();	
		person.setName("Dheeraj Pratap Singh");
		person.setAge(25);
		person.setClassName("XIth");
		
		ObjectMapper mapper=new ObjectMapper();
		ObjectWriter objectWriter=mapper.writerWithDefaultPrettyPrinter();
		String jsonString=objectWriter.writeValueAsString(person);
		System.out.println("Json Object is :-");
		System.out.println(jsonString);
	}
}
