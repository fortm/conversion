package com.example.demo;

import com.example.demo.service.DecimalToWordConversionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DecimalToWordConversionServiceTest {

    @Autowired
    private DecimalToWordConversionService decimalToWordConversionService;

    @Test
    public void test() {
        assertThat(decimalToWordConversionService.decimalToWords(56945781L)).isEqualTo("Fifty Six Million Nine Hundred and Forty Five Thousand Seven Hundred and Eighty One");
    }

    @Test
    public void testForTrillions() {
        assertThat(decimalToWordConversionService.decimalToWords(654217896542123L)).isEqualTo("Six Hundred and Fifty Four Trillion Two Hundred and Seventeen Billion Eight Hundred " +
                "and Ninety Six Million Five Hundred and Forty Two Thousand One Hundred and Twenty Three");
    }


}
