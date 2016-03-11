package main.java.controller;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

@Controller
public class NetworkToEdu {
	
	private final static String CONFIG_PATH = "src/main/resources/eduConfig.xml";
	
	@RequestMapping(value="/edudata", method=RequestMethod.GET)
	public String retreiveData(Model model){
		//TODO check currentUser is Admin
		try{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.parse(CONFIG_PATH);
			System.err.println(CONFIG_PATH);
			NodeList list = d.getElementsByTagName("path");
			if (list == null || list.getLength() != 1){
				model.addAttribute("path", "Invalid Config");
			}else{
				String path= list.item(0).getTextContent();
				int prefix=0;
				while (prefix<path.length() && Character.isWhitespace(path.charAt(prefix))) 
					++prefix;
				int suffix=path.length()-1;
				while (suffix>=prefix && Character.isWhitespace(path.charAt(suffix)))
					--suffix;
				if (prefix<=suffix)
					path= path.substring(prefix, suffix+1);
				else
					path= "";
				File file = new File(path);
				model.addAttribute("path", path);
				EduDataAnalyzer.getInstance().parseAndInsertNewData(file);
//				EduDataAnalyzer.getInstance().parseAndInsertNewData(new File(list.item(0).getTextContent()));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return "edudata";
	}
}
