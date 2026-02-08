package com.atul.miniproject.Quotable.configs;

import com.atul.miniproject.Quotable.clients.KimiQuotesRestClient;
import com.atul.miniproject.Quotable.clients.KimiQuotesWebClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ThirdPartyBeansConfiguration {

    @Bean
    public RestClient getRestClient(){
        return RestClient.builder()
                .baseUrl("https://kimiquotes.pages.dev/api")
                .build();
    }

    @Bean
    public KimiQuotesRestClient getQuotesClient(RestClient restClient){
        return new KimiQuotesRestClient(restClient);

    }

    @Bean
    public WebClient webClient(){
        return  WebClient.builder()
                .baseUrl("https://kimiquotes.pages.dev/api")
                .build();
    }

    @Bean
    public KimiQuotesWebClient kimiQuotesWebClient(WebClient webClient){
        return new KimiQuotesWebClient(webClient);
    }

// With Default Headers
// Now every request includes those headers automatically.
// @Bean
// public RestClient restClient() {
//    return RestClient.builder()
//            .baseUrl("http://localhost:8081")
//            .defaultHeader("Authorization", "Bearer my-token")
//            .defaultHeader("Accept", "application/json")
//            .build();
//}
//



// With Custom Error Handling
//    @Bean
//    public RestClient restClient() {
//        return RestClient.builder()
//                .baseUrl("http://localhost:8081")
//                .defaultStatusHandler(
//                        status -> status.is4xxClientError() || status.is5xxServerError(),
//                        (request, response) -> {
//                            throw new RuntimeException("API call failed: " + response.getStatusCode());
//                        }
//                )
//                .build();
//    }
}
