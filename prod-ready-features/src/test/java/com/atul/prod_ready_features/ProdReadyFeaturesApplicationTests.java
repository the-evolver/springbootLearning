package com.atul.prod_ready_features;

import com.atul.prod_ready_features.clients.OpenFeignWeatherClient;
import com.atul.prod_ready_features.clients.WebClientWeather;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest
class ProdReadyFeaturesApplicationTests {

     @Autowired
    private WebClientWeather webClientWeather;

    @Autowired
    private OpenFeignWeatherClient openFeignWeatherClient;

	@Test
	void contextLoads() {
	}

    @Test
    void test(){
        String webClientResponse = webClientWeather.getWeather();
        System.out.println("get weather => "+webClientResponse);

//        String operFeignClientResponse = openFeignWeatherClient.getWeather();
//        System.out.println("get weather => "+operFeignClientResponse);
    }

}
