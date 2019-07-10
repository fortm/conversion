package com.example.demo;

import com.example.demo.service.DecimalToWordConversionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    @Value("${input.val}")
    private String inputVal;

    @Autowired
    private DecimalToWordConversionService decimalToWordConversionService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            long val = Long.parseLong(inputVal);
            logger.info("input={}, output={}", val, decimalToWordConversionService.decimalToWords(val));
        } catch (NumberFormatException ex) {
            logger.error("Invalid long number ,input = {}", inputVal, ex);
        } catch (Exception e) {
            logger.error("Exception occured for input={} ", inputVal, e);
        }
    }
}
