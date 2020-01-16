package me.jdragon.atdd.rentalExam;

import me.jdragon.atdd.controller.RentalController;
import me.jdragon.atdd.service.RentalService;
import me.jdragon.atdd.vo.Item;
import me.jdragon.atdd.vo.Rental;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(controllers = RentalController.class)
@AutoConfigureMockMvc
public class RentalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RentalService rentalService;

    @DisplayName("대여 신청한다")
    @Test
    public void createRentals() throws Exception {

        Item item = new Item(110920 , "READY");
        Rental rental = new Rental(1 , "20191127", item, "READY");

        given(rentalService.createRental(any())).willReturn(rental);

        String inputJson = "{\"date\":\"" + "20191127" + "\", " +
                "\"itemId\":\"" + "110920" + "\"}";
        mockMvc.perform(post("/rentals")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(inputJson))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.date").value("20191127"))
                .andExpect(jsonPath("$.itemid").value("110920"))
                .andExpect(jsonPath("$.status").value("READY"))
                .andDo(print());



    }
}
