/** 
 * Haotian Zhang
 * UWaterloo CS
*/  
import java.util.List;  
import java.util.Map;  
import java.util.Properties;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.nio.charset.StandardCharsets;
import java.io.PrintWriter;

  
import edu.stanford.nlp.dcoref.CorefChain;  
import edu.stanford.nlp.dcoref.CorefCoreAnnotations.CorefChainAnnotation;  
import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;  
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;  
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;  
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;  
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;  
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;  
import edu.stanford.nlp.ling.CoreLabel;  
import edu.stanford.nlp.pipeline.Annotation;  
import edu.stanford.nlp.pipeline.StanfordCoreNLP;  
import edu.stanford.nlp.semgraph.SemanticGraph;  
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation;  
// import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;  
import edu.stanford.nlp.trees.Tree;  
import edu.stanford.nlp.trees.TreeCoreAnnotations.TreeAnnotation;  
import edu.stanford.nlp.util.CoreMap;  
  
//javac -cp .:* Document2Sentences.java 
//java -cp .:* Document2Sentences
public class Document2Sentences {  
    public static void main(String[] args) throws IOException{  

          
        Properties props = new Properties();      
        props.put("annotators", "tokenize, cleanxml, ssplit");      
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);    

        byte[] encoded = Files.readAllBytes(Paths.get("00504"));
        

        String text = new String(encoded, StandardCharsets.UTF_8);

        Annotation document = new Annotation(text);     
        pipeline.annotate(document);                     
          
 
        List<CoreMap> sentences = document.get(SentencesAnnotation.class);  
        // System.out.println("word\tpos\tlemma\tner");  
        
        int count = 0;
        

        for(CoreMap sentence: sentences) { 
            

            PrintWriter writer = new PrintWriter("00504."+count, "UTF-8");
            
            writer.println(sentence);
            writer.close();  
            count++;
              

        }  
    }  
}  

