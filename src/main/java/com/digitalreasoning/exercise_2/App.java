package com.digitalreasoning.exercise_2;
import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.digitalreasoning.nlf.ObjectFactory;
import com.digitalreasoning.nlf.Sentenceset;
import com.digitalreasoning.nlf.TField;
import com.digitalreasoning.nlf.TSentence;

/**
 * @author Fei Xiao
 *
 */
public class App {

	/**
	 * @param args
	 * @throws JAXBException
	 */
	public static void main(String[] args) throws JAXBException{
		
		   JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
		    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		    Sentenceset sentenceset = (Sentenceset) unmarshaller.unmarshal(new File("sentenceSet.xml"));
		    
		    List<TSentence> sentences = sentenceset.getSentence();
		    for (TSentence sentence : sentences) {
		    	List<TField> fields = sentence.getField();
		    	for (TField field : fields) {
		  
		    		System.out.println(field.getValue() + "\t" + field.getFieldtype()
		    				+ "\t" + field.getTotal());
		    	}
		    }
	}

}
