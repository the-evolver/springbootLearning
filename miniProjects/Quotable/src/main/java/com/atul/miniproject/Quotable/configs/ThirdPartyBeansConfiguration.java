package com.atul.miniproject.Quotable.configs;

import com.atul.miniproject.Quotable.clients.kimiQuotesClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ThirdPartyBeansConfiguration {

    @Bean
    public RestClient getRestClient(){
        return RestClient.builder()
                .baseUrl("https://kimiquotes.pages.dev/api")
                .build();
    }

    @Bean
    public kimiQuotesClient getQuotesClient(RestClient restClient){
        return new kimiQuotesClient(restClient);

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
