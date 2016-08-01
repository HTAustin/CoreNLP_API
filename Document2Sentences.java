/** 
 * Haotian Zhang
 * UWaterloo CS
*/  
import java.util.List;  
import java.util.Map;  
import java.util.Properties;  
  
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
    public static void main(String[] args) {  

          
        Properties props = new Properties();      
        props.put("annotators", "tokenize, cleanxml, ssplit");      
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);    
          
        String text = "add your text here! It can contain multiple sentences.";              
          
        Annotation document = new Annotation(text);     
        pipeline.annotate(document);                     
          
 
        List<CoreMap> sentences = document.get(SentencesAnnotation.class);  
        // System.out.println("word\tpos\tlemma\tner");  
          
        for(CoreMap sentence: sentences) {  
            System.out.println(sentence);    
              

        }  
    }  
}  

