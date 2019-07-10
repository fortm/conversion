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
public class DemoApplicationTests {

    @Autowired
    private DecimalToWordConversionService decimalToWordConversionService;

    @Test
    public void testForHundreds() {
        assertThat(decimalToWordConversionService.decimalToWords(123L)).isEqualTo("One Hundred and Twenty Three");
    }

    @Test
    public void testForThousands() {
        assertThat(decimalToWordConversionService.decimalToWords(2123L)).isEqualTo("Two Thousand and One Hundred and Twenty Three");
    }

    @Test
    public void testForTrillions() {
        assertThat(decimalToWordConversionService.decimalToWords(654217896542123L)).isEqualTo("Six Hundred and Fifty Four Trillion and Two Hundred and Seventeen Billion and Eight Hundred " +
                "and Ninety Six Million and Five Hundred and Forty Two Thousand and One Hundred and Twenty Three");
    }


}
