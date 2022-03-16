package tp.util;

import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import tp.data.Product;

public class MyFileConsumer {
	
	//cette classe utilitaire va surveiller l'existence d'un nouveau fichier
	//potentiellement déposé dans ./files/input
	//et va récupérer le contenu de ce fichier 
	//et supprimer ce fichier
	//ou bien déplacer et renommer le fichier traité dans ./files/done/fileName_timestamp
	
	private String mainDirectoryPath="./files";
	private String inputSubDirectory="input";
	//private String doneSubDirectory="done";
	
	public Optional<String> extractNewFileContentIfExists() {
		String fileContent=null;
		try {
			Path inputDirectoryPath = Paths.get("./files/input");
			DirectoryStream<Path> directoryStream = Files.newDirectoryStream(inputDirectoryPath);
			for(Path filePath : directoryStream) {
				System.out.println(filePath);
				List<String> lignes = Files.readAllLines(filePath, StandardCharsets.UTF_8);
				fileContent = lignes.stream().collect(Collectors.joining(" "));
				Files.delete(filePath); //v1 : simply delete readen file
				//next v2 : move rename readen file in ".files/done" and rename it  with timestamp
				break; //we just want to load content of the first found file (if exists)
			}
			//fileContent may be null if no file found in input directory
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return Optional.ofNullable(fileContent);
	}
	
	//secondary main() for direct test:
	public static void main(String[] args) {
		MyFileConsumer myFileConsumer = new MyFileConsumer();
		String fileContent = myFileConsumer.extractNewFileContentIfExists().orElse(null);
		System.out.println("fileContent="+fileContent);
		
		ObjectMapper jacksonObjectMapper = new ObjectMapper();
		//jacksonObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		if(fileContent!=null) {
			try {
				Product p = jacksonObjectMapper.readValue(fileContent, Product.class);
				System.out.println("p="+p);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}

}
