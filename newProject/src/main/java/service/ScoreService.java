package service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ScoreService {
    private RestTemplate restTemplate = new RestTemplate();



    public void displayScores(){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(headers);
       Score[] scores = restTemplate.exchange("http://localhost:8080/score", HttpMethod.GET, entity, Score[].class).getBody();
       //    Transfer[] transfers = restTemplate.exchange(baseUrl + "users/transfer", HttpMethod.GET, entity, Transfer[].class).getBody();
        System.out.println("\t HighScores");
        System.out.println("-----------------------------------------------------");
       for(Score score : scores){
           System.out.println(score.getName() + " " + score.getScore());
       }
        System.out.println("-----------------------------------------------------");
   }
   public void createScore(ScoreDTO scoreDTO){
       HttpHeaders headers = new HttpHeaders();
       HttpEntity<?> entity = new HttpEntity<>(scoreDTO, headers);
       restTemplate.exchange("http://localhost:8080/create", HttpMethod.POST, entity, Score.class);

   }
}
