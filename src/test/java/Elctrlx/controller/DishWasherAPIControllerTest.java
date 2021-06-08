package Elctrlx.controller;

import Elctrlx.service.DishWasherService;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DishWasherAPIController.class)
class DishWasherAPIControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void createNewDishwasher() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/dishwasher/new?model=margo");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("DishWasher{id=1, model='margo', state=Off, waterTemperature=0}", result.getResponse().getContentAsString());
    }

    @Test
    void turnOnDishwasher() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/dishwasher/on?id=1");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("DishWasher{id=1, model='margo', state=On, waterTemperature=0}", result.getResponse().getContentAsString());
    }

    @Test
    void turnOffDishwasher() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/dishwasher/off?id=1");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("DishWasher{id=1, model='margo', state=Off, waterTemperature=0}", result.getResponse().getContentAsString());
    }

    @Test
    void setTemperatureDishwasher() throws Exception {
        RequestBuilder requestToTurnOn = MockMvcRequestBuilders.get("/dishwasher/on?id=1");
        RequestBuilder requestToSetTemp = MockMvcRequestBuilders.get("/dishwasher/temp?id=1&temp=40");
        MvcResult result = mvc.perform(requestToSetTemp).andReturn();
        assertEquals("DishWasher{id=1, model='margo', state=On, waterTemperature=40}", result.getResponse().getContentAsString());

    }
}